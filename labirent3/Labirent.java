package labirent3;


public class Labirent {
	
	private int adamX, adamY;
	private int hedefX, hedefY;
	
		
	public static final int ZEMIN = 1;
	public static final int DUVAR = 2;
	public static final int ADAM = 3;
	public static final int CIKIS = 4;

	
	private int matris[][];

	public Labirent(){
		adamX = adamY = hedefX = hedefY = 0;
		matris = null;
	}
	
	public Labirent(int[][] grid){
		adamX = adamY = hedefX = hedefY = 0;
		yukle(grid);
		
	}

	public void yukle(int[][] grid) {
		
		matris = new int[grid.length][grid[0].length];
		
		for (int y = 0; y < grid.length; y++){
			for(int x = 0; x < grid[0].length; x++){
				int hucre = grid[y][x];
				if(hucre == ADAM){
					adamX = x;
					adamY = y;
				}
				if(hucre == CIKIS){
					hedefX = x;
					hedefY = y;
				}
				matris[y][x] = grid[y][x];
			}
		}
		
	}
	
	public int getAdamX() {
		return adamX;
	}


	public int getAdamY() {
		return adamY;
	}


	public int getHedefX() {
		return hedefX;
	}

	public int getHedefY() {
		return hedefY;
	}

		
	public String toString() {

		String s = "";
		
		for (int y = 0; y < matris.length; y++){
			for(int x = 0; x < matris[0].length; x++){
				int hucre = matris[y][x];
				
				switch(hucre){
					case ZEMIN: 
						s += "-";
						break;
					case DUVAR: 
						s += "#";
						break;
					case ADAM:
						s += "ö";
						break;
					case CIKIS: 
						s += (char)169;
						break;
				}
				
			}
			s += "\n";
		}
		
		return s;
		
	}

	public boolean adaminYeriniGuncelle(int x, int y) {
		
		boolean basarili = false;
		
		if(matris[y][x] == ZEMIN || matris[y][x] == CIKIS){
			matris[adamY][adamX] = ZEMIN; // şu an ki bulunduğu yeri boşluk olarak belirle
			matris[y][x] = ADAM; // labirentte adamın yerini değiştir
			adamX = x;
			adamY = y;
			
			basarili = true;
		}
		
		return basarili;
	}

	
	

	
}
