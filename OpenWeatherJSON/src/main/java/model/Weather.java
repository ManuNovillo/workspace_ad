package model;

public class Weather {
	private String description;
	private String icon;
	
	public Weather(String description, String icon) {
		super();
		this.description = description;
		this.icon = icon;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Override
	public String toString() {
		return "Weather [description=" + description + ", icon=" + icon + "]";
	}
	
	
	
}