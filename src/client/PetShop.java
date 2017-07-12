import java.net.*;
import java.io.*;
import java.util.*;

public class PetShop {
	private Socket s = null;
	private InputStream is= null;
	private OutputStream os= null;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	private String cmd = null;
	public PetShop () {
		try {
			s = new Socket ("localhost", 8080);
			is= s.getInputStream ();
			os= s.getOutputStream ();
			dis = new DataInputStream (is);
			dos = new DataOutputStream (os);
			oos = new ObjectOutputStream (os);
			ois = new ObjectInputStream (is);
		} catch (Exception e) {
			e.printStackTrace ();
		}
	}
	public void setCmd (String c) {
		cmd = c;
	}
	public void add (Pet p) {
		try {
			cmd = "add";
			os.write (cmd.getBytes ());
			os.flush ();
			Thread.sleep (1000);
			oos.writeObject (p);
		} catch (Exception e) {
			e.printStackTrace ();
		}
	}
	public List<Pet> searchName (String key) {
		List<Pet> p = new ArrayList<Pet> ();
		try {
			cmd = "select";
			os.write (cmd.getBytes ());
			os.flush ();
			Thread.sleep (1000);
			String tp = "n";
			os.write (tp.getBytes ());
			os.flush ();
			Thread.sleep (1000);
			key = key + " ";
			os.write (key.getBytes ());
			p = recList ();
		} catch (Exception e) {
			e.printStackTrace ();
		} finally {
			return p;
		}
	}
	public List<Pet> searchColor (String key) {
		List<Pet> p = new ArrayList<Pet> ();
		try {
			cmd = "select";
			os.write (cmd.getBytes ());
			os.flush ();
			Thread.sleep (1000);
			String tp = "c";
			os.write (tp.getBytes ());
			os.flush ();
			Thread.sleep (1000);
			key = key + " ";
			os.write (key.getBytes ());
			p = recList ();
		} catch (Exception e) {
			e.printStackTrace ();
		} finally {
			return p;
		}
	}
	public List<Pet> searchAge (int key) {
		List<Pet> p = new ArrayList<Pet> ();
		try {
			cmd = "select";
			os.write (cmd.getBytes ());
			os.flush ();
			Thread.sleep (1000);
			String tp = "a";
			os.write (tp.getBytes ());
			os.flush ();
			Thread.sleep (1000);
			dos.writeInt (key);
			p = recList ();
		} catch (Exception e) {
			e.printStackTrace ();
		} finally {
			return p;
		}
	}
	public void modify (Pet p, int i, String n, String c, int a) {
		delete (i);
		p.setName (n);
		p.setColor (c);
		p.setAge (a);
		//System.out.println (p);
		add (p);
	}
	public void delete (int i) {
		try {
			cmd = "delete";
			os.write (cmd.getBytes ());
			os.flush ();
			Thread.sleep (1000);
			dos.writeInt (i);
		} catch (Exception e) {
			e.printStackTrace ();
		}
	}
	public List<Pet> recList () {
		List<Pet> l = new ArrayList<Pet> ();
		try {
			int n = dis.readInt ();
			for (int i=0; i < n; i++) {
				l.add ((Pet)ois.readObject ());
			}
		} catch (Exception e) {
			e.printStackTrace ();
		} finally {
			return l;
		}
	}
}