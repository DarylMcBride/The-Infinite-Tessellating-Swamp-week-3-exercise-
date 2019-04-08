package game;

import java.util.Random;

public class Tiles {

	Random rand = new Random();
	private int[][] swamp = new int[6][6];
	private int gameBoardMaxX = 5;
	private int gameBoardMaxY = 5;

	public int[][] getGameBoard() {

		return swamp;
	}

	public void setPlayerPosition(int x, int y) {
		swamp[x][y] = 1;
	}

	public void setTreasurePosition(int x, int y) {
		if (swamp[x][y] != 1) {
			swamp[x][y] = 3;
		} else {
			swamp[rand.nextInt(gameBoardMaxX)][rand.nextInt(gameBoardMaxY)] = 3;
		}
	}

	public void setEnemyOnePosition(int x, int y) {
		if (swamp[x][y] != 1 && swamp[x][y] != 3) {
			swamp[x][y] = 3;
		}
	}

	public void setEnemyTwoPosition(int x, int y) {
		if (swamp[x][y] != 1 && swamp[x][y] != 3 && swamp[x][y] != 2) {
			swamp[x][y] = 4;
		}
	}

	public int getGameBoardY() {
		return gameBoardMaxY;
	}

	public int getGameBoardX() {
		return gameBoardMaxX;
	}

	public int validatePlayerX(int x) {

		if (x >= getGameBoardX() || x < 0) {
			x = 0;
		}
		return x;
	}

	public int validatePlayerY(int y) {
		if (y >= getGameBoardY() || y < 0) {
			y = 0;
		}
		return y;
	}

}

// public void setTreasurePosition() {

// }

/*
 * public int xYPosition() { int result = 0;
 * 
 * result = rand.nextInt(3);
 * 
 * return result; }
 */
