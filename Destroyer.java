/*	StarFighterz 
 *	Version 1.0
 *	Kyle Simmons
 * 
 *	CLASS - Destroyer - Creates destroyer enemy
 */

package starfighterz;
import processing.core.*;

public class Destroyer extends Droid{

	private PApplet sketch;
	private PImage destroyer;
	
	public int pos_x;
	public int pos_y;
	public int speed;
	private int reset_x;
	private int reset_y;
	
	Destroyer(PApplet sketch, int pos_x, int pos_y, int speed) {
		super(sketch, pos_x, pos_y, speed);
		this.sketch = sketch;
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.reset_x = pos_x;
		this.reset_y = pos_y;
		this.speed = speed;
		destroyer = sketch.loadImage("images/destroyer.png");
	}
	
	/*
	 *	Draws the enemy destroyer on screen 
	 */
	public void render() {
		sketch.image(destroyer, this.pos_x, this.pos_y);
	}
	
	/*
	 * 	Moves the destroyer across the screen
	 */
	public void move() {
		this.pos_x += this.speed;
	    
		if(this.pos_x > 680) {
		    this.speed *= -1;
		    this.pos_y += 40;
		}
		else if(this.pos_x < 0) {
			this.speed *= -1;
		  this.pos_y += 40;
		}
	}
	
	/*
	 * 	Resets the destroyer variables and moves them to original position
	 */
	public void reset() {
		this.pos_x = this.reset_x;
		this.pos_y = this.reset_y;
	}
}