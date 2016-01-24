package p1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EditMovie extends JPanel {

	private Library lib;
	private JPanel panelWest = new JPanel(new GridLayout(6, 1));
	private JPanel panelCenter = new JPanel(new GridLayout(6, 1));
	private JPanel panelSouth = new JPanel();
	private JPanel panelType = new JPanel(new GridLayout(1, 2));
	private JPanel panelRating = new JPanel();
	private JLabel lblTitle = new JLabel("Title");
	private JLabel lblType = new JLabel("Type");
	private JLabel lblDirector = new JLabel("Director");
	private JLabel lblLength = new JLabel("Length");
	private JLabel lblGenre = new JLabel("Genre");
	private JLabel lblRating = new JLabel("Rating");
	private JRadioButton rbDVD = new JRadioButton("DVD");
	private JRadioButton rbBluray = new JRadioButton("Bluray");
	private JSlider jsRating = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
	private JButton btnAdd = new JButton("Done");
	private JButton btnCancel = new JButton("Cancel");

	private JTextField tfTitle = new JTextField();
	private JTextField tfDirector = new JTextField();
	private JTextField tfLength = new JTextField();
	private JTextField tfGenre = new JTextField();
	private JTextField tfRating = new JTextField();

	private JLabel lblRatingS = new JLabel("5.0");

	public EditMovie(Library lib) {
		this.lib = lib;
		lib.setupEditFrame(this);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300, 192));
		panelWest.setPreferredSize(new Dimension(60, 150));
		panelCenter.setPreferredSize(new Dimension(200, 150));
		setBackground(Color.black);
		btnAdd.setPreferredSize(new Dimension(80, 30));
		btnCancel.setPreferredSize(new Dimension(80, 30));
		lblRatingS.setPreferredSize(new Dimension(25, 25));
		tfLength.setPreferredSize(new Dimension(25, 25));

		ButtonGroup group = new ButtonGroup();
		group.add(rbDVD);
		group.add(rbBluray);

		panelType.add(rbDVD);
		panelType.add(rbBluray);
		rbDVD.setSelected(true);
		panelRating.add(jsRating);
		panelRating.add(lblRatingS);

		panelSouth.add(btnAdd);

		panelWest.add(lblType);
		panelWest.add(lblTitle);
		panelWest.add(lblDirector);
		panelWest.add(lblLength);
		panelWest.add(lblGenre);
		panelWest.add(lblRating);
		panelCenter.add(panelType);
		panelCenter.add(tfTitle);
		panelCenter.add(tfDirector);
		panelCenter.add(tfLength);
		panelCenter.add(tfGenre);
		panelCenter.add(panelRating);

		add(panelWest, BorderLayout.WEST);
		add(panelCenter, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);

		btnAdd.addActionListener(new ButtonListener());
		jsRating.addChangeListener(new SliderListener());

	}
	
	public void editValues(int pos) {
		tfTitle.setText(lib.getMovie(pos).getTitle());
		tfDirector.setText(lib.getMovie(pos).getDirector());
		tfLength.setText(lib.getMovie(pos).getLength() + "");
		tfGenre.setText(lib.getMovie(pos).getGenre());
		if(lib.getMovie(pos).getType().equalsIgnoreCase("DVD")) {
			rbDVD.setSelected(true);
		} else {
			rbBluray.setSelected(true);
		}
		double rating = lib.getMovie(pos).getRating();
		lblRatingS.setText("" + rating);
		jsRating.setValue((int) (rating * 10));
	}

	public void clear() {
		tfTitle.setText("");
		tfDirector.setText("");
		tfLength.setText("");
		tfGenre.setText("");
		lblRatingS.setText("5.0");
		jsRating.setValue(50);
	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String director = "";
			String genre = "";
			int length = 0;
			double rating = jsRating.getValue();
			rating = rating / 10;

			if (e.getSource() == btnAdd && !(tfTitle.getText().equals(""))) {
				boolean type = true;
				if (rbDVD.isSelected()) {
					type = false;
				}
				if (!(tfDirector.equals(""))) {
					director = tfDirector.getText();
				}
				if (!(tfLength.equals(""))) {
					length = Integer.parseInt(tfLength.getText());
				}
				if (!(tfGenre.equals(""))) {
					genre = tfGenre.getText();
				}

				lib.replaceMovie(new Movie(tfTitle.getText(), type, director,
						length, genre, rating));
				clear();
				lib.hideEditMovieFrame();
			} else {
				JOptionPane.showMessageDialog(null,	"Movie has to have a title!");
			}
		}
	}

	private class SliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			double value = jsRating.getValue();
			value = value / 10;
			if (value == 10.0) {
				lblRatingS.setText("10");
			} else if (value == 0) {
				lblRatingS.setText("0");
			} else {
				lblRatingS.setText("" + value);
			}
		}
	}
}

