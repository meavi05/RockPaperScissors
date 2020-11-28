/**
 * 
 */
package avi.game;

import java.util.Scanner;

/**
 * The HumanPlayer class will take the input for the player using play method.
 * 
 * @author avi08
 *
 */
public class HumanPlayer implements RPSPlayer {

	private final Scanner scanner;

	public HumanPlayer(Scanner scanner) {
		this.scanner = scanner;
	}

	/**
	 * This method will take the input move from the HumanPlayer player
	 * 
	 * @return Player move
	 */
	@Override
	public String play() {
		Integer move = takeInput();
		while (!isValidMove(move)) {
			System.out.println(GameConstants.INVALID_MOVE);
			move = takeInput();
		}
		return PlayerMove.values()[move - 1].name();
	}

	/**
	 * This method takes the input move of the player.
	 * 
	 * @return Integer value of selected move
	 */
	private Integer takeInput() {
		System.out.println(GameConstants.SELECT_MOVE);
		return parseInput(scanner.next());
	}

	/**
	 * This method checks if the human player has provided the valid move or not.
	 * 
	 * @param move
	 * @return true for valid play move and false for invalid move.
	 */
	private boolean isValidMove(int move) {
		return (move == 1 || move == 2 || move == 3);
	}

	/**
	 * This method parse the player move to Integer value
	 * 
	 * @param move
	 * @return
	 */
	private Integer parseInput(String move) {
		try {
			return Integer.parseInt(move);
		} catch (NumberFormatException nfe) {
			System.out.println(GameConstants.INVALID_MOVE);
			return takeInput();
		}

	}
}
