/*	StarFighterz 
 *	Version 1.0
 *	Kyle Simmons
 *
 *	CLASS - StarFighterz (main class) runs the game
 */

package starfighterz;

import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import processing.core.*;

public class StarFighterz extends PApplet {
	
	// Variables setup - for backgrounds, lives,  scores and how many enemies have been killed.
	private static final long serialVersionUID = 1L;
	private boolean start = false;
	private int background_y = 0;
	private int currentScore = 0;
	private int totalScore = 0;
	private int bestScore = 0;
	private int playerLives = 3;
	private float startTime, currTime;
	private int enemyDeadLevel1 = 0;
	private int enemyDeadLevel2 = 0;
	private int enemyDeadLevel3 = 0;
	private int enemyDeadLevel4 = 0;
	
	// Boss setup, new instance of boss and get the health variable from Boss
	
	Boss bossLevel1 = new Boss(this,200,200,3,700);
	private int health1 = bossLevel1.health;
	
	Boss bossLevel2 = new Boss(this,200,200,4,700);
	private int health2 = bossLevel2.health;
	
	Boss bossLevel3 = new Boss(this,200,200,8,700);
	private int health3 = bossLevel3.health;
	
	Boss bossLevel4 = new Boss(this,200,200,5,700);
	private int health4 = bossLevel4.health;
		
	// Setup arraylists for storing player and enemy lasers
	ArrayList<Laser> lasers = new ArrayList<Laser>();
	ArrayList<Shoot> destroyerShoot = new ArrayList<Shoot>();
	ArrayList<Shoot> droidShoot = new ArrayList<Shoot>();
	ArrayList<Shoot> speederShoot = new ArrayList<Shoot>();
	ArrayList<Shoot> bossShoot = new ArrayList<Shoot>();
	
	// Level 1 - 2d arrays (1 destroyer / 1 speeder)
	Destroyer[][] destroyer1 = new Destroyer[5][3];
	Speeder[][] speeder1 = new Speeder[8][1];
	
	// Level 2 - 2d array (2 droids)
	Droid[][] droid1 = new Droid[8][4];
	Droid[][] droid2 = new Droid[8][4];
	
	// Level 3 - 2d array (2 destroyers / 1 speeder)
	Destroyer[][] destroyer2 = new Destroyer[10][4];
	Destroyer[][] destroyer3 = new Destroyer[10][4];
	Speeder[][] speeder4 = new Speeder[8][1];
	
	// Level 4 - 2d array (1 destroyer / 1 droid 2 speeders)
	Destroyer[][] destroyer5 = new Destroyer[10][4];
	Droid[][] droid3 = new Droid[8][4];
	Speeder[][] speeder6 = new Speeder[8][1];
	Speeder[][] speeder7 = new Speeder[8][1];
	
	
	// New instance of the player
	Player p1 = new Player(this,310,550,5);
	
	// Create image variables
	private PImage gameBackground;
	private PImage menuBackground;
	private PImage levelBackground;
	private PImage helpBackground;
	private PImage help2Background;
	private PImage gameoverBackground;
	private PImage win1Background;
	private PImage win2Background;	
	private PImage win3Background;
	private PImage win4Background;
	
	
	// Create audio variables
	private Clip laserSound;
	private Clip gameoverSound;
	private Clip buttonSound;
	private Clip hitSound;
	private Clip dieSound;
	private Clip victorySound;
	private Clip playerHitSound;
	
	/*
	 * Setup all menus for game
	 */
	private enum LocationSetup {
		MAIN,START,FINISH,HELP,HELP2,LEVEL1,LEVEL2,LEVEL3,LEVEL4,WIN1,WIN2,WIN3,WIN4,GAMEOVER,EXIT;
	}
	
	LocationSetup drawScreen;

	/*
	 *	Setup screen size - loads enemies and loads all backgrounds
	 */
	public void setup() {
		size(700,600);
		
		startTime = millis();
		
		/*
		 * Load all audio wavs
		 */
		laserSound = loadClip("/laser.wav");
		gameoverSound = loadClip("/gameover.wav");
		buttonSound = loadClip("/button.wav");
		hitSound = loadClip("/hit.wav");
		dieSound = loadClip("/die.wav");
		victorySound = loadClip("/victory.wav");
		playerHitSound = loadClip("/player-hit.wav");
		
		/*
		 *	Load all images
		 */
		menuBackground = loadImage("images/menuBackground.png");
		gameBackground = loadImage("images/gameBackground.png");
		levelBackground = loadImage("images/levelBackground.png");
		helpBackground = loadImage("images/help.png");
		help2Background = loadImage("images/help2.png");
		gameoverBackground = loadImage("images/gameoverBackground.png");
		win1Background = loadImage("images/win1Background.png");
		win2Background = loadImage("images/win2Background.png");
		win3Background = loadImage("images/win3Background.png");
		win4Background = loadImage("images/win4Background.png");
		
		/*
		 * New instancees of all the enemies stored in 2D arrays
		 */
		for(int row = 0; row < 5; row ++) {	
			for(int column = 0; column < 3; column++) {
				destroyer1[row][column] = new Destroyer(this, row * 80, column* 80, 3);	
			}
		}
		
		for(int row = 0; row < 10; row ++) {	
			for(int column = 0; column < 4; column++) {
				destroyer2[row][column] = new Destroyer(this, row * 60, column* 80, 6);	
				destroyer3[row][column] = new Destroyer(this, row * 60, column* 80, 8);	
				destroyer5[row][column] = new Destroyer(this, row * 60, column* 80, 9);
			}
		}
		
		for(int row = 0; row < 8; row ++) {	
			for(int column = 0; column < 1; column++) {
				speeder1[row][column] = new Speeder(this, row * 80, column* 80, 6);	
				speeder4[row][column] = new Speeder(this, row * 80, column* 80, 10);
				speeder6[row][column] = new Speeder(this, row * 80, column* 80, 10);
				speeder7[row][column] = new Speeder(this, row * 80, column* 80, 10);
			}
		}
		
		for(int row = 0; row < 8; row ++) {	
			for(int column = 0; column < 4; column++) {
				droid1[row][column] = new Droid(this, row * 80, column* 80, 6);	
				droid2[row][column] = new Droid(this, row * 80, column* 80, 6);	
				droid3[row][column] = new Droid(this, row * 80, column* 80, 6);
			}
		}
	}	
	
