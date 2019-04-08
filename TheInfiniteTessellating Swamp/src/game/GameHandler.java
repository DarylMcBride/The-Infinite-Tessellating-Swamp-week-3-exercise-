package game;

public class GameHandler {

	public void introMessage() {
		System.out.println("Grey foggy clouds float oppressively close to you, \r\n" + "\r\n"
				+ "reflected in the murky grey water which reaches up your shins.\r\n" + "\r\n"
				+ "Some black plants barely poke out of the shallow water.\r\n" + "\r\n"
				+ "Try \"north\",\"south\",\"east\",or \"west\" in order to move \n"
				+ "Try \"location\" in order to use your magic compass");
		System.out.println("Try \"potion\" in order to drink your health potion");
		System.out.println("if you would like to end the game at any time type 'end' into the console");
		System.out.println();
		System.out.println("if you encounter an enemy type \"attack\" to attack or \"give up\" to run away");
		System.out.println("input 1 to begin the game");

	}

	public boolean startGame(String userInput) {

		Boolean result = false;

		if (userInput.equals("1")) {
			result = true;
		}

		return false;
	}
}
