package package1;
import java.util.Scanner;
public class GuardsRiddle 
{
	public static void startMessage()
	{
		System.out.println("You awake in a small room with stone walls, there are torches on the walls.");
		System.out.println("The room is otherwise featureless. You feel the assorted gemstones and the ");
		System.out.println("watch in your hands.");
		System.out.println("To the north you can see a woooden door guarded by a small Sphinx");
		System.out.println("(pick a direction)");
	}
	public static boolean navigateCorridor(char direction)
	{
		if (direction == 'n' || direction == 'N')
		{
			System.out.println("You stand in front of the sphinx. Behind the Sphinx is a wooden door.");
			return true;
		}
		else
		{
			System.out.println("You walk into a stone wall. The Sphinx gives you a disappointed look");
			return false;
		}
	}
	private static void sphinxStart()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("The Sphinx stares at you. After a short while, the sphinx speaks,");
		System.out.println("'Greetings traveller. To get through me, you must answer my riddles.'");
		System.out.println("'But consider carefully, for if you get 3 answers wrong, I shall eat you'");
		boolean doRiddlesStart = false;
		while (doRiddlesStart == false)
		{
			System.out.println("'Are you ready for my riddles?'");
			String yesNo = input.nextLine();
			char[] yN = yesNo.toCharArray();
			if(yN[0] == 'y' || yN[0] == 'Y')
			{
				System.out.println("'Excellent!'");
				doRiddlesStart = true;
			}
			else
			{
				System.out.println("'I will grant you some time to gather your senses'");
				System.out.println("A few minutes pass....");
			}
		}
	}
	public static void sphinxRiddles()
	{
		sphinxStart();
		Scanner input = new Scanner(System.in);
		int lives = 3; 
		boolean riddleComplete = false;
		while (lives>0 && riddleComplete == false)
		{
			System.out.println("'What language can you travel across?'");
			String answer = input.nextLine();
			if ( answer.contains("Sea") || answer.contains("sea") || answer.equals("c") || answer.equals("C"))
			{
				riddleComplete = true;
			}
			else
			{
				lives--;
				sphinxWarning(lives);
			}
		}
		riddleComplete = false;
		while (lives>0 && riddleComplete == false)
		{
			System.out.println("'What has 4 legs but cannot move?'");
			String answer = input.nextLine();
			if (answer.contains("table") || answer.contains("Table") || answer.contains("TABLE"))
			{
				riddleComplete = true;
			}
			else
			{
				lives--;
				sphinxWarning(lives);
			}
		}
		riddleComplete = false;
		while (lives>0 && riddleComplete == false)
		{
			System.out.println("'I have a mouth yet I cannot speak, what am I?");
			String answer = input.nextLine();
			if(answer.contains("river")||answer.contains("River")||answer.contains("RIVER"))
			{
				riddleComplete = true;
			}
			else
			{
				lives--;
				sphinxWarning(lives);
			}
		}
		if(riddleComplete)
		{
			successMessage();
		}
	}
	private static void successMessage()
	{
		System.out.println("You have beaten the sphinxes riddles, the sphinx steps aside and the door opens.");
		System.out.println("You are free! You step out into the world a handful of gemstones richer.");
		System.out.println("GAME OVER");
	}
	private static void sphinxWarning(int lives)
	{
		if (lives == 1) 
		{
			System.out.println("'Be careful, if you get an answer wrong now, I will eat you'");
		}
		else if(lives == 0)
		{
			System.out.println("You have been eaten by the Sphinx");
			System.out.println("GAME OVER");
		}
		else 
		{
			System.out.println("'Try again, I will allow you to make " + lives +" more mistakes before I eat you'" );
		}
	}
}