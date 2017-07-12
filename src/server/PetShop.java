import java.util.*;
import java.io.*;

public class PetShop implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Pet> pl = new ArrayList<Pet> ();
	public void add (Pet p) {
		System.out.println (p);
		pl.add (p);
	}
	public List<Pet> searchName (String key) {
		List<Pet> p = new ArrayList<Pet> ();
		for (int i = 0; i < pl.size (); i++) {
			if (pl.get (i).getName ().indexOf (key) != -1) {
				p.add (pl.get (i));
			}
		}
		return p;
	}
	public List<Pet> searchColor (String key) {
		List<Pet> p = new ArrayList<Pet> ();
		for (int i = 0; i < pl.size (); i++) {
			if (pl.get (i).getColor ().indexOf (key) != -1) {
				p.add (pl.get (i));
			}
		}
		return p;
	}
	public List<Pet> searchAge (int key) {
		List<Pet> p = new ArrayList<Pet> ();
		for (int i = 0; i < pl.size (); i++) {
			if (pl.get (i).getAge () == key || key ==-1) {
				p.add (pl.get (i));
			}
		}
		return p;
	}
	public void modify (Pet p, String n, String c, int a) {
		pl.remove (p);
		p.setName (n);
		p.setColor (c);
		p.setAge (a);
		pl.add (p);
	}
	public void delete (Pet p) {
		if (pl.indexOf (p) != -1) {
			System.out.println (p);
			pl.remove (p);
		}
		else System.out.println ("sb");
	}
	public void showAll () {
		for (int i = 0; i < pl.size (); i++) {
			System.out.println (pl.get (i) + " ");
		}
	}
	public void output () {
		try{
			OutputStream os = new FileOutputStream (new File ("1.db"));
			ObjectOutputStream oos = new ObjectOutputStream (os);
			oos.writeObject (this);
		} catch (Exception e) {
			e.printStackTrace ();
		}
	}
	public static PetShop input () {
		PetShop p = null;
		InputStream is = null;
		ObjectInputStream ois = null;
		try {
			is = new FileInputStream (new File ("1.db"));
			ois = new ObjectInputStream (is);
			p = (PetShop)ois.readObject ();
		} catch (Exception e) {
			e.printStackTrace ();
		} finally {
			try {
				ois.close();
				is.close();
			} catch (Exception e) {
				e.printStackTrace ();
			}
			return p;
		}
	}
}
