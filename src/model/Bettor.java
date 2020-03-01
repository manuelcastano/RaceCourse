package model;

public class Bettor {
	
	private String nit;
	private String name;
	private String horse;
	private double amount;
	
	public Bettor(String nit, String name, String horse, double amount) {
		this.nit = nit;
		this.name = name;
		this.horse = horse;
		this.amount = amount;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHorse() {
		return horse;
	}

	public void setHorse(String horse) {
		this.horse = horse;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
