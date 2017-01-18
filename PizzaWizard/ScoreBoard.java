import java.io.Serializable;
import java.util.ArrayList;

public class ScoreBoard implements Serializable{

	private static final long serialVersionUID = -7449965256681558850L;
	
	private ArrayList<Score> scores;

	public ScoreBoard() {
		scores = new ArrayList<Score>();
	}

	public void addScore(Score score) {
		if (scores.size() == 0) {
			scores.add(score);
		} else {
			for (int i = 0; i < scores.size(); i++) {
				if (score.getScore() > scores.get(i).getScore()) {
					scores.add(i, score);
					if (scores.size() > 10)
						scores.remove(10);
					return;
				}
			}
			scores.add(scores.size() - 1, score);
			if (scores.size() > 10)
				scores.remove(10);
		}
	}

	public String getScores() {
		String result = "";

		for (int i = 0; i < scores.size(); i++) {
			result += scores.get(i).getName() + "   " + scores.get(i).getScore() + "\n";
		}

		return result;
	}

}
