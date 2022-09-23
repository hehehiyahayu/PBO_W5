package Restaurant_App_3;

import java.util.*;

public class RestaurantMain {
	
	public void inputMenuView(Restaurant menu) {
		menu.tambahMenuMakanan("Batagor", 5000, 20);
		Restaurant.nextId();
		menu.tambahMenuMakanan("Roti Bakar", 12000, 20);
		Restaurant.nextId();
		menu.tambahMenuMakanan("Indomie + Telor", 1000, 0);
		Restaurant.nextId();
		menu.tambahMenuMakanan("Kwetiaw", 12000, 10);
		Restaurant.nextId();
		menu.tambahMenuMakanan("Nasi Goreng", 12000, 1);
		Restaurant.nextId();
		menu.tambahMenuMakanan("Air Mineral", 3000, 5);
		Restaurant.nextId();
		menu.tambahMenuMakanan("Teh Manis", 4000, 10);
		Restaurant.nextId();
		menu.tambahMenuMakanan("Jus Alpukat", 8000, 11);
		Restaurant.nextId();
		menu.tambahMenuMakanan("Teh Botol", 5000, 12);
		Restaurant.nextId();
		menu.tambahMenuMakanan("Kopi", 3000, 20);
		Restaurant.nextId();
	}
	
	public void mainMenuView() {
		System.out.println("================== Restaurant App ==================");
		System.out.println("1. 	Batagor				= Rp 5000 	");
		System.out.println("2. 	Roti Bakar			= Rp 12000 	");
		System.out.println("3. 	Indomie + Telor			= Rp 10000 	");
		System.out.println("4. 	Kwetiaw				= Rp 12000 	");
		System.out.println("5. 	Nasi Goreng			= Rp 12000 	");
		System.out.println("6. 	Air Mineral			= Rp 3000  	");
		System.out.println("7. 	Teh Manis			= Rp 4000	");
		System.out.println("8. 	Jus Alpukat			= Rp 8000	");
		System.out.println("9. 	Teh Botol			= Rp 5000	");
		System.out.println("10.	Kopi				= Rp 3000	");
		System.out.println("====================================================");
	}
	
	public static void main(String[] args) {
		//Input Data Menu
		Restaurant menu =  new Restaurant();
		new RestaurantMain().inputMenuView(menu);
		Scanner input = new Scanner(System.in);
		char confirm = 'Y';
		while(confirm == 'Y' || confirm == 'y') {
			new RestaurantMain().mainMenuView();
			//Input erapa pesananan yang diinginkan
			System.out.println("Berapa menu yang ingin dibeli: ");
			int index = input.nextInt();
			int indexCadangan = index;
			if(index <= 0) {
				System.out.println("Tidak bisa memesan menu dengan jumlah kurang atau sama dengan 0");
				System.exit(1);
			}
			int[] penampung = new int[index];
			int loop = 0;
			//Pemilihan menu
			System.out.println("Pilih Menu: ");
			for(int i = 0; i <= penampung.length - 1; i++) {
				loop = input.nextInt();
				if(loop <= 0 || loop >= 11) {
					System.out.println("Tidak ada didalam pilihan menu");
					System.out.println();
					confirm = 'r';
					break;
				}else {
					penampung[i] = loop - 1;
					menu.prosesBeli(penampung[i]);
				}
			}
			if(confirm != 'r'){
				System.out.println();
				System.out.println();
				//Struk Pembayaran
				System.out.println("Struk Pembayaran:");
				for(int i = 0; i <= penampung.length - 1; i++) {
					menu.tampilPesananMenu(penampung[i]);
					System.out.print(" 		Rp.");
					menu.tampilHargaPesanan(penampung[i]);
					System.out.println();
				}
				System.out.println("Harga Total: 		Rp." + menu.tampilHargaTotal());
				System.out.println();
				System.out.println("Sisa Stok:");
				//Tampilan Sisa Stok
			}
			menu.tampilMenuMakanan();
			//Konfirmasi Pesanan Lanjutan
			System.out.println();
			System.out.println("Apakah anda ingin membuat pesanan baru? [Y/N]");
			confirm = input.next().charAt(0);
		}
		System.out.println();
		System.out.println("Aplikasi sudah ditutup");
		input.close();
		System.exit(0);
	}
}
