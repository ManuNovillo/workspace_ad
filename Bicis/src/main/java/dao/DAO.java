package dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase sirve para sacar, introducir y actualizar datos de cualquier tabla
 * de cualquier BBDD
 */
public class DAO {

    public static <T> List<T> getAll(Class<T> clazz, Connection con) {
        return getMany(clazz, con, getSelectString(clazz));
    }

    /**
     * Devuelve una List con todos los T del select
     *
     * @param clazz  la entidad que se quiere obtener
     * @param con    la conexión con la base de datos
     * @param select el select que se ejecutará
     * @return todos los T que cumplan con el select
     */
    private static <T> List<T> getMany(Class<T> clazz, Connection con, String select) {
        List<T> ts = new ArrayList<>();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(select);
            ResultSet set = ps.executeQuery();
            while (set.next()) {
                ts.add(getFilledT(clazz, set));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.err.println("Error en la sentencia sql: " + e.getMessage());
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            System.err.println("Error al instanciar la clase: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            System.err.println("Error al intentar acceder a un elemento de la clase: " + e.getMessage());
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            System.err.println("Error al intentar acceder a método o constructor de la clase: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            System.err.println("No existe el método: " + e.getMessage());
            e.printStackTrace();
        }

        return ts;
    }

    /**
     * Devuelve una List con todos los T ordenados
     *
     * @param clazz la entidad que se quiere obtener
     * @param con   la conexión con la base de datos
     * @return todos los T que cumplan con el select
     */
    public static <T> List<T> getAllOrderBy(Class<T> clazz, String orderField, Order order, Connection con) {
        return getMany(clazz, con, getSelectOrderByString(clazz, orderField, order));
    }

    /**
     * Devuelve todos los registros que tengan el valor value en el campo con el nombre fieldName,
     * o una lista vacía si no hay
     * @param clazz la clase del objeto
     * @param fieldName el nombre del campo
     * @param value el valor del campo
     * @param con la conexión con la bbdd
     * @return odos los registros que tengan el valor value en el campo con el nombre fieldName,
     * o una lista vacía si no hay
     */
    public static <T> List<T> getByField(Class<T> clazz, String fieldName, Object value, Connection con) {
        Field campo = null;
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getName().equals(fieldName)) {
                campo = field;
            }
        }
        if (campo == null) throw new IllegalArgumentException("El campo no existe");
        String select = getSelectWhere(clazz, campo, value);
        return getMany(clazz, con, select);
    }

