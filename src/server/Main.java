import java.net.*;

public class Main {
	public static PetShop PS = null;
	public static ExitThread t = new ExitThread ();
	public static void main (String args[]) {
		PS = PetShop.input ();
		t.start ();
		ServerSocket ss = null;
		Socket s = null;
		ClientThread c = null;
		try {
			ss = new ServerSocket (8080);
			while (true){
				s = ss.accept ();
				System.out.println ("Connect : " + s.getInetAddress ());
				c = new ClientThread (s);
				t.addLink ();
				c.start ();
			}
		} catch (Exception e) {
			e.printStackTrace ();
		} finally {
			if (ss != null) {
				try {
					ss.close ();
				} catch (Exception e) {
					e.printStackTrace ();
				}
			}
		}
	}
}
