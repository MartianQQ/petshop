import java.net.*;
import java.io.*;
import java.util.*;

public class ClientThread extends Thread {
	Socket s = null;
	InputStream is = null;
	OutputStream os = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	public ClientThread (Socket x) {
		try {
			s = x;
			is = s.getInputStream ();
			os = s.getOutputStream ();
			dis = new DataInputStream (is);
			dos = new DataOutputStream (os);
			ois = new ObjectInputStream (is);
			oos = new ObjectOutputStream (os);
		} catch (Exception e) {
			e.printStackTrace ();
		}
	}
	public void run () {
		List<Pet> l = null;
		try {
			while (true) {
				byte bt[] = new byte[1024];
				is.read (bt);
				String cmd = new String (bt);
				cmd = cmd.trim ();
				System.out.println (cmd);
				String tp = null;
				String k = null;
				if (cmd.equals ("add")) {
					Pet p = (Pet)ois.readObject ();
					Main.PS.add (p);
				}
				if (cmd.equals ("select")) {
					bt = new byte[1024];
					is.read (bt);
					tp = new String (bt);
					tp = tp.trim ();
					System.out.println (tp);
					if (tp.equals ("n")) {
						bt = new byte[4096];
						is.read (bt);
						k = new String (bt);
						k = k.trim ();
						l = Main.PS.searchName (k);
						sendList (l);
					}
					if (tp.equals ("c")) {
						bt = new byte[4096];
						is.read (bt);
						k = new String (bt);
						k = k.trim ();
						l = Main.PS.searchColor (k);
						sendList (l);
					}
					if (tp.equals ("a")) {
						int ka;
						ka = dis.readInt ();
						l = Main.PS.searchAge (ka);
						sendList (l);
					}
				}
				if (cmd.equals ("delete")) {
					int x = dis.readInt ();
					System.out.println (x);
					Pet dp = l.get (x);
					System.out.println (dp);
					Main.PS.delete (dp);
				}
			}
		} catch (Exception e) {
			System.out.println ("Client exit");
			Main.t.delLink ();
		} finally {
			try {
				if (is != null) is.close ();
				if (os != null) os.close ();
			} catch (Exception e) {
				e.printStackTrace ();
			}
		}
	}
	private void sendList (List<Pet> l) throws Exception {
		dos.writeInt (l.size ());
		for (int i=0; i < l.size (); i++) {
			try {
				oos.writeObject (l.get (i));
			} catch (Exception e) {
				e.printStackTrace ();
			}
		}
	}
}
