import java.util.*;

public class PetShopTest {
	public static void main (String args[]) {
		PetShop ps = new PetShop ();
		/*ps.add(new Cat("��è", "��ɫ��", 2));
		ps.add(new Cat("��è", "��ɫ��", 3));
		ps.add(new Cat("��è", "��ɫ��", 3));
		ps.add(new Dog("��������", "��ɫ��", 3));
		ps.add(new Dog("��ë", "��ɫ��", 3));
		ps.add(new Dog("�ƹ�", "��ɫ��", 3));
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
