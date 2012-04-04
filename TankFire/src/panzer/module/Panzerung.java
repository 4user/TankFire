package panzer.module;

public class Panzerung {
	
	String name = "Panzerplatten";
	int thickness = 10; 	//stärke in mm;
	int hardening = 0;  //Härtung in %;
	int weight = 1000;	//Gewicht in kg
	int risk = 10;		//Ausfallrate in %
	int angle = 0;		//Winkel für bessere Form
	int cost = 1000;		//Preis
	
	
	public Panzerung() {
		super();
	}

	public Panzerung(String name, int thickness, int hardening, int weight,
			int risk, int angle, int cost) {
		super();
		this.name = name;
		this.thickness = thickness;
		this.hardening = hardening;
		this.weight = weight;
		this.risk = risk;
		this.angle = angle;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	public int getHardening() {
		return hardening;
	}

	public void setHardening(int hardening) {
		this.hardening = hardening;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getRisk() {
		return risk;
	}

	public void setRisk(int risk) {
		this.risk = risk;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	

}
