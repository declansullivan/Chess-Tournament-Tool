import java.util.ArrayList;

public class Matchup 
{	
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<String> playerNames = new ArrayList<String>();
	private Player holder = new Player();
	
	public Matchup()
	{}
	
	public void addToGUI()
	{
		for(int x = 0; x < ReadNames.getList().size(); x++)
		{
			players.add(new Player(ReadNames.getList().get(x)));
			playerNames.add(ReadNames.getList().get(x));
		}
		
		Window.setOppositionList(players);
		Window.updatePoints(players);
		Window.setButtonList(players);
		Window.setOutcomeArea(players);
	}
	
	public void updateScore()
	{
		Window.updatePoints(players);
	}
	
	public ArrayList<Player> getPlayers()
	{
		return players;
	}

	public ArrayList<String> getNames()
	{
		return playerNames;
	}
	
	public void sortByScore()
	{
		for(int x = 0; x < players.size(); x++)
		{
			for(int y = 0; y < players.size(); y++)
			{
				if(players.get(x).getPoints() > players.get(y).getPoints())
				{
					holder = players.get(x);
					players.set(x, players.get(y));
					players.set(y, holder);
				}
			}
		}
		Window.updatePoints(players);
		Window.setOppositionList(players);
	}
}