	/*
	 * Loads all game menus, levels and features
	 */
	public void draw() {
		// Setup Main menu options
		if(start == false) {	
			drawScreen = LocationSetup.MAIN;
			if(key == 's' || key == 'S') {						// MENU OPTION > START GAME
				playClip(buttonSound);
				drawScreen = LocationSetup.START;
			}
			else if(key == 'h' || key == 'H') {					// MENU OPTION > DISPLAY HELP SCREEN
				playClip(buttonSound);
				drawScreen = LocationSetup.HELP;
			}
			else if(key == 'q' || key == 'Q') {					// MENU OPTION > QUIT
				drawScreen = LocationSetup.EXIT;
			}
			else if(key == 'f'  || key == 'F') {				// MENU OPTION > HELP SCREEN 2 
				playClip(buttonSound);
				drawScreen = LocationSetup.HELP2;
			}
		}  
		
		/*
		 *	If key is pressed laod reset method and reset all variables
		 *	Option to quit game at anytime.
		 */
		if(key == 'b' || key == 'B') {
			reset();
		}

		switch(drawScreen) {
		
		/*
		 *	Displays all menu options [start/help/exit]
		 */
		case MAIN:												
			image(menuBackground,0,0);
		break;
		
		/*
		 *	If start is true, load levels
		 */
		case START:												
			start = true;
			image(levelBackground,0,0);
			// Select a level
			if(key == '1') {
				playClip(buttonSound);
				drawScreen = LocationSetup.LEVEL1;
			}
			else if(key == '2') {
				playClip(buttonSound);
				drawScreen = LocationSetup.LEVEL2;
			}
			else if(key == '3') {
				playClip(buttonSound);
				drawScreen = LocationSetup.LEVEL3;
			}
			else if(key == '4') {
				playClip(buttonSound);
				drawScreen = LocationSetup.LEVEL4;
			}
		break;
		
		/*
		 *	Displays the help screens
		 */
		case HELP:
			image(helpBackground,0,0);	
		break;
		
		case HELP2:
			image(help2Background,0,0);
		break;
		
		/*
		 *	Loads level 1 - EASY (background speed = 1 | enemies = 2)
		 */
		case LEVEL1:		
			level1Setup();
		break;
		
		/*
		 *	Loads level 2 - NORMAL (background speed = 2 | fighters = 2)
		 */
		case LEVEL2:										
			level2Setup();
		break;
		
		/*
		 *	Loads level 3 - HARD (background speed = 4 | fighters = 3)
		 */
		case LEVEL3:										
			level3Setup();
		break;
		
		/*
		 *	Loads level 4 - INSANE (background speed = 5 | fighters = 4 | Boss)
		 */
		case LEVEL4:
			level4Setup();
		break;
			
		/*
		 *	Loads the win screens once level is finished
		 */
		case WIN1:
			image(win1Background,0,0);
			winLevel();
			if(key == 'l' || key == 'L') {
				drawScreen = LocationSetup.LEVEL2;
			}
		break;
		
		case WIN2:
			image(win2Background,0,0);
			winLevel();
			if(key == 'l' || key == 'L') {
				drawScreen = LocationSetup.LEVEL3;
			}
		break;
		
		case WIN3:
			image(win3Background,0,0);
			winLevel();
			if(key == 'l' || key == 'L') {
				drawScreen = LocationSetup.LEVEL4;
			}
		break;
			
		case WIN4:
			playClip(victorySound);
			image(win4Background,0,0);
			GUI();
		break;
		
		/*
		 *	Loads the game over background when the user has lost
		 */
		case GAMEOVER:
			image(gameoverBackground,0,0);
		break;
		
		/*
		 * Exits the program
		 */
		case EXIT:
			exit();										
		break;

		default:
			reset();
		break;
		}
	}
	
	/*
	 * Load all methods, backgrounds, GUI, collisions and loop through all enemies to move / render them.
	 */
	private void level1Setup() {
		this.parallax();
		GUI();
		for(int row = 0; row < 5;row++) {
			for(int column = 0;column < 3; column++) {
				if(destroyer1[row][column] != null) {
					destroyer1[row][column].render();
					destroyer1[row][column].move();
					hitEnemyLevel1();
					gameoverCollision();
					playerHit();
			
				}
			}					
		}

		for(int row = 0; row < 8; row++){
			for(int column = 0;column < 1; column++) {
				if(enemyDeadLevel1 >= 6) {
					if(speeder1[row][column] != null) {
						speeder1[row][column].render();
						speeder1[row][column].move();
						hitEnemyLevel1();
						playerHit();
						gameoverCollision();
						
						currTime = millis() - startTime;
						if( currTime >= 1000) {
							startTime = millis();
							  Shoot enemyshoot = new Shoot(this,speeder1[row][column].pos_x+22, speeder1[row][column].pos_y+110,5);
							  speederShoot.add(enemyshoot);	
						}
					}
				}
			}
		}
		p1.update();									
		background_y += 1;											
		playerShoot();
		enemyShoot();	
		
		if(enemyDeadLevel1 >= 23) {
			destroyerBossSetup();
			bossShoot();
		}
	}
	
