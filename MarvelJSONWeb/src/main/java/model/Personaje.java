package model;

public class Personaje {
	private String name;
	private String description;
	private Thumbnail thumbnail;
	private Comics comics;
	private int id;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		if (description.equals("")) return "Descripción no disponible";
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Thumbnail getThumbnail() {
		return thumbnail;
	}
	
	public void setThumbnail(Thumbnail thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public Comics getComics() {
		return comics;
	}
	
	public void setComics(Comics comics) {
		this.comics = comics;
	}
	@Override
	public String toString() {
		return "Personaje [id=" + id + "name=" + name + ", description=" + description + ", thumbnail=" + thumbnail + ", comics="
				+ comics + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
