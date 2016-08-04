package QCMapRendering;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Graphics {

	private Pane root;
	private Grid grid;
	private CreateFile cf;

	public Graphics(Pane root, Grid grid, CreateFile cf) {
		this.root = root;
		this.grid = grid;
		this.cf = cf;
	}
	
	public Rectangle createRectangle(Square curr){
		Rectangle rect = new Rectangle(curr.getXPos(), curr.getYPos(), curr.getWidth(), curr.getHeight());
		if(curr.getState() == 0){
			rect.setFill(Color.ALICEBLUE);
		}
		if(curr.getState() == 1){
			rect.setFill(Color.BLACK);
		}
		if(curr.getState() == 2){
			rect.setFill(Color.BROWN);
		}
		rect.setStroke(Color.BLACK);
		root.getChildren().add(rect);
		rect.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				curr.nextState();
				createRectangle(curr);
				grid.print_grid();
			//	cf.updateGrid(grid, curr);
			}
		});
		return rect;
	}

	public void visualizeGrid() {
		for (int i = 0; i < grid.getRows(); i++) {
			for (int j = 0; j < grid.getColumns(); j++) {
				Square curr = grid.getArray()[j][i];
				curr.i = j;
				curr.j = i;
				Rectangle rect = createRectangle(curr);
				rect.setOnMouseClicked(new EventHandler<Event>() {

					@Override
					public void handle(Event event) {
						curr.nextState();
						createRectangle(curr);
						grid.print_grid();
						//cf.updateGrid(grid, curr);
					}
				});
			}
		}
	}

}
