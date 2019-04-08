package game;

public class Enemy extends Character {

	private String attackType;
	private String loot;

	public Enemy(String name, int health, int dmg, String attackType, String loot, int charX, int charY) {
		super(name, health, dmg, charX, charY);
		this.setAttackType(attackType);
		this.setLoot(loot);

	}

	public String getAttackType() {
		return attackType;
	}

	public void setAttackType(String attackType) {
		this.attackType = attackType;
	}

	public String getLoot() {
		return loot;
	}

	public void setLoot(String loot) {
		this.loot = loot;
	}

	public boolean isAlive() {
		boolean alive = true;
		if (getHealth() <= 0) {
			alive = false;
		}
		return alive;
	}

}
