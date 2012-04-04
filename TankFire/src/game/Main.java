package game;

import java.awt.Point;
import java.text.DecimalFormat;

import panzer.Panzer;

public class Main {

	public static void main (String args[]) {
		DecimalFormat df = new DecimalFormat("#.##");
		int t_min = 0;
		int t_h = 0;
		Panzer panzer = new Panzer();
		Point feld;
		System.out.println("#####START#####");
		System.out.println(panzer.getName() + " unter Leitung von " +panzer.getKommandant().getName());
		while(t_h < 1) {
			if(t_min >= 60) {
				t_h++;
				t_min = 0;
			}

			feld = panzer.getMap().getField(panzer.getPos_x(), panzer.getPos_y());
			System.out.println(t_h+ ":"+t_min+" Position: \t" + df.format(panzer.getPos_x()) + ":" + df.format(panzer.getPos_y()) + "\t SF: " + df.format(feld.getX())+"."+df.format(feld.getY())+"\t Heading: "+panzer.getHeading());	
			panzer.move(60);
			t_min++;
		}
		
		
	}
}
