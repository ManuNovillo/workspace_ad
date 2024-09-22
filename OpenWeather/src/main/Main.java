package main;

import java.util.ArrayList;

import model.Dia;
import parser.OpenWeather;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Dia> dias = OpenWeather.getForecast();
		System.out.println(dias.size());
		for (Dia dia : dias) {
			System.out.println(dia);
		}
	}
}
