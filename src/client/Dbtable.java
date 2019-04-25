package client;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;

public class Dbtable extends JPanel{
	DefaultListModel<String> listModel = new DefaultListModel<>();
	String[] s = {"s","b","w","s","b","w","s","b","w","s","b","w","s","b","w","s",
			"b","w","s","b","w","s","b","w","s","b","w","s","b","w","s","b","w","s","b","w"};
	JList<String> list = new JList<>(listModel);
	JScrollPane listScroller = new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	int selection;
	public String r = "";
	Font font = new Font("Helvetica", Font.PLAIN,20);

	Dbtable(){
		setPreferredSize(new Dimension(1400,400));
		setMaximumSize(getPreferredSize());
		setMinimumSize(getPreferredSize());
		addItem(s);
		add(listScroller);
		list.setVisible(true);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		listScroller.setPreferredSize(new Dimension(1350, 345));
		list.setFont(font);
	}
	
	void addItem(String[] input) {
		/*String[] response = server.addQuote(selection);
		if (response[1] != "1") // maybe tell the user?
		listModel = new DefaultListModel<>(server.getQuotes());*/
		for(String p : input) {
			listModel.addElement(p);
		}
	}
	
	void addItem(String input) {	
			listModel.addElement(input);
	}
	
	void editItem(String input) {
		//listModel.setElementAt(input, selection);
		/*String[] response = server.editQuote(selection);
		if (response[1] != "1") // maybe tell the user?
		listModel = new DefaultListModel<>(server.getQuotes());*/
	}
	
	void removeItem() {
		listModel.removeElementAt(selection);
		/*String[] response = server.deleteQuote(selection);
		if (response[1] != "1") // maybe tell the user?
		listModel = new DefaultListModel<>(server.getQuotes());*/
	}
	
	void updateItems() {
		//listModel = new DefaultListModel<>(server.getQuotes());
	}
	
}
