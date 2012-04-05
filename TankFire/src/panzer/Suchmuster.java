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
		//Wenn Richtung 180 S�D UND (Feld im S�den bekannt ist ODER Feld im S�den < als Karte)
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
		//Fahr nach S�den
		if(panzer.getHeading() == 90 && (panzer.getVisitedField().contains(panzer.map.getField(panzer.getPos_x(),panzer.getPos_y()+Config.viewdistance)) | panzer.getPos_y()+Config.viewdistance > panzer.map.getHeight() )) {
			panzer.setHeading(90);
			panzer.move(panzer.getHeading(), time);
		}
	}

}
