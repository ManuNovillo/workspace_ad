package model;

import com.google.gson.annotations.SerializedName;

public class Temperature {
	@SerializedName("temp_min")
	private float min;
	@SerializedName("temp_max")
	private float max;
	public Temperature(float min, float max) {
		super();
		this.min = min;
		this.max = max;
	}
	public float getMin() {
		return min;
	}
	public void setMin(float min) {
		this.min = min;
	}
	public float getMax() {
		return max;
	}
	public void setMax(float max) {
		this.max = max;
	}
	@Override
	public String toString() {
		return "Temperature [min=" + min + ", max=" + max + "]";
	}
	
	
}
