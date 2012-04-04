package panzer.module;

public class Kanone {
	
	String name = "KwK";
	int damage = 100;			//schaden in HP
	int penetration = 20;	//Durchschlagskraft in mm in 500m Entfernung
	int precision = 10;		//Abweichung in mm auf 100m
	int firerate = 4;		//Schuss/min
	int weight = 800;		//Gewicht
	int risk = 10;			//Ausfallrate in %
	int cost = 1000;			//Preis
	


	public Kanone() {
		super();
	}

	public Kanone(String name, int damage, int penetration, int precision,
			int firerate, int weight, int risk, int cost) {
		super();
		this.name = name;
		this.damage = damage;
		this.penetration = penetration;
		this.precision = precision;
		this.firerate = firerate;
		this.weight = weight;
		this.risk = risk;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getPenetration() {
		return penetration;
	}

	public void setPenetration(int penetration) {
		this.penetration = penetration;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public int getFirerate() {
		return firerate;
	}

	public void setFirerate(int firerate) {
		this.firerate = firerate;
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}



}