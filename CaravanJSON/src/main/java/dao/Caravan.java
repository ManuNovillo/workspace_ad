package dao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import model.Lieux;
import model.Root;

public class Caravan {

	public static List<Lieux> getLugares() {
		String urtTXT = "https://guest.park4night.com/services/V4.1/lieuxGetFilter.php?latitude=39.856780&longitude=-4.024476&context_os=ANDROID&context_lang=es&langue_locale=es_ES";
		try {
			// traer JSON de internet en formato String
			URI uri = new URI(urtTXT);
			String jsonTxt = IOUtils.toString(uri.toURL(), Charset.forName("UTF-8"));
			// Result es la clase que representa este JSON Object
			return new Gson().fromJson(jsonTxt, Root.class).getLieux();
			
		} catch (IOException e) {

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
