import java.util.ArrayList;
import java.util.Random;

public class AssignSide 
{
	private int randomer;
	Random random = new Random();
	
	public AssignSide()
	{}
	
	public void assign(ArrayList<Player> p)
	{
		for(int x = 0; x < p.size(); x += 2)
		{
			
			if(p.get(x).getWhite() > p.get(x + 1).getWhite())
			{
				p.get(x + 1).setColor("White");
				p.get(x + 1).addWhite(1);
				p.get(x).setColor("Black");
				p.get(x).addBlack(1);
			}
			else if(p.get(x).getWhite() < p.get(x + 1).getWhite())
			{
				p.get(x + 1).setColor("Black");
				p.get(x + 1).addBlack(1);
				p.get(x).setColor("White");
				p.get(x).addWhite(1);
			}
			
			else if(p.get(x).getWhite() == p.get(x + 1).getWhite())
			{
				randomer = random.nextInt(2);
				if(randomer == 0)
				{
					p.get(x).setColor("White");
					p.get(x).addWhite(1);
					p.get(x + 1).setColor("Black");
					p.get(x + 1).addBlack(1);
				}
				else
				{
					p.get(x).setColor("Black");
					p.get(x).addBlack(1);
					p.get(x + 1).setColor("White");
					p.get(x + 1).addWhite(1);
				}
			}
			else
			{
				System.out.println("Something has gone horribly wrong");
			}
		}
	}
}