import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame {
	private JMenuItem jmi1[] = new JMenuItem[4];
	private JMenuItem jmi2[] = new JMenuItem[3];
	private JMenu jm[] = new JMenu[2];
	private JMenuBar jmb;
	private JPanel jp[] = new JPanel[4];
	private JPanel njp = new JPanel ();
	private JTextArea jta = null;
	private JPanel p2 = null;
	private JPanel p3 = null;
	private void buildJP0 () { //add
		JDialog jd = new JDialog (this, "MsgBox", true);
		JLabel jlt = new JLabel ();
		JButton jbt = new JButton ("OK");
		jd.setLayout (null);
		jd.setResizable (false);
		jd.setSize (220, 90);
		jd.setLocation (430, 250);
		jlt.setBounds (5, 5, 200, 20);
		jbt.setBounds (50, 30, 100, 20);
		jbt.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				jd.dispose ();
			}
		});
		jd.add (jlt);
		jd.add (jbt);
		jp[0] = new JPanel ();
		jp[0].setLayout (null);
		JRadioButton jrb1 = new JRadioButton ("Cat");
		JRadioButton jrb2 = new JRadioButton ("Dog");
		ButtonGroup bg = new ButtonGroup ();
		JLabel jl1 = new JLabel ("Name : ");
		JLabel jl2 = new JLabel ("Color : ");
		JLabel jl3 = new JLabel ("Age : ");
		JTextField jtf1 = new JTextField ();
		JTextField jtf2 = new JTextField ();
		JTextField jtf3 = new JTextField ();
		JButton jb1 = new JButton ("Enter");
		JButton jb2 = new JButton ("Reset");
		jb1.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				String n = jtf1.getText ();
				String c = jtf2.getText ();
				String a = jtf3.getText ();
				if (!jrb1.isSelected () && !jrb2.isSelected ()) {
					jlt.setText ("Please choose which pet you want");
					jd.setVisible (true);
				}
				else if (n.equals("") || c.equals("") || a.equals("")) {
					jlt.setText ("Pleast input name, color and age");
					jd.setVisible (true);
				}
				else {
					Pet p = null;
					if (jrb1.isSelected ()){
						p = new Cat (n,c,Integer.parseInt(a));
					}
					else {
						p = new Dog (n,c,Integer.parseInt(a));
					}
					Main.PS.setCmd ("add");
					Main.PS.add (p);
					jtf1.setText ("");
					jtf2.setText ("");
					jtf3.setText ("");
					jlt.setText ("Add Succeed");
					jd.setVisible (true);
				}
			}
		});
		jb2.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				jrb1.setSelected (false);
				jrb2.setSelected (false);
				jtf1.setText ("");
				jtf2.setText ("");
				jtf3.setText ("");
			}
		});
		bg.add (jrb1);
		bg.add (jrb2);
		jrb1.setBounds (5, 3, 135, 20);
		jrb2.setBounds (145, 3, 135, 20);
		jl1.setBounds (5, 29, 75, 20);
		jtf1.setBounds (85, 29, 195, 20);
		jl2.setBounds (5, 55, 75, 20);
		jtf2.setBounds (85, 55, 195, 20);
		jl3.setBounds (5, 81, 75, 20);
		jtf3.setBounds (85, 81, 195, 20);
		jb1.setBounds (5, 107, 135, 20);
		jb2.setBounds (145, 107, 135, 20);
		jp[0].add (jrb1);
		jp[0].add (jrb2);
		jp[0].add (jl1);
		jp[0].add (jtf1);
		jp[0].add (jl2);
		jp[0].add (jtf2);
		jp[0].add (jl3);
		jp[0].add (jtf3);
		jp[0].add (jb1);
		jp[0].add (jb2);
	}
	private void buildJP1(){ //select
		jp[1] = new JPanel ();
		JPanel pan = new JPanel ();
		JLabel jl1 = new JLabel ("Name : ");
		JLabel jl2 = new JLabel ("Color : ");
		JLabel jl3 = new JLabel ("Age : ");
		JTextField jtf1 = new JTextField ();
		JTextField jtf2 = new JTextField ();
		JTextField jtf3 = new JTextField ();
		JButton jb1 = new JButton ("Select");
		JButton jb2 = new JButton ("Select");
		JButton jb3 = new JButton ("Select");
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane (jta);
		jb1.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				jta.setText ("");
				String n = jtf1.getText ();
					jtf1.setText ("");
					Main.PS.setCmd ("select");
					java.util.List<Pet> p = Main.PS.searchName (n);
					for (int i = 0; i < p.size (); i++) {
						jta.append (p.get (i) + "\n");
						//System.out.println (p.get (i));
					}
			}
		});
		jb2.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				jta.setText ("");
				String c = jtf2.getText ();
					jtf2.setText ("");
					Main.PS.setCmd ("select");
					java.util.List<Pet> p = Main.PS.searchColor (c);
					for (int i = 0; i < p.size (); i++) {
						jta.append (p.get (i) + "\n");
						//System.out.println (p.get (i));
					}
			}
		});
		jb3.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				jta.setText ("");
				String a =  jtf3.getText ();
					jtf3.setText ("");
					java.util.List<Pet> p = null;
					Main.PS.setCmd ("select");
					if (a.length () == 0) p = Main.PS.searchAge (-1);
					else p = Main.PS.searchAge (Integer.parseInt (a));
					for (int i = 0; i < p.size (); i++) {
						jta.append (p.get (i) + "\n");
						//System.out.println (p.get (i));
					}
			}
		});
		jta.setEditable (false);
		pan.setLayout (new GridLayout (3, 3, 3, 3));
		pan.add (jl1); pan.add (jtf1); pan.add (jb1);
		pan.add (jl2); pan.add (jtf2); pan.add (jb2);
		pan.add (jl3); pan.add (jtf3); pan.add (jb3);
		jp[1].setLayout (new BorderLayout(3, 3));
		jp[1].add (pan, BorderLayout.NORTH);
		jp[1].add (jsp, BorderLayout.CENTER);
	}
	private void buildJP2(){ //modify
		JDialog jdm = new JDialog (this, "Modify", true);
		jdm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		jdm.setLayout (new GridLayout (-1, 2, 3, 3));
		jdm.setSize (300,200);
		JLabel jld1 = new JLabel ("Name : ");
		JLabel jld2 = new JLabel ("Color : ");
		JLabel jld3 = new JLabel ("Age : ");
		JTextField jtfd1 = new JTextField ();
		JTextField jtfd2 = new JTextField ();
		JTextField jtfd3 = new JTextField ();
		JButton jbd1 = new JButton ("Enter");
		JButton jbd2 = new JButton ("Cancel");
		jbd2.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				jdm.dispose ();
			}
		});
		jdm.add (jld1); jdm.add (jtfd1);
		jdm.add (jld2); jdm.add (jtfd2);
		jdm.add (jld3); jdm.add (jtfd3);
		jdm.add (jbd1); jdm.add (jbd2);
		jp[2] = new JPanel ();
		JPanel pan = new JPanel ();
		p2 = new JPanel ();
		p2.setLayout (new GridLayout (-1, 2, 3, 3));
		JLabel jl1 = new JLabel ("Name : ");
		JLabel jl2 = new JLabel ("Color : ");
		JLabel jl3 = new JLabel ("Age : ");
		JTextField jtf1 = new JTextField ();
		JTextField jtf2 = new JTextField ();
		JTextField jtf3 = new JTextField ();
		JButton jb1 = new JButton ("Select");
		JButton jb2 = new JButton ("Select");
		JButton jb3 = new JButton ("Select");
		JScrollPane jsp = new JScrollPane (p2);
		jb1.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				p2.removeAll ();
				String n = jtf1.getText ();
					jtf1.setText ("");
					java.util.List<Pet> p = Main.PS.searchName (n);
					for (int i = 0; i < p.size (); i++) {
						Pet tt = p.get (i);
						JLabel x = new JLabel (tt.toString());
						p2.add (x);
						JButton t = new JButton ("Modify");
						final int id = i;
						t.addActionListener (new ActionListener () {
							@Override
							public void actionPerformed (ActionEvent e) {
								jtfd1.setText (tt.getName ());
								jtfd2.setText (tt.getColor ());
								jtfd3.setText (((Integer)(tt.getAge ())).toString ());
								jbd1.addActionListener (new ActionListener () {
									@Override
									public void actionPerformed (ActionEvent e) {
										//if (!jtfd1.getText().equals("")) {
											int x = Integer.parseInt (jtfd3.getText());
											Main.PS.modify (tt, id, jtfd1.getText(), jtfd2.getText(), x);
											//jtfd1.setText ("");
											//jtfd2.setText ("");
											//jtfd3.setText ("");
											p2.removeAll ();
											jsp.repaint ();
											repaint ();
											jdm.dispose();
										//}
									}
								});
								jdm.setVisible (true);
							}
						});
						p2.add (t);
						p2.repaint ();
						jsp.repaint ();
						repaint ();
						setVisible (true);
						//System.out.println (p.get (i));
					}
			}
		});
		jb2.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				p2.removeAll ();
				String c = jtf2.getText ();
					jtf2.setText ("");
					java.util.List<Pet> p = Main.PS.searchColor (c);
					for (int i = 0; i < p.size (); i++) {
						Pet tt = p.get (i);
						JLabel x = new JLabel (tt.toString());
						p2.add (x);
						JButton t = new JButton ("Modify");
						final int id = i;
						t.addActionListener (new ActionListener () {
							@Override
							public void actionPerformed (ActionEvent e) {
								jtfd1.setText (tt.getName ());
								jtfd2.setText (tt.getColor ());
								jtfd3.setText (((Integer)(tt.getAge ())).toString ());
								jbd1.addActionListener (new ActionListener () {
									@Override
									public void actionPerformed (ActionEvent e) {
										int x = Integer.parseInt (jtfd3.getText());
										Main.PS.modify (tt, id, jtfd1.getText(), jtfd2.getText(), x);
										jtfd1.setText ("");
										jtfd2.setText ("");
										jtfd3.setText ("");
										p2.removeAll ();
										jsp.repaint ();
										repaint ();
										jdm.dispose();
									}
								});
								jdm.setVisible (true);
							}
						});
						p2.add (t);
						p2.repaint ();
						jsp.repaint ();
						repaint ();
						setVisible (true);
						//System.out.println (p.get (i));
					}
			}
		});
		jb3.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				p2.removeAll ();
				String a =  jtf3.getText ();
					jtf3.setText ("");
					java.util.List<Pet> p = null;
					if (a.length () == 0) p = Main.PS.searchAge (-1);
					else p = Main.PS.searchAge (Integer.parseInt (a));
					for (int i = 0; i < p.size (); i++) {
						Pet tt = p.get (i);
						JLabel x = new JLabel (tt.toString());
						p2.add (x);
						JButton t = new JButton ("Modify");
						final int id = i;
						t.addActionListener (new ActionListener () {
							@Override
							public void actionPerformed (ActionEvent e) {
								jtfd1.setText (tt.getName ());
								jtfd2.setText (tt.getColor ());
								jtfd3.setText (((Integer)(tt.getAge ())).toString ());
								jbd1.addActionListener (new ActionListener () {
									@Override
									public void actionPerformed (ActionEvent e) {
										int x = Integer.parseInt (jtfd3.getText());
										Main.PS.modify (tt, id, jtfd1.getText(), jtfd2.getText(), x);
										jtfd1.setText ("");
										jtfd2.setText ("");
										jtfd3.setText ("");
										p2.removeAll ();
										jsp.repaint ();
										repaint ();
										jdm.dispose();
									}
								});
								jdm.setVisible (true);
							}
						});
						p2.add (t);
						p2.repaint ();
						jsp.repaint ();
						repaint ();
						setVisible (true);
						//System.out.println (p.get (i));
					}
			}
		});
		pan.setLayout (new GridLayout (3, 3, 3, 3));
		pan.add (jl1); pan.add (jtf1); pan.add (jb1);
		pan.add (jl2); pan.add (jtf2); pan.add (jb2);
		pan.add (jl3); pan.add (jtf3); pan.add (jb3);
		jp[2].setLayout (new BorderLayout(3, 3));
		jp[2].add (pan, BorderLayout.NORTH);
		jp[2].add (jsp, BorderLayout.CENTER);
	}
	private void buildJP3(){ //delete
		jp[3] = new JPanel ();
		JPanel pan = new JPanel ();
		p3 = new JPanel ();
		p3.setLayout (new GridLayout (-1, 2, 3, 3));
		JLabel jl1 = new JLabel ("Name : ");
		JLabel jl2 = new JLabel ("Color : ");
		JLabel jl3 = new JLabel ("Age : ");
		JTextField jtf1 = new JTextField ();
		JTextField jtf2 = new JTextField ();
		JTextField jtf3 = new JTextField ();
		JButton jb1 = new JButton ("Select");
		JButton jb2 = new JButton ("Select");
		JButton jb3 = new JButton ("Select");
		JScrollPane jsp = new JScrollPane (p3);
		jb1.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				p3.removeAll ();
				String n = jtf1.getText ();
					jtf1.setText ("");
					Main.PS.setCmd ("delete");
					java.util.List<Pet> p = Main.PS.searchName (n);
					for (int i = 0; i < p.size (); i++) {
						Pet tt = p.get(i);
						JLabel x = new JLabel (tt.toString());
						p3.add (x);
						JButton t = new JButton ("Delete");
						final int id = i;
						t.addActionListener (new ActionListener () {
							@Override
							public void actionPerformed (ActionEvent e) {
								Main.PS.delete (id);
								t.setEnabled (false);
							}
						});
						p3.add (t);
						p3.repaint ();
						jp[3].repaint ();
						repaint ();
						setVisible (true);
						//System.out.println (p.get (i));
					}
			}
		});
		jb2.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				p3.removeAll ();
				String c = jtf2.getText ();
					jtf2.setText ("");
					Main.PS.setCmd ("delete");
					java.util.List<Pet> p = Main.PS.searchColor (c);
					for (int i = 0; i < p.size (); i++) {
						Pet tt = p.get(i);
						JLabel x = new JLabel (tt.toString());
						p3.add (x);
						JButton t = new JButton ("Delete");
						final int id = i;
						t.addActionListener (new ActionListener () {
							@Override
							public void actionPerformed (ActionEvent e) {
								Main.PS.delete (id);
							}
						});
						p3.add (t);
						p3.repaint ();
						jp[3].repaint ();
						repaint ();
						setVisible (true);
						//System.out.println (p.get (i));
					}
			}
		});
		jb3.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				p3.removeAll ();
				String a =  jtf3.getText ();
					jtf3.setText ("");
					java.util.List<Pet> p = null;
					Main.PS.setCmd ("delete");
					if (a.length () == 0) p = Main.PS.searchAge (-1);
					else p = Main.PS.searchAge (Integer.parseInt (a));
					for (int i = 0; i < p.size (); i++) {
						Pet tt = p.get(i);
						JLabel x = new JLabel (tt.toString());
						p3.add (x);
						JButton t = new JButton ("Delete");
						final int id = i;
						t.addActionListener (new ActionListener () {
							@Override
							public void actionPerformed (ActionEvent e) {
								Main.PS.delete (id);
							}
						});
						p3.add (t);
						p3.repaint ();
						jp[3].repaint ();
						repaint ();
						setVisible (true);
						//System.out.println (p.get (i));
					}
			}
		});
		pan.setLayout (new GridLayout (3, 3, 3, 3));
		pan.add (jl1); pan.add (jtf1); pan.add (jb1);
		pan.add (jl2); pan.add (jtf2); pan.add (jb2);
		pan.add (jl3); pan.add (jtf3); pan.add (jb3);
		jp[3].setLayout (new BorderLayout(3, 3));
		jp[3].add (pan, BorderLayout.NORTH);
		jp[3].add (jsp, BorderLayout.CENTER);
	}
	public MainWindow () {
		buildJP0();
		buildJP1();
		buildJP2();
		buildJP3();
		setLayout (new BorderLayout ());
		JLabel l = new JLabel ();
        ImageIcon image = new ImageIcon("./timg.jpg");
        image.setImage(image.getImage().getScaledInstance(200,-1,Image.SCALE_DEFAULT));
        l.setIcon (image);
        njp.add (l);
		add (njp, BorderLayout.CENTER);
		jmi1[0] = new JMenuItem ("Add");
		jmi1[0].setMnemonic ('A');
		jmi1[0].setAccelerator(KeyStroke.getKeyStroke('A',Event.ALT_MASK));
		jmi1[1] = new JMenuItem ("Select");
		jmi1[1].setMnemonic ('R');
		jmi1[1].setAccelerator(KeyStroke.getKeyStroke('R',Event.ALT_MASK));
		jmi1[2] = new JMenuItem ("Modify");
		jmi1[2].setMnemonic ('M');
		jmi1[2].setAccelerator(KeyStroke.getKeyStroke('M',Event.ALT_MASK));
		jmi1[3] = new JMenuItem ("Delete");
		jmi1[3].setMnemonic ('D');
		jmi1[3].setAccelerator(KeyStroke.getKeyStroke('D',Event.ALT_MASK));
		jmi2[0] = new JMenuItem ("Save");
		jmi2[0].setMnemonic ('S');
		jmi2[0].setAccelerator(KeyStroke.getKeyStroke('S',Event.ALT_MASK));
		jmi2[1] = new JMenuItem ("Load");
		jmi2[1].setMnemonic ('L');
		jmi2[1].setAccelerator(KeyStroke.getKeyStroke('L',Event.ALT_MASK));
		jmi2[2] = new JMenuItem ("Exit");
		jmi2[2].setMnemonic ('E');
		jmi2[2].setAccelerator(KeyStroke.getKeyStroke('E',Event.ALT_MASK));
		jm[0] = new JMenu ("Pet");
		jm[1] = new JMenu ("System");
		jmb = new JMenuBar ();
		addWindowListener (new WindowAdapter () {
			@Override
			public void windowClosing (WindowEvent e) {
				//Main.PS.output ();
				System.exit (0);
			}
		});
		jmi1[0].addActionListener (new ActionListener () { //add
			@Override
			public void actionPerformed (ActionEvent e) {
				if (njp != null)
					getContentPane().remove (njp);
				njp = jp[0];
				add (njp, BorderLayout.CENTER);
				repaint ();
				setVisible (true);
			}
		});
		jmi1[1].addActionListener (new ActionListener () { //select
			@Override
			public void actionPerformed (ActionEvent e) {
				if (njp != null)
					getContentPane().remove (njp);
				jta.setText ("");
				njp = jp[1];
				add (njp, BorderLayout.CENTER);
				repaint ();
				setVisible (true);
			}
		});
		jmi1[2].addActionListener (new ActionListener () { //modify
			@Override
			public void actionPerformed (ActionEvent e) {
				if (njp != null)
					getContentPane().remove (njp);
				njp = jp[2];
				p2.removeAll ();
				add (njp, BorderLayout.CENTER);
				repaint ();
				setVisible (true);
			}
		});
		jmi1[3].addActionListener (new ActionListener () { //delete
			@Override
			public void actionPerformed (ActionEvent e) {
				if (njp != null)
					getContentPane().remove (njp);
				njp = jp[3];
				p3.removeAll ();
				add (njp, BorderLayout.CENTER);
				repaint ();
				setVisible (true);
			}
		});
		jmi2[0].addActionListener (new ActionListener () { //save
			@Override
			public void actionPerformed (ActionEvent e) {
			}
		});
		jmi2[1].addActionListener (new ActionListener () { //load
			@Override
			public void actionPerformed (ActionEvent e) {
			}
		});
		jmi2[2].addActionListener (new ActionListener () { //exit
			@Override
			public void actionPerformed (ActionEvent e) {
				dispose();
			}
		});
		for (int i = 0; i < 4; i ++) {
			jm[0].add (jmi1[i]);
		}
		for (int i = 0; i < 3; i ++) {
			jm[1].add (jmi2[i]);
		}
		for (int i = 0; i < 2; i ++) {
			jmb.add (jm[i]);
		}
		add (jmb, BorderLayout.NORTH);
		//add (jp[2], BorderLayout.CENTER);
		setLocation (400, 200);	
		//setResizable (false);
		setSize (300, 200);
		setVisible (true);
	}
}
