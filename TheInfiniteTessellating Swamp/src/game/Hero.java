package game;

public class Hero extends Character {

	private int numHealthPotions;
	private int maxHp;

	public Hero(String name, int health, int maxHp, int dmg, int charX, int charY, int numHealthPotions) {
		super(name, health, dmg, charX, charY);
		this.numHealthPotions = numHealthPotions;
		this.maxHp = maxHp;
	}

	public int getNumHealthPotions() {
		return numHealthPotions;
	}

	public void setNumHealthPotions(int numHealthPotions) {
		this.numHealthPotions = 3;
	}

	public double useMagicCompass(int tresX, int tresY) {

		double a = getCharX() - tresX;
		double b = getCharY() - tresY;
		double result;

		result = Math.pow(a, 2) + Math.pow(b, 2);

		return Math.pow(result, 2);
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public void useHealthPotion() {
		if (getNumHealthPotions() > 0) {
			setHealth(maxHp);
			numHealthPotions--;
			System.out.println("you have " + getNumHealthPotions() + " left");
		} else {
			System.out.println("you have no more health potions");
		}

	}

	public boolean isAlive() {
		boolean alive = true;
		if (getHealth() <= 0) {
			alive = false;
		}
		return alive;
	}

}
