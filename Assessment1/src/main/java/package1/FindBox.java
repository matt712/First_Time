package package1;

import java.util.Random;

public class FindBox 
{
	public static void startMessage()
	{
		System.out.println("Grey foggy clouds float oppressively close to you,");
		System.out.println("reflected in the murky grey water which reaches up your shins.");
		System.out.println("Some black plants barely poke out of the shallow water.");
		System.out.println("You notice a small watch-like device in your left hand");
		System.out.println("It has hands like a watch, but the hands don't seem to tell time.");
		System.out.println("(Try 'north', 'south', 'east', or 'west' to play the game.)");
	}
	public static double getDistance(int[] playerLocation, int[] treasureLocation)
	{
		int distanceX = treasureLocation[0] - playerLocation[0];
		int distanceY = treasureLocation[1] - playerLocation[1];
		double distance = Math.sqrt(distanceX*distanceX + distanceY*distanceY);
		return distance;
	}
	public static int[] generateCoordinates()
	{
		Random r = new Random();
		int x = 0;
		int y = 0;
		int xDir = r.nextInt(1);
		int yDir = r.nextInt(1);
		if (xDir == 1)
		{
			x = r.nextInt(5);
		}
		else
		{
			x = -(r.nextInt(5));
		}
		if ( yDir == 1)
		{
			y = r.nextInt(5);
		}
		else
		{
			y = -(r.nextInt(5));
		}
		int[] coordinates = {x,y} ;
		return coordinates;
	}
	public static int[] goDirection(char direction, int[] playerCoordinate)
	{
		switch(direction)
		{
			case 'n': 
				playerCoordinate[1] = playerCoordinate[1] + 1;
				break;
			case 'N':
				playerCoordinate[1] = playerCoordinate[1] + 1;
				break;
			case 's':
				playerCoordinate[1] = playerCoordinate[1] - 1;
				break;
			case 'S': 
				playerCoordinate[1] = playerCoordinate[1] - 1;
				break;
			case 'e':
				playerCoordinate[0] = playerCoordinate[0] + 1;
				break;
			case 'E':
				playerCoordinate[0] = playerCoordinate[0] + 1;
				break;
			case 'w':
				playerCoordinate[0] = playerCoordinate[0] - 1;
				break;
			case 'W':
				playerCoordinate[0] = playerCoordinate[0] - 1;
				break;	
		}
		return playerCoordinate;
	}
	public static void boxFoundMessage()
	{
		System.out.println("Your toe bumps into a hard object in the water.");
		System.out.println("You pick up the object, it appears to be a small box");
		System.out.println("Open the Box? (type yes or no)");
	}
	public static boolean doYouOpen(char decision)
	{
		boolean decided = false;
		switch (decision)
		{
		case 'y': decided = true;
		break;
		case 'Y': decided = true;
		break;
		}
		return decided;
	}
	public static void noMessage()
	{
		System.out.println("Looking around the featureless landscape, the box seems like your only hope of");
		System.out.println("getting out of this strange world");	
		System.out.println("Do you open the box?");
	}
	public static void yesMessage()
	{
		System.out.println("You open the box, inside are beautiful gemstones of assorted colours.");
		System.out.println("Suddenly, the world around you dissapears to darkness.");
	}
}