	/*
	 *	Level 2 setup
	 */
	private void level2Setup() {
		this.parallax();
		GUI();
		
		for(int row = 0; row < 8;row++) {
			for(int column = 0;column < 4; column++) {		
	
				if(enemyDeadLevel2 >= 0) {
					if(droid1[row][column] != null) {
						droid1[row][column].render();
						droid1[row][column].move();
						hitEnemyLevel2();
						gameoverCollision();
						playerHit();
		
						/*currTime = millis() - startTime;
						if( currTime >= 1000) {
							startTime = millis();
							Shoot enemyshoot = new Shoot(this,droid1[row][column].pos_x+22, droid1[row][column].pos_y+110,5);
							droidShoot.add(enemyshoot);	
						}	*/
					}
				}
				
				if(enemyDeadLevel2 >= 32) {
					if(droid2[row][column] != null) {
						droid2[row][column].render();
						droid2[row][column].move();
						hitEnemyLevel2();
						gameoverCollision();
						playerHit();
					}
				}
			}					
		}
		
		p1.update();									
		background_y += 1;											
		playerShoot();
		enemyShoot();
	
		if(enemyDeadLevel2 == 64) {
			droidBossSetup();
			bossShoot();
		}
	}
	
	/*
	 *	Level 3 setup
	 */
	private void level3Setup() {
		this.parallax();
		GUI();
		
		for(int row = 0; row < 10; row++) {
			for(int column = 0; column < 4; column++) {	
				if(enemyDeadLevel3 >= 0) {
					if(destroyer2[row][column] != null) {
						destroyer2[row][column].render();
						destroyer2[row][column].move();
						hitEnemyLevel3();
						gameoverCollision();
						playerHit();	
					}
					
						/*currTime = millis() - startTime;
						if( currTime >= 3000) {
							startTime = millis();
							Shoot enemyshoot = new Shoot(this,destroyer2[row][column].pos_x+22, destroyer2[row][column].pos_y+110,5);
							destroyerShoot.add(enemyshoot);	
						}	*/
					
				}
				
				if(enemyDeadLevel3 >= 40) {
					if(destroyer3[row][column] != null) {
						destroyer3[row][column].render();
						destroyer3[row][column].move();
						hitEnemyLevel3();
						gameoverCollision();
						playerHit();
					}
				}
			}
		}
		
		for(int row = 0; row < 8; row++) {
			for(int column = 0; column < 1; column++) {	
				if(enemyDeadLevel3 >= 68) {
					if(speeder4[row][column] != null) {
						speeder4[row][column].render();
						speeder4[row][column].move();
						hitEnemyLevel3();
						gameoverCollision();
						playerHit();
					}
				}
			}
		}
		
		p1.update();									
		background_y += 1;											
		playerShoot();
		enemyShoot();
	
		if(enemyDeadLevel3 == 88) {
			speederBossSetup();
			bossShoot();
		}
	}
	
	/*
	 *	Level 4 setup and load boss 
	 */
	private void level4Setup() {
		this.parallax();
		GUI();
		
		for(int row = 0; row < 10; row++) {
			for(int column = 0; column < 4; column++) {	
				if(enemyDeadLevel4 >= 0) {
					if(destroyer5[row][column] != null) {
						destroyer5[row][column].render();
						destroyer5[row][column].move();
						hitEnemyLevel4();
						gameoverCollision();
						playerHit();
					}
				}
			}
		}
		
		for(int row = 0; row < 8; row++) {
			for(int column = 0; column < 4; column++) {	
				if(enemyDeadLevel4 >= 40) {
					if(droid3[row][column] != null) {
						droid3[row][column].render();
						droid3[row][column].move();
						hitEnemyLevel4();
						gameoverCollision();
						playerHit();
					}
				}
				
			}
		}
		
		for(int row = 0; row < 8; row++) {
			for(int column = 0; column < 1; column++) {	
				if(enemyDeadLevel4 >= 46) {
					if(speeder6[row][column] != null) {
						speeder6[row][column].render();
						speeder6[row][column].move();
						hitEnemyLevel4();
						gameoverCollision();
						playerHit();
					}
				}
				
				if(enemyDeadLevel4 >= 52) {
					if(speeder7[row][column] != null) {
						speeder7[row][column].render();
						speeder7[row][column].move();
						hitEnemyLevel4();
						gameoverCollision();
						playerHit();
					}
				}
				
			
			}
		}
		
		p1.update();									
		background_y += 1;											
		playerShoot();
		playerHit();
		if(enemyDeadLevel4 >= 88) {
			bossSetup();
			bossShoot();
		}
	}
	
	/*
	 *	Setup GUI, load scores, lives on screen 
	 */
	private void GUI() {
		fill(200,200,100);
		text("Current Score:",5,15);
		text(currentScore,92,15);
		text("Total Score:",130,15);
		text(totalScore,202,15);
		text("Best score:",245,15);
		text(bestScore,311,15);
		text("Lives: ",640,15);
		text(playerLives,675,15);
		
		if(currentScore > bestScore) {
			bestScore = currentScore;
		}
	}
	
	/*
	 *	If the game is won clear lasers and reset some values.
	 */
	private void winLevel() {
		playClip(victorySound);
		GUI();
		lasers.clear();
		droidShoot.clear();
		destroyerShoot.clear();
		speederShoot.clear();
		p1.resetPlayer();
	}
	
