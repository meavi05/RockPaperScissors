/**
 * 
 */
package avi.game;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		RPSPlayer computer = new ComputerPlayer(new Random());
		try {
			RPSPlayer human = new HumanPlayer(scanner);
			RockPaperScissorsGame game = new RockPaperScissorsGame();
			System.out.println(GameConstants.START_GAME_NOTE);
			do {
				String comp = computer.play();
				String you = human.play();
				System.out.println(GameConstants.YOUR_MOVE + you);
				System.out.println(GameConstants.COMPUTER_MOVE + comp);
				game.gameOutcome(comp, you);
			} while (game.playAgain(scanner));
		} catch (Exception e) {
			System.out.println(GameConstants.GAME_EXCEPTION_OCCURED);
		} finally {
			scanner.close();
		}
	}

	/**
	 * This method checks if the player wants to play more game.
	 * 
	 * @param scanner
	 * @return true to play again and false to exit
	 */
	private boolean playAgain(Scanner scanner) {
		String playAgain = takePlayAgainInput(scanner);
		while (isValidPlayAgainInput(playAgain)) {
			System.out.println(GameConstants.INVALID_INPUT);
			playAgain = takePlayAgainInput(scanner);
		}
		if (GameConstants.YES.equalsIgnoreCase(playAgain))
			return true;
		else {
			System.out.println(GameConstants.END_GAME_NOTE);
			return false;
		}
	}

	/**
	 * This method takes the play again input from the player.
	 * 
	 * @param scanner
	 * @return play again input
	 */
	private String takePlayAgainInput(Scanner scanner) {
		System.out.println(GameConstants.PLAY_AGAIN);
		return scanner.next();
	}

	/**
	 * This method checks if the player has provided the valid input or not.
	 * 
	 * @param playAgain
	 * @return true/false for valid play again input
	 */
	private boolean isValidPlayAgainInput(String playAgain) {
		return !GameConstants.YES.equalsIgnoreCase(playAgain) && !GameConstants.NO.equalsIgnoreCase(playAgain);
	}

	/**
	 * This method provides the outcome of the game by checking your input and
	 * computer input
	 * 
	 * @param  comp
	 * @param  you
	 */
	private void gameOutcome(String comp, String you) {
		PlayerMove yourMove = PlayerMove.valueOf(you);
		PlayerMove CompMove = PlayerMove.valueOf(comp);
		if (yourMove.equals(CompMove)) {
			System.out.println(GameConstants.TIE);
		} else if (yourMove.beats(CompMove)) {
			System.out.println(GameConstants.WIN);
		} else {
			System.out.println(GameConstants.LOSE);
		}
	}
}