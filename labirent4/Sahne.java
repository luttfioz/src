package labirent4;

public abstract class Sahne {
		
		protected Hucre[][] hucreler;
		protected int skor;
		
		public Sahne(){
			hucreler = null;
			skor = 0;
		}
		
		public Sahne(int[][] grid) {
			skor = 0;			
			yukle(grid);
		}

		public Sahne(String dosyaAdi) {
			skor = 0;			
			yukle(dosyaAdi);
		}
		
		public Hucre getHucre(int x, int y){
			return hucreler[y][x];
		}
		
		public void setHucre(Hucre h, int x, int y){
			hucreler[y][x] = h;
		}

		
		public int getSkor() {
			return skor;
		}

		public void setSkor(int skor) {
			this.skor = skor;
		}

		public abstract void yukle(int[][] grid);
		
		public abstract void yukle(String dosyaAdi);

		
}