	/*
	 *  Resets all the variables and positions so when the game starts everything is reset
	 */
	private void reset() {
		try {
			for(int row = 0; row < 5; row++) {
				for( int column = 0; column < 3; column++) {
					if(destroyer1[row][column] != null) {
						destroyer1[row][column].reset();
					}
				}
			}
			
			for(int row = 0; row < 10; row++) {
				for( int column = 0; column < 4; column++) {
					if(destroyer2[row][column] != null) {
						destroyer2[row][column].reset();
					}
					if(destroyer3[row][column] != null) {
						destroyer3[row][column].reset();
					}
					if(destroyer5[row][column] != null) {
						destroyer5[row][column].reset();
					}
				}
			}
			
			for(int row = 0; row < 8; row++) {
				for( int column = 0; column < 1; column++) {
					if(speeder1[row][column] != null) {
						speeder1[row][column].reset();
					}
					if(speeder4[row][column] != null) {
						speeder4[row][column].reset();
					}
					if(speeder6[row][column] != null) {
						speeder6[row][column].reset();
					}
					if(speeder7[row][column] != null) {
						speeder7[row][column].reset();
					}
				}
			}
			
			for(int row = 0; row < 8; row++) {
				for( int column = 0; column < 4; column++) {
					if(droid1[row][column] != null) {
						droid1[row][column].reset();
					}
					if(droid2[row][column] != null) {
						droid2[row][column].reset();
					}
					if(droid3[row][column] != null) {
						droid3[row][column].reset();
					}
				}
			}
			
			start = false;
			background_y = 0;
			currentScore = 0;
			playerLives = 3;
			lasers.clear();
			droidShoot.clear();
			destroyerShoot.clear();
			speederShoot.clear();
			startTime = millis();
			p1.resetPlayer();
			
			bossLevel1.resetBoss();
			health1 = bossLevel1.health;
			
			bossLevel2.resetBoss();
			health2 = bossLevel2.health;
			
			bossLevel3.resetBoss();
			health3 = bossLevel3.health;
			
			bossLevel4.resetBoss();
			health4 = bossLevel4.health;
			
			enemyDeadLevel1 = 0;
			enemyDeadLevel2 = 0;
			enemyDeadLevel3 = 0;
			enemyDeadLevel4 = 0;
			//stopClip(laserSound);
			stopClip(gameoverSound);
			//stopClip(buttonSound);
			//stopClip(hitSound);
			stopClip(playerHitSound);
			stopClip(victorySound);
			setup();
		} catch(IllegalArgumentException e) {
			   e.printStackTrace();
		}
	}

	/*
	 *	Draws parallax background / moving background
	 */
	private void parallax() {
		image(gameBackground, 0, background_y);
		image(gameBackground,0, background_y-gameBackground.height);
		
		if(background_y == +gameBackground.height) {
			background_y = 0;
		}
	}

	/*
	 *  Allows the player to shoot when 'N' is pressed
	 */
	public void keyPressed() {
	    println("Key: " + key + " was pressed.");
	
		if(key == 'n' || key == 'N') {
			playClip(laserSound);
			Laser lasershoot = new Laser(this, p1.pos_x+16, p1.pos_y-20, 6);
			lasers.add(lasershoot);	

	    }
	    
	    /*
	     *	If key B is pressed, go back to main menu and load reset method
	     */
	    if(key == 'b' || key == 'B') {
			reset();
	    }	
	}

	/*
	 *	Allows the player to shoot, loops through and moves / renders the laser. 
	 *	Checks for collisions between lasers and the boss, to see if a laser is off the screen, if a laser is 
	 *	off the screen then remove it, to save memory.
	 */
	private void playerShoot() {
		for (int currentLaser = 0; currentLaser < lasers.size(); currentLaser++) {
		    Laser lasera = (Laser) lasers.get(currentLaser);
		    
		    lasera.update();
		    
		    float hitWall = dist(lasera.pos_x, lasera.pos_y, bossLevel1.pos_x, bossLevel1.pos_y-1000);
		    if(hitWall < 800) {
		    	lasers.remove(currentLaser);
		    	int laserRemoved =+ 1;
		    	print("Laser removed when > screen: " + laserRemoved + "\n");
		    } 
		}
	}
	
