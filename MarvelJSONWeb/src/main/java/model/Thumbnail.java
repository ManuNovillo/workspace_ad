package model;

public class Thumbnail {
	private String path;
	private String extension;
	private String picture;
	
	public String getThumbnail() {
		return path;
	}
	public void setPath(String thumbnail) {
		this.path = thumbnail;
	}
	public String getPath() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	@Override
	public String toString() {
		return "Thumbnail [path=" + path + ", extension=" + extension + "]";
	}
	
	public String getPicture() {
		return path + "." + extension;
	}
	
	
}
