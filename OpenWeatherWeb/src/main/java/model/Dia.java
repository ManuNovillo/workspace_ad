package model;

public class Dia {
	private String timeFrom;
	private String timeTo;
	private String symbolName;
	private String precipitationProb;
	private String tempMax;
	private String tempMin;
	private String codigo;
	
	public Dia(String timeFrom, String timeTo, String symbolName, String precipitationProb, String tempMax,
			String tempMin, String codigo) {
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.symbolName = symbolName;
		this.precipitationProb = precipitationProb;
		this.tempMax = tempMax;
		this.tempMin = tempMin;
		this.codigo = codigo;
	}
	
	public Dia() {}
	
	public String getTimeFrom() {
		return timeFrom;
	}
	
	public String getTimeTo() {
		return timeTo;
	}
	
	public String getSymbolName() {
		return symbolName;
	}
	
	public String getPrecipitationProb() {
		return precipitationProb;
	}
	
	public String getTempMax() {
		return tempMax;
	}
	
	public String getTempMin() {
		return tempMin;
	}
	
	public String getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Dia [timeFrom=" + timeFrom + ", timeTo=" + timeTo + ", symbolName=" + symbolName
				+ ", precipitationProb=" + precipitationProb + ", tempMax=" + tempMax + ", tempMin=" + tempMin + ", codigo=" + codigo + "]";
	}

	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}

	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}

	public void setSymbolName(String symbolName) {
		this.symbolName = symbolName;
	}

	public void setPrecipitationProb(String precipitationProb) {
		this.precipitationProb = precipitationProb;
	}

	public void setTempMax(String tempMax) {
		this.tempMax = tempMax;
	}

	public void setTempMin(String tempMin) {
		this.tempMin = tempMin;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
}
