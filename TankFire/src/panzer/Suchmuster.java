package panzer;

import java.awt.Point;

import game.Config;

public class Suchmuster {
	
	
	
	public void tiefensucheL(Panzer panzer, int time) {
		double _x,_y;
		Point point = new Point();
		_x = (0 + Config.viewdistance)/2;
		_y = (0 + Config.viewdistance)/2;
		point.setLocation(_x, _y);
		if(!panzer.getVisitedField().contains(panzer.map.getField(_x, _y))) {
			panzer.setHeading(270);
			panzer.move(panzer.getHeading(), time);
		}
		//Wenn Richtung 0 NORD UND (Feld im Norden bekannt ist ODER Feld im Norden > als Karte)
		//Merke aktuelles Feld
		//Fahr nach Rechts
		if(panzer.getHeading() == 0 && (panzer.getVisitedField().contains(panzer.map.getField(panzer.getPos_x(),panzer.getPos_y()+Config.viewdistance)) | panzer.getPos_y()+Config.viewdistance > panzer.map.getHeight() )) {
			point.setLocation(panzer.getPos_x(), panzer.getPos_y());
			panzer.visitedField.add(point);
			panzer.setHeading(90);
			panzer.move(panzer.getHeading(), time);
		}
		//Wenn Richtung 180 SÜD UND (Feld im Süden bekannt ist ODER Feld im Süden < als Karte)
		//Merke aktuelles Feld
		//Fahr nach Rechts
		if(panzer.getHeading() == 180 && (panzer.getVisitedField().contains(panzer.map.getField(panzer.getPos_x(),panzer.getPos_y()-Config.viewdistance)) | panzer.getPos_y()-Config.viewdistance < 0 )) {
			point.setLocation(panzer.getPos_x(), panzer.getPos_y());
			panzer.visitedField.add(point);
			panzer.setHeading(270);
			panzer.move(panzer.getHeading(), time);
		}
		// Wenn Richtung 90 Ost UND (Feld im Westen weiter entfernt als Sichtweite/2)
		// Merke aktuelles Feld
		//Fahr nach Süden
		if(panzer.getHeading() == 90 && (panzer.getVisitedField().contains(panzer.map.getField(panzer.getPos_x(),panzer.getPos_y()+Config.viewdistance)) | panzer.getPos_y()+Config.viewdistance > panzer.map.getHeight() )) {
			panzer.setHeading(90);
			panzer.move(panzer.getHeading(), time);
		}
		
	}

	public boolean tiefensuche(Panzer panzer, int time) {
		int richtung = 0;
		if(!panzer.isAttacker()) {
			richtung = 180;
		}
		
		if(panzer.getHeading()+richtung == 0 && !(panzer.isVisitedField(Config.viewdistance, 270+richtung))) {
			panzer.setHeading(270+richtung);
			panzer.move(panzer.getHeading(), time);
			return true;
		}
		//Süd, Ost bekannt --> Richtung Nord
		if(panzer.isVisitedField(Config.viewdistance, 180+richtung) 
				&& panzer.isVisitedField(Config.viewdistance, 270+richtung)) {
			panzer.setHeading(0+richtung);
			panzer.move(panzer.getHeading(), time);
			return true;
		}
		//Süd, Ost, Nord bekannt --> Richtung West
		if((panzer.isVisitedField(Config.viewdistance, 180+richtung)) 
				&& (panzer.isVisitedField(Config.viewdistance, 270+richtung)) 
				&& panzer.isVisitedField(Config.viewdistance, 0+richtung)) {
			panzer.setHeading(90+richtung);
			panzer.move(panzer.getHeading(), time);
			return true;
		}		
		//Ost, Nord bekannt	-->Richtung Süd
		if(panzer.isVisitedField(Config.viewdistance, 270+richtung) 
				&& panzer.isVisitedField(Config.viewdistance, 0+richtung)) {
			panzer.setHeading(180+richtung);
			panzer.move(panzer.getHeading(), time);	
			return true;
		} else {
			panzer.move(panzer.getHeading(), time);
			return true;
		}
		
	}
}
