package client;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame {
	Dbtable table = new Dbtable();
	Dbdisplay display = new Dbdisplay();
	JPanel side = new MihaiPanel();
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
		
		MihaiPanel.b1.addActionListener(new ActionListener() 
		{
			public void actionPerformed (ActionEvent e) 
			{
				System.out.print("Peter has");
				table.addItem("Something which");
			}
		});
		
		MihaiPanel.b2.addActionListener(new ActionListener() 
		{
			public void actionPerformed (ActionEvent e) 
			{
				System.out.print(" a");
			}
		});
		
		MihaiPanel.b3.addActionListener(new ActionListener() 
		{
			public void actionPerformed (ActionEvent e) 
			{
				System.out.print(" small Penis");
				table.removeItem();
			}
		});
		
		MihaiPanel.b4.addActionListener(new ActionListener() 
		{
			public void actionPerformed (ActionEvent e) 
			{
				System.out.print("!!!!!!");
			}
		});
	}
}
