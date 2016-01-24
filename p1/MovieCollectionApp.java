package p1;

import javax.swing.JFrame;

public class MovieCollectionApp {
	
	public void start() {
		
		Library lib = new Library();
		JFrame frame = new JFrame( "Movie Collection" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.add( new HumanGUI(lib));
		frame.pack();
		frame.setVisible( true );
		frame.setResizable(false);
	}
	public static void main(String[] args) {
		MovieCollectionApp app = new MovieCollectionApp();
		app.start();
	}

}
