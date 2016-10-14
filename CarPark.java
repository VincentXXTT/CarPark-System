import javax.security.auth.x500.X500Principal;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CarPark extends JLabel {
	private MyCar myCar = new MyCar(1,1);
	
	// 每一块的具体大小
	private int blockX = 150; 
	private int blockY = 150;
	// X和Y方向的块数
	private int countX = 4;
	private int countY = 4;
	
	public int width() {
		return countX * blockX;
	}
	
	public int height() {
		return countY * blockY;
	}
	
	// 画出车的形状（用三角形表示）
	private void drawCar(Graphics g) {
		int x = myCar.getPositionX();
		int y = myCar.getPositionY();
	    if(x < 0 || x >= 4 || y < 0 || y >= 4){
	         throw new RuntimeException();	
	    }
		// 转换坐标到绘图坐标系上
		int realX = x * blockX;
		int realY = blockY * (countY - 1) - y * blockY;
		// 获取车的方向
		String Command = myCar.getOrientation();
		// 绘制三角形，箭头代表车的方向
		Point p1 = new Point(realX + blockX / 2, realY + blockY / 6); 
		Point p2 = new Point(realX + blockX / 4, realY + 2 * blockY / 3);
		Point p3 = new Point(realX + 3 * blockX / 4, p2.y);
		if (Command == "North") {
			
		} else if (Command == "South") {
			p1.y = realY + (realY + blockY - p1.y);
			p2.y = realY + (realY + blockY - p2.y);
			p3.y = p2.y;
		} else if (Command == "West") {
			p1 = new Point(realX + blockX / 6, realY + blockY / 2);
			p2 = new Point(realX + 2 * blockX / 3, realY + blockY / 4);
			p3 = new Point(p2.x, realY + 3 * blockY / 4);
		} else if (Command == "East") {
			p1 = new Point(realX + 5 * blockX / 6, realY + blockY / 2);
			p2 = new Point(realX + blockX / 3, realY + blockY / 4);
			p3 = new Point(p2.x, realY + 3 * blockY / 4);
		} else {}
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
		g.drawLine(p1.x, p1.y, p3.x, p3.y);
		g.drawLine(p2.x, p2.y, p3.x, p3.y);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.blue);
		// 画出格网
		for (int i = 0; i <= 4; ++i) {
			g.drawLine(i * blockX, 0, i * blockY, height()); 
			g.drawLine(0, i * blockY, width(), i * blockY);
		}
		// 画出Car的位置
		drawCar(g);
	}
	
	public CarPark() {
		// 添加监听
		addKeyListener(new Monitor());
	}
	
	class Monitor extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			int keyCode =  e.getKeyCode();
			if (keyCode == KeyEvent.VK_UP)
				myCar.move("North");
			else if (keyCode == KeyEvent.VK_DOWN)
				myCar.move("South");
			else if (keyCode == KeyEvent.VK_LEFT)
				myCar.move("West");
			else if (keyCode == KeyEvent.VK_RIGHT)
				myCar.move("East");
			else {}
			repaint();
		}
	}
}
