package labirent4;

public class Kutu extends Hucre {

	public Kutu(Konum konum) {
		super(konum);
		
	}

	@Override
	public String toString() {
		
		return "@";
	}
	
	public boolean hareketEttir(Hucre hucre){
		boolean hareketEtti = false;
		if(hucre instanceof Zemin || hucre instanceof Bosluk){
			this.getKonum().setX(hucre.getKonum().getX());
			this.getKonum().setY(hucre.getKonum().getY());
			hareketEtti = true;
		}
		
		return hareketEtti;
	}

}
