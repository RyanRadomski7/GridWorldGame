import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ScoreRunner {
	public static void makeBoard() {
		try {
			ScoreBoard board = new ScoreBoard();
			@SuppressWarnings("resource")
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("board.binary"));
			file.writeObject(board);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
