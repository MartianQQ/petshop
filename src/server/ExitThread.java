import java.util.*;

public class ExitThread extends Thread {
	private int link;
	public void run () {
		String cmd = null;
		Scanner sc = new Scanner (System.in);
		while (true) {
			cmd = sc.nextLine ();
			if (cmd.equals ("exit") && link == 0) {
				Main.PS.output ();
				System.exit (0);
			}
		}
	}
	public void addLink () {
		link ++;
	}
	public void delLink () {
		link --;
	}
}