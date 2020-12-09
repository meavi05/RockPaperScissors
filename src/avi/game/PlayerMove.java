/**
 * 
 */
package avi.game;

/**
 * The PlayerMove Enum contains the moves that a player can take. Available moves are 
 * {@link #ROCK},{@link #PAPER} and {@link #SCISSORS}.
 * @author avi08
 *
 */
public enum PlayerMove {

		ROCK,
		PAPER,
		SCISSORS;
	
	/**
	 * This method provide the winning condition when we compare two players move
	 * @param other
	 * @return true for the win and false for the loss	 
	 */
	public boolean beats(PlayerMove other)
	  {
	     switch (this)
	     { 
	         case ROCK:
	              return other == SCISSORS;
	         case PAPER:
	              return other == ROCK;
	         case SCISSORS:
	              return other == PAPER;
	     }
		return false;
	  }
}
