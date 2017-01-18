import info.gridworld.grid.Location;

import java.util.ArrayList;

public class Game {
	private Player player;
	private GameObjectWorld world;
	private ArrayList<GameObject> objects;
	private String name;

	public Game(String name) {
		this.name = name;
		player = new Player();
		objects = new ArrayList<GameObject>();
		world = new GameObjectWorld();
	}

	public void start() {
		objects.add(new Enemy());
		world.add(player);
		for (GameObject x : objects)
			world.add(x);
		world.show();
		loop();
	}

	private void loop() {
		while (!player.isDead()) {

			if (player.addLazer)
				addLazer();

			spawnEnemy();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			player.act();

			Enemy.setDestination(player.getLocation());

			for (int i = 0; i < objects.size(); i++) {
				try {
					objects.get(i).act();
					if (objects.get(i).remove == true)
						objects.remove(i);
				} catch (NullPointerException e) {
					objects.remove(i);
				}

			}
			try {
				world.show();
			} catch (NullPointerException e) {

			}
		}
		System.out.println("saving scores....");
		Utils.save(name);
	}

	private void spawnEnemy() {
		if (Math.random() < (Utils.getScore() * .01) + .05) {
			objects.add(0, new Enemy());
			world.add(objects.get(0));
		}
	}

	private void addLazer() {
		if (!player.canMove()) {
			Location next = player.getLocation().getAdjacentLocation(player.getDirection());
			GameObject obInFront = (GameObject) world.getGrid().get(next);
			obInFront.damage();
			player.addLazer = false;
		} else {
			Location next = player.getLocation().getAdjacentLocation(player.getDirection());
			Projectile toAdd = new Projectile(player.getDirection());
			toAdd.putSelfInGrid(world.getGrid(), next);
			objects.add(toAdd);
			player.addLazer = false;
		}
	}
}
