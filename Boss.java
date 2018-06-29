/*	StarFighterz 
 *	Version 1.0
 *	Kyle Simmons
 *
 *	CLASS - Boss - Creates a boss enemy
 */

package starfighterz;
import processing.core.*;

public class Boss {

	private PApplet sketch;
	private PImage destroyerBoss;
	private PImage droidBoss;
	private PImage speederBoss;
	private PImage boss;
	
	public float pos_x;
	public float pos_y;
	public float speed;
	private float reset_x;
	private float reset_y;
	public int health;
	
	Boss(PApplet sketch, float pos_x, float pos_y, float speed, int health) {
		this.sketch = sketch;
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.reset_x = pos_x;
		this.reset_y = pos_y;
		this.speed = speed;
		this.health = health;
		destroyerBoss = sketch.loadImage("images/destroyerBoss.png");
		droidBoss = sketch.loadImage("images/droidBoss.png");
		speederBoss = sketch.loadImage("images/speederBoss.png");
		boss = sketch.loadImage("images/boss.png");
	}
	
	/*
	 *	Draws the bosses on screen 
	 */
	public void renderBossLevel1() {
		sketch.image(destroyerBoss, pos_x, pos_y);
	}
	
	public void renderBossLevel2() {
		sketch.image(droidBoss, pos_x, pos_y);
	}
	
	public void renderBossLevel3() {
		sketch.image(speederBoss, pos_x, pos_y);
	}
	
	public void renderBossLevel4() {
		sketch.image(boss, pos_x, pos_y);
	}
	
	/*
	 *	Basic boss movement
	 */
	public void moveBoss() {
		this.pos_x += this.speed;
	    
		if(this.pos_x > 620) {
		    this.speed *= -1;
		    this.pos_y += 80;
		}
		else if(this.pos_x < 20) {
			this.speed *= -1;
			this.pos_y +=  80;
		}
		if(this.pos_y > 350) {
			this.pos_y -=  100;
		}
	}
	
	/*
	 *	Different movement pattern for some bosses
	 */
	public void fastMoveBoss() {
		this.pos_x += this.speed;
	    
		if(this.pos_x > 620) {
		    this.speed *= -1;
		    this.pos_y += 80;
		}
		else if(this.pos_x < 20) {
			this.speed *= -1;
			this.pos_y +=  80;
		}
		if(this.pos_y > 350) {
			this.pos_y -=  250;
		}
	}
	
	/*
	 * 	Resets the boss to original position
	 */
	public void resetBoss() {
		this.pos_x = this.reset_x;
		this.pos_y = this.reset_y;
	}
}