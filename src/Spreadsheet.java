import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

public class Spreadsheet extends JFrame
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Miscellaneous declaration area
	private JScrollPane scroll;
	private JTable table;
	private ArrayList<String> rows;
	private TableColumnModel table2;
	//Object[][] names = new String[ReadNames.getList().size()][Window.getRequestedRounds() + 2];
	//String[] rowNames = new String[Window.getRequestedRounds() + 2];
	Object[][] names;
	String[] rowNames = new String[101];
	
	// Base variables declaration area
	private int indexA;
	private int indexB;
	private String contentA;
	private String contentB;
	
	public Spreadsheet()
	{
		super();
		this.setSize(800, 700);
		this.setTitle("Overall Results");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setResizable(true);
		
		rows = new ArrayList<String>();
		rows.add("Player Number");
		rows.add("Player Name");
		
		for(int x = 0; x < 99; x++)
		{
			rows.add("Round " + String.valueOf(x + 1));
		}
		
		if(ReadNames.containsFreePass() == true)
		{
			names = new String[ReadNames.getList().size() - 1][101];
		}
		else
		{
			names = new String[ReadNames.getList().size()][101];
		}
		
		getNamesToArray();
		getrowsToArray();
		
		table = new JTable(names, rowNames);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scroll);
		
		if(ReadNames.containsFreePass() == true)
		{
			for(int x = 0; x < ReadNames.getList().size() - 1; x++)
			{
				names[x][0] = String.valueOf(x);
			}
		}
		else
		{
			for(int x = 0; x < ReadNames.getList().size(); x++)
			{
				names[x][0] = String.valueOf(x);
			}
		}
		
		table.setRowHeight(50);
		table.setGridColor(Color.BLACK);
		
		table2 = table.getColumnModel();
		table2.getColumn(0).setPreferredWidth(20);
		table2.getColumn(1).setPreferredWidth(150);
		
		for(int x = 2; x < 101; x++)
		{
			table2.getColumn(x).setPreferredWidth(80);
		}
	}
	
	public void updateSpreadsheet(String a, double a1, String a2, 
									String b, double b1, String b2)
	{
		for(int x = 0; x < ReadNames.getList().size(); x++)
		{
			if(ReadNames.getList().get(x).equals(a))
			{
				indexA = x;
			}
			if(ReadNames.getList().get(x).equals(b))
			{
				indexB = x;
			}
		}
		for(int x = 0; x < ReadNames.getList().size(); x++)
		{
			if(!a.equals("Free Pass"))
			{
				if(ReadNames.getList().get(x).equals(a))
				{
					contentA = "<html><body> Points: " + a1 + ". <br> Color: " + a2 + ". <br> Faced: " + indexB + ".";
					names[indexA][Window.whatRound() + 2] = contentA;
				}
			}
			if(!b.equals("Free Pass"))
			{
				if(ReadNames.getList().get(x).equals(b))
				{
					contentB = "<html><body> Points: " + b1 + ". <br> Color: " + b2 + ". <br> Faced: " + indexA + ".";
					names[indexB][Window.whatRound() + 2] = contentB;
				}
			}
		}
	}
	
	public void setSpreadsheetVisible()
	{
		setVisible(true);
	}
	
	public void setSpreadsheetVolatility()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void getNamesToArray()
	{
		if(ReadNames.containsFreePass() == true)
		{
			for(int x = 0; x < ReadNames.getList().size() - 1; x++)
			{
				names[x][1] = ReadNames.getList().get(x);
			}
		}
		else
		{
			for(int x = 0; x < ReadNames.getList().size(); x++)
			{
				names[x][1] = ReadNames.getList().get(x);
			}
		}
	}	
	
	public void getrowsToArray()
	{
		for(int x = 0; x < rows.size(); x++)
		{
			rowNames[x] = rows.get(x);
		}
	}
}