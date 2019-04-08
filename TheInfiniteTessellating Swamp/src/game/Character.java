package game;

public abstract class Character {

	private String name;
	private int health;
	private int dmg;
	private int charX;
	private int charY;

	public abstract boolean isAlive();

	public Character(String name, int health, int dmg, int charX, int charY) {
		this.setDmg(dmg);
		this.setHealth(health);
		this.setName(name);
		this.setCharX(charX);
		this.setCharY(charY);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmgMod) {
		this.dmg = dmgMod;
	}

	public int getCharX() {
		return charX;
	}

	public void setCharX(int charX) {
		if (charX <= 0) {
			charX = 1;
		} else {
			this.charX = charX;
		}
	}

	public int getCharY() {
		return charY;
	}

	public void setCharY(int charY) {
		if (charY <= 0) {
			charY = 1;
		} else {
			this.charY = charY;
		}

	}
}
