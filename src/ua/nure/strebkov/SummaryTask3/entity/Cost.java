package ua.nure.strebkov.SummaryTask3.entity;

public class Cost {
	
	private Integer cost;
	
	@Override
	public String toString() {
		
		return cost.toString();
	}
	
	public Cost(int cost) {
		this.cost = cost;
	}
	public Integer getCost() {
		return cost;
	}
	
	public void setCost(Integer cost) {
		this.cost = cost;
	}

}
