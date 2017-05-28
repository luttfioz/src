package labirent4;

public class Konum implements Comparable<Konum>{
	private int x,y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Konum(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Konum k) {
		if ((this.x == k.getX()) && (this.y == k.getY()))
			return 0;
		return -1;
	}
	
}
