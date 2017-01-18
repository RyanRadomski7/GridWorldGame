import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("NAME HERE: ");
		Game game = new Game(scan.nextLine());
		System.out.println("Starting game in one second. Get ready!");
		Thread.sleep(1000);
		game.start();
	}
}