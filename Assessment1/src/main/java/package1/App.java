package package1;
import java.util.Scanner;
public class App 
{
	public static void main(String[] args)
	{
		int[] locationCoordinates = FindBox.generateCoordinates();
		int[] playerCoordinates = {0,0};
		playGame(playerCoordinates, locationCoordinates);
	}
	public static void playGame(int[] playerLocation, int[] treasureLocation)
	{
		FindBox.startMessage();
		Scanner input = new Scanner(System.in);
		while (FindBox.getDistance(playerLocation, treasureLocation) != 0)
		{
			System.out.println("The watch reads " + FindBox.getDistance(playerLocation, treasureLocation) + "m");
			System.out.println("Where do you want to go traveller?");
			char[] direction = playerGoes();
			FindBox.goDirection(direction[0], playerLocation);
		}
		FindBox.boxFoundMessage();
		boolean canEscape = false;
		while(canEscape == false)
		{
			String yesNo = input.nextLine();
			char[] yN = yesNo.toCharArray();
			if (FindBox.doYouOpen(yN[0]) == false)
			{
				FindBox.noMessage();
			}
			else
			{
				FindBox.yesMessage();
				canEscape = true;
			}
		}
		GuardsRiddle.startMessage();
		canEscape = false;
		while(canEscape == false)
		{
			char[] direction = playerGoes();
			canEscape = GuardsRiddle.navigateCorridor(direction[0]);
		}
		GuardsRiddle.sphinxRiddles();
	}
	public static char[] playerGoes()
	{
		Scanner input = new Scanner(System.in);
		String directionDesired = input.nextLine();
		char[] direction = directionDesired.toCharArray();
		return direction;
	}
}