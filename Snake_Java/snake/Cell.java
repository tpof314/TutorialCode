package snake;

/**
 * 一个格子.
 * 一个格子是由一组坐标(x,y)构成的.
 * 格子是贪吃蛇游戏的最基本部件. 不论是蛇还是食物, 都需要通过cell
 * 来确定它的位置.
 * ===========================
 *  请不要修改这个类的代码!
 * ===========================
 * @author Wesley
 * 
 */

public class Cell {
	private int x;
	private int y;
	
	public Cell(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
}
