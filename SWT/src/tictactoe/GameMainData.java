package tictactoe;

public class GameMainData {
	private Board board;
	private GameState currentState;
	private Seed currentPlayer;

	public GameMainData() {
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public GameState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(GameState currentState) {
		this.currentState = currentState;
	}

	public Seed getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Seed currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	/** Initialize the game-board contents and the current-state */
	   public void initGame() {
	      for (int row = 0; row < GameMain.ROWS; row++) {
	         for (int col = 0; col < GameMain.COLS; col++) {
	            getBoard().getCells()[row][col].setContent(Seed.EMPTY); // all cells empty
	         }
	      }
	      setCurrentState(GameState.PLAYING);  // ready to play
	      setCurrentPlayer(Seed.CROSS);        // cross plays first
	   }

	/** Update the currentState after the player with "theSeed" has placed on (row, col) 
	 * @param theSeed TODO
	 * @param row TODO
	 * @param col TODO*/
	   public void updateGame(Seed theSeed, int row, int col) {
	      if (getBoard().hasWon(theSeed, row, col)) {  // check for win
	         setCurrentState((theSeed == Seed.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON);
	      } else if (getBoard().isDraw()) {  // check for draw
	         setCurrentState(GameState.DRAW);
	      }
	      // Otherwise, no change to current state (PLAYING).
	   }
}