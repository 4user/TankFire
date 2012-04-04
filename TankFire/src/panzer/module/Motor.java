package panzer.module;

public class Motor {
	
	String name = "S-Motor";
	double speed = 30; 	//GefechtsGeschwinddigkeit in km/h
	double risk = 20; 	//Ausfallrate in %
	double weight = 1000; //Gewicht in kg
	int cost = 1000; 	//Preis
	
	
	public Motor() {
		super();
	}


	public Motor(String name, double speed, double risk, double weight, int cost) {
		super();
		this.name = name;
		this.speed = speed;
		this.risk = risk;
		this.weight = weight;
		this.cost = cost;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSpeed() {
		return speed;
	}


	public void setSpeed(double speed) {
		this.speed = speed;
	}


	public double getRisk() {
		return risk;
	}


	public void setRisk(double risk) {
		this.risk = risk;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	
}
