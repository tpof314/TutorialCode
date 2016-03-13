package snake;

/**
 * 食物.
 * 给蛇吃的东西. 蛇吃到食物后, 会变长.
 * @author Wesley
 */
public class Food {
	private Cell location;
	private int  gridSize;
	
	/**
	 * 食物的构造方法
	 */
	public Food(int gridSize) {
		this.gridSize = gridSize;
		this.location = new Cell(0, 0);
		this.getNextPosition();
	}
	
	/**
	 * 为食物随机地换一个位置.
	 * 直接更新位置就行, 不需要关心这个新位置会不会和蛇重合.
	 */
	public void getNextPosition() {
		int x = (int)(Math.random() * gridSize);
		int y = (int)(Math.random() * gridSize);
		location.setX(x);
		location.setY(y);
	}
	
	/**
	 * 获取食物的横坐标.
	 * @return 返回食物的横坐标.
	 */
	public int getX() {
		return location.getX();
	}
	
	/**
	 * 获取食物的纵坐标.
	 * @return 返回食物的纵坐标.
	 */
	public int getY() {
		return location.getY();
	}
}
