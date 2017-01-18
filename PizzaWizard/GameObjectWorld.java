import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class GameObjectWorld extends ActorWorld {
	
	public GameObjectWorld(){
		this.setGrid(new BoundedGrid<Actor>(10, 10));
	}
	
	public boolean locationClicked(Location loc) {
		return true;
	}
	
	public boolean keyPressed(String description, Location loc) {
		if (description.equals("DOWN")) {
			Player.destination = Location.SOUTH;
			Player.act = true;
		} else if (description.equals("UP")) {
			Player.destination = Location.NORTH;
			Player.act = true;
		} else if (description.equals("LEFT")) {
			Player.destination = Location.WEST;
			Player.act = true;
		} else if (description.equals("RIGHT")) {
			Player.destination = Location.EAST;
			Player.act = true;
		} else if (description.equals("SPACE")) {
			Player.destination = 999;
			Player.act = true;
		}
		return true;
	}
}
