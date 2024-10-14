package dao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Player;
import model.Team;

public class NBA {

	public NBA() {
		super();
	}
	
	public List<Team> getTeams(){
		String urtTXT = "http://www.ies-azarquiel.es/paco/apinba/teams";
		List<Team> teams=null;
		
		try {
			// traer JSON de internet a través de la URL en formato String
			URI uri = new URI(urtTXT);
			String jsonTxt = IOUtils.toString(uri.toURL(), Charset.forName("UTF-8"));
			// serializar
			TypeToken<List<Team>> listType = new TypeToken<List<Team>>() {};
			teams = (List<Team>) new Gson().fromJson(jsonTxt, listType);
			 
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teams;
	}
	
	public List<Player> getPlayers(String name){
		String urtTXT = "http://www.ies-azarquiel.es/paco/apinba/players/team?name="+name;
		urtTXT = urtTXT.replace(" ", "%20");
		List<Player> players=null;
		
		try {
			// traer JSON de internet a través de la URL en formato String
			URI uri = new URI(urtTXT);
			String jsonTxt = IOUtils.toString(uri.toURL(), Charset.forName("UTF-8"));
			// serializar
			TypeToken<List<Player>> listType = new TypeToken<List<Player>>() {};
			players = (List<Player>) new Gson().fromJson(jsonTxt, listType);
			 
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return players;
	}

	
}
