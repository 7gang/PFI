package client;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;

public class Gui extends JFrame {
	Dbtable table = new Dbtable();
	Dbdisplay display = new Dbdisplay();
	JPanel side = new JPanel();
	JPanel side2 = new JPanel();
	//JPanel top = new JPanel();
	JPanel top = display;
	JPanel bottom = table;
	GroupLayout layout = new GroupLayout(getContentPane());
	
	Gui(){
		layout.setHorizontalGroup(
    			layout.createSequentialGroup()
    			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(side)
						.addComponent(side2))
    				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    						.addComponent(top)
    						.addComponent(bottom)));
    	
    	layout.setVerticalGroup(
    			layout.createSequentialGroup()
    				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    						.addComponent(side)
    						.addComponent(top))
    				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    						.addComponent(side2)
    						.addComponent(bottom)));
		
		side.setPreferredSize(new Dimension(250,800));
		side2.setPreferredSize(new Dimension(250,100));
		side.setBackground(Color.GREEN);
		side2.setBackground(Color.GREEN);
		top.setPreferredSize(new Dimension(800,450));
		top.setBackground(Color.red);
		bottom.setBackground(Color.blue);
		setLayout(layout);
		setSize(1600,900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		table.        list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				System.out.println(table.list.getSelectedIndex());
				table.r = table.listModel.getElementAt(table.list.getSelectedIndex());
				System.out.println(table.r);
				display.text.setText(table.r);
			}
		});
		display.text.setText(table.r);
	}
}
