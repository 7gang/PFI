package client;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MihaiPanel extends JFrame {
	
	JPanel panel = new JPanel();
	JButton b1 = new JButton("Add");
	JButton b2 = new JButton("Edit");
	JButton b3 = new JButton("Remove");
	JButton b4 = new JButton("Refresh");
	int bDim = 50;
	int bDist = 15;
	
		MihaiPanel(){
			try {
		            // Set System L&F
		        UIManager.setLookAndFeel(
		            UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (UnsupportedLookAndFeelException e) {
		       // handle exception
		    }
		    catch (ClassNotFoundException e) {
		       // handle exception
		    }
		    catch (InstantiationException e) {
		       // handle exception
		    }
		    catch (IllegalAccessException e) {
		       // handle exception
		    }

			setSize(300,400);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
			add(panel);
			panel.setOpaque(true);
			panel.setBackground(Color.WHITE);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			
			panel.add(Box.createVerticalGlue());
			panel.add(b1);
			panel.add(Box.createRigidArea(new Dimension(0,bDist)));
			panel.add(b2);
			panel.add(Box.createRigidArea(new Dimension(0,bDist)));
			panel.add(b3);
			panel.add(Box.createRigidArea(new Dimension(0,bDist)));
			panel.add(b4);
			
			b1.setPreferredSize(new Dimension(bDim, bDim));
			b2.setPreferredSize(new Dimension(bDim, bDim));
			b3.setPreferredSize(new Dimension(bDim, bDim));
			b4.setPreferredSize(new Dimension(bDim, bDim));
			
			panel.setVisible(true);
			
			b1.setAlignmentX(CENTER_ALIGNMENT);
			b2.setAlignmentX(CENTER_ALIGNMENT);
			b3.setAlignmentX(CENTER_ALIGNMENT);
			b4.setAlignmentX(CENTER_ALIGNMENT);
			
			panel.add(Box.createVerticalGlue());
			
			b1.setVisible(true);
			b2.setVisible(true);
			b3.setVisible(true);
			b4.setVisible(true);
			
			b1.addActionListener(new ActionListener() 
			{
				public void actionPerformed (ActionEvent e) 
				{
					System.out.print("Peter has");
				}
			});
			
			b2.addActionListener(new ActionListener() 
			{
				public void actionPerformed (ActionEvent e) 
				{
					System.out.print(" a");
				}
			});
			
			b3.addActionListener(new ActionListener() 
			{
				public void actionPerformed (ActionEvent e) 
				{
					System.out.print(" small Penis");
				}
			});
			
			b4.addActionListener(new ActionListener() 
			{
				public void actionPerformed (ActionEvent e) 
				{
					System.out.print("!!!!!!");
				}
			});
			
		}
}
