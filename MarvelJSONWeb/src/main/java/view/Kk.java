package view;

import dao.Marvel;
import model.Personaje;
import model.Result;

public class Kk {
	public static void main(String[] args) throws Exception {
		Result r = new Marvel().get();
		for (Personaje p : r.getData().getPersonajes()) {
			System.out.println(p);
		}
	}
}
