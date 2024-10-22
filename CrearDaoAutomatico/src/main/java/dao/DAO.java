package dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	
	public static <T> List<T> getAll(Class<T> clazz, Connection con) throws Exception {
		return getAll(clazz, con, "");
	}
	
	public static <T> List<T> getAll(Class<T> clazz, Connection con, String order) {
		List<T> ts = new ArrayList<>();
		StringBuilder selectBuilder = new StringBuilder("SELECT ");
		for (Field field : clazz.getDeclaredFields()) {
			selectBuilder.append(field.getName()).append(", ");
		}
		selectBuilder.delete(selectBuilder.length() - 2, selectBuilder.length() - 1);
		selectBuilder.append("FROM ").append(clazz.getSimpleName()).append(" ").append(order);
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(selectBuilder.toString());
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				T t = clazz.getConstructor().newInstance();
				for (Field field : clazz.getDeclaredFields()) {
					field.setAccessible(true);
					char letraMayus = Character.toUpperCase(field.getType().getSimpleName().charAt(0));
					String nombreMetodo = "get" + letraMayus + field.getType().getSimpleName().substring(1);
					field.set(t, set.getClass().getMethod(nombreMetodo , String.class).invoke(set, field.getName()));
				}
				ts.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ts;
	}
	
	public static <T> T get(Class<T> clazz, Object pk, Connection con) {
		StringBuilder selectBuilder = new StringBuilder("SELECT ");
		Field pkCampo = null;
		T t = null;
		for (Field field : clazz.getDeclaredFields()) {
			selectBuilder.append(field.getName()).append(", ");
			if (field.getAnnotation(PrimaryKey.class) != null) {
				pkCampo = field;
			}
		}
		selectBuilder.delete(selectBuilder.length() - 2, selectBuilder.length() - 1);
	
		selectBuilder.append("FROM ").append(clazz.getSimpleName()).append(" WHERE " + pkCampo.getName() + " = " + pk);
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(selectBuilder.toString());
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				t = clazz.getConstructor().newInstance();
				for (Field field : clazz.getDeclaredFields()) {
					field.setAccessible(true);
					char letraMayus = Character.toUpperCase(field.getType().getSimpleName().charAt(0));
					String nombreMetodo = "get" + letraMayus + field.getType().getSimpleName().substring(1);
					field.set(t, set.getClass().getMethod(nombreMetodo , String.class).invoke(set, field.getName()));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
		
	}
}
