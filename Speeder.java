/*	StarFighterz 
 *	Version 1.0
 *	Kyle Simmons
 *
 *	CLASS - Speeder - Creates speeder enemye
 */

package starfighterz;
import processing.core.*;

public class Speeder {

	private PApplet sketch;
	private PImage speeder;
	
	public int pos_x;
	public int pos_y;
	public int speed;
	private int reset_x;
	private int reset_y;
	
	Speeder(PApplet sketch, int pos_x, int pos_y, int speed) {
		this.sketch = sketch;
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.reset_x = pos_x;
		this.reset_y = pos_y;
		this.speed = speed;
		speeder = sketch.loadImage("images/enemy.png");
	}
	
	/*
	 *	Draws the enemy speeder on screen 
	 */
	public void render() {
		sketch.image(speeder, this.pos_x, this.pos_y);
	}
	
	/*
	 * 	Moves the speeder across the screen
	 */
	public void move() {
		this.pos_x += this.speed;
	    
		if(this.pos_x > 680) {
		    this.speed *= -1;
		    this.pos_y += 80;
		}
		else if(this.pos_x < 0) {
			this.speed *= -1;
		  this.pos_y += 80;
		}
	}
	
	/*
	 * 	Resets the speeders variables and moves them to original position
	 */
	public void reset() {
		this.pos_x = this.reset_x;
		this.pos_y = this.reset_y;
	}
}