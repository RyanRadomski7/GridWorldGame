import java.io.Serializable;

public class Score implements Serializable {
	
	private static final long serialVersionUID = -4548121766119229931L;
	
	private int score;
	private String name;

	public Score(int score, String name) {
		this.score = score;
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
