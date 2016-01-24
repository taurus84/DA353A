package f1;
import java.awt.*;
import javax.swing.*;

public class SquareSearch extends JFrame {
	private Square square;
    private long delay;

    public SquareSearch(Square square, long delay) {
    	this.square = square;
        this.delay = delay;	
    }

    public SearchResult cheapestWay(int fromRow, int fromCol, int toRow, int toCol) {
    	SearchResult result = new SearchResult("",Integer.MAX_VALUE);
        cheapestWay(fromRow, fromCol, toRow, toCol, "", 0, result);
        return result;
    }

    private void cheapestWay(int row, int col, int stopRow, int stopCol, 
    		                 String path, int cost, SearchResult result) {
        if (square.validRow(row) && square.validCol(col)) {
        	cost += square.getValue(row, col);
            square.mark(row,col);
            Square.pause(delay);
            if (row == stopRow && col == stopCol && cost < result.getCost()) {
            	result.setCost(cost);
            	result.setPath(path);
            } else {
                cheapestWay(row + 1, col, stopRow, stopCol, path + 'D', cost, result);
                cheapestWay(row, col + 1, stopRow, stopCol, path + 'R', cost, result);
            }
            square.unmark(row, col);
            Square.pause(delay / 2);
        }
    }
    
    public static void main(String[] args) {
    	Square square = new Square(4,4);
        SquareSearch squareSearch = new SquareSearch(square, 10);
        SearchResult result = squareSearch.cheapestWay(0,0,3,3);
        square.showPath(0, 0, result.getPath());
        System.out.println("Billigaste väg: " + result.getCost());
    }
}    

class SearchResult {
	private String path;
	private int cost;
	
	public SearchResult(String path, int cost) {
		this.path = path;
		this.cost = cost;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
}

class Square extends JFrame {
    private int[][] values;  // lagrar talen i kvadraten
    private Label[][] squares;  // representerar de olik rutorna i kvadraten 
    private Font font = new Font("SansSerif", Font.BOLD, 18);  // typsnitt i rutorna
    private int cols,  rows,  sum,  colorIndex;  // antal kol, antal rader, bästa summa och färg som ska visas
    
    public static void pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }

    public Square(int rows, int cols) {
        this.cols = cols;
        this.rows = rows;
        Container c = getContentPane();
        this.setBounds(200, 200, cols * 50 + 23, rows * 50);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLayout(new GridLayout(rows, cols, 5, 5));
        values = new int[rows][cols];
        squares = new Label[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                values[row][col] = (int) (Math.random() * 10);
                squares[row][col] = new Label(String.valueOf(values[row][col]), Label.CENTER);
                squares[row][col].setBackground(Color.black);
                squares[row][col].setForeground(Color.white);
                squares[row][col].setFont(font);
                c.add(squares[row][col]);
            }
        }
        setVisible(true);
    }
    
    public boolean validRow(int row) {
    	return (row>=0) && (row<rows);
    }
    
    public boolean validCol(int col) {
    	return (col>=0) && (col<cols);
    }
    
	public void mark(int row, int col) {
		squares[row][col].setBackground(Color.RED);
	}
	
	public void unmark(int row, int col) {
		squares[row][col].setBackground(Color.BLACK);
	}
	
	public int getValue(int row, int col) {
		return values[row][col];
	}

    public void showPath(int row, int col, String path) {
        squares[row][col].setBackground(Color.red);
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'D') {
                row++;
            } else if (path.charAt(i) == 'R') {
                col++;
            } else if (path.charAt(i) == 'U') {
                row--;
            } else if (path.charAt(i) == 'L') {
                col--;
            }
            squares[row][col].setBackground(Color.red);
        }
    }
}
