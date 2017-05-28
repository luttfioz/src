package labirent4;

import java.util.Scanner;

import labirent4.dusman.AsagiYukariDusman;
import labirent4.dusman.Dusman;
import labirent4.dusman.SagSolDusman;
import labirent4.ozellik.GucluItebilme;
import labirent4.ozellik.GucluYumruk;
import labirent4.ozellik.Kosma;
import labirent4.ozellik.Ozellik;

public class LabirentOyunu extends Oyun {

	public static final int YUKARI = 1;
	public static final int ASAGI = 2;
	public static final int SAGA = 3;
	public static final int SOLA = 4;
	public static final int HATALI = 0;

	public void yukle() {

		int[][] lab = {
				{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
				{ 2, 3, 1, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2 },
				{ 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2 },
				{ 2, 11, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2 },
				{ 2, 12, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2 },
				{ 2, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2, 15, 1, 1, 1, 1, 2 },
				{ 2, 1, 2, 1, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2 },
				{ 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 1, 1, 2 },
				{ 2, 1, 2, 1, 2, 1, 2, 1, 2, 2, 2, 2, 1, 2, 1, 2, 1, 1, 1, 2 },
				{ 2, 1, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2 },
				{ 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 1, 1, 2 },
				{ 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 2, 2, 1, 2 },
				{ 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 2 },
				{ 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 2 },
				{ 2, 1, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2 },
				{ 2, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2 },
				{ 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 1, 2 },
				{ 2, 1, 2, 16, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2 },
				{ 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 2 },
				{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 } };

		sahne = new LabirentSahnesi(lab);

	}

	public void basla() {

		while (true) {

			System.out.println(this);
			int girdi = kullanicidanYonBilgisiAl();
			if (girdi != HATALI) {
				guncelle(girdi);
				
			}
		}

	}

	private int kullanicidanYonBilgisiAl() {

		Scanner consol = new Scanner(System.in);

		System.out
				.print("Yön Tuşları (w = yukarı, s = aşağı, a = sol, d = sağ), seçiniz: ");

		String secimStr = consol.next();

		char secim = secimStr.charAt(0);
		int yon = HATALI;

		switch (secim) {
		case 'w':
		case 'W':
			yon = YUKARI;
			break;

		case 'a':
		case 'A':
			yon = SOLA;
			break;

		case 's':
		case 'S':
			yon = ASAGI;
			break;

		case 'd':
		case 'D':
			yon = SAGA;
			break;

		default:
			yon = HATALI;
			break;
		}

		return yon;

	}

	private void guncelle(int girdi) {

		Konum adamKonum = ((LabirentSahnesi) sahne).getAdam().getKonum();
		AsagiYukariDusman ayDusman = (AsagiYukariDusman) ((LabirentSahnesi) sahne).getAsagiYukariDusman();
		SagSolDusman ssDusman = (SagSolDusman) ((LabirentSahnesi) sahne).getSagSolDusman();
		

		switch (girdi) {

		case YUKARI:

			hareketEttir(adamKonum.getX(), adamKonum.getY() - 1, girdi);
			
			if(ayDusman != null){
				Konum ayDusmanKonum = ayDusman.getKonum();
				dusmanHareketEttir(ayDusmanKonum.getX(), ayDusmanKonum.getY() -1, girdi);
			}
			break;

		case SOLA:
			hareketEttir(adamKonum.getX() - 1, adamKonum.getY(), girdi);
			if(ssDusman != null){
				Konum ssDusmanKonum = ssDusman.getKonum();
				dusmanHareketEttir(ssDusmanKonum.getX() - 1, ssDusmanKonum.getY(), girdi);
			}
			break;

		case ASAGI:
			hareketEttir(adamKonum.getX(), adamKonum.getY() + 1, girdi);
			if(ayDusman != null){
				Konum ayDusmanKonum = ayDusman.getKonum();
				dusmanHareketEttir(ayDusmanKonum.getX(), ayDusmanKonum.getY() +1, girdi);
			}
			break;

		case SAGA:
			hareketEttir(adamKonum.getX() + 1, adamKonum.getY(), girdi);
			if(ssDusman != null){
				Konum ssDusmanKonum = ssDusman.getKonum();
				dusmanHareketEttir(ssDusmanKonum.getX() + 1, ssDusmanKonum.getY(), girdi);
			}
			break;
		}

	}

	private void hareketEttir(int x, int y, int yon) {

		Adam adam = ((LabirentSahnesi) sahne).getAdam();
		Hucre yeniHucre = ((LabirentSahnesi) sahne).getHucre(x, y);
		if (yeniHucre instanceof Cikis) {
			System.out.println("Tebrikler! Çıkışı buldunuz");
		}
		if (yeniHucre instanceof GucluYumruk) {
			adamaGucVer((GucluYumruk) yeniHucre);
		}
		if (yeniHucre instanceof GucluItebilme) {
			adamaGucVer((GucluItebilme) yeniHucre);
		}
		if (yeniHucre instanceof Kosma) {
			adamaGucVer((Kosma) yeniHucre);
		}
		// kutu hareket ettirme
		boolean kutuHareketEtti = false;
		if (yeniHucre instanceof Kutu) {
			switch (yon) {
			case YUKARI:
				kutuHareketEtti = kutuHareketEttir(x, y, x, y - 1);
				if (adam.getOzellik() instanceof GucluItebilme)
					kutuHareketEttir(x, y - 1, x, y - 2);
				break;
			case SOLA:
				kutuHareketEtti = kutuHareketEttir(x, y, x - 1, y);
				if (adam.getOzellik() instanceof GucluItebilme)
					kutuHareketEttir(x - 1, y, x - 2, y);
				break;
			case ASAGI:
				kutuHareketEtti = kutuHareketEttir(x, y, x, y + 1);
				if (adam.getOzellik() instanceof GucluItebilme)
					kutuHareketEttir(x, y + 1, x, y + 2);
				break;
			case SAGA:
				kutuHareketEtti = kutuHareketEttir(x, y, x + 1, y);
				if (adam.getOzellik() instanceof GucluItebilme)
					kutuHareketEttir(x + 1, y, x + 2, y);
				break;
			}

		}
		if (yeniHucre instanceof Kutu && kutuHareketEtti) {
			adamiHareketEttir(x, y);
		}
		if (!(yeniHucre instanceof Kutu)) {
			adamiHareketEttir(x, y);
			if (adam.getOzellik() instanceof Kosma) {
				switch (yon) {
				case YUKARI:
					adamiHareketEttir(x, y - 1);
					break;
				case SOLA:
					adamiHareketEttir(x - 1, y);
					break;
				case ASAGI:
					adamiHareketEttir(x, y + 1);
					break;
				case SAGA:
					adamiHareketEttir(x + 1, y);
					break;
				}

			}

		}

	}

	private void adamaGucVer(Ozellik ozellik) {

		Adam adam = ((LabirentSahnesi) sahne).getAdam();
		adam.setOzellik(ozellik);
	}

	private void adamiHareketEttir(int x, int y) {
		try {
			Adam adam = ((LabirentSahnesi) sahne).getAdam();
			Hucre yeniHucre = ((LabirentSahnesi) sahne).getHucre(x, y);

			int eskiX = adam.getKonum().getX();
			int eskiY = adam.getKonum().getY();
			Hucre bosluk = new Bosluk(new Konum(eskiX, eskiY));

			boolean hareketEtti = adam.hareketEttir(yeniHucre);

			if (hareketEtti) {
				sahne.setHucre(adam, x, y);
				sahne.setHucre(bosluk, eskiX, eskiY);
				sahne.setSkor(sahne.getSkor() + 1);
			}
			
		} catch (Exception e) {
		}
	}

	private boolean kutuHareketEttir(int eskiX, int eskiY, int x, int y) {
		try {
			Kutu kutu = new Kutu(new Konum(eskiX, eskiY));
			Hucre yeniHucre = ((LabirentSahnesi) sahne).getHucre(x, y);
			Hucre bosluk = new Bosluk(new Konum(eskiX, eskiY));

			boolean hareketEtti = kutu.hareketEttir(yeniHucre);

			if (hareketEtti) {
				sahne.setHucre(kutu, x, y);
				sahne.setHucre(bosluk, eskiX, eskiY);
			}
			return hareketEtti;
		} catch (Exception e) {
			return false;
		}
	}

	private void dusmanHareketEttir(int x, int y, int yon) {
		try {
			Dusman dusman = null;
			switch (yon) {
			case YUKARI:
			case ASAGI:
				dusman = ((LabirentSahnesi) sahne).getAsagiYukariDusman();
				break;
			case SOLA:
			case SAGA:
				dusman = ((LabirentSahnesi) sahne).getSagSolDusman();
				break;
			}

			Hucre yeniHucre = ((LabirentSahnesi) sahne).getHucre(x, y);

			int eskiX = dusman.getKonum().getX();
			int eskiY = dusman.getKonum().getY();
			Hucre bosluk = new Bosluk(new Konum(eskiX, eskiY));

			boolean hareketEtti = dusman.hareketEttir(yeniHucre);

			if (hareketEtti) {
				sahne.setHucre(dusman, x, y);
				sahne.setHucre(bosluk, eskiX, eskiY);
			}
		} catch (Exception e) {
		}
	}

	private boolean oyunBitti() {
		LabirentSahnesi labs = (LabirentSahnesi) sahne;
		boolean oyunBitti = false;
		if (labs.getAdam().getKonum().compareTo(labs.getCikis().getKonum()) == 0)
			oyunBitti = true;

		return oyunBitti;
	}

	public String toString() {
		String s = "-------------------------\n";
		s += sahne.toString();
		s += "\n Toplam Adım: " + sahne.getSkor();
		s += "\n-------------------------\n";

		return s;
	}

}