	/*
	 * Allows the enemy to shoot, render / move each enemy laser
	 */
	private void enemyShoot() {
		for (int i = 0; i < destroyerShoot.size(); i++) {
		    Shoot shootLaser = (Shoot) destroyerShoot.get(i);
		    shootLaser.update();
		}
		
		for (int i = 0; i < droidShoot.size(); i++) {
		    Shoot shootLaser = (Shoot) droidShoot.get(i);
		    shootLaser.update();
		}
		
		for (int i = 0; i < speederShoot.size(); i++) {
		    Shoot shootLaser = (Shoot) speederShoot.get(i);
		    shootLaser.update();
		}
	}
	
	
	/*
	 * Allows the boss to shoot.
	 * Checks collision detection between bottom of the screen and boss laser, if boss laser reaches bottom remove
	 * to save memory.
	 */
	private void bossShoot() {
		for (int i = 0; i < bossShoot.size(); i++) {
		    Shoot shootLaser = (Shoot) bossShoot.get(i);
		    shootLaser.renderBlueLaser();
		    shootLaser.moveLaser();
		    
		    float hitWall = dist(shootLaser.pos_x, shootLaser.pos_y, p1.pos_x, p1.pos_y+1000);
		    if(hitWall < 800) {
		    	bossShoot.remove(i);
		    	int laserRemoved =+ 1;
		    	print("blue laser removed when > screen: " + laserRemoved + "\n");
		    } 
		}
	}
	
	
	/*
	 *	If the game ends, go to game over screen. This method will end the game if enemy hits player
	 *	Loops through each rows / columns to see if a collision has been met with the player.
	 */
	private void gameoverCollision() {

		for(int row = 0; row < 5; row++) {
			for(int column = 0; column < 3; column++) {
				if(destroyer1[row][column] != null) {
					
					float gameOver = dist(destroyer1[row][column].pos_x, destroyer1[row][column].pos_y, p1.pos_x, p1.pos_y);
				
					if(gameOver < 40 ) {
						playClip(gameoverSound);
						drawScreen = LocationSetup.GAMEOVER;
					}
				}
			}
		}
		
		for(int row = 0; row < 10; row++) {
			for(int column = 0; column < 4; column++) {
				if(destroyer2[row][column] != null) {
					
					float gameOver = dist(destroyer2[row][column].pos_x, destroyer2[row][column].pos_y, p1.pos_x, p1.pos_y);
				
					if(gameOver < 40 ) {
						playClip(gameoverSound);
						drawScreen = LocationSetup.GAMEOVER;
					}
				}
				
				if(destroyer3[row][column] != null) {
					
					float gameOver = dist(destroyer3[row][column].pos_x, destroyer3[row][column].pos_y, p1.pos_x, p1.pos_y);
				
					if(gameOver < 40 ) {
						playClip(gameoverSound);
						drawScreen = LocationSetup.GAMEOVER;
					}
				}
				
				if(destroyer5[row][column] != null) {
					
					float gameOver = dist(destroyer5[row][column].pos_x, destroyer5[row][column].pos_y, p1.pos_x, p1.pos_y);
				
					if(gameOver < 40 ) {
						playClip(gameoverSound);
						drawScreen = LocationSetup.GAMEOVER;
					}
				}
			}
		}
		
		for(int row = 0; row < 8; row++) {
			for(int column = 0; column < 1; column++) {
				if(speeder1[row][column] != null) {
					
					float gameOver = dist(speeder1[row][column].pos_x, speeder1[row][column].pos_y, p1.pos_x, p1.pos_y);
				
					if(gameOver < 40 ) {
						playClip(gameoverSound);
						drawScreen = LocationSetup.GAMEOVER;
					}
				}
				
				if(speeder4[row][column] != null) {
					
					float gameOver = dist(speeder4[row][column].pos_x, speeder4[row][column].pos_y, p1.pos_x, p1.pos_y);
				
					if(gameOver < 40 ) {
						playClip(gameoverSound);
						drawScreen = LocationSetup.GAMEOVER;
					}
				}

				if(speeder7[row][column] != null) {
					
					float gameOver = dist(speeder7[row][column].pos_x, speeder7[row][column].pos_y, p1.pos_x, p1.pos_y);
				
					if(gameOver < 40 ) {
						playClip(gameoverSound);
						drawScreen = LocationSetup.GAMEOVER;
					}
				}
			}
		}
		
		for(int row = 0; row < 8; row++) {
			for(int column = 0; column < 4; column++) {
				if(droid1[row][column] != null) {
					
					float gameOver = dist(droid1[row][column].pos_x, droid1[row][column].pos_y, p1.pos_x, p1.pos_y);
				
					if(gameOver < 40 ) {
						playClip(gameoverSound);
						drawScreen = LocationSetup.GAMEOVER;
					}
				}
				
				if(droid2[row][column] != null) {
					
					float gameOver = dist(droid2[row][column].pos_x, droid2[row][column].pos_y, p1.pos_x, p1.pos_y);
				
					if(gameOver < 40 ) {
						playClip(gameoverSound);
						drawScreen = LocationSetup.GAMEOVER;
					}
				}
				
				if(droid3[row][column] != null) {
					
					float gameOver = dist(droid3[row][column].pos_x, droid3[row][column].pos_y, p1.pos_x, p1.pos_y);
				
					if(gameOver < 40 ) {
						playClip(gameoverSound);
						drawScreen = LocationSetup.GAMEOVER;
					}
				}
			}
		}
	}
	
	/*
	 *	Collision : if enemy and laser touches > remove laser and enemy[row][column]
	 */
	
	private void hitEnemyLevel1() {
		
		for(int row = 0; row < 5; row++) {
			for(int column = 0; column < 3; column++) {
				if(enemyDeadLevel1 >= 0) {
				for (int currentLaser = 0; currentLaser < lasers.size(); currentLaser++) {
					Laser lasera = (Laser) lasers.get(currentLaser);

				
						if(destroyer1[row][column] != null) {
							float hitEnemy = dist(destroyer1[row][column].pos_x, destroyer1[row][column].pos_y, lasera.pos_x, lasera.pos_y);
			
							/*
							 * 	Remove laser and enemy if collision is made
							 */
							
							if (hitEnemy < 20) {
								destroyer1[row][column] = null;
								lasers.remove(currentLaser);
								
								enemyDeadLevel1++;
								currentScore++;
								totalScore++;
								
								playClip(hitSound); 
								
								print(enemyDeadLevel1 + " enemy destroyer1 was hit: " + hitEnemy + "\n");
							}	
						}
					}
				}				
			}
		}
		
		for(int row = 0; row < 8; row++) {
			for(int column = 0; column < 1; column++) {
				if(enemyDeadLevel1 >= 6) {
					for (int currentLaser = 0; currentLaser < lasers.size(); currentLaser++) {
						Laser lasera = (Laser) lasers.get(currentLaser);
	
						if(speeder1[row][column] != null) {
							
							float hitEnemy = dist(speeder1[row][column].pos_x, speeder1[row][column].pos_y, lasera.pos_x, lasera.pos_y);
						
							/*
							 * 	Remove laser and enemy if collision is made
							 */
							if (hitEnemy < 20) {
								speeder1[row][column] = null; 
								lasers.remove(currentLaser);
								
								enemyDeadLevel1++;
								currentScore++;
								totalScore++;
									
								playClip(hitSound);
									
								print(enemyDeadLevel1 + " enemy speeder1 was hit: " + hitEnemy + "\n");
							 }	
						}
					}
				}
			}
		}
	}
	
