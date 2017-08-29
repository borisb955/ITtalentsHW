package Others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

import cakes.Cake;
import cakes.Cake.CakeKind;
import cakes.child.*;
import cakes.special.*;
import cakes.standard.*;
import cakes.wedding.*;
import clients.*;

public class Demo {

	public static void main(String[] args) {
		HashSet<DeliveryMan> dms = new HashSet<>();
		HashSet<Client> clients = new HashSet<>();
		
		//1. making 5 DeliveryMen
		for (int i = 0; i < 5; i++) {
			dms.add(new DeliveryMan("D Man " + i, "08855" +(i*10)));	
		}
		
		//1. Making Sweet Shop
		SweetShop talanti = new SweetShop("Sweet Talents", "Tsar Kaloqn 23", "0884383453", dms);
		
		//2. Create 30 cakes
		for (int i = 0; i < 30; i++) {
			Cake cake = null;
			
			int randomKind = new Random().nextInt(4) + 1;
			
			switch(randomKind) {
			case 1: int randomType = new Random().nextInt(4) + 1;
					switch(randomType) {
					case 1: cake = new Biscuit("Cake " + i, "dfdf", new Random().nextInt(20) + 5, new Random().nextInt(20) + 5);
							break;
					case 2: cake = new Ekler("Cake " + i, "dfdf", new Random().nextInt(20) + 5, new Random().nextInt(20) + 5);
							break;
					case 3: cake = new Fruit("Cake " + i, "dfdf", new Random().nextInt(20) + 5, new Random().nextInt(20) + 5);
							break;
					case 4: cake = new Chocolate("Cake " + i, "dfdf", new Random().nextInt(20) + 5, new Random().nextInt(20) + 5);
							break;
					default: break;
					}
					break;
			case 2:  int randomType2 = new Random().nextInt(3) + 1;
					switch(randomType2) {
					case 1:	cake = new Big("Cake " + i, "mnoo dobra", new Random().nextInt(20) + 5, new Random().nextInt(20) + 5);
							break;
					case 2: cake = new Medium("Cake " + i, "mnoo hubava", new Random().nextInt(20) + 5, new Random().nextInt(20) + 5);
							break;
					case 3: cake = new Small("Cake " + i, "dobra e", new Random().nextInt(20) + 5, new Random().nextInt(20) + 5);
							break;
					default: break;
					}
					break;
			case 3:  int randomType3 = new Random().nextInt(3) + 1;
				switch(randomType3) {
				case 1:	cake = new Jubilee("Cake " + i, "mnoo dobra", new Random().nextInt(20) + 5, new Random().nextInt(20) + 5, "Name " + i);
						break;
				case 2: cake = new Company("Cake " + i, "mnoo hubava", new Random().nextInt(20) + 5, new Random().nextInt(20) + 5, "Name " + i);
						break;
				case 3: cake = new Advertising("Cake " + i, "dobra e", new Random().nextInt(20) + 5, new Random().nextInt(20) + 5, "Name " + i);
						break;
				default: break;
				}
				break;
			case 4:  int randomType4 = new Random().nextInt(3) + 1;
				switch(randomType4) {
				case 1:	cake = new BDay("Cake " + i, "mnoo dobra", new Random().nextInt(20) + 5, new Random().nextInt(20) + 5, "Name " + i);
						break;
				case 2: cake = new Baptist("Cake " + i, "mnoo hubava", new Random().nextInt(20) + 5, new Random().nextInt(20) + 5, "Name " + i);
						break;
				case 3: cake = new Chuck("Cake " + i, "dobra e", new Random().nextInt(20) + 5, new Random().nextInt(20) + 5, "Name " + i);
						break;
				default: break;
				}
				break;
			}
			
			talanti.addCake(cake);
			
		}
		
		//3. Making 2 x 5 clients
		for (int i = 0; i < 5; i++) {
			clients.add(new CorClient("Cor Client " + i, "0888" + i, new Random().nextInt(100) + 20));
			clients.add(new PrClient("Pr Client " + i, "02" + i, new Random().nextInt(100) + 20));
		}
		
		//5. Show cakes
		System.out.println("Cakes before selling");
		talanti.showCakesInfo();
		
		//4. All clients make order
		for(Client c : clients) {
			c.makeOrder(talanti);
		}
		
		//5. Show cakes
		System.out.println("Cakes after selling");
		talanti.showCakesInfo();
		
		//6.Show SweetShop money
		System.out.println("\n\nSweet Shop Talanti's money : " + talanti.getMoney());
		
		//7.Show Delivery Men sorted by their tip 
		TreeSet<DeliveryMan> dmsSorted = new TreeSet<>((dm1, dm2) -> (int)(dm2.getMoney() - dm1.getMoney()));
		dmsSorted.addAll(talanti.getDeliveryMen());
		System.out.println("\nDelivery Men sorted by tip");
		System.out.println("- - - - ");
		for(DeliveryMan dm : dmsSorted) {
			System.out.println(dm);
		}
		
		//8. Most frequent cake sold
		CakeKind mostSoldCake = null;
		int num = 0;
		for(CakeKind ck : talanti.getCakesSold().keySet()) {
			int soldFromKind = 0;
			for(TreeSet<Cake> hm : talanti.getCakesSold().get(ck).values()) {
				soldFromKind += hm.size();
			}
			if(soldFromKind > num) {
				num = soldFromKind;
				mostSoldCake = ck;
			}
		}
		System.out.println("\nMost sold kind of cake is : " + mostSoldCake + " : " + num + " cakes sold");
		
		//9.Delivery Man with highest orders
		DeliveryMan dm = null;
		int num2 = 0;
		for(DeliveryMan d : talanti.getDeliveryMen()) {
			if(d.getDeliveredOrders() > num2) {
				num2 = d.getDeliveredOrders();
				dm = d;
			}
		}
		System.out.println("\nDelivery Man with the most orders is : " + dm.getName() + " : " + num2 + " delivered orders");
		
		//10. The client with most paid money for an order
		Client client = null;
		int num3 = 0;
		for(Client c : clients) {
			if(c.getMoneyGivenForCakes() > num3) {
				num3 = c.getMoneyGivenForCakes();
				client = c;
			}
		}
		System.out.println("\nThe client with highest ordery price is " + client.getName() + " with $" + num3 + " paid");
	}

}
