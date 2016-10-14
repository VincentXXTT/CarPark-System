import javax.swing.*;

public class MyGraphics extends JFrame {
	public static void main(String[] args) {
		new MyGraphics();
	}
	
	public MyGraphics() {
		super("Car Park");
		CarPark carPark = new CarPark();
		carPark.setFocusable(true);
		add(carPark);
		
		setVisible(true);
		setLocation(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
	}
}
