package panzer.module;

public class Kommandant {
	
	String name = "Karl Heinz";
	int rang = 0;		//Dienstrang
	int driving = 0;	//Fahrzeugtraining steigert Geschwindigkeit
	int defending = 0;	//Panzertaktik steigert Panzerungsfähigkeit
	int fighting = 0;	//Feuerkampf steigert Durchschlagsleistung
	

	public Kommandant(String name, int rang, int driving, int defending,
			int fighting) {
		super();
		this.name = name;
		this.rang = rang;
		this.driving = driving;
		this.defending = defending;
		this.fighting = fighting;
	}

	public Kommandant() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRang() {
		return rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}

	public int getDriving() {
		return driving;
	}

	public void setDriving(int driving) {
		this.driving = driving;
	}

	public int getDefending() {
		return defending;
	}

	public void setDefending(int defending) {
		this.defending = defending;
	}

	public int getFighting() {
		return fighting;
	}

	public void setFighting(int fighting) {
		this.fighting = fighting;
	}
	
	

}
