package model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Data {
	@SerializedName("results")
	private List<Personaje> personajes;

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

	@Override
	public String toString() {
		return "Data [personajes=" + personajes + "]";
	}
	
	
}
