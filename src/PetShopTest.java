import java.util.*;

public class PetShopTest {
	public static void main (String args[]) {
		PetShop ps = new PetShop ();
		/*ps.add(new Cat("白猫", "白色的", 2));
		ps.add(new Cat("黑猫", "黑色的", 3));
		ps.add(new Cat("花猫", "花色的", 3));
		ps.add(new Dog("拉布拉多", "黄色的", 3));
		ps.add(new Dog("金毛", "金色的", 3));
		ps.add(new Dog("黄狗", "黑色的", 3));
		ps.delete (ps.searchAge (3).get (0));
		ps.output ();*/
		ps = ps.input();
		ps.showAll();
	}
	public static void print (List<Pet> p) {
		for (int i = 0; i < p.size (); i++) {
			System.out.println (p.get (i));
		}
	}
}
