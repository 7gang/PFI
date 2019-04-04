package client;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JButton b1 = new JButton("b1");
	JButton b2 = new JButton("b2");
	
	Gui(){
		
		setSize(1600,900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		add(panel1, BorderLayout.PAGE_START);
		add(panel2, BorderLayout.CENTER);
		panel1.add(b1);
		panel2.add(b2);
		panel1.setVisible(true);
		panel2.setVisible(true);
		b1.setVisible(true);
		b2.setVisible(true);
		
	}
	
}
