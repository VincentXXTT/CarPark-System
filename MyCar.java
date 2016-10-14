
public class MyCar implements Car {
	private int x, y;  // 车的坐标
	private String orientation = "North";  // 默认朝向北
	
	public MyCar() {
		x = y = 1;  // 默认初始坐标为(1,1)
	}
	
	public MyCar(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void move(String Command) {
		if (Command != orientation) {
			orientation = Command;
			return;
		}
		if (Command == "North") {
			++y;
		} else if (Command == "South") {
			--y;
		} else if (Command == "West") {
			--x;
		} else if (Command == "East") {
			++x;
		} else {}
		// 检查是否到达边界的功能交由CarPark
	}

	@Override
	public int getPositionX() {
		return x;
	}

	@Override
	public int getPositionY() {
		return y;
	}

	@Override
	public String getOrientation() {
		return orientation;
	}

}
