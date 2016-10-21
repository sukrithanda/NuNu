package constants;

public enum Markups {
	 BASE(0.05), WORKER(0.012), PHARMA(0.075), FOOD(0.13), ELECTRONIC(0.02), ELSE(0);
    private final double value;

    private Markups(double value) {
            this.value = value;
    }

	public double getValue() {
		return value;
	}

}
