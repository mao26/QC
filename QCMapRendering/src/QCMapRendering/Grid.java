package QCMapRendering;

import java.util.Iterator;
import java.util.Random;

public class Grid implements Iterable<CharSequence>{

	private Square[][] grid;
	private String[] array_of_grid;
	private int row_size = OG_SIZE;
	private int column_size = OG_SIZE;
	private final static int OG_SIZE = 30;
	private final static int WIDTH = 10;
	
	public Grid(int size) {
		grid = new Square[size][size];
		row_size = size;
		column_size = size;
	}

	public Grid() {
		grid = new Square[OG_SIZE][OG_SIZE];
	}

	public Grid(int x_size, int y_size) {
		grid = new Square[x_size][y_size];
		row_size = x_size;
		column_size = y_size;
	}
	
	public String[] update_array_of_grid(){
		for(int row = 0; row < row_size; row++){
			String curr_line = "";
			for(int column = 0; column < column_size; column++){
				int num = grid[column][row].getState();
				curr_line += num;
			}
			array_of_grid[row] = curr_line;
		}
		return array_of_grid;
	}
	
	public void random_init(){
		array_of_grid = new String[row_size];
		for(int row = 0; row < row_size; row++){
			String curr_line = "";
			for(int column = 0; column < column_size; column++){
				int num = 0;
				curr_line += num;
				Square newCell = new Square(row * WIDTH, column * WIDTH, WIDTH);
				newCell.setState(num);
				grid[row][column] = newCell;
			}
			array_of_grid[row] = curr_line.toString();
		}
	}
	
	public static void main(String[] args){
		Grid grid = new Grid();
		grid.random_init();
		grid.print_grid();
	}
	
	public void print_grid(){
		for(int row = 0; row < row_size; row++){
			for(int column = 0; column < column_size; column++){
				System.out.print("" + grid[column][row].getState() + "| ");
			}
			System.out.println();
		}
	}
	
	public int getRows(){
		return row_size;
	}
	
	public int getColumns(){
		return column_size;
	}
	
	public void updateGrid(Square curr){
		grid[curr.j][curr.i].nextState();
	}
	
	public Square[][] getArray(){
		return grid;
	}
	
	public String[] getStatesAsStringRepresentation(){
		return array_of_grid;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
