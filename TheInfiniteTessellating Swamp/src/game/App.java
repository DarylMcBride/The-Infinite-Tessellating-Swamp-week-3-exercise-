package game;

import java.util.Random;
import java.util.Scanner;

public class App {

	/*
	 * Grey foggy clouds float oppressively close to you,
	 * 
	 * reflected in the murky grey water which reaches up your shins.
	 * 
	 * Some black plants barely poke out of the shallow water.
	 * 
	 * Try "north","south","east",or "west"
	 * 
	 * You notice a small watch-like device in your left hand.
	 * 
	 * It has hands like a watch, but the hands don't seem to tell time.
	 * 
	 * 
	 * 
	 * The dial reads '5m'
	 * 
	 * >north
	 * 
	 * The dial reads '4.472m'
	 * 
	 * >north
	 * 
	 * The dial reads '1m'
	 * 
	 * >e
	 * 
	 * 
	 * 
	 * You see a box sitting on the plain. Its filled with treasure! You win! The
	 * end.​
	 */

	/*
	 * hero position = 1
	 * 
	 * treasure position =2
	 */

	// for (int i = 0; i < swamp.length; i++) {
	// for (int j = 0; j < swamp[i].length; j++) {

	// }
	// }
	public static void main(String[] args) {

		GameHandler gh = new GameHandler();
		Scanner sc = new Scanner(System.in);
		String userRespone = null;
		Random rand = new Random();
		Tiles tiles = new Tiles();

		Hero hero = new Hero("link", 250, 250, 15, rand.nextInt(5), rand.nextInt(5), 3);
		Enemy orc = new Enemy("gork", 100, 25, "cleave", "axe", rand.nextInt(5), rand.nextInt(5));
		Enemy orc2 = new Enemy("mork", 100, 40, "smash", "boots", rand.nextInt(5), rand.nextInt(5));
		Treasure tres = new Treasure(rand.nextInt(5), rand.nextInt(5));

		int[][] swamp = tiles.getGameBoard();

		tiles.setPlayerPosition(hero.getCharX(), hero.getCharY());
		tiles.setTreasurePosition(tres.getTresX(), tres.getTresY());
		tiles.setEnemyOnePosition(orc.getCharX(), orc.getCharY());
		tiles.setEnemyTwoPosition(orc2.getCharX(), orc2.getCharY());

		gh.introMessage();

		Boolean running = gh.startGame(sc.nextLine());

		while (running = true) {

			// checks if hero is still alive
			running = hero.isAlive();
			userRespone = sc.nextLine();

			// if player is on location of the treasure trigger game end
			if (hero.useMagicCompass(tres.getTresX(), tres.getTresY()) == 1.0) {

				System.out.println("Congratulations you have found the treasure and esaped the swamp");
				running = false;
				break;
				// if player is on the location of an enemy triggers an encounter
			} else if (swamp[hero.getCharX()][hero.getCharY()] == 3) {

				System.out.println("you have been ambushed by an orc named " + orc.getName());
				System.out.println(orc.getName() + " used " + orc.getAttackType());
				hero.setHealth(hero.getHealth() - orc.getDmg());
				System.out.println("your health is now " + hero.getHealth());

				while (orc.isAlive() == true) {
					if (userRespone.equals("attack")) {

						System.out.println(hero.getName() + " attacks " + orc.getName() + " for " + hero.getDmg());
						orc.setHealth(orc.getHealth() - hero.getDmg());
						orc.isAlive();

						System.out.println(orc.getName() + " used " + orc.getAttackType());
						hero.setHealth(hero.getHealth() - orc.getDmg());
						System.out.println("your health is now " + hero.getHealth());

					} else if (userRespone.equals("give up")) {
						System.out.println("you fall down and die");
						break;
					}
				}

			} else if (swamp[hero.getCharX()][hero.getCharY()] == 4) {

				System.out.println("you have been ambushed by an orc named " + orc.getName());
				System.out.println(orc2.getName() + " used " + orc2.getAttackType());
				hero.setHealth(hero.getHealth() - orc2.getDmg());
				System.out.println("your health is now " + hero.getHealth());

				while (orc2.isAlive() == true) {
					if (userRespone.equals("attack")) {

						System.out.println(hero.getName() + " attacks " + orc2.getName() + " for " + hero.getDmg());
						orc2.setHealth(orc2.getHealth() - hero.getDmg());
						orc2.isAlive();

						System.out.println(orc2.getName() + " used " + orc2.getAttackType());
						hero.setHealth(hero.getHealth() - orc.getDmg());
						System.out.println("your health is now " + hero.getHealth());

					} else if (userRespone.equals("give up")) {
						System.out.println("you fall down and die");
						break;
					}
				}
			}

			// player movement
			if (userRespone.equals("end")) {
				running = false;
				break;
			} else if (userRespone.equals("location")) {
				System.out.println(hero.useMagicCompass(tres.getTresX(), tres.getTresY()));

			} else if (userRespone.equals("north")) {

				hero.setCharY(tiles.validatePlayerY(hero.getCharY() + 1));
				System.out.println("you move forward through the swamp");

			} else if (userRespone.equals("south")) {

				hero.setCharY(tiles.validatePlayerY(hero.getCharY() - 1));
				System.out.println("you move back through the swamp");

			} else if (userRespone.equals("east")) {

				System.out.println("you move eastward through the swamp");
				hero.setCharX(tiles.validatePlayerX(hero.getCharX() + 1));

			} else if (userRespone.equals("west")) {

				hero.setCharX(tiles.validatePlayerX(hero.getCharX() - 1));
				System.out.println("you move westward through the swamp");

			} else if (userRespone.equals("potion")) {
				hero.useHealthPotion();
			} else {
				System.out.println("unrecognised command");
			}

		}

		System.out.println("game end");
		sc.close();
	}

}
