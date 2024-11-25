package Main;

import java.awt.Color;
import java.awt.Graphics;

public class unitArea {
	private int x, y, width, height;
	private Color color;
	//birim karedeki sekil icin sinif tanimlaniyor
	public unitArea(int x, int y, int size, Color color) {
		this.x = x;
		this.y = y;
		width = size;
		height = size;
		this.color = color;
		
	}
	
	public void tick() {
		
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x*width, y*height, width, height);
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x; 
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y; 
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	// baska bir engelle carpisiyor mu diye bakiliyor
	public boolean didCollide(unitArea object) {
		if(x - 1 < object.getX() && object.getX() < x + 1) {
			if(y - 1 < object.getY() && object.getY() < y + 1) {
				//System.out.println("x: " + x +" y: " + y + " xhero: " + object.getX() + " yhero: "+ object.getY());
				return true;
			}
		}
		
		return false;
	}
	
}



