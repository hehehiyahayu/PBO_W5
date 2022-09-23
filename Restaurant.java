package Restaurant_App_3;

public class Restaurant {
	private static byte id=0;
	private static double harga_total=0;
	
	ItemMenu[] Menu = new ItemMenu[11];
	
	public void tambahMenuMakanan(String nama, double harga, int stok) {
		Menu[id] = new ItemMenu();
		Menu[id].setNama_makanan(nama);
		Menu[id].setHarga_makanan(harga);
		Menu[id].setStok(stok);
	}
	
	public void tampilMenuMakanan() {
		Menu[id] = new ItemMenu();
		String nama_menu;
		double harga_menu;
		int stok_menu;
		
		for(int i = 0; i <= id; i++) {
			if(!isOutOfStock(i)) {
				nama_menu = Menu[i].getNama_makanan();
				harga_menu = Menu[i].getHarga_makanan();
				stok_menu = Menu[i].getStok();
				System.out.println(nama_menu + "[" +stok_menu+ "]" + "\tRp. "+harga_menu);
			}
		}
	}
	
	public void prosesBeli(int id_Menu) {
		Menu[id] = new ItemMenu();
		if(!isOutOfStock(id_Menu)) {
			Menu[id_Menu].setStok(Menu[id_Menu].getStok() - 1);
			harga_total = harga_total + Menu[id_Menu].getHarga_makanan();
		}else {
			System.out.print("Menu sudah habis");
		}
	}
	
	public double tampilHargaTotal() {
		return harga_total;
	}
	
	public void tampilPesananMenu(int id_Menu) {
		Menu[id] = new ItemMenu();
		if(!isOutOfStock(id_Menu)) {
			System.out.print(Menu[id_Menu].getNama_makanan());
		}else {
			System.out.print("Menu sudah habis");
		}
	}
	
	public void tampilHargaPesanan(int id_Menu) {
		Menu[id] = new ItemMenu();
		if(!isOutOfStock(id_Menu)) {
			System.out.print(Menu[id_Menu].getHarga_makanan());
		}else {
			System.out.print(0);
		}
	}
	
	public boolean isOutOfStock(int id) {
		int stok_menu = Menu[id].getStok();
		if(stok_menu == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void nextId() {
		id++;
	}
}
