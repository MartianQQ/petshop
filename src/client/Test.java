import java.net.*;
import java.io.*;
import java.util.*;

public class Test {
	public static void main (String args[]) {
		Socket s = null;
		try {
			s = new Socket ("127.0.0.1", 8080);
			InputStream is = s.getInputStream ();
			OutputStream os = s.getOutputStream ();
			DataInputStream dis = new DataInputStream (s.getInputStream ());
			DataOutputStream dos = new DataOutputStream (s.getOutputStream ());
			ObjectOutputStream oos = new ObjectOutputStream (s.getOutputStream ());
			ObjectInputStream ois = new ObjectInputStream (s.getInputStream ());
			String cmd = "delete";
			Pet p = new Cat ("a", "b", 1);
			List<Pet> l = new ArrayList<Pet> ();
			os.write (cmd.getBytes ());
			os.flush ();
			Thread.sleep (1000);
			os.write ("n".getBytes ());
			os.flush ();
			Thread.sleep (1000);
			os.write ("1".getBytes ());
			os.flush ();
			Thread.sleep (1000);
			int n = dis.readInt ();
			System.out.println (n);
			
			for (int i=0; i < n; i++){
				p = (Pet)ois.readObject ();
				System.out.println (p);
			}
			p = new Cat ("1", "2", 3);
			dos.writeInt (0);
			Thread.sleep (1000);
		} catch (Exception e) {
			e.printStackTrace ();
		}
	}
}