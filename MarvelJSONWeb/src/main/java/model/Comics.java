package model;

import java.util.List;

public class Comics {
	private List<Comic> items;

	public List<Comic> getItems() {
		return items;
	}

	public void setItems(List<Comic> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Comics [items=" + items + "]";
	}
	
}
