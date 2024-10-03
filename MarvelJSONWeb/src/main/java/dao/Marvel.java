package dao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import model.Result;

public class Marvel {
	public Result get() throws IOException, URISyntaxException {
		String direccion = "https://gateway.marvel.com/v1/public/characters?limit=100&offset=1&apikey=e894ad1f6af082d2b6b7a63ff20f35e0&hash=6faa0674ad5f8d6d7563ae9d0ad65dc9&ts=9";
		String text = IOUtils.toString(new URI(direccion), Charset.forName("utf-8"));
		return new Gson().fromJson(text, Result.class);
	}
}