    /**
     * Devuelve el objeto de la bbdd que tenga este primary key, o null si no lo hay
     *
     * @param clazz   la clase que representa la tabla de la que se quieren sacar los datos
     * @param pkValue el valor de la primary key
     * @param con     la conexión con la bbdd
     * @return el objeto de la bbdd que tenga este primary key, o null si no lo hay
     */
    public static <T> T getById(Class<T> clazz, Object pkValue, Connection con) {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getDeclaredAnnotation(PrimaryKey.class) != null) { // Si hay primary key
                List<T> ts = getByField(clazz, field.getName(), pkValue, con);
                return ts.isEmpty() ? null : ts.getFirst();  // Devolver null si está vacía, o el primer elemento si no
                // Solo puede haber un elemento ya que es el primary key
            }

        }
        throw new NoPrimaryKeyException("Tiene que haber una primary key"); // Si no hay primary key
    }

    /**
     * Crea un select con una sentencia where para sacar datos de la tabla representada por clazz,
     * y usando campo y value para el where
     * @param clazz la clase que representa la tabla de donde se quieren sacar los datos
     * @param campo el campo de la cláusula where
     * @param value el valor del campo
     * @return un select con una cláusula where
     */
    private static <T> String getSelectWhere(Class<T> clazz, Field campo, Object value) {
        StringBuilder selectBuilder = new StringBuilder(getSelectString(clazz));
        selectBuilder.append(" WHERE ").append(campo.getName()).append(" = ");
        if (value instanceof String) selectBuilder.append("'").append(value).append("'");
        else selectBuilder.append(value);
        return selectBuilder.toString();
    }

    /**
     * Da un valor al field especificado para el objeto t, leído del set
     *
     * @param t     el objeto al que le quiere poner el campo
     * @param field el campo que se quiere rellenar
     * @param set   el RestulSet con los datos de la query
     * @throws IllegalAccessException    si hay un error al intentar acceder a un
     *                                   elemento de la clase
     * @throws InvocationTargetException si hay un error al intentar acceder a
     *                                   método o constructor de la clase
     * @throws NoSuchMethodException     si no existe el metodo
     */
    private static <T> void setField(T t, Field field, ResultSet set)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
        field.setAccessible(true);
        // Hay que construir el nombre del metodo para poder hacer el get set.getInt o set.getString etc
        // en función del tipo de dato de field

        //Primero obtener la primera letra del tipo de field, ya que los metodos son getString, getInt, con mayuscula
        char letraMayus = Character.toUpperCase(field.getType().getSimpleName().charAt(0));
        String nombreMetodo = "get" + letraMayus + field.getType().getSimpleName().substring(1);
        Method method = set.getClass().getMethod(nombreMetodo, String.class);
        method.setAccessible(true);
        field.set(t, method.invoke(set, field.getName()));
    }

    /** TODO
     * Actualiza el registro de la bbdd que tenga el id de t
     * @param t el objeto a actualizar en la bbdd
     * @param con la conexión con la bbdd
     */
    public static <T> void update(T t, Connection con) {
        try {
            change(t, getUpdateString(t), con);
//            System.out.println(getUpdateString(t));
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            System.err.println("Error al intentar acceder a un elemento de la clase: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /** TODO
     * Inserta el registro en la BBDD
     * @param t el objeto a actualizar en la bbdd
     * @param con la conexión con la bbdd
     */
    public static <T> void insert(T t, Connection con) {
        try {
            change(t, getInsertString(t), con);
//            System.out.println(getInsertString(t));
        } catch (IllegalAccessException e) {
            System.err.println("Error al intentar acceder a un elemento de la clase: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Ejecuta un cambio en la base de datos (un insert o un update)
     *
     * @param t     el objeto que cambiar en la bbdd
     * @param query la query sql a ejecutar
     * @param con   la conexión
     */
    private static <T> void change(T t, String query, Connection con) {
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.err.println("Error en la sentencia sql: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            System.err.println("Error se seguridad, no se lo que es " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Devuelve el String correspondiente para hacer un insert
     *
     * @param t el objeto a insertar
     * @return el String para hacer el insert
     * @throws IllegalAccessException si hay un problema al acceder al valor de alguno de los campos del objeto
     */
    private static <T> String getInsertString(T t) throws IllegalAccessException {
        StringBuilder insertBuilder = new StringBuilder("INSERT INTO ");
        insertBuilder.append(t.getClass().getSimpleName()); // INSERT INTO PRODUCTO
        insertBuilder.append("(");  // INSERT INTO PRODUCTO(
        List<Object> values = new ArrayList<>();
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Ignore.class)
                || field.isAnnotationPresent(Entity.class)) continue;
            insertBuilder.append(field.getName()).append(", "); // INSERT INTO PRODUCTO(nombre, id,...)
            field.setAccessible(true);
            values.add(field.get(t));
        }
        insertBuilder.delete(insertBuilder.length() - 2, insertBuilder.length());
        insertBuilder.append(")").append(" VALUES ("); // INSERT INTO PRODUCTO(nombre, id,...) VALUES (
        for (Object obj : values) {
            if (obj instanceof String)
                insertBuilder.append("'").append(obj).append("'"); // Si es String, poner comillas para que lo guarde como String
            else insertBuilder.append(obj);
            insertBuilder.append(", ");
        }
        insertBuilder.append(")"); // INSERT INTO PRODUCTO(nombre, id,...) VALUES ("pizza", 2, ...)
        insertBuilder.delete(insertBuilder.length() - 3, insertBuilder.length() - 1);
        return insertBuilder.toString();
    }

    /**
     * Devuelve un String con la sentencia select para la tabla con el nombre de clazz
     * @param clazz la clase con la que obtener la tabla y los campos
     * @return un String con la sentencia select para la tabla con el nombre de clazz
     */
    private static <T> String getSelectString(Class<T> clazz) {
        StringBuilder selectBuilder = new StringBuilder("SELECT ");
        appendSelectFields(selectBuilder, clazz);
        selectBuilder.append("FROM ").append(clazz.getSimpleName()); // SELECT FROM PRODUCTO
        return selectBuilder.toString();
    }

    /**
     * Devuelve un String con la sentencia select ordenando según se especifique
     * @param clazz
     * @param orderField
     * @param order ascendente o descendente
     * @return un String con la sentencia select ordenando según se especifique
     * @param <T>
     */
    private static <T> String getSelectOrderByString(Class<T> clazz, String orderField, Order order) {
        return getSelectString(clazz) + " " + "ORDER BY " + orderField + " " + order.toString(); // SELECT FROM PRODUCTO ORDER BY ID DESC
    }

    /**
     * Crea una nueva instancia de T con los datos actuales del ResultSet
     *
     * @param clazz la clase entidad, de la cual se quiere obtener la instancia
     * @param set   el RestulSet con los datos de la query
     * @return una nueva instancia de T con los datos de la base de datos
     * @throws InstantiationException    si hay un error al instanciar la clase
     * @throws IllegalAccessException    si hay un error al intentar acceder a un
     *                                   elemento de la clase
     * @throws InvocationTargetException si hay un error al intentar acceder a
     *                                   método o constructor de la clase
     * @throws NoSuchMethodException     si no existe el metodo
     * @throws SecurityException         si hay un error se seguridad, no sé lo que
     *                                   es
     * @throws SQLException              si hay un error en la sentencia sql
     */
    private static <T> T getFilledT(Class<T> clazz, ResultSet set) throws InstantiationException,
            IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
        T t = clazz.getConstructor().newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Entity.class)
                || field.isAnnotationPresent(Ignore.class)) continue;
            setField(t, field, set);
        }
        return t;
    }

    /**
     * Devuelve todos los registros de la tabla con el nombre de la clase clazz,
     * y si tiene relaciones 1:N, rellena los campos de la clase correspondientes a esa relación,
     * si los hay
     * @param clazz
     * @param fk
     * @param con
     * @return
     * @param <T>
     */
    public static <T> List<T> getAllWithEntitiesFilled(Class<T> clazz, String fk, Connection con) {
        String select = getSelectString(clazz);
        List<T> ts = getAll(clazz, con);
        try {
            for (T t : ts) {
                fillEntityFields(t, con, fk);
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Clase entidad no encontrada " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.err.println("Acceso ilegal " + e.getMessage());
            e.printStackTrace();
        }
        return ts;
    }

    public static <T> T getWithEntitiesFilled(Class<T> clazz, Object pkValue, String fk, Connection con) {
        T t = getById(clazz, pkValue, con);
        try {
            fillEntityFields(t, con, fk);
        } catch (ClassNotFoundException e) {
            System.err.println("Clase entidad no encontrada " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.err.println("Acceso ilegal " + e.getMessage());
            e.printStackTrace();
        }
        return t;
    }

    private static <T> void fillEntityFields(T t, Connection con, String fk) throws ClassNotFoundException, IllegalAccessException {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Entity.class)) {
                fillEntityField(t, field, con, Class.forName(field.getAnnotation(Entity.class).className()), fk);
            }
        }

    }

    /**
     * Da un valor al campo especificado. Los ejemplos de abajo es suponiendo el caso de Libro Ejemplar 1:N,
     * donde en java la clase Libro tiene el campo ejemplares
     * @param t la instancia de Libro a la que se le quieren rellenar los ejemplares
     * @param field el campo a rellenar
     * @param con la conexión
     * @param clazz la clase Ejemplar
     * @param fk el nombre de la fk, por ejemplo libroid en la tabla ejemplar
     * @param <T> el tipo de la clase que está compuesto por un campo que representa otra tabla. Por ejemplo, Libro
     * @param <E> el tipo del compuesto, por ejemplo Ejemplar
     */
    private static <T, E> void fillEntityField(T t, Field field, Connection con, Class<E> clazz, String fk) throws IllegalAccessException {
        Field idField = null;
        for (Field campo : t.getClass().getDeclaredFields()) {
            if (campo.getDeclaredAnnotation(PrimaryKey.class) != null) idField = campo;
        }

        if (idField == null) throw new NoPrimaryKeyException("Tiene que haber una primary key");
        idField.setAccessible(true);
        Object idValue = idField.get(t);
        List<E> es = getByField(clazz, fk, idValue, con);
        field.setAccessible(true);
        field.set(t, es);
    }

    /**
     *
     * @param t
     * @return el
     * @throws IllegalAccessException si se accede a algún elemento de la clase sin poder hacerlo
     */
    private static <T> String getUpdateString(T t) throws IllegalAccessException {
        Field pkField = null;
        StringBuilder updateBuilder = new StringBuilder("UPDATE ")
                .append(t.getClass().getSimpleName())
                .append(" SET ");
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Entity.class)
                    || field.isAnnotationPresent(Ignore.class)) continue;
            if (field.isAnnotationPresent(PrimaryKey.class)) {
                pkField = field;
            }
            updateBuilder.append(field.getName()).append(" = ");
            field.setAccessible(true);
            Object val = field.get(t);
            if (val instanceof String) updateBuilder.append("'").append(val).append("'");
            else updateBuilder.append(val);
            updateBuilder.append(", ");
        }
        updateBuilder.delete(updateBuilder.length() - 2, updateBuilder.length() - 1);
        updateBuilder.append(" WHERE ").append(pkField.getName()).append(" = ").append(pkField.get(t));
        return updateBuilder.toString();
    }

    /**
     * Añade los nombres de los campos a sb para que la sentencia select tenga los campos
     * @param sb el StringBuilder que está construyendo la sentencia select
     * @param clazz la clase que tiene los campos a buscar
     */
    private static <T> void appendSelectFields(StringBuilder sb, Class<T> clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Entity.class)
                    || field.isAnnotationPresent(Ignore.class)) continue;
            sb.append(field.getName()).append(", "); // SELECT id, nombre, ...
        }                                             
        sb.delete(sb.length() - 2, sb.length() - 1); // Quitar la coma y el espacio del final para
                                                     // que no quede como SELECT id, nombre, FROM ...
    }

    private static <T> int getOperation(Class<T> clazz, Operation operation, String fieldName, Connection con) {
        String select = "SELECT round("+ operation.name() + "("  + fieldName + "))" + " result FROM " +  clazz.getSimpleName();
        try {
            PreparedStatement ps = con.prepareStatement(select);
            ResultSet set = ps.executeQuery();
            set.next();
            return set.getInt("result");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return 0;
    }

    public static <T> int getAvg(Class<T> clazz,String fieldName, Connection con) {
        return getOperation(clazz, Operation.AVG, fieldName, con);
    }

    public static <T> int getSum(Class<T> clazz, String fieldName, Connection con) {
        return getOperation(clazz, Operation.SUM, fieldName, con);
    }
}
