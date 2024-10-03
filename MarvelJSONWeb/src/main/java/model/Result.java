package model;

public class Result {
	
	private Data data;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [data=" + data + "]";
	}

	
}
