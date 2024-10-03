package view;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import model.OpenWeather;
import model.Time;

public class Prueba {
	public static void main(String[] args) {
		String url = "http://api.openweathermap.org/data/2.5/forecast?q=Toledo,es&units=metric&APPID=601c9db344b44f9774ef76a4c07979b1&lang=sp";
		try {
			String text = IOUtils.toString(new URI(url), Charset.forName("utf-8"));
			OpenWeather ow = new Gson().fromJson(text, OpenWeather.class);
			for (Time time : ow.getList()) {
				System.out.println(time);
			}
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}