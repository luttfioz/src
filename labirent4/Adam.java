package labirent4;

import labirent4.ozellik.Ozellik;

public class Adam extends Hucre{

	private Ozellik ozellik;
	
	@Override
	public String toString() {
		return "ö";
	}
	
	public Adam(Konum konum){
		super(konum);
	}
	
	public boolean hareketEttir(Hucre hucre){
		boolean hareketEtti = false;
		if(hucre instanceof Zemin || hucre instanceof Bosluk || hucre instanceof Ozellik){
			this.getKonum().setX(hucre.getKonum().getX());
			this.getKonum().setY(hucre.getKonum().getY());
			hareketEtti = true;
		}
		if(hucre instanceof Cikis){
			hareketEtti = true;
		}
		return hareketEtti;
	}

	public Ozellik getOzellik() {
		return ozellik;
	}

	public void setOzellik(Ozellik ozellik) {
		this.ozellik = ozellik;
	}
	
	

}
