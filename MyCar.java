
public class MyCar implements Car {
	private int x, y;  // ��������
	private String orientation = "North";  // Ĭ�ϳ���
	
	public MyCar() {
		x = y = 1;  // Ĭ�ϳ�ʼ����Ϊ(1,1)
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
		// ����Ƿ񵽴�߽�Ĺ��ܽ���CarPark
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
