package labirent4.ozellik;

import labirent4.Hucre;
import labirent4.Konum;

public abstract class Ozellik extends Hucre {
		
	public Ozellik(Konum konum) {
		super(konum);
	}

	public abstract String toString();
			
}
