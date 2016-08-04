package QCMapRendering;

public class Square {

	private int x_pos = -1;
	private int y_pos = -1;
	private int state = -1;
	private int height = -1;
	private int width = -1;
	int i = 0;
	int j = 0;
	final static int NUM_STATES = 3;
	
	public Square(int x_pos, int y_pos, int state, int size) {
		this.x_pos = x_pos;
		this.y_pos = y_pos;
		this.state = state;
		this.width = size;
		this.height = size;
	}
	
	public Square(int x_pos, int y_pos, int size) {
		this.x_pos = x_pos;
		this.y_pos = y_pos;
		this.width = size;
		this.height = size;
	}
	
	public void nextState(){
		if(this.state == NUM_STATES - 1) this.state = 0;
		else ++state;
	}
	
	public void setState(int state){
		this.state = state;
	}
	
	public int getState(){
		return this.state;
	}

	public Square getCell(){
		return this;
	}
	
	public int getXPos(){
		return x_pos;
	}
	
	public int getYPos(){
		return y_pos;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
}
