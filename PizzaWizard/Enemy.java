import info.gridworld.grid.Location;

public class Enemy extends GameObject {
	public static Location destination;

	public Enemy() {
		threshold = 0;
		this.setColor(null);
		speed = .15;
	}

	public void act() {
		if (threshold >= 1) {
			this.setDirection(this.getLocation().getDirectionToward(destination));

			if (canMove()) {
				move();
			} else {
				Location next = this.getLocation().getAdjacentLocation(getDirection());
				GameObject obInFront = (GameObject) this.getGrid().get(next);

				//if object in front is of type player
				if (obInFront.getClass().equals(Player.class)) {
					obInFront.damage();
					this.removeSelfFromGrid();
				}
			}
			threshold = 0;
		} else {
			threshold += speed;
		}
	}

	public static void setDestination(Location adestination) {
		destination = adestination;
	}

}
