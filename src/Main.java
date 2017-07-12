import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main{
    public static void main (String args[]) {
        //MainWindow mw = new MainWindow();
        /*JFrame r = new JFrame ("SB");
        JPanel a = new JPanel ();
        JTextField t = new JTextField ("Who am I?");
        JButton b1 = new JButton ("Enter");
        JButton b2 = new JButton ("Cancel");
        t.setBounds (50, 5, 100, 20);
        b1.setBounds (10, 30, 80, 20);
        b2.setBounds (110, 30, 80, 20);
        b1.addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                if (e.getSource () == b1) {
                    JFrame f = new JFrame ();
                    f.setSize (400, 400);
                    f.setLayout (null);
                    JLabel l = new JLabel ();
                    ImageIcon image = new ImageIcon("./timg.jpg");
                    image.setImage(image.getImage().getScaledInstance(320,-1,Image.SCALE_DEFAULT));
                    l.setIcon (image);
                    l.setBounds (20,20,340,320);
                    f.setLocation (350,220);
                    f.add (l);
                    f.setVisible (true);
                }
            }
        });
        b2.addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                if (e.getSource () == b2) {
                    System.exit (1);
                }
            }
        });
        r.addWindowListener (new WindowAdapter() {
            public void windowClosing (WindowEvent arg0) {
                System.exit (1);
            }
        });
        a.setLayout (null);
        a.add (t);
        a.add (b1);
        a.add (b2);
        a.setBounds (0,0,200,50);
        r.setSize (220, 90);
        r.setLocation (300,200);
        a.setPreferredSize(new Dimension(190,250));
        JScrollPane jsp = new JScrollPane (a);
        jsp.setBounds (0,0,200,30);
        r.add (jsp);
        //r.setResizable (false);
        //r.setVisible (true);*/
    }
}
