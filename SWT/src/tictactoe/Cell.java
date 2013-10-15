package tictactoe;
import java.awt.*;
/**
 * The Cell class models each individual cell of the game board.
 */
public class Cell {
   // Package access
   private Seed content; // content of this cell (Seed.EMPTY, Seed.CROSS, or Seed.NOUGHT)
   private int row; //TODO row and column of this cell
   private int col; //TODO
 
   /** Constructor to initialize this cell with the specified row and col */
   public Cell(int row, int col) {//TODO
      this.setRow(row);//TODO
      this.setCol(col);//TODO
      clear(); // clear content
   }
 
   /** Clear this cell's content to EMPTY */
   public void clear() {
      setContent(Seed.EMPTY);
   }
 
   /** Paint itself on the graphics canvas, given the Graphics context */
   public void paint(Graphics g) {
      // Use Graphics2D which allows us to set the pen's stroke
      Graphics2D g2d = (Graphics2D)g;
      g2d.setStroke(new BasicStroke(GameMain.SYMBOL_STROKE_WIDTH,
            BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Graphics2D only
      // Draw the Seed if it is not empty
      int x1 = getCol() * GameMain.CELL_SIZE + GameMain.CELL_PADDING;
      int y1 = getRow() * GameMain.CELL_SIZE + GameMain.CELL_PADDING;
      if (getContent() == Seed.CROSS) {
         g2d.setColor(Color.RED);
         int x2 = (getCol() + 1) * GameMain.CELL_SIZE - GameMain.CELL_PADDING;
         int y2 = (getRow() + 1) * GameMain.CELL_SIZE - GameMain.CELL_PADDING;
         g2d.drawLine(x1, y1, x2, y2);
         g2d.drawLine(x2, y1, x1, y2);
      } else if (getContent() == Seed.NOUGHT) {
         g2d.setColor(Color.BLUE);
         g2d.drawOval(x1, y1, GameMain.SYMBOL_SIZE, GameMain.SYMBOL_SIZE);
      }
   }

Seed getContent() {
	return content;
}

void setContent(Seed content) {
	this.content = content;
}

int getCol() {
	return col;
}

void setCol(int col) {
	this.col = col;
}

int getRow() {
	return row;
}

void setRow(int row) {
	this.row = row;
}
}
