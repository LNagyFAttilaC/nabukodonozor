package grafikus;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import nabukodonozor.Field;
import nabukodonozor.Mountain;
import nabukodonozor.Program;

public class MountainView extends CellView {
	//konstruktor
	public MountainView(Mountain mountain) {
		cell = mountain;
	}
	
	public void notifyView(){
		// célcella meghatározása
		int c_x = x*40;
		int c_y = y*40;
		
		// kép kirajzolása
		ImagePanel land = new ImagePanel("pics/mountain.jpg");
		land.setSize(40, 40);
		land.setLocation(200, 400);
		Program.game.add(land);
	}
}