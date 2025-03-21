package parser;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.Dia;

public class OpenWeather {
	
	public static ArrayList<Dia> getForecast() {
		ArrayList<Dia> forecast = new ArrayList<Dia>();
		String direccion = "http://api.openweathermap.org/data/2.5/forecast?q=Toledo,es&units=metric&mode=xml&APPID=601c9db344b44f9774ef76a4c07979b1&lang=sp";
		Document doc = new DOMParserWeb(direccion).getDocumento();
		Element root = (Element) doc.getElementsByTagName("weatherdata").item(0);
		NodeList times = ((Element) (root.getElementsByTagName("forecast").item(0))).getElementsByTagName("time");
		for(int i = 0; i < times.getLength(); i++) {
			Element time = (Element) times.item(i);
			String timeFrom = time.getAttribute("from");
			String timeTo = time.getAttribute("to");
			String symbolName = getAttribute(time, "symbol", "name");
			String precipitationProb = getAttribute(time, "precipitation", "probability");
			String tempMax = getAttribute(time, "temperature", "max");
			String tempMin = getAttribute(time, "temperature", "min");
			String codigo = getAttribute(time, "symbol", "var");
			forecast.add(new Dia(timeFrom, timeTo, symbolName, precipitationProb, tempMax, tempMin, codigo));
		}
		
		return forecast;
	}
	
	private static String getAttribute(Element parentElement, String element, String attribute) {
		return ((Element) parentElement.getElementsByTagName(element).item(0)).getAttribute(attribute);
	}
}
