import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadNames 
{
	private Scanner fileIn;
	private int numOfLines;
	private static ArrayList<String> list;
	private static boolean hasFreePass;
	
	public ReadNames() 
	{}
	
	public void readFile() 
	{
		hasFreePass = false;
		list = new ArrayList<String>();
	    try
	    {
	    	fileIn = new Scanner(new FileInputStream("chessinfo.txt"));
	    	while(fileIn.hasNextLine())
	    	{
	    		numOfLines++;
	    		list.add(fileIn.nextLine());
	    		if(!fileIn.hasNextLine() && numOfLines%2 == 1)
	    		{
	    			list.add("Free Pass");
	    			hasFreePass = true;
	    		}
	    	}
	    }
	    catch(FileNotFoundException e)
	    {
	    	System.out.println("ERROR: FILE NOT FOUND.\nPlease ensure that the file is titled 'chessinfo.txt'");
         	System.exit(0);
	    }
	    
	    removeEmpty(list);
	}
	
	public static ArrayList<String> getList()
	{return list;}
	
	public static boolean containsFreePass()
	{
		return hasFreePass;
	}
	
	public void removeEmpty(ArrayList<String> a)
	{
		for(int x = 0; x < a.size(); x++)
		{
			if(a.get(x).equals(""))
			{
				a.remove(x);
			}
		}
	}
}