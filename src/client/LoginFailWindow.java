import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginFailWindow extends JDialog {
	private JPanel jp= new JPanel ();

	public LoginFailWindow (JFrame jf) {
		super (jf, "Error", true);
		JLabel jl = new JLabel ("Wrong username or password!");
		JButton jb = new JButton ("OK");
		jb.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				dispose ();
			}
		});
		setSize (220, 90);
		setLocation (450, 300);
		setLayout (new GridLayout (-1, 1, 3, 3));
		add (jl);
		add (jb);
	}
}