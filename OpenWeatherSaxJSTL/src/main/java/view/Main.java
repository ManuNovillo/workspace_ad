package view;

import java.util.ArrayList;

import model.Dia;
import parser.ManejadorWeb;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Dia> dias = new ManejadorWeb("http://api.openweathermap.org/data/2.5/forecast?q=Toledo,es&units=metric&mode=xml&APPID=601c9db344b44f9774ef76a4c07979b1&lang=sp").parsear();
		for (Dia dia : dias) {
			System.out.println(dia);
		}
	}
}
