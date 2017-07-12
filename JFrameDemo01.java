import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JFrameDemo01 {

	
	public static void main(String[] args) {
			JFrame f = new JFrame("宠物管理系统v1.0");
			f.setLayout(new FlowLayout(FlowLayout.CENTER,3,3));
			JButton but[]=new JButton[6];
			
			 
			for(int i=0;i<5;i++){
				but[i]=new JButton("按钮  "+(i+1));
				f.add(but[i]);
			}
			JButton but6 = new JButton("按钮 6");
			f.add(but6);
			but6.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					if(arg0.getSource()==but6){
						System.exit(1);
					}
				}
			}
			);
			
			
			f.setSize(300, 400);
			f.setBackground(Color.WHITE);
			f.setLocation(300, 200);
			f.setVisible(true);
			

		
	}

}
