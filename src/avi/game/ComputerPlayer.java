/**
 * 
 */
package avi.game;

import java.util.Random;

/**
 * The ComputerPlayer class will take the input for the computer using play
 * method.
 * 
 * @author avi08
 *
 */
public class ComputerPlayer implements RPSPlayer {

	private final Random random;

	/**
	 * @param random
	 */
	public ComputerPlayer(Random random) {
		super();
		this.random = random;
	}

	/**
	 * This method will take the input move from the Computer player
	 * @return Computer move
	 */
	@Override
	public String play() {
		return PlayerMove.values()[this.random.nextInt(PlayerMove.values().length)].name();
	}

}
