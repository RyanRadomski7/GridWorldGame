import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public abstract class GameObject extends Actor {
	int health;
	public boolean remove = false;
	double threshold;
	double speed;

	public GameObject() {
		threshold = 0;
		speed = .3;
	}

	public void damage() {
		health--;
		if (health < 1) {
			this.removeSelfFromGrid();
			Utils.incrementScore();
		}
	}

	public void act() {
		if (threshold >= 1) {
			super.act();
			threshold = 0;
		} else
			threshold += speed;
	}

	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (gr.isValid(next))
			moveTo(next);
		else
			removeSelfFromGrid();
	}

	public boolean canMove() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return false;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (!gr.isValid(next))
			return false;
		Actor neighbor = gr.get(next);
		return (neighbor == null) || (neighbor instanceof Flower);
	}

	public void removeSelfFromGrid() {
		super.removeSelfFromGrid();
		remove = true;
	}
}
