package model;

import java.util.List;

public class Lieux {
	private String titre;
	private String description_es;
	private List<Photo> photos;
	private String id;

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription_es() {
		return description_es;
	}

	public void setDescription_es(String description_es) {
		this.description_es = description_es;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	
	public String getId() {
		return id;
	}

}
