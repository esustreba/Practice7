package ua.nure.strebkov.SummaryTask3.entity;

public class Cost {
	
	private Integer cost;
	

	public Cost(int cost) {
		this.cost = cost;
	}
	public Integer getCost() {
		return cost;
	}
	
	public void setCost(Integer cost) {
		this.cost = cost;
	}

    private String currency;

    public Cost() {

    }

    public Cost(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "currency='" + currency + '\'' +
                '}';
    }
}
