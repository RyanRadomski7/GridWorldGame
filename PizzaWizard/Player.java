import info.gridworld.grid.Location;

import java.awt.Color;

public class Player extends GameObject {

	public static int destination;
	public static boolean act;
	public boolean addLazer;

	public Player() {
		setColor(null);
		this.health = 5;
		addLazer = false;
	}

	public boolean isDead() {
		if (health < 1)
			return true;
		return false;
	}

	public void act() {
		this.setColor(null);
		if (act) {
			if (destination != 999) {
				int prevDir = this.getDirection();
				this.setDirection(destination);
				if (canMove() && prevDir == destination)
					move();
			} else {
				if (canMove())
					addLazer = true;
				else {
					Location next = this.getLocation().getAdjacentLocation(getDirection());
					GameObject obInFront = (GameObject) this.getGrid().get(next);
					if (!obInFront.equals(null))
						obInFront.damage();
				}
			}
			act = false;
		}
	}

	public void damage() {
		this.health--;
		this.setColor(Color.RED);
	}

}
