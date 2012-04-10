package panzer;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


import game.Config;
import game.Map;
import panzer.module.*;
import panzer.Suchmuster;

public class Panzer {
	
	Map map = new Map();
	String name = "Panzer";
	String[] typ ={"leichter", "mittlerer", "schwerer"};
	double pos_x = 0; // in m
	double pos_y = 0; // in m
	int level = 1;
	boolean in_danger = false;
	boolean in_use = false;	
	int heading = 0;
	List<Point> visitedField = new ArrayList<Point>();
	boolean isAttacker = true;
	Suchmuster suchmuster = new Suchmuster();
	
	
	Kanone kanone = new Kanone();
	Kommandant kommandant = new Kommandant();
	Motor motor = new Motor();
	Panzerung panzerung = new Panzerung();	
	
	/* Leichter Panzer, Typfahrzeug Panzer II, Gewicht unter 20 Tonnen, Bewaffnung mindestens 2 cm und höchstens 4,9 cm.
	- Mittlerer Panzer, Typfahrzeug Panzer IV, Gewicht über 20 Tonnen bis 39 Tonnen, Bewaffnung mindestens 5 cm bis 8,4 cm.
	-  Schwerer Panzer, Typfahrzeug Panzer V, Gewicht über 40 Tonnen, Bewaffnung mindestens 8,5 cm oder 7,5 cm überlang.
	*/

	
	public Panzer() {
		this.name = "Panzer III";
		Point point = new Point();

	}
	//TODO new CONSTRUCTOR
	public Panzer(String name, String[] typ, int pos_x, int pos_y, int level,
			boolean in_danger, Kanone kanone, Kommandant kommandant,
			Motor motor, Panzerung panzerung, Map map) {
		super();
		this.name = name;
		this.typ = typ;
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.level = level;
		this.in_danger = in_danger;
		this.kanone = kanone;
		this.kommandant = kommandant;
		this.motor = motor;
		this.panzerung = panzerung;
		this.map = map;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getTyp() {
		return typ;
	}

	public void setTyp(String[] typ) {
		this.typ = typ;
	}

	public double getPos_x() {
		return pos_x;
	}

	public void setPos_x(double pos_x) {
		this.pos_x = pos_x;
	}

	public double getPos_y() {
		return pos_y;
	}

	public void setPos_y(double pos_y) {
		this.pos_y = pos_y;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isIn_danger() {
		return in_danger;
	}

	public void setIn_danger(boolean in_danger) {
		this.in_danger = in_danger;
	}

	public Kanone getKanone() {
		return kanone;
	}

	public void setKanone(Kanone kanone) {
		this.kanone = kanone;
	}

	public Kommandant getKommandant() {
		return kommandant;
	}

	public void setKommandant(Kommandant kommandant) {
		this.kommandant = kommandant;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public Panzerung getPanzerung() {
		return panzerung;
	}

	public void setPanzerung(Panzerung panzerung) {
		this.panzerung = panzerung;
	}
	
	public boolean isIn_use() {
		return in_use;
	}

	public void setIn_use(boolean in_use) {
		this.in_use = in_use;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
	
	public int getHeading() {
		return heading;
	}

	public void setHeading(int heading) {
		this.heading = heading;
	}

	public List<Point> getVisitedField() {
		return visitedField;
	}

	public void setVisitedField(List<Point> visitedField) {
		this.visitedField = visitedField;
	}
	
	public boolean isVisitedField(double distance, int direction) {
		Point point = new Point();
		double h_x,h_y;
		h_x = this.pos_x + (distance * Math.sin(Math.toRadians(direction)));
		h_y = this.pos_y + (distance * Math.cos(Math.toRadians(direction)));
		point.setLocation(h_x, h_y);
		if(this.getVisitedField().contains(point) 
				| point.x > this.map.getWidth() 
				| point.x < 0 
				| point.y > this.map.getHeight() 
				| point.y < 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isAttacker() {
		return isAttacker;
	}

	public void setAttacker(boolean isAttacker) {
		this.isAttacker = isAttacker;
	}

	public void move(int pattern) {
		
		if(pattern == 0) {
			suchmuster.tiefensuche(this, Config.tick);			
		}
	}
	
	//direction 0 north, 90 east, 180 south, 270 west
	//time in sec
	public void move(int direction, int time) {
		
		//aktuelle Position merken
		Point point = new Point();
		point.setLocation(pos_x, pos_y);
		this.visitedField.add(point);
		
		double distance = (this.motor.getSpeed()/3.6)*time;
		
		//Unter Gefahr bewegt sich die Einheit nur mit halber Geschwindigkeit
		if(in_danger) {
			distance = distance/2;
		}
		
		this.pos_x = this.pos_x + (distance * Math.sin(Math.toRadians(direction)));
		this.pos_y = this.pos_y + (distance * Math.cos(Math.toRadians(direction)));
		
		if(this.pos_x < 0) {	this.pos_x = 0; }
		if(this.pos_y < 0) {	this.pos_y = 0; }
		if(this.pos_x > map.getWidth()*1000) 	{	this.pos_x = map.getWidth()*1000; }
		if(this.pos_y > map.getHeight()*1000) 	{	this.pos_y = map.getHeight()*1000; }
		
		/*4 Bewegungsrichtungen Switch direction 0 = north, 1 = east, 2 = south, 3 = west
		switch(direction) {
		case 0 : this.pos_y = pos_y + distance; break;
		case 1 : this.pos_x = pos_x + distance; break;
		case 2 : this.pos_y = pos_y - distance; break;
		case 3 : this.pos_x = pos_x - distance; break;
		default : System.out.println(this.name + " unter Führung von " + this.kommandant.getName()+" fährt in unbekannte Richtung: " +direction);
		}
		*/
	}

}
