package Main;

import java.awt.Color;

public class Obstacle extends unitArea {
	private int direction;
	//engel alt sinifi inherit ediyor
	public Obstacle(int x, int y, int size, Color color, int direction) {
		super(x, y, size, color);
		this.direction = direction;
	}
	// engeller tek tek hareket ediyor
	public void move(int xStart, int xEnd) {
		if(direction == 1) {
			int x = getX();
			if(x+1 >= xEnd) {
				setX(xStart);
			} else {
				setX(x+1);
			}
		} else {
			int x = getX();
			if(x-1 < xStart) {
				setX(xEnd-1);
			} else {
				setX(x-1);
			}
		}
	}
}

