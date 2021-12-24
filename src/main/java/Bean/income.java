package Bean;

public class income {
	private int id;
	private double min;
	private double merit;
	private double allo;
	private double ponins;
	private double heains;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMerit() {
		return merit;
	}

	public void setMerit(double merit) {
		this.merit = merit;
	}

	public double getAllo() {
		return allo;
	}

	public void setAllo(double allo) {
		this.allo = allo;
	}

	public double getPonins() {
		return ponins;
	}

	public void setPonins(double ponins) {
		this.ponins = ponins;
	}

	public double getHeains() {
		return heains;
	}

	public void setHeains(double heains) {
		this.heains = heains;
	}

	public double getReal() {
		return min + merit + allo - ponins - heains;
	}
}
