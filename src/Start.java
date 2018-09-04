import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Start extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// JPanel declaration area
	private JPanel main, home, title, footnote, playerTitle, playerBase, playerHolder, inputHolder;
	
	// JButton declaration area
	private JButton inputMultiple, complete, updateInformation;
	
	// JLabel declaration area
	private JLabel titleText, playerTitleText, playerText, footnoteText, rounds;
	
	// Miscellaneous declaration area
	private Window win;
	private ReadNames rn;
	private JTextArea numOfRounds;
	private JScrollPane scroll;
	private File file;
	
	// Base variable declaration area
	private String tempData;
	private String error;
	private static int roundValue;
	
	public Start()
	{
		super();
		this.setSize(600, 350);
		this.setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setResizable(true);
		
		file = new File("chessinfo.txt");
		rn = new ReadNames();
		
		main = new JPanel();
		main.setLayout(new BorderLayout());
		add(main);
		
		home = new JPanel();
		home.setLayout(new GridLayout(1, 2));
		main.add(home, BorderLayout.CENTER);
		
		title = new JPanel();
		title.setBorder(new LineBorder(Color.GRAY));
		main.add(title, BorderLayout.NORTH);
		
		footnote = new JPanel();
		footnote.setBorder(new LineBorder(Color.GRAY));
		main.add(footnote, BorderLayout.SOUTH);
		
		inputHolder = new JPanel();
		inputHolder.setBorder(new LineBorder(Color.GRAY));
		home.add(inputHolder);
		
		playerBase = new JPanel();
		playerBase.setBorder(new LineBorder(Color.GRAY));
		playerBase.setLayout(new BorderLayout());
		scroll = new JScrollPane(playerHolder);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		home.add(playerBase);
		
		playerTitle = new JPanel();
		playerTitle.setBorder(new LineBorder(Color.GRAY));
		playerBase.add(playerTitle, BorderLayout.NORTH);
		
		playerHolder = new JPanel();
		scroll = new JScrollPane(playerHolder);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		playerBase.add(scroll, BorderLayout.CENTER);
		
		titleText = new JLabel("Current Setup - Please Change if you Desire");
		title.add(titleText);
		
		playerTitleText = new JLabel("Current Players");
		playerTitle.add(playerTitleText);
		
		footnoteText = new JLabel("Declan Sullivan's Chess Managing Program");
		footnote.add(footnoteText);
		
		playerText = new JLabel("");
		playerHolder.add(playerText);
		
		rn.readFile();
		tempData = "<html><body>";
		
		setPlayerText();
		
		rounds = new JLabel("Input the desired number of rounds: ");
		inputHolder.add(rounds);
		
		numOfRounds = new JTextArea("10");
		inputHolder.add(numOfRounds);
		
		inputMultiple = new JButton("Edit the Player List");
		inputMultiple.addActionListener(this);
		inputHolder.add(inputMultiple);
		
		updateInformation = new JButton("Update Displayed Info");
		updateInformation.addActionListener(this);
		inputHolder.add(updateInformation);
		
		complete = new JButton("Move on to the Tournament");
		complete.addActionListener(this);
		inputHolder.add(complete);
	}
	
	public static int getRounds()
	{
		return roundValue;
	}
	
	public void setPlayerText()
	{
		rn.readFile();
		tempData = "<html><body>";
		for (int x = 0; x < ReadNames.getList().size(); x++) 
		{
			if (!ReadNames.getList().get(x).equals("Free Pass"))
			{
				tempData += ReadNames.getList().get(x) + "<br>";
			}
		}
		playerText.setText(tempData + "</html>");
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(inputMultiple))
		{
			try 
			{
				Desktop.getDesktop().edit(file);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
		
		if(e.getSource().equals(updateInformation))
		{
			setPlayerText();
		}
		
		if(e.getSource().equals(complete))
		{
			try
			{
				Integer.parseInt(numOfRounds.getText());
				if(Integer.parseInt(numOfRounds.getText()) < 1)
				{
					numOfRounds.setText("Please input a number greater than 1");
				}
				else if(Integer.parseInt(numOfRounds.getText()) > 99)
				{
					numOfRounds.setText("Please input a number smaller than 100");
				}
				else
				{
					roundValue = Integer.parseInt(numOfRounds.getText());
					updateInformation.doClick();
					this.setVisible(false);
					win = new Window();
					win.setVisible(true);
				}
			}
			catch(NumberFormatException x)
			{
				error = "Please only enter numbers";
				numOfRounds.setText(error);
			}
		}
	}
}