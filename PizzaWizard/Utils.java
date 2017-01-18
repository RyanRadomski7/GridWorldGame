import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Utils {
	private static int score = 0;

	public static void incrementScore() {
		score++;
	}

	@SuppressWarnings("static-access")
	public static void save(String name) {
		try {
			@SuppressWarnings("resource")
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("board.binary"));
			ScoreBoard board = (ScoreBoard) input.readObject();
			board.addScore(new Score(score, name));
			System.out.println(board.getScores());
			@SuppressWarnings("resource")
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("board.binary"));
			out.writeObject(board);
		} catch (IOException e) {
			ScoreRunner sr = new ScoreRunner();
			sr.makeBoard();
			Utils.save(name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static int getScore() {
		return score;
	}
}
