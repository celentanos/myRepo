package tictactoe;
import java.awt.*;
/**
 * The Board class models the ROWS-by-COLS game-board.
 */
public class Board {
   // package access
   private Cell[][] cells; // composes of 2D array of ROWS-by-COLS Cell instances
 
   /** Constructor to initialize the game board */
   public Board() {
      setCells(new Cell[GameMain.ROWS][GameMain.COLS]); // allocate the array
      for (int row = 0; row < GameMain.ROWS; row++) {
         for (int col = 0; col < GameMain.COLS; col++) {
            getCells()[row][col] = new Cell(row, col); // allocate element of array
         }
      }
   }
 
   /** Initialize (or re-initialize) the game board */
   public void init() {
      for (int row = 0; row < GameMain.ROWS; row++) {
         for (int col = 0; col < GameMain.COLS; col++) {
            getCells()[row][col].clear(); // clear the cell content
         }
      }
   }
 
   /** Return true if it is a draw (i.e., no more EMPTY cell) */
   public boolean isDraw() {
      for (int row = 0; row < GameMain.ROWS; row++) {
         for (int col = 0; col < GameMain.COLS; col++) {
            if (getCells()[row][col].getContent() == Seed.EMPTY) {
               return false; // an empty seed found, not a draw, exit
            }
         }
      }
      return true; // no empty cell, it's a draw
   }
 
   /** Return true if the player with "seed" has won after placing at
       (seedRow, seedCol) */
   public boolean hasWon(Seed seed, int seedRow, int seedCol) {
      return (getCells()[seedRow][0].getContent() == seed   // 3-in-the-row
                 && getCells()[seedRow][1].getContent() == seed
                 && getCells()[seedRow][2].getContent() == seed
             || getCells()[0][seedCol].getContent() == seed // 3-in-the-column
                 && getCells()[1][seedCol].getContent() == seed
                 && getCells()[2][seedCol].getContent() == seed
             || seedRow == seedCol              // 3-in-the-diagonal
                 && getCells()[0][0].getContent() == seed
                 && getCells()[1][1].getContent() == seed
                 && getCells()[2][2].getContent() == seed
             || seedRow + seedCol == 2          // 3-in-the-opposite-diagonal
                 && getCells()[0][2].getContent() == seed
                 && getCells()[1][1].getContent() == seed
                 && getCells()[2][0].getContent() == seed);
   }
 
   /** Paint itself on the graphics canvas, given the Graphics context */
   public void paint(Graphics g) {
      // Draw the grid-lines
      g.setColor(Color.GRAY);
      for (int row = 1; row < GameMain.ROWS; row++) {
         g.fillRoundRect(0, GameMain.CELL_SIZE * row - GameMain.GRID_WIDHT_HALF,
               GameMain.CANVAS_WIDTH - 1, GameMain.GRID_WIDTH,
               GameMain.GRID_WIDTH, GameMain.GRID_WIDTH);
      }
      for (int col = 1; col < GameMain.COLS; col++) {
         g.fillRoundRect(GameMain.CELL_SIZE * col - GameMain.GRID_WIDHT_HALF, 0,
               GameMain.GRID_WIDTH, GameMain.CANVAS_HEIGHT - 1,
               GameMain.GRID_WIDTH, GameMain.GRID_WIDTH);
      }
 
      // Draw all the cells
      for (int row = 0; row < GameMain.ROWS; row++) {
         for (int col = 0; col < GameMain.COLS; col++) {
            getCells()[row][col].paint(g);  // ask the cell to paint itself
         }
      }
   }

Cell[][] getCells() {
	return cells;
}

void setCells(Cell[][] cells) {
	this.cells = cells;
}
}