import java.util.Scanner;
import java.util.Vector;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Main_UAP{
	module IoN;
	Scanner in = new Scanner(System.in);
	static Vector<module> info = new Vector<>(); // this perma
	ArrayList<String> productName = new ArrayList<>();
	ArrayList<Integer> productPrice = new ArrayList<>();
	ArrayList<Integer> productStock = new ArrayList<>();
	static ArrayList<module> refresh = new ArrayList<>();
	static ArrayList<module> completed = new ArrayList<>();
	static ArrayList<Refresh> threadPool = new ArrayList<>();
	
	public void prompt() {
		System.out.println("Press ENTER to Continue..");
		in.nextLine();
	}
	
	public void printRefresh() {
		for (module module : refresh) {
			if(module.getDelivery() == 1) {
				System.out.println("ViCepat");
			}
			else {
				System.out.println("VedEx");
			}
			System.out.println();
			System.out.println("Shipping ID: "+module.getPrID());
			System.out.println("Shipping status: "+module.getStatus());
			if(module.getStatus().equals("Failed")) {
				System.out.println("Packet cannot be traced\n Sorry for the inconvinence. Insurance fee will be sent directly to the according address\n");
			}
			System.out.println();
		}
	}
	
	public void refreshList() {
		for (module module : info) {
			if(!refresh.contains(module) && !module.getStatus().equals("Completed")) {
				refresh.add(module);
			}
		}
	}
	
	public void initializeDummy() {
		Random temp  = new Random();
		productName.add("The Aubree Niacinamide Serum");
		productName.add("Tiff Body Cacao Coffee Scrub");
		productName.add("Kleveru Glass Skin Serum");
		productName.add("Sensatia Botanicals Unscented Facial-C Serum");
		productName.add("Mineral Botanicals Vanila Lip Scrub");
		productName.add("Think Hale Let's Mask");
		productName.add("Faith In Face Cica Jelly Mask");
		productName.add("Lacoco Swallow Facial Foam");
		productName.add("Everwhite Brightening Essence Serum");
		
		productPrice.add(99000);
		productPrice.add(150000);
		productPrice.add(143000);
		productPrice.add(180000);
		productPrice.add(55000);
		productPrice.add(129000);
		productPrice.add(29000);
		productPrice.add(165000);
		productPrice.add(125000);
		
		for(int i = 0; i<9; i++) {
			int rand = temp.nextInt(21);
			productStock.add(50-rand);
		}
	}

	public void view() {
		int size = productName.size();

		if (size != 0) {
			for(int i = 0; i<size; i++) {
				if(productStock.get(i)>0) {
				System.out.printf("No\t: %d\n",i+1);
				System.out.printf("Name\t: %s\n",productName.get(i));
				System.out.printf("Price\t: Rp. %d.0\n",productPrice.get(i));
				System.out.printf("Stocks\t: %d\n\n",productStock.get(i));
				}
			}
		} else {
			System.out.println("Sorry, all of our products are currently out of stock!");
		}
	}
	
	public void one() {
		ArrayList<Integer> productBought = new ArrayList<>();
		ArrayList<Integer> productQty = new ArrayList<>();
		String YN = null;
		long productTotal = 0;
		do {
			view();
			int size = 0;
			size = productName.size();
			int pick = 0, ts = 0;
			do {
				ts = 0; 
				pick = 0;
				while(pick<1 || pick>size) {
					System.out.printf("Pick product to buy[1..%d]: ", size);
					try {
						pick = in.nextInt();
						in.nextLine();
					}catch(Exception e) {
						in.nextLine();
					}
				}
				if(productStock.get(pick-1) < 1) {
					ts = 1;
					System.out.println("Sorry, Product is out of stock");
				}
			}while(pick<1 || pick>size || ts==1);
			productBought.add(pick-1);
			int qty = 0, stock = 0;
			do {
				stock = productStock.get(pick-1);
				System.out.printf("Input  quantity [1..%d]: ", stock);
				try {
					qty = in.nextInt();
					in.nextLine();
				}catch(Exception e) {
					in.nextLine();
				}
				if(qty>stock) {
					System.out.printf("Insufficient product stock. Maximum purchase of this product is only %d.\n", stock);
				}
			}while(qty<1 || qty>stock);
			productStock.set(pick-1, productStock.get(pick-1)-qty); //mengubah nilai stock (update sesuai barang yang terbeli)
			productQty.add(qty); //quantity yang dibeli oleh user
			productTotal += qty*productPrice.get(pick-1); //
			do{
				System.out.println("Would you like to add more product into your cart? [Y/N]: ");
				YN = in.nextLine();
			}while(!YN.contentEquals("N") && !YN.contentEquals("Y"));
		}while(YN.contentEquals("Y"));
		
		int res = 0, ongkir = 0;
		String address = null;
		do {
			res = 0;
			address = null;
			System.out.print("Input shipping address[must begin with 'Jl. ' (case-sensitive)]: ");
			address = in.nextLine();
			if(address.length()>9) {
				String checkJL = address.substring(0,4);				
				if(checkJL.contentEquals("Jl. ")) {
					res = 1;
				}
			}
		}while(res == 0);

		do {
			res = 0;
			String shipping = null;
			System.out.print("Input Shipping Service[VeDex | ViCepat (case-insensitive)]: ");
			shipping = in.nextLine();
			if(shipping.compareToIgnoreCase("vedex") == 0 || shipping.compareToIgnoreCase("vicepat") == 0) {
				res = 1;
				if(shipping.equalsIgnoreCase("vicepat")) {
					ongkir = 1;
				}
			}
		}while(res == 0);
		System.out.println();

		int Fee = 12000;
		if(ongkir == 0) {
			Fee = 0;
			if(productTotal<150000) {
				Fee = 10000;
				productTotal += Fee;
			}
		} else {
			productTotal += Fee;
		}
		//ongkir 0 berarti VeDex, ongkir 1 berarti ViCepat
		UUID iD = UUID.randomUUID();
		String tempStr = "";
		int size = productBought.size();

		for(int i = 0; i<size; i++) {
			tempStr += "- "+productQty.get(i)+"pcs "+productName.get(productBought.get(i))+"\n";
		}
		IoN = new module(iD.toString(),address, ongkir, Fee, productTotal, tempStr);
		threadPool.add(new Refresh(IoN,ongkir));
		info.add(IoN);
		System.out.printf("Products' Prices\t: Rp. %d.0\n",productTotal);
		System.out.printf("Shipping Fee\t\t: Rp. %d.0\n",Fee);		
		System.out.printf("Grand Total\t\t: Rp. %d.0\n",productTotal+Fee);
		prompt();
	}
	
	public Main_UAP() {
		initializeDummy();
		System.out.println("Welcome to Vi Shop! ^-^\n");
		System.out.println("To Create an order, please input your name.");
		String name = null;
		int check = 0;
		do {
			check = 0;
			name = null;
			System.out.print("Name [Min. 3 characters | Must contain two words]: ");
			name = in.nextLine();
			String str[] = name.split(" ");
			List<String> temp = new ArrayList<String>();
			temp = Arrays.asList(str);
			int count = 0;
			for(String s: temp) {
				count++;
			}
			if(count<2) {
				check = 1;
				System.out.println("Name must be two words!");
			} else if (name.length()<4) {
				check = 1;
				System.out.println("Name must contain minimal 3 characters!");
			}
		}while(check == 1);	

		int input = 0;
		do {
			printRefresh();
			System.out.printf("\nHello, %s\n",name);
			System.out.println("1. Shop at Vi");
			System.out.println("2. Refresh My Shipping Status");
			System.out.println("3. View Purchase History");
			System.out.println("4. Exit");
			
			try {
				input = in.nextInt();
				in.nextLine();
			}catch(Exception e) {
				in.nextLine();
			}
			
			if(input == 1) {
				one();
			}else if (input == 2) {
				refreshList();
			}else if (input == 3) {
				int j = 0;
				System.out.println("Finished Order\n==============\n");
				for (module module : completed) {
					System.out.println("Shipping ID: "+module.getPrID());
					System.out.println("Shipping status: "+ module.getStatus());
					System.out.println(module.getS());
					System.out.println();
				}
				prompt();
			}
		}while(input != 4);
	}

	public static void main(String[] args) {
		new Main_UAP();
	}

}
