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
		setPreferredSize(new Dimension(1360,390));
		setMaximumSize(getPreferredSize());
		setMinimumSize(getPreferredSize());
		add(listScroller);
		list.setVisible(true);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		listScroller.setPreferredSize(new Dimension(1350, 375));
		list.setFont(font);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	private void reformList() {
		listModel.clear();
		for (String quote : Server.getQuotes()) {
			listModel.addElement(quote);
		}
	}
	
	void addItem(String input) {	
		Boolean success = Server.addQuote(input);
		System.out.println("add request success: " + success);
		if (!success) 
			return; // something
		reformList();
	}
	
	void editItem(String targetQuote, String newQuote) {
		Boolean success = Server.editQuote(targetQuote, newQuote);
		if (!success)
			return; // something
		reformList();
	}
	
	void removeItem(String quote) {
		Boolean success = Server.deleteQuote(quote);
		if (!success)
			return; // something
		reformList();
	}
	
	void updateItems() {
		System.out.println("update request");
		reformList();
	}
	
}
