package model;

public class Dia {
	String timeFrom;
	String timeTo;
	String symbolName;
	String precipitationProb;
	String tempMax;
	String tempMin;
	String codigo;

	public Dia(String timeFrom, String timeTo, String symbolName, String precipitationProb, String tempMax,
			String tempMin, String codigo) {
		super();
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.symbolName = symbolName;
		this.precipitationProb = precipitationProb;
		this.tempMax = tempMax;
		this.tempMin = tempMin;
		this.codigo = codigo;
	}

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
				+ ", precipitationProb=" + precipitationProb + ", tempMax=" + tempMax + ", tempMin=" + tempMin + "]";
	}
	
	

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
