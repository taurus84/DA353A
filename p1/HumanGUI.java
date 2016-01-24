package p1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class HumanGUI extends JPanel {

	private Library lib;

	private JButton btnTitle = new JButton("   TITLE");
	private JButton btnType = new JButton("TYPE");
	private JButton btnDirector = new JButton("DIRECTOR");
	private JButton btnLength = new JButton("LENGTH");
	private JButton btnGenre = new JButton("GENRE    ");
	private JButton btnRating = new JButton("RATING");
	private JButton btnAddMovie = new JButton();
	private JButton btnReadFile = new JButton();
	private JButton btnEdit = new JButton("EDIT");
	private JButton btnRemove = new JButton("REMOVE");
	private JButton btnSearch = new JButton("SEARCH");
	private JButton btnShuffle = new JButton("SHUFFLE");
	private JButton btnShowAll = new JButton("");
	private JRadioButton rbQuick = new JRadioButton("Quicksort");
	private JRadioButton rbBubble = new JRadioButton("Bubble");
	private JRadioButton rbLinear = new JRadioButton("Linear");
	private JRadioButton rbBinary = new JRadioButton("Binary");
	private final int TITLE = 0, TYPE = 1, DIRECTOR = 2, LENGTH = 3, GENRE = 4,	RATING = 5;
	private boolean boolReadFile = false;
	private JPanel panelTopOfScreen = new JPanel(new GridLayout(1, 3));
	private JPanel panelSort = new JPanel(new GridLayout(1, 2));
	private JPanel panelSearch = new JPanel(new GridLayout(1, 2));
	private JLabel lblNorth = new JLabel("<< Sort      Search >>");
	private JTextArea textArea = new JTextArea();
	private JList<Movie> jList = new JList<Movie>();
	private JScrollPane scrollPane = new JScrollPane(jList);

	public HumanGUI(Library library) {
		this.lib = library;
		lib.setHumanGUI(this);
		setPreferredSize(new Dimension(600, 505));
		setLayout(null);
		jList.setFont(new Font("Monospaced", Font.PLAIN, 14));
		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lblNorth.setFont(new Font("Plain", Font.PLAIN, 12));

		ButtonGroup group = new ButtonGroup();
		group.add(rbQuick);
		group.add(rbBubble);
		rbQuick.setSelected(true);
		ButtonGroup group2 = new ButtonGroup();
		group2.add(rbLinear);
		group2.add(rbBinary);
		rbLinear.setSelected(true);

		btnTitle.setContentAreaFilled(true);
		btnTitle.setFocusPainted(false);
		btnType.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnDirector.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnLength.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnGenre.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnRating.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnTitle.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAddMovie.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnReadFile.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnRemove.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnEdit.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnShuffle.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnSearch.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnShowAll.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		panelSort.add(rbQuick);
		panelSort.add(rbBubble);
		panelSearch.add(rbLinear);
		panelSearch.add(rbBinary);

		btnAddMovie.setText("<html>ADD<br />MOVIE</html>");
		btnReadFile.setText("<html>READ<br />FILE</html>");
		btnTitle.setHorizontalAlignment(SwingConstants.LEFT);
		btnLength.setHorizontalAlignment(SwingConstants.RIGHT);
		btnDirector.setHorizontalAlignment(SwingConstants.RIGHT);
		btnType.setHorizontalAlignment(SwingConstants.RIGHT);
		btnGenre.setHorizontalAlignment(SwingConstants.RIGHT);

		panelTopOfScreen.setBounds(0, 0, 600, 35);
		btnTitle.setBounds(0, 35, 100, 30);
		btnType.setBounds(100, 35, 100, 30);
		btnDirector.setBounds(200, 35, 100, 30);
		btnLength.setBounds(300, 35, 100, 30);
		btnGenre.setBounds(400, 35, 100, 30);
		btnRating.setBounds(500, 35, 100, 30);
		textArea.setBounds(0, 30, 600, 400);
		scrollPane.setBounds(0, 70, 600, 400);
		textArea.setBackground(Color.BLUE);
		btnAddMovie.setBounds(2, 468, 85, 40);
		btnReadFile.setBounds(87, 468, 85, 40);
		btnRemove.setBounds(172, 468, 85, 40);
		btnEdit.setBounds(257, 468, 85, 40);
		btnShuffle.setBounds(342, 468, 85, 40);
		btnSearch.setBounds(427, 468, 85, 40);
		btnShowAll.setBounds(512, 468, 87, 40);

		panelTopOfScreen.add(panelSort);
		panelTopOfScreen.add(lblNorth);
		panelTopOfScreen.add(panelSearch);
		add(panelTopOfScreen);
		add(btnTitle);
		add(btnType);
		add(btnDirector);
		add(btnLength);
		add(btnGenre);
		add(btnRating);
		add(btnAddMovie);
		add(btnReadFile);
		add(btnRemove);
		add(btnEdit);
		add(btnSearch);
		add(btnShuffle);
		add(btnShowAll);
		add(scrollPane);

		AL listener = new AL();
		btnTitle.addActionListener(listener);
		btnType.addActionListener(listener);
		btnDirector.addActionListener(listener);
		btnLength.addActionListener(listener);
		btnGenre.addActionListener(listener);
		btnRating.addActionListener(listener);
		btnAddMovie.addActionListener(listener);
		btnReadFile.addActionListener(listener);
		btnRemove.addActionListener(listener);
		btnEdit.addActionListener(listener);
		btnSearch.addActionListener(listener);
		btnShuffle.addActionListener(listener);
		btnShowAll.addActionListener(listener);

	}

	private class AL implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnTitle) {
				lib.sort(rbQuick.isSelected(), TITLE);
			} else if (e.getSource() == btnType) {
				lib.sort(rbQuick.isSelected(), TYPE);
			} else if (e.getSource() == btnDirector) {
				lib.sort(rbQuick.isSelected(), DIRECTOR);
			} else if (e.getSource() == btnLength) {
				lib.sort(rbQuick.isSelected(), LENGTH);
			} else if (e.getSource() == btnGenre) {
				lib.sort(rbQuick.isSelected(), GENRE);
			} else if (e.getSource() == btnRating) {
				lib.sort(rbQuick.isSelected(), RATING);
			} else if (e.getSource() == btnAddMovie) {
				lib.addMovie();
			} else if (e.getSource() == btnReadFile) {
				if (boolReadFile) {
					int reply = JOptionPane.showConfirmDialog(null,
									"You already added the list. \nWould your like to try and add it again?",
									"Add list from file", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						lib.readFromFile();
					}

				} else {
					lib.readFromFile();
					boolReadFile = true;
				}
			} else if (e.getSource() == btnRemove) {
				if (jList.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Choose a movie to delete");
				} else {
					lib.remove(jList.getSelectedValue());
				}
			} else if (e.getSource() == btnEdit) {
				if (jList.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Choose a movie to edit");
				} else {
					lib.editMovie(jList.getSelectedValue());
				}
			} else if (e.getSource() == btnSearch) {
				if (rbLinear.isSelected()) {
					lib.search();
				} else {
					lib.searchBinary();
				}
			} else if (e.getSource() == btnShuffle) {
				lib.shuffle();
			} else if (e.getSource() == btnShowAll) {
				update();
				btnShowAll.setEnabled(false);
				lib.clearTempList();
			}
		}
	}

	private class ListListener implements ListSelectionListener {

		public void valueChanged(ListSelectionEvent e) {
			jList.getSelectedIndex();
		}
	}

	public void update() {
		jList.setListData(lib.getMovies());
	}

	public void updateWithSearchResults() {
		jList.setListData(lib.getTempMovies());
		btnShowAll.setText("<html>SHOW<br />ALL</html>");
		btnShowAll.setEnabled(true);
		lib.clearTempList();
	}

}
