package labirent4.dusman;

import labirent4.Bosluk;
import labirent4.Cikis;
import labirent4.Hucre;
import labirent4.Konum;
import labirent4.Zemin;
import labirent4.ozellik.Ozellik;

public abstract class Dusman extends Hucre {
		
	public Dusman(Konum konum) {
		super(konum);
	}

	public abstract String toString();

	public boolean hareketEttir(Hucre hucre) {
		boolean hareketEtti = false;
		if(hucre instanceof Zemin || hucre instanceof Bosluk){
			this.getKonum().setX(hucre.getKonum().getX());
			this.getKonum().setY(hucre.getKonum().getY());
			hareketEtti = true;
		}
		
		return hareketEtti;
	}
			
}
