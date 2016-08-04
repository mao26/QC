package QCMapRendering;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CreateFile extends Application {

	private Grid grid;
	private Pane root;
	private String[] numRepOfMap = new String[30];
	
	private Button btn;

	public CreateFile() {
		grid = new Grid();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Rendering Tool for Store Maps");
		Grid cf_grid = createFile();
		btn = new Button();
		btn.setText("Render File");
		root = new Pane();
		btn.setTranslateX(0);// primaryStage.getWidth() - btn.getWidth());
		btn.setTranslateY(300);// primaryStage.getHeight() - btn.getHeight());
		root.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 300, 350));
		// btn.setLayoutX((primaryStage.getWidth()) - btn.getWidth());
		// btn.setLayoutY(primaryStage.getHeight() - btn.getHeight());
		primaryStage.show();
		visualize(cf_grid);
		
	}

	public void updateGrid(Grid grid, Square curr) {
		Square[][] sgrid = grid.getArray();
		String need = "";
		for (int j = 0; j < grid.getColumns(); j++) {
			need += sgrid[j][curr.i].getState();
		}
		numRepOfMap[curr.j] = need;
		grid.updateGrid(curr);
	}

	private void visualize(Grid grid) {
		Graphics graphics = new Graphics(root, grid, this);
		graphics.visualizeGrid();
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				// List<String> lines = Arrays.asList("The first line", "The
				// second line");
				try {
					/*
					 * File createdFile = new File("MapOutput.txt"); FileWriter
					 * fr = new FileWriter(createdFile); BufferedWriter br = new
					 * BufferedWriter(fr); PrintWriter out = new
					 * PrintWriter(br); System.out.println(numRepOfMap[0]);
					 */
					String[] string_grid = grid.update_array_of_grid();
					Path file = Paths.get("/Users/mario_oliver93/Desktop/MapNumRep.txt");
					// for (int i = 0; i < grid.getRows(); i++) {

					Files.write(file, Arrays.asList(string_grid), Charset.forName("UTF-8"));
					// out.write(grid.getStatesAsStringRepresentation()[i] +
					// "\n");
					// }
					// out.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		});
	}

	private Grid createFile() {
		CreateFile cf = new CreateFile();
		cf.grid.random_init();
		cf.grid.print_grid();
		numRepOfMap = cf.grid.getStatesAsStringRepresentation();
		return cf.grid;
	}

}
