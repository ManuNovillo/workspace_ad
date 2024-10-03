package model;

public class Thumbnail {
	private String thumbnail;
	private String extension;
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	@Override
	public String toString() {
		return "Thumbnail [thumbnail=" + thumbnail + ", extension=" + extension + "]";
	}
	
	
}
