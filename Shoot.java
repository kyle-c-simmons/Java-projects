/*	StarFighterz 
 *	Version 1.0
 *	Kyle Simmons
 *
 *	CLASS - Shoot - Allows enemies to shoot
 */

package starfighterz;

import processing.core.*;

public class Shoot extends StarFighterz {
	
	private PApplet sketch; 
	private PImage redLaser;
	private PImage blueLaser;

	private static final long serialVersionUID = 1L;
	public float pos_x;
	public float pos_y;
	public int speed;

	Shoot(PApplet sketch, float pos_x, float pos_y, int speed) {
		this.sketch = sketch;
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.speed = speed;
		redLaser = sketch.loadImage("images/redLaser.png");
		blueLaser = sketch.loadImage("images/blueLaser.png");
	}
	
	/*
	 *	Render enemy laser
	 */
	private void renderRedLaser() {
		sketch.image(redLaser,pos_x,pos_y);
	}
	
	public void renderBlueLaser(){
		sketch.image(blueLaser, pos_x, pos_y);
	}
	
	/*
	 *	Move the laser
	 */
	public void moveLaser() {
		this.pos_y += this.speed;
	}
	
	public void update() {
		renderRedLaser();
		moveLaser();
	}

}
