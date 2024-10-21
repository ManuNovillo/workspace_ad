package view;

import java.lang.reflect.InvocationTargetException;

import dao.DAO;

public class Prueba {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchMethodException {
		// TODO Auto-generated method stub
		DAO<Empleado> dao = new DAO<Empleado>();
		System.out.println(dao.get());
	}

}