	/*
	 *	Collision for level 2
	 */
	private void hitEnemyLevel2() {

		for(int row = 0; row < 8; row++) {
			for(int column = 0; column < 4; column++) {
				if(enemyDeadLevel2 >= 0) {
					// droid1
					for (int currentLaser = 0; currentLaser < lasers.size(); currentLaser++) {
						Laser lasera = (Laser) lasers.get(currentLaser);
	
						if(droid1[row][column] != null) {
							float hitEnemy = dist(droid1[row][column].pos_x, droid1[row][column].pos_y, lasera.pos_x, lasera.pos_y);
						
							/*
							 * 	Remove laser and enemy if collision is made
							 */
							if (hitEnemy < 25) {
								droid1[row][column] = null; 
								lasers.remove(currentLaser);
								
								enemyDeadLevel2++;
								currentScore++;
								totalScore++;
									
								playClip(hitSound);
									
								print(enemyDeadLevel2 + " enemy droid1 was hit: " + hitEnemy + "\n");
							 }	
						}
					}
				}
					
				if(enemyDeadLevel2 >= 32) {
					// droid2
					for (int currentLaser = 0; currentLaser < lasers.size(); currentLaser++) {
						Laser lasera = (Laser) lasers.get(currentLaser);
	
						if(droid2[row][column] != null) {
							
							float hitEnemy = dist(droid2[row][column].pos_x, droid2[row][column].pos_y, lasera.pos_x, lasera.pos_y);
						
							/*
							 * 	Remove laser and enemy if collision is made
							 */
							if (hitEnemy < 25) {
								droid2[row][column] = null; 
								lasers.remove(currentLaser);
								
								enemyDeadLevel2++;
								currentScore++;
								totalScore++;
									
								playClip(hitSound);
									
								print(enemyDeadLevel2 + " enemy droid2 was hit: " + hitEnemy + "\n");
							 }	
						}
					}
				}
			}
		}
	}
	
	/*
	 *	Collision for level 3
	 */
	private void hitEnemyLevel3() {
		for(int row = 0; row < 10; row++) {
			for(int column = 0; column < 4; column++) {
				if(enemyDeadLevel3 >= 0) {
				for (int currentLaser = 0; currentLaser < lasers.size(); currentLaser++) {
					Laser lasera = (Laser) lasers.get(currentLaser);
						if(destroyer2[row][column] != null) {
							float hitEnemy = dist(destroyer2[row][column].pos_x, destroyer2[row][column].pos_y, lasera.pos_x, lasera.pos_y);
			
							/*
							 * 	Remove laser and enemy if collision is made
							 */
							
							if (hitEnemy < 20) {
								destroyer2[row][column] = null;
								lasers.remove(currentLaser);
								
								enemyDeadLevel3++;
								currentScore++;
								totalScore++;
								
								playClip(hitSound); 
								
								print(enemyDeadLevel3 + " enemy destroyer2 was hit: " + hitEnemy + "\n");
							}	
						}
					}
				}	
				
				if(enemyDeadLevel3 >= 40) {
					for (int currentLaser = 0; currentLaser < lasers.size(); currentLaser++) {
						Laser lasera = (Laser) lasers.get(currentLaser);
							if(destroyer3[row][column] != null) {
								float hitEnemy = dist(destroyer3[row][column].pos_x, destroyer3[row][column].pos_y, lasera.pos_x, lasera.pos_y);
				
								/*
								 * 	Remove laser and enemy if collision is made
								 */
								
								if (hitEnemy < 20) {
									destroyer3[row][column] = null;
									lasers.remove(currentLaser);
									
									enemyDeadLevel3++;
									currentScore++;
									totalScore++;
									
									playClip(hitSound); 
									
									print(enemyDeadLevel3 + " enemy destroyer3 was hit: " + hitEnemy + "\n");
								}	
							}
						}
					}		
			}
		}
		
		for(int row = 0; row < 8; row++) {
			for(int column = 0; column < 1; column++) {
				if(enemyDeadLevel3 >= 68) {
					for (int currentLaser = 0; currentLaser < lasers.size(); currentLaser++) {
						Laser lasera = (Laser) lasers.get(currentLaser);
							if(speeder4[row][column] != null) {
								float hitEnemy = dist(speeder4[row][column].pos_x, speeder4[row][column].pos_y, lasera.pos_x, lasera.pos_y);
				
								/*
								 * 	Remove laser and enemy if collision is made
								 */
								
								if (hitEnemy < 20) {
									speeder4[row][column] = null;
									lasers.remove(currentLaser);
									
									enemyDeadLevel3++;
									currentScore++;
									totalScore++;
									
									playClip(hitSound); 
									
									print(enemyDeadLevel3 + " enemy speeder4 was hit: " + hitEnemy + "\n");
								}	
							}
						}
					}
			}
		}
	}
	
