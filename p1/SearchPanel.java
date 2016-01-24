package p1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchPanel extends JPanel {

	Library lib;
	private JTextField tfSearch = new JTextField();
	private JButton btnSearch = new JButton("Search");
	
	public SearchPanel(Library lib) {
		this.lib = lib;
		setPreferredSize(new Dimension(300,40));
		setLayout(new BorderLayout());
		
		tfSearch.setPreferredSize(new Dimension(140,30));
		btnSearch.setPreferredSize(new Dimension(60,30));
		
		add(tfSearch);
		add(btnSearch, BorderLayout.EAST);
		
		btnSearch.addActionListener(new AL());
	}
	
	private class AL implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnSearch) {
				lib.search(tfSearch.getText());
//				lib.searchWithIter(tfSearch.getText());
				lib.hideSearchPanel();
			}
			
		}
	}

	
	
}
