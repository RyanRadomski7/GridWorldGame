import info.gridworld.grid.Location;

public class Projectile extends GameObject {

	public Projectile(int direction) {
		this.setColor(null);
		health = 1;
		this.setDirection(direction);
	}

	public void act() {
		if (canMove()) {
			move();
		} else {
			Location next = this.getLocation().getAdjacentLocation(getDirection());

			try {
				GameObject obInFront = (GameObject) this.getGrid().get(next);
				if (!obInFront.equals(null)) {
					obInFront.damage();
					this.removeSelfFromGrid();
				}
			} catch(IllegalArgumentException e) {
				this.removeSelfFromGrid();
			}
		}
	}

}
