package model;

import java.util.List;

public class OpenWeather {
	private List<Time> list;

	public OpenWeather(List<Time> list) {
		super();
		this.list = list;
	}

	public List<Time> getList() {
		return list;
	}

	public void setList(List<Time> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "OpenWeather [list=" + list + "]";
	}
	
}
