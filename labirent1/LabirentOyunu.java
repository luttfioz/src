package labirent1;
import java.util.Scanner;

/**
 * 
 * @author dogan
 *
 * Bu program düzensiz yazılmış bir program örneği olup labirent oyununu içerir
 */
public class LabirentOyunu {

	// labirent matrisi
	public static int[][] labirent={{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
									{2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
									{2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2},
									{2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2},
									{2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2},
									{2, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2},
									{2, 1, 2, 1, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2},
									{2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 1, 1, 2},
									{2, 1, 2, 1, 2, 1, 2, 1, 2, 2, 2, 2, 1, 2, 1, 2, 1, 1, 1, 2},
									{2, 1, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2},
									{2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 1, 1, 2},
									{2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 2, 2, 1, 2},
									{2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 2},
									{2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 2},
									{2, 1, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2},
									{2, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2},
									{2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 1, 2},
									{2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2},
									{2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 4, 2},
									{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};
	
	// colsoldan okumak için Scanner nesnesi oluşturuyor.
	public static Scanner consol = new Scanner (System.in);
	
	
	public static void main(String[] args) {
		
		int adamX = 0, adamY = 0; // adamın koordinatları
		int hedefX = 0, hedefY = 0; // hedefin koordinatları
		
		int toplamAdim = 0; // toplam atılmış adım sayısı
			
		/*
		 * Labirent baştan sona dolaşılıp adamın ve hedefin yeri
		 * tespit ediliyor
		 */
		for (int y = 0; y < labirent.length; y++){
			for(int x = 0; x < labirent[y].length; x++){
				int hucre = labirent[y][x];
				if(hucre == 3){
					adamX = x;
					adamY = y;
				}
				if(hucre == 4){
					hedefX = x;
					hedefY = y;
				}
			}
		}
		
		/*
		 * Oyun bu aşamadan itibaren başlıyor
		 * Adam hedefi (çıkışı) bulana kadar aşağıdaki işlemler tekrar ediyor
		 * 
		 */
		while(true){
			
			// labirent ekrana bastırılıyor
			System.out.println("-------------------------\n");
			for (int y = 0; y < labirent.length; y++){
				for(int x = 0; x < labirent[y].length; x++){
					int hucre = labirent[y][x];
					
					switch(hucre){
						case 1: 
							System.out.print("-");
							break;
						case 2: 
							System.out.print("#");
							break;
						case 3:
							System.out.print("�");
							break;
						case 4: 
							System.out.print((char)169);
							break;
					}
					
				}
				System.out.println("");
			}
			System.out.println("\n Toplam Adım: "+toplamAdim);
			System.out.println("\n-------------------------\n");
			
			
			// kullanıcıdan adamı hareket ettirmek için yön bilgisi isteniyor
			System.out.print("Yön Tuşları (w = yukarı, s = aşağı, a = sol, d = sağ), seçiniz: ");
			String secimStr = consol.next();
			
			char secim = secimStr.charAt(0);
			
			switch(secim){
				case 'w':
				case 'W': 
					// yukarıda yer boş mu
					if(labirent[adamY-1][adamX] == 1 || labirent[adamY-1][adamX] == 4){
						labirent[adamY][adamY] = 1; // şu an ki bulunduğu yeri boşluk olarak belirle
						labirent[--adamY][adamX] = 3; // labirentte adamın yerini değiştir
						toplamAdim++;
					}
					break;
				case 'a':
				case 'A':
					// solunda yer boş mu
					if(labirent[adamY][adamX-1] == 1 || labirent[adamY][adamX-1] == 4){
						labirent[adamY][adamX] = 1; // şu an ki bulunduğu yeri boşluk olarak belirle
						labirent[adamY][--adamX] = 3; // labirentte adamın yerini değiştir
						toplamAdim++;
					}
					break;
					
				case 's':
				case 'S':	
					// aşağıda yer boş mu
					if(labirent[adamY+1][adamX] == 1 || labirent[adamY+1][adamX] == 4){
						labirent[adamY][adamX] = 1; // şu an ki bulunduğu yeri boşluk olarak belirle
						labirent[++adamY][adamX] = 3; // labirentte adamın yerini değiştir
						toplamAdim++;
					}
					break;
				
				case 'd':
				case 'D':	
					// sağ tarafta yer boş mu
					if(labirent[adamY][adamX+1] == 1 || labirent[adamY][adamX+1] == 4){
						labirent[adamY][adamX] = 1; // şu an ki bulunduğu yeri boşluk olarak belirle
						labirent[adamY][++adamX] = 3; // labirentte adamın yerini değiştir
						toplamAdim++;
					}
					
					break;

				
			}
			
			// oyunun bitip bitmediği kontrol ediliyor
			if(hedefX == adamX && hedefY == adamY){
				System.out.println("Tebrikler! Çıkışı buldunuz");
				break;
			}
			
			
		}
		
	}

}
