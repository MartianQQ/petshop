import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginWindow extends JFrame {
	private JPanel jp= new JPanel ();
	private LoginFailWindow lfw = new LoginFailWindow (this);
	public LoginWindow () {
		super ("Login");
		addWindowListener (new WindowAdapter () {
			@Override
			public void windowClosing (WindowEvent e) {
				System.exit (0);
			}
		});
		JLabel jl1 = new JLabel ("username : ");
		JLabel jl2 = new JLabel ("password : ");
		JTextField jtf = new JTextField ();
		JPasswordField jpf = new JPasswordField ();
		JButton jb1 = new JButton ("login");
		JButton jb2 = new JButton ("register");
		jb1.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				String un = jtf.getText ();
				String pw = new String (jpf.getPassword ());
				if (!(un.equals ("root") && pw.equals ("123456"))) {
					lfw.setVisible (true);
				} else {
					MainWindow lw = new MainWindow ();
					dispose ();
				}
			}
		});
		jb2.setEnabled (false);
		jl1.setBounds (5, 3, 75, 20);
		jtf.setBounds (85, 3, 195, 20);
		jl2.setBounds (5, 29, 75, 20);
		jpf.setBounds (85, 29, 195, 20);
		jb1.setBounds (5, 55, 135, 20);
		jb2.setBounds (145, 55, 135, 20);
		setSize (300, 120);
		setLocation (400, 250);
		setLayout (null);
		add (jl1); add (jtf);
		add (jl2); add (jpf);
		add (jb1); add (jb2);
		setVisible (true);
	}
}