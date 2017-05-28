package labirent4;

import labirent4.dusman.AsagiYukariDusman;
import labirent4.dusman.Dusman;
import labirent4.dusman.SagSolDusman;
import labirent4.ozellik.GucluItebilme;
import labirent4.ozellik.GucluYumruk;
import labirent4.ozellik.Kosma;

public class LabirentSahnesi extends Sahne{
	
	public static final int ZEMIN = 1;
	public static final int DUVAR = 2;
	public static final int ADAM = 3;
	public static final int CIKIS = 4;
	public static final int BOSLUK = 5;
	public static final int KUTU = 6;
	

	public static final int GUCLU_YUMRUK = 10;
	public static final int GUCLU_ITEBILME = 11;
	public static final int KOSMA = 12;
	
	public static final int AY_DUSMAN = 15;
	public static final int SS_DUSMAN = 16;
	
	public LabirentSahnesi(){
		super();
	}
	
	public LabirentSahnesi(int[][] labirent){
		super(labirent);
	}
	
	public void yukle(int[][] labirent){
		
		hucreler = new Hucre[labirent.length][labirent[0].length];
		
		for (int y = 0; y < labirent.length; y++){
			for(int x = 0; x < labirent[y].length; x++){
				int hucre = labirent[y][x];
				switch(hucre){
					case ZEMIN:
						hucreler[y][x] = new Zemin(new Konum(x,y));
						break;
					case DUVAR:
						hucreler[y][x] = new Duvar(new Konum(x,y));
						break;
					case ADAM:
						hucreler[y][x] = new Adam(new Konum(x,y));
						break;
					case CIKIS:
						hucreler[y][x] = new Cikis(new Konum(x,y));
						break;
					case BOSLUK:
						hucreler[y][x] = new Bosluk(new Konum(x,y));
						break;
					case KUTU:
						hucreler[y][x] = new Kutu(new Konum(x,y));
						break;
						
					case GUCLU_YUMRUK:
						hucreler[y][x] = new GucluYumruk(new Konum(x,y));
						break;
					case GUCLU_ITEBILME:
						hucreler[y][x] = new GucluItebilme(new Konum(x,y));
						break;
					case KOSMA:
						hucreler[y][x] = new Kosma(new Konum(x,y));
						break;
					case AY_DUSMAN:
						hucreler[y][x] = new AsagiYukariDusman(new Konum(x,y));
						break;
					case SS_DUSMAN:
						hucreler[y][x] = new SagSolDusman(new Konum(x,y));
						break;
				}
			}
		}
	}
	
	public Adam getAdam() {
		Adam adam = null;
		for (int y = 0; y < hucreler.length; y++){
			for(int x = 0; x < hucreler[y].length; x++){
				Hucre hucre = hucreler[y][x];
				if(hucre instanceof Adam)
					adam = (Adam)hucre;
			}
		}

		return adam;
	}
	

	public Cikis getCikis() {
		Cikis cikis = null;
		for (int y = 0; y < hucreler.length; y++){
			for(int x = 0; x < hucreler[y].length; x++){
				Hucre hucre = hucreler[y][x];
				if(hucre instanceof Cikis)
					cikis = (Cikis)hucre;
			}
		}

		return cikis;

	}


	public String toString(){
		String s = "";
		for (int y = 0; y < hucreler.length; y++){
			for(int x = 0; x < hucreler[y].length; x++){
				s += (hucreler[y][x]).toString();
			}
			s +="\n";
		}
		return s;
	}

		
	

	
	
	@Override
	public void yukle(String dosyaAdi) {
		
	}

	public Dusman getAsagiYukariDusman() {
		AsagiYukariDusman dusman = null;
		for (int y = 0; y < hucreler.length; y++){
			for(int x = 0; x < hucreler[y].length; x++){
				Hucre hucre = hucreler[y][x];
				if(hucre instanceof AsagiYukariDusman)
					dusman = (AsagiYukariDusman)hucre;
			}
		}

		return dusman;
	}

	public Dusman getSagSolDusman() {
		SagSolDusman dusman = null;
		for (int y = 0; y < hucreler.length; y++){
			for(int x = 0; x < hucreler[y].length; x++){
				Hucre hucre = hucreler[y][x];
				if(hucre instanceof SagSolDusman)
					dusman = (SagSolDusman)hucre;
			}
		}

		return dusman;
	}

}