	/*
	 *	Collisons for level 4
	 */
	private void hitEnemyLevel4() {
		for(int row = 0; row < 10; row++) {
			for(int column = 0; column < 4; column++) {
				if(enemyDeadLevel4 >= 0) {
				for (int currentLaser = 0; currentLaser < lasers.size(); currentLaser++) {
					Laser lasera = (Laser) lasers.get(currentLaser);
						if(destroyer5[row][column] != null) {
							float hitEnemy = dist(destroyer5[row][column].pos_x, destroyer5[row][column].pos_y, lasera.pos_x, lasera.pos_y);
			
							/*
							 * 	Remove laser and enemy if collision is made
							 */
							
							if (hitEnemy < 20) {
								destroyer5[row][column] = null;
								lasers.remove(currentLaser);
								
								enemyDeadLevel4++;
								currentScore++;
								totalScore++;
								
								playClip(hitSound); 
								
								print(enemyDeadLevel4 + " enemy destroyer5 was hit: " + hitEnemy + "\n");
							}	
						}
					}
				}						
			}
		}
		
		for(int row = 0; row < 8; row++) {
			for(int column = 0; column < 4; column++) {
				if(enemyDeadLevel4 >= 40) {
				for (int currentLaser = 0; currentLaser < lasers.size(); currentLaser++) {
					Laser lasera = (Laser) lasers.get(currentLaser);
						if(droid3[row][column] != null) {
							float hitEnemy = dist(droid3[row][column].pos_x, droid3[row][column].pos_y, lasera.pos_x, lasera.pos_y);
			
							/*
							 * 	Remove laser and enemy if collision is made
							 */
							
							if (hitEnemy < 20) {
								droid3[row][column] = null;
								lasers.remove(currentLaser);
								
								enemyDeadLevel4++;
								currentScore++;
								totalScore++;
								
								playClip(hitSound); 
								
								print(enemyDeadLevel4 + " enemy droid3 was hit: " + hitEnemy + "\n");
							}	
						}
					}
				}
			}
		}
		
		for(int row = 0; row < 8; row++) {
			for(int column = 0; column < 1; column++) {
				if(enemyDeadLevel4 >= 46) {
					for (int currentLaser = 0; currentLaser < lasers.size(); currentLaser++) {
						Laser lasera = (Laser) lasers.get(currentLaser);
							if(speeder6[row][column] != null) {
								float hitEnemy = dist(speeder6[row][column].pos_x, speeder6[row][column].pos_y, lasera.pos_x, lasera.pos_y);
				
								/*
								 * 	Remove laser and enemy if collision is made
								 */
								
								if (hitEnemy < 20) {
									speeder6[row][column] = null;
									lasers.remove(currentLaser);
									
									enemyDeadLevel4++;
									currentScore++;
									totalScore++;
									
									playClip(hitSound); 
									
									print(enemyDeadLevel4 + " enemy speeder6 was hit: " + hitEnemy + "\n");
								}	
							}
						}
					}
				
				if(enemyDeadLevel4 >= 52) {
					for (int currentLaser = 0; currentLaser < lasers.size(); currentLaser++) {
						Laser lasera = (Laser) lasers.get(currentLaser);
							if(speeder7[row][column] != null) {
								float hitEnemy = dist(speeder7[row][column].pos_x, speeder7[row][column].pos_y, lasera.pos_x, lasera.pos_y);
				
								/*
								 * 	Remove laser and enemy if collision is made
								 */
								
								if (hitEnemy < 20) {
									speeder7[row][column] = null;
									lasers.remove(currentLaser);
									
									enemyDeadLevel4++;
									currentScore++;
									totalScore++;
									
									playClip(hitSound); 
									
									print(enemyDeadLevel4 + " enemy speeder7 was hit: " + hitEnemy + "\n");
								}	
							}
						}
					}
			}
		}
	}
	
	/*
	 *	Controls lasers when they hit the player
	 */
	private void playerHit() {
		
		/*
		 *	If enemy laser hits player, lose a life or if lives = 0 end game	
		 */
		for (int currentLaser = 0; currentLaser < droidShoot.size(); currentLaser++) {
				
			Shoot shootPlayer = (Shoot) droidShoot.get(currentLaser);
			float hitPlayer = dist(p1.pos_x, p1.pos_y, shootPlayer.pos_x, shootPlayer.pos_y);
				
			if(hitPlayer < 25) {
				droidShoot.remove(currentLaser);
				playerLives--;
				playClip(playerHitSound);
			}
			else if(playerLives == 0) {
				playClip(dieSound);
				drawScreen = LocationSetup.GAMEOVER;
			}
		}	
		
		for (int currentLaser = 0; currentLaser < destroyerShoot.size(); currentLaser++) {
			
			Shoot shootPlayer = (Shoot) destroyerShoot.get(currentLaser);
			float hitPlayer = dist(p1.pos_x, p1.pos_y, shootPlayer.pos_x, shootPlayer.pos_y);
				
			if(hitPlayer < 25) {
				destroyerShoot.remove(currentLaser);
				playerLives--;
				playClip(playerHitSound);
			}
			else if(playerLives == 0) {
				playClip(dieSound);
				drawScreen = LocationSetup.GAMEOVER;
			}
		}
		
		for (int currentLaser = 0; currentLaser < speederShoot.size(); currentLaser++) {
			
			Shoot shootPlayer = (Shoot) speederShoot.get(currentLaser);
			float hitPlayer = dist(p1.pos_x, p1.pos_y, shootPlayer.pos_x, shootPlayer.pos_y);
				
			if(hitPlayer < 25) {
				speederShoot.remove(currentLaser);
				playerLives--;
				playClip(playerHitSound);
			}
			else if(playerLives == 0) {
				playClip(dieSound);
				drawScreen = LocationSetup.GAMEOVER;
			}
		}
		
		/*
		 *	If boss laser hits player, lose a life or if lives = 0 end game	
		 */
		for (int bossLaser = 0; bossLaser < bossShoot.size(); bossLaser++) {
				
			Shoot bossShootPlayer = (Shoot) bossShoot.get(bossLaser);
			float bossHitPlayer = dist(p1.pos_x, p1.pos_y, bossShootPlayer.pos_x, bossShootPlayer.pos_y);
			
			if(bossHitPlayer < 25) {
				bossShoot.remove(bossLaser);
				playerLives--;
				playClip(playerHitSound);
			}
			else if(playerLives == 0) {
				playClip(dieSound);
				drawScreen = LocationSetup.GAMEOVER;
			}
		}
	}
	
	/*
	 *	Boss setup, health shoot, audio, score and collision between players laser and boss to see
	 *	if the player has hit the boss, if player hits boss:
	 *		add score;
	 *		play sound;
	 *		remove laser;
	 *		and decrease health;
	 */
	
