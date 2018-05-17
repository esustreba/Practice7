package ua.nure.strebkov.SummaryTask3.entity;

public enum Meal {
	HB("HB"), OB("OB"), AI("AI");
	
	private String value;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value.toString();
	}
	
	 Meal(String value) {
		this.value = value;
	}
	
	 public void setValue(String value) {
		this.value = value;
	}
	 
	 public String getValue() {
		return value;
	}

}
