package snake;
/**
 * 蛇.
 * 一条蛇有是由一串格子组成的.
 * @author wesley
 */
public class Snake {
	private Cell[] cells;		/* 组成蛇身体的格子 */
	private int    length;		/* 蛇的长度 */
	private int    direction;	/* 蛇的移动方向 */
	private int    gridSize;	/* 游戏版面的边长 */
	
	/* 蛇可以往4个方向移动. 这4个方向被定义成具体的常数值. */
	public final static int DIRECTION_UP    = 1;
	public final static int DIRECTION_DOWN  = 2;
	public final static int DIRECTION_LEFT  = 3;
	public final static int DIRECTION_RIGHT = 4;
	
	/**
	 * 新建一条蛇.
	 * 蛇出生的时候, 位于屏幕的左上角;
	 * 身体为水平方向, 长度为3格, 往右移动.
	 */
	public Snake(int gridSize) {
		this.gridSize = gridSize;
		this.cells  = new Cell[gridSize * 5];
		this.length = 3;
		this.direction = DIRECTION_RIGHT;
		cells[0] = new Cell(2, 0);
		cells[1] = new Cell(1, 0);
		cells[2] = new Cell(0, 0);
	}
	
	/**
	 * 蛇往前走一步.
	 */
	public void moveSnake() {
		for (int i=length-1; i>0; i--) {
			int prevX = cells[i-1].getX();
			int prevY = cells[i-1].getY();
			this.cells[i].setX(prevX);
			this.cells[i].setY(prevY);
		}
		int headX = cells[0].getX();
		int headY = cells[0].getY();
		if (direction == Snake.DIRECTION_DOWN) {
			headY++;
		}
		else if (direction == Snake.DIRECTION_UP) {
			headY--;
		}
		else if (direction == Snake.DIRECTION_LEFT) {
			headX--;
		}
		else {
			headX++;
		}
		cells[0].setX(headX);
		cells[0].setY(headY);
	}
	
	/**
	 * 判断一个格子(x, y)是不是在蛇的身上.
	 * @param x x坐标.
	 * @param y y坐标.
	 * @return 如果(x,y)是蛇身上的点, 返回true. 否则返回false.
	 */
	public boolean isCellOnSnake(int x, int y) {
		for (int i=0; i<length; i++) {
			if (cells[i].getX() == x && cells[i].getY() == y) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断一下蛇是不是咬到了自己.
	 * @return 如果蛇咬到了自己, 返回true. 否则返回false.
	 */
	public boolean biteItself() {
		int x = cells[0].getX();
		int y = cells[0].getY();
		for (int i=1; i<length; i++) {
			if (cells[i].getX() == x && cells[i].getY() == y) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断一下蛇是不是撞到墙了.
	 * @return 如果蛇撞墙了, 返回true. 否则返回false.
	 */
	public boolean hitBoundary() {
		int x = cells[0].getX();
		int y = cells[0].getY();
		return !isValidPosition(x, y);
	}
	
	/**
	 * 改变蛇的运动方向. 
	 * 改变方向的时候, 需要做额外的方向判断. 比方说, 
	 * 如果蛇目前正在向右移动，那么，它不能改成向左移动.
	 * @param direction 需要改变的方向.
	 */
	public void changeDirection(int direction) {
		int[] conflict = {0, DIRECTION_DOWN, DIRECTION_UP, DIRECTION_RIGHT, DIRECTION_LEFT};
		if (conflict[this.direction] != direction) {
			this.direction = direction;
		}
	}
	
	/**
	 * 蛇的身体变长一格.
	 */
	public void extendLength() {
		int prevX = cells[length - 1].getX();
		int prevY = cells[length - 1].getY();
		cells[length] = new Cell(prevX, prevY);
		this.length++;
	}
	
	public Cell getSnakeHead() {
		return cells[0];
	}
	
	/**
	 * 判断一个位置(x, y)是不是落在网格范围里面.
	 * @param x x坐标.
	 * @param y y坐标.
	 * @return 如果(x, y)在网格范围内, 返回true. 否则返回false.
	 */
	public boolean isValidPosition(int x, int y) {
		if (x < 0 || x >= gridSize) {
			return false;
		}
		else if (y < 0 || y >= gridSize) {
			return false;
		}
		else {
			return true;
		}
	}
}
