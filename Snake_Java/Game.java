import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import snake.Grid;
import snake.Snake;

/**
 * 这个类是用来呈现游戏界面的. 
 * ====================
 * 请不要修改这个类的代码!
 * ====================
 * @author wesley
 */
public class Game {
	
	private Grid   grid;
	private JFrame window;		/* 窗口 */
	private int    width;		/* 窗口宽度 */
	private int    height;		/* 窗口高度 */
	private Timer  timer;
	
	private final static int CELL_SIZE   = 8;	/* 格子大小 */
	private final static int OFFSET      = 5;	/* 边框大小 */
	private final static int GRID_WIDTH  = 40;	/* 网格宽度 */
	private final static int TIME_SLOP   = 200;	/* 时间间隔 */
	
	public Game() {
		this.grid = new Grid(GRID_WIDTH);
		this.window = new JFrame("Snake Game");
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.getContentPane().add(new MyCanvas());
		this.window.addKeyListener(new MyKeyboard());
		this.window.setVisible(true);
		
		this.width  = GRID_WIDTH * CELL_SIZE + 2 * OFFSET;
		this.height = GRID_WIDTH * CELL_SIZE + 2 * OFFSET;
		this.window.setBounds(50, 50, width, height + 4*OFFSET);
		
		this.timer = new Timer(TIME_SLOP, new TimerListener());
		this.timer.start();
	}
	
	private void drawSquare(int r, int c, Graphics graphics, Color color) {
		int x = OFFSET + c * CELL_SIZE;
		int y = OFFSET + r * CELL_SIZE;
		graphics.setColor(color);
		graphics.fillRect(x, y, CELL_SIZE, CELL_SIZE);
	}
	
	private class MyCanvas extends JComponent {
		public void paint(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, width, height);
			
			for (int i=0; i<GRID_WIDTH; i++) {
				for (int j=0; j<GRID_WIDTH; j++) {
					if (grid.getMapValue(i, j) == grid.FOOD) {
						drawSquare(i, j, g, Color.RED);
					}
					else if (grid.getMapValue(i, j) == grid.SNAKE_BODY) {
						drawSquare(i, j, g, Color.WHITE);
					}
					else {
						drawSquare(i, j, g, Color.BLACK);
					}
				}
			}
		}
	}
	private class MyKeyboard implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) { }

		@Override
		public void keyReleased(KeyEvent e) { }
		
		@Override
		public void keyPressed(KeyEvent e) {
			Snake snake = grid.getSnake();
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				snake.changeDirection(Snake.DIRECTION_UP);
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				snake.changeDirection(Snake.DIRECTION_DOWN);
			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				snake.changeDirection(Snake.DIRECTION_LEFT);
			}
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				snake.changeDirection(Snake.DIRECTION_RIGHT);
			}
			grid.refreshGrid();
			window.repaint();
			timer.restart();
		}
	}

	private class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			grid.refreshGrid();
			window.repaint();
			if (grid.isGameOver()) {
				JOptionPane.showMessageDialog(window, "游戏结束");
				timer.stop();
			}
		}
		
	}
	
	public static void main(String args[]) {
		new Game();
	}
}
