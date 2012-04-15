package panzer;

import java.awt.Point;

import game.Config;

public class Suchmuster {
	
	public Point nearestPoint(Panzer panzer) {
		if(panzer.visitedField.isEmpty()) {
			return null;
		}
		double distance = Config.viewdistance*1000;
		Point rpoint = null;
		for(Point point : panzer.visitedField) {
			if(point.distance(panzer.getPos_x(), panzer.getPos_y()) < distance) {
				distance = point.distance(panzer.getPos_x(), panzer.getPos_y());
				rpoint = point;
			}			
		}
		return rpoint;		
	}
	
	public boolean tiefensucheL(Panzer panzer, int time) {
		boolean north = false;
		boolean south = false;
		boolean east = false;
		boolean west = false;
		
		if(panzer.getPos_x()+Config.viewdistance*1000 >= panzer.map.getWidth()*1000) {
			east = true;
		}
		if(panzer.getPos_x()-Config.viewdistance*1000 <= 0) {
			west = true;
		}
		if(panzer.getPos_y()+Config.viewdistance*1000 >= panzer.map.getHeight()*1000) {
			north = true;
		}
		if(panzer.getPos_y()-Config.viewdistance*1000 <= 0) {
			south = true;
		}
		
		
		for (Point point: panzer.viewField) {
			if(!north && (panzer.getBearing(point) >= 315 && panzer.getBearing(point) < 360 | panzer.getBearing(point) < 45)) {
				north = true;				
			}
			if(!east && (panzer.getBearing(point) >= 45 && panzer.getBearing(point) < 135)) {
				east = true;				
			}
			if(!south &&(panzer.getBearing(point) >= 135 && panzer.getBearing(point) < 225)) {
				south = true;				
			}
			if(!west &&(panzer.getBearing(point) >= 225 && panzer.getBearing(point) < 315)) {
				west = true;				
			}
		}
		if(panzer.isAttacker()){
			panzer.setHeading(270);
		} else {
			panzer.setHeading(95);
		}
		if(west && south ) {
			panzer.setHeading(0);
		}
		if(west && !south && north){
			panzer.setHeading(180);
		}
		if(!east && west && north && south){
			panzer.setHeading(90);			
		}
		if(east && !west && north && south) {
			panzer.setHeading(270);			
		}
		if(east && west && !north && south) {
			panzer.setHeading(0);			
		}
		if(east && west && north && !south) {
			panzer.setHeading(180);			
		}
		panzer.move(panzer.getHeading(), time);
		
		
		return true;
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
