package model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Time {
	@SerializedName("main")
	private Temperature temp;
	private List<Weather> weather;
	private float pop;
	@SerializedName("dt_txt")
	private String fecha;
	public Time(Temperature temp, List<Weather> weather, int pop, String fecha) {
		super();
		this.temp = temp;
		this.weather = weather;
		this.pop = pop;
		this.fecha = fecha;
	}
	public Temperature getTemp() {
		return temp;
	}
	public void setTemp(Temperature temp) {
		this.temp = temp;
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	public float getPop() {
		return pop;
	}
	public void setPop(float pop) {
		this.pop = pop;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Time [temp=" + temp + ", weather=" + weather + ", pop=" + pop + ", fecha=" + fecha + "]";
	}
	
	
}