	private void destroyerBossSetup() {
		
		int takeAwayHealth = 700;
		
		bossLevel1.moveBoss();
		bossLevel1.renderBossLevel1();
		fill(121,66,66);
		rect(00,30,700,30);
		fill(200,200,100);
		rect(00,30,takeAwayHealth -= health1,30);
		fill(255);
		text("Destroyer boss health: " + health1 + "/ 700",280,50);		
		
		for (int currentLaser = 0; currentLaser < lasers.size(); currentLaser++) {
			Laser lasera = (Laser) lasers.get(currentLaser);
				
			float hitBoss = dist(bossLevel1.pos_x, bossLevel1.pos_y, lasera.pos_x, lasera.pos_y);
				
			if (hitBoss < 45) {
				currentScore += 2;
				totalScore += 2;
				playClip(hitSound);
				print("Destroyer boss was hit: " + hitBoss + "\n");
				lasers.remove(currentLaser);					
				health1 -= 70;
			}
			else if(health1 <= 0) {
				health1 = 0;
				playClip(victorySound);
				drawScreen = LocationSetup.WIN1;
			}	 
		}
			
		currTime = millis() - startTime;
		if( currTime >= 1400) {
			startTime = millis();
			  Shoot enemyshoot = new Shoot(this,bossLevel1.pos_x+22, bossLevel1.pos_y+110,5);
			  destroyerShoot.add(enemyshoot);	
		}
	}	
	
	private void droidBossSetup() {
		
		int takeAwayHealth = 700;
		
		bossLevel2.moveBoss();
		bossLevel2.renderBossLevel2();
		fill(121,66,66);
		rect(00,30,700,30);
		fill(200,200,100);
		rect(00,30,takeAwayHealth -= health2,30);
		fill(255);
		text("Droid boss health: " + health2 + "/ 700",280,50);		
		
		for (int currentLaser = 0; currentLaser < lasers.size(); currentLaser++) {
			Laser lasera = (Laser) lasers.get(currentLaser);
				
			float hitBoss = dist(bossLevel2.pos_x, bossLevel2.pos_y, lasera.pos_x, lasera.pos_y);
				
			if (hitBoss < 45) {
				currentScore += 3;
				totalScore += 3;
				playClip(hitSound);
				print("Droid boss was hit: " + hitBoss + "\n");
				lasers.remove(currentLaser);					
				health2 -= 35;
			}
			else if(health2 <= 0) {
				health2 = 0;
				playClip(victorySound);
				drawScreen = LocationSetup.WIN2;
			}	 
		}
			
		currTime = millis() - startTime;
		if( currTime >= 1400) {
			startTime = millis();
			  Shoot enemyshoot = new Shoot(this,bossLevel2.pos_x+22, bossLevel2.pos_y+110,5);
			  droidShoot.add(enemyshoot);	
		}
	}	
	
	private void speederBossSetup() {
		
		int takeAwayHealth = 700;
		
		bossLevel3.fastMoveBoss();
		bossLevel3.renderBossLevel3();
		fill(121,66,66);
		rect(00,30,700,30);
		fill(200,200,100);
		rect(00,30,takeAwayHealth -= health3,30);
		fill(255);
		text("Speeder boss health: " + health3 + "/ 700",280,50);		
		
		for (int currentLaser = 0; currentLaser < lasers.size(); currentLaser++) {
			Laser lasera = (Laser) lasers.get(currentLaser);
				
			float hitBoss = dist(bossLevel3.pos_x, bossLevel3.pos_y, lasera.pos_x, lasera.pos_y);
				
			if (hitBoss < 45) {
				currentScore += 5;
				totalScore += 5;
				playClip(hitSound);
				print("Speeder Boss was hit: " + hitBoss + "\n");
				lasers.remove(currentLaser);					
				health3 -= 25;
			}
			else if(health3<= 0) {
				health3 = 0;
				playClip(victorySound);
				drawScreen = LocationSetup.WIN3;
			}	 
		}
			
		currTime = millis() - startTime;
		if( currTime >= 1400) {
			startTime = millis();
			  Shoot enemyshoot = new Shoot(this,bossLevel3.pos_x+22, bossLevel3.pos_y+110,5);
			  speederShoot.add(enemyshoot);	
		}
	}	
	
	private void bossSetup() {
		
		int takeAwayHealth = 700;
		
		bossLevel4.moveBoss();
		bossLevel4.renderBossLevel4();
		fill(121,66,66);
		rect(00,30,700,30);
		fill(200,200,100);
		rect(00,30,takeAwayHealth -= health4,30);
		fill(255);
		text("Boss health: " + health4 + "/ 700",280,50);		
		
		for (int currentLaser = 0; currentLaser < lasers.size(); currentLaser++) {
			Laser lasera = (Laser) lasers.get(currentLaser);
				
			float hitBoss = dist(bossLevel4.pos_x, bossLevel4.pos_y, lasera.pos_x, lasera.pos_y);
				
			if (hitBoss < 45) {
				currentScore += 10;
				totalScore += 10;
				playClip(hitSound);
				print("Boss was hit: " + hitBoss + "\n");
				lasers.remove(currentLaser);					
				health4 -= 10;
				enemyDeadLevel4++;
			}
			else if(health4 <= 0) {
				health4 = 0;
				playClip(victorySound);
				drawScreen = LocationSetup.WIN4;
			}	 
		}
			
		currTime = millis() - startTime;
		if( currTime >= 1000) {
			startTime = millis();
			  Shoot enemyshoot = new Shoot(this,bossLevel4.pos_x+22, bossLevel4.pos_y+110,5);
			  bossShoot.add(enemyshoot);	
		}
	}		
	
	/*
	 *	Loads the audio and gets the file, using the javax.sound.sampled library.
	 *
	 *	Attempts to open the file and gets the audio file(wav).
	 */
	private Clip loadClip(String filename) {
		Clip clip = null;	
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(filename));
			clip = AudioSystem.getClip();
			clip.open(audioIn);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return clip;
		
	}
	
	/*
	 *	Plays the audio and rewinds it if its stopped and starts again, so the audio can run mulitple times
	 */
	private void playClip(Clip clip) {
		if (clip.isRunning()) 
			clip.stop();   
	    	clip.setFramePosition(0); // rewind to 0
	        clip.start();
	}
	
	/*
	 *	Stops the audio while its running
	 */
	private void stopClip(Clip clip) {
		if(clip.isRunning()) {
			clip.stop();
		}
	}
}