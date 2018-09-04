import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Window extends JFrame implements ActionListener, MouseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// JPanel declaration area.
	private JPanel main, home, left, subLeftNorth, subLeftSouth, right, 
					subRightNorth, buttons, centerNorth, centerSouth, centerButtons, 
					buttonInput;
	
	private static JPanel center, outcomeInput, subLeftNorthC, 
							subLeftSouthC, subRightNorthC, subRightSouthC,
							subRightSouth, OINorth;

	// JButton declaration area.
	private JButton instructions, endGame, spreadsheet, enter;
	private static JButton topWin, bottomWin, tie, nextRound, theme, finishGame,
							newRoundInput;

	// JLabel declaration area.
	private JLabel title, players, opposition, points, centerTitle, statistics, buttonText;
	
	private static JLabel pointList, oppositionList, playerList, response;

	// Miscellaneous declaration area.
	private ReadNames rn;
	private ChangeTheme ct;
	private Matchup m;
	private Popup p;
	private File file;
	private Spreadsheet ss;
	private static JTextField numberInput;
	private static AssignSide wb;
	private static Color color;
	private static JScrollPane scroll;
	private static ArrayList<Player> oppose;
	private static ArrayList<Player> f;
	private static ArrayList<JButton> button;

	// Base variables declaration area.
	private String error;
	private static String tempData, respond;
	private static int color1, color2, color3, get, round, index, requestedRounds;

	public Window() 
	{
		super();
		this.setSize(800, 600);
		this.setTitle("Swiss System Chess Tournament");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setResizable(true);

		requestedRounds = Start.getRounds();
		
		rn = new ReadNames();
		m = new Matchup();
		p = new Popup();
		wb = new AssignSide();
		ct = new ChangeTheme();
		ss = new Spreadsheet();
		file = new File("instructions.txt");

		color1 = 216;
		color2 = 216;
		color3 = 216;
		get = 0;
		round = 0;
		
		main = new JPanel();
		main.setLayout(new BorderLayout());
		main.setOpaque(false);
		add(main);
		
		color = new Color(color1, color2, color3);
		getContentPane().setBackground(color);

		oppose = new ArrayList<Player>();
		f = new ArrayList<Player>();
		button = new ArrayList<JButton>();

		title = new JLabel("Current Round: " + (round + 1) + ".           Rounds to Be Played: " 
							+ requestedRounds + ".", SwingConstants.CENTER);
		title.setBorder(new LineBorder(Color.GRAY));
		title.setOpaque(true);
		main.add(title, BorderLayout.NORTH);

		statistics = new JLabel("Player Stats", SwingConstants.CENTER);
		statistics.setBorder(new LineBorder(Color.GRAY));

		pointList = new JLabel("", SwingConstants.CENTER);
		points = new JLabel("Current Leaderboard", SwingConstants.CENTER);
		points.setBorder(new LineBorder(Color.GRAY));

		playerList = new JLabel("");
		players = new JLabel("Player List", SwingConstants.CENTER);
		players.setBorder(new LineBorder(Color.GRAY));

		centerTitle = new JLabel("Outcome Input", SwingConstants.CENTER);
		centerTitle.setBorder(new LineBorder(Color.GRAY));

		oppositionList = new JLabel("", SwingConstants.CENTER);
		opposition = new JLabel("Current Matchup", SwingConstants.CENTER);
		opposition.setBorder(new LineBorder(Color.GRAY));
		
		home = new JPanel();
		home.setOpaque(false);
		home.setLayout(new GridLayout(1, 3));
		main.add(home);

		topWin = new JButton("");
		topWin.addActionListener(this);

		tie = new JButton("Draw");
		tie.addActionListener(this);

		bottomWin = new JButton("");
		bottomWin.addActionListener(this);

		respond = "<html><div style='text-align: center;'> This round is complete.  " +
				"<br>" + "Please click 'Next Round' when ready." + "<html>";
		response = new JLabel("", SwingConstants.CENTER);
		
		OINorth = new JPanel();
		OINorth.setLayout(new GridLayout(4, 1));
		OINorth.setOpaque(false);
		OINorth.add(topWin);
		OINorth.add(tie);
		OINorth.add(bottomWin);
		OINorth.add(response);

		centerNorth = new JPanel();
		centerNorth.setLayout(new FlowLayout());
		centerNorth.setOpaque(false);
		centerNorth.add(OINorth);

		outcomeInput = new JPanel();
		outcomeInput.setLayout(new BorderLayout());
		outcomeInput.setOpaque(false);
		outcomeInput.add(centerTitle, BorderLayout.NORTH);
		outcomeInput.add(centerNorth, BorderLayout.CENTER);
		
		buttonText = new JLabel("Settings and Options", SwingConstants.CENTER);
		buttonText.setBorder(new LineBorder(Color.GRAY));
		
		centerButtons = new JPanel();
		centerButtons.setLayout(new GridLayout(5, 1));
		centerButtons.setOpaque(false);
		
		centerSouth = new JPanel();
		centerSouth.setLayout(new FlowLayout());
		centerSouth.setOpaque(false);
		centerSouth.add(centerButtons);
		
		buttonInput = new JPanel();
		buttonInput.setLayout(new BorderLayout());
		buttonInput.setOpaque(false);
		buttonInput.add(buttonText, BorderLayout.NORTH);
		buttonInput.add(centerSouth, BorderLayout.CENTER);

		center = new JPanel();
		center.setOpaque(false);
		center.setLayout(new GridLayout(2, 1));
		center.setBorder(new LineBorder(Color.GRAY));
		center.add(outcomeInput);
		center.add(buttonInput);

		subLeftNorthC = new JPanel();
		scroll = new JScrollPane(subLeftNorthC);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		subLeftNorth = new JPanel();
		subLeftNorth.setLayout(new BorderLayout());
		subLeftNorth.add(players, BorderLayout.NORTH);
		subLeftNorth.add(scroll, BorderLayout.CENTER);
		
		subLeftSouthC = new JPanel();
		scroll = new JScrollPane(subLeftSouthC);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		subLeftSouth = new JPanel();
		subLeftSouth.setLayout(new BorderLayout());
		subLeftSouth.add(opposition, BorderLayout.NORTH);
		subLeftSouth.add(scroll, BorderLayout.CENTER);

		subRightNorthC = new JPanel();
		scroll = new JScrollPane(subRightNorthC);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		subRightNorth = new JPanel();
		subRightNorth.setLayout(new BorderLayout());
		subRightNorth.add(points, BorderLayout.NORTH);
		subRightNorth.add(scroll, BorderLayout.CENTER);

		subRightSouthC = new JPanel();
		scroll = new JScrollPane(subRightSouthC);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		subRightSouth = new JPanel();
		subRightSouth.setLayout(new BorderLayout());
		subRightSouth.add(statistics, BorderLayout.NORTH);
		subRightSouth.add(scroll, BorderLayout.CENTER);

		left = new JPanel();
		left.setLayout(new GridLayout(2, 1));
		left.add(subLeftNorth);
		left.add(subLeftSouth);
		left.setBorder(new LineBorder(Color.GRAY));

		right = new JPanel();
		right.setLayout(new GridLayout(2, 1));
		right.add(subRightNorth);
		right.add(subRightSouth);
		right.setBorder(new LineBorder(Color.GRAY));

		buttons = new JPanel();
		buttons.setLayout(new GridLayout(1, 4));
		main.add(buttons, BorderLayout.SOUTH);

		main.add(home, BorderLayout.CENTER);
		home.add(left);
		home.add(center);
		home.add(right);

		instructions = new JButton("Instructions");
		instructions.addActionListener(this);

		theme = new JButton("Change Theme");
		theme.addActionListener(this);

		nextRound = new JButton("Next Round");
		nextRound.addActionListener(this);
		nextRound.setEnabled(false);
		
		spreadsheet = new JButton("Display Spreadsheet");
		spreadsheet.addActionListener(this);

		endGame = new JButton("Close Program");
		endGame.addActionListener(this);
		
		finishGame = new JButton("Show Final Standings");
		finishGame.addActionListener(this);
		
		newRoundInput = new JButton("Alter Rounds");
		newRoundInput.addActionListener(this);
		
		enter = new JButton("Enter Input");
		enter.addActionListener(this);
		
		numberInput = new JTextField("Enter a new number of rounds");
		
		buttons.add(nextRound);
		buttons.add(finishGame);
		buttons.add(spreadsheet);
		buttons.add(endGame);
		
		centerButtons.add(instructions);
		centerButtons.add(theme);
		centerButtons.add(newRoundInput);
		centerButtons.add(numberInput);
		centerButtons.add(enter);
		
		numberInput.setVisible(false);
		enter.setVisible(false);
		
		rn.readFile();
		setPlayerList(ReadNames.getList());
		m.addToGUI();
		m.updateScore();

		for (int x = 0; x < button.size(); x++) 
		{
			button.get(x).addActionListener(this);
		}
		
		numberInput.addMouseListener(this);
		
		checkRoundCount();
	}
	
	public static void setPlayerList(ArrayList<String> s) 
	{
		tempData = "<html><body>";
		for (int x = 0; x < s.size(); x++) 
		{
			if (!s.get(x).equals("Free Pass"))
			{
				tempData += s.get(x) + "<br>";
			}
		}
		
		playerList.setText(tempData + "</html>");
		subLeftNorthC.add(playerList);
	}
	
	public static void setOppositionList(ArrayList<Player> p) {
		f = p;
		tempData = "";
		if(round == 0)
		{
			for (int x = 0; x < f.size() / 2; x++) 
			{
				oppose.add(f.get(x));
				oppose.add(f.get(x + f.size() / 2));
			}
				wb.assign(oppose);
				
			for(int x = 0; x < f.size() / 2; x++) 
			{
				if(f.get(x).getColor().equals("White")) 
				{
					tempData += "<html><span bgcolor=\"white\">" + f.get(x).getName() + 
								"<html><span bgcolor=\"blank\"> v. " + 
								"<html><span bgcolor=\"gray\">" + 
								f.get(x + f.size() / 2).getName() + "<br>";
				} 
				else if(f.get(x).getColor().equals("Black")) 
				{
					tempData += "<html><span bgcolor=\"gray\">" + f.get(x).getName() + 
								"<html><span bgcolor=\"blank\"> v. " + 
								"<html><span bgcolor=\"white\">" + 
								f.get(x + f.size() / 2).getName() + "<br>";
				}
			}
				
				oppositionList.setText(tempData + "</span></html>");
				subLeftSouthC.add(oppositionList);
			
		}
		else
		{
			for(int x = 0; x < f.size(); x += 2)
			{
				oppose.set(x, f.get(x));
				oppose.set(x + 1, f.get(x + 1));
			}
				wb.assign(oppose);
				
			for(int x = 0; x < f.size(); x += 2) 
			{
				if(f.get(x).getColor().equals("White")) 
				{
					tempData += "<html><span bgcolor=\"white\">" + f.get(x).getName() + 
								"<html><span bgcolor=\"blank\"> v. " + 
								"<html><span bgcolor=\"gray\">" + 
								f.get(x + 1).getName() + "<br>";
				} 
				else if(f.get(x).getColor().equals("Black")) 
				{
					tempData += "<html><span bgcolor=\"gray\">" + f.get(x).getName() + 
								"<html><span bgcolor=\"blank\"> v. " + 
								"<html><span bgcolor=\"white\">" + 
								f.get(x + 1).getName() + "<br>";
				}
			}
			
			oppositionList.setText(tempData + "</span></html>");
			subLeftSouthC.add(oppositionList);
		}
	}

	public static void updatePoints(ArrayList<Player> p) 
	{
		tempData = "<html><body>";
		for(int x = 0; x < p.size(); x++) 
		{
			if(p.get(x).getName().equals("Free Pass")) 
			{} 
			else 
			{
				tempData += p.get(x).getName() + ": " + String.valueOf(p.get(x).getPoints()) + "<br>";
			}
		}
		pointList.setText(tempData + "</html>");
		subRightNorthC.add(pointList);
	}

	public static void setOutcomeArea(ArrayList<Player> p) 
	{
		if(get < oppose.size())
		{
			if(oppose.get(get).getName().equals("Free Pass") && get == oppose.size())
			{}
			else if(oppose.get(get + 1).getName().equals("Free Pass"))
			{
				topWin.setText((oppose.get(get).getName() + " Won"));
				bottomWin.setText(oppose.get(get + 1).getName() + " Won");
				tie.setEnabled(false);
				bottomWin.setEnabled(false);
			}
			else
			{
				topWin.setText(oppose.get(get).getName() + " Won");
				bottomWin.setText(oppose.get(get + 1).getName() + " Won");
			}
		}
		if(get > oppose.size() || get == oppose.size())
		{
			topWin.setEnabled(false);
			bottomWin.setEnabled(false);
			tie.setEnabled(false);
			nextRound.setEnabled(true);
			newRoundInput.setEnabled(false);
			finishGame.setEnabled(true);
			response.setText(respond);
		}
	}
	
	public static void setButtonList(ArrayList<Player> p) 
	{
		subRightSouthC.setLayout(new GridLayout(p.size(), 1));
		for(int x = 0; x < oppose.size(); x++)
		{
			if(p.get(x).getName().equals("Free Pass")) 
			{
				subRightSouthC.setLayout(new GridLayout(p.size() - 1, 1));
			} 
			else 
			{
				button.add(new JButton((String) p.get(x).getName()));
				subRightSouthC.add(button.get(x));
			}
		}
	}

	public static void updateColors(int x, int y, int z)
	{
		color1 = x;
		color2 = y;
		color3 = z;
		color = new Color(color1, color2, color3);
		theme.doClick();
	}
	
	public static int whatRound()
	{
		return round;
	}

	public static int getRequestedRounds()
	{
		return requestedRounds;
	}
	
	public void checkRoundCount()
	{
		if(requestedRounds - round == 1 || requestedRounds == 1)
		{
			nextRound.setVisible(false);
			finishGame.setVisible(true);
			finishGame.setEnabled(false);
		}
		else
		{
			finishGame.setVisible(false);
			nextRound.setVisible(true);
		}
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(newRoundInput))
		{
			newRoundInput.setEnabled(false);
			numberInput.setVisible(true);
			numberInput.setText("Enter a new number of rounds");
			enter.setVisible(true);
		}
		
		if(e.getSource().equals(enter))
		{
			try
			{
				Integer.parseInt(numberInput.getText());
				if(Integer.parseInt(numberInput.getText()) < 1)
				{
					numberInput.setText("Input a number greater than 0");
				}
				else if(Integer.parseInt(numberInput.getText()) < round ||
						Integer.parseInt(numberInput.getText()) == round)
				{
					numberInput.setText("Input a larger round value");
				}
				else if(Integer.parseInt(numberInput.getText()) > 99)
				{
					numberInput.setText("Input a number less than 99");
				}
				else
				{
					requestedRounds  = Integer.parseInt(numberInput.getText());
					newRoundInput.setEnabled(true);
					numberInput.setVisible(false);
					enter.setVisible(false);
					title.setText("Current Round: " + round + ".           Rounds to Be Played: " 
									+ requestedRounds + ".");
					checkRoundCount();
				}
			}
			catch(NumberFormatException x)
			{
				error = "Please only enter numbers";
				numberInput.setText(error);
			}
		}
		
		if((e.getSource()).equals(endGame)) 
		{
			System.exit(0);
		}

		if((e.getSource()).equals(theme)) 
		{
			ct.newTheme(color1, color2, color3);
			getContentPane().setBackground(color);
		}

		if((e.getSource()).equals(nextRound)) 
		{
			round++;
			get = 0;
			m.sortByScore();
			oppose = m.getPlayers();
			setOutcomeArea(oppose);
			newRoundInput.setEnabled(true);
			nextRound.setEnabled(false);
			topWin.setEnabled(true);
			bottomWin.setEnabled(true);
			tie.setEnabled(true);
			response.setText("");
			title.setText("Current Round: " + round + ".           Rounds to Be Played: " 
							+ requestedRounds + ".");
			checkRoundCount();
		}
		
		if((e.getSource()).equals(finishGame))
		{
			setVisible(false);
			ss.setSpreadsheetVolatility();
			ss.setSpreadsheetVisible();
		}
		
		if((e.getSource()).equals(spreadsheet))
		{
			ss.setSpreadsheetVisible();
		}

		if((e.getSource()).equals(tie)) 
		{
			oppose.get(get).setPoints(oppose.get(get).getPoints() + 0.5);
			oppose.get(get + 1).setPoints(oppose.get(get + 1).getPoints() + 0.5);
			oppose.get(get).setGames(oppose.get(get).getGames() + 1);
			oppose.get(get + 1).setGames(oppose.get(get + 1).getGames() + 1);
			
			ss.updateSpreadsheet(oppose.get(get).getName(), oppose.get(get).getPoints(), 
					oppose.get(get).getColor(), oppose.get(get + 1).getName(), 
					oppose.get(get + 1).getPoints(), oppose.get(get + 1).getColor());
			
			get += 2;
			setOutcomeArea(oppose);
			m.updateScore();
		}

		if((e.getSource()).equals(topWin)) 
		{
			oppose.get(get).setPoints(oppose.get(get).getPoints() + 1);
			oppose.get(get).setGames(oppose.get(get).getGames() + 1);
			oppose.get(get + 1).setGames(oppose.get(get + 1).getGames() + 1);
			
			ss.updateSpreadsheet(oppose.get(get).getName(), oppose.get(get).getPoints(), 
					oppose.get(get).getColor(), oppose.get(get + 1).getName(), 
					oppose.get(get + 1).getPoints(), oppose.get(get + 1).getColor());
			
			get += 2;
			setOutcomeArea(oppose);
			m.updateScore();
		}
		
		if((e.getSource()).equals(bottomWin))
		{
			oppose.get(get + 1).setPoints(oppose.get(get + 1).getPoints() + 1);
			oppose.get(get + 1).setGames(oppose.get(get + 1).getGames() + 1);
			oppose.get(get).setGames(oppose.get(get).getGames() + 1);

			ss.updateSpreadsheet(oppose.get(get).getName(), oppose.get(get).getPoints(), 
					oppose.get(get).getColor(), oppose.get(get + 1).getName(), 
					oppose.get(get + 1).getPoints(), oppose.get(get + 1).getColor());
			
			get += 2;
			setOutcomeArea(oppose);
			m.updateScore();
		}
		
		if(e.getSource().equals(instructions))
		{
			try 
			{
				Desktop.getDesktop().edit(file);
				file.setReadOnly();
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}

		for(int x = 0; x < button.size(); x++) 
		{
			if((e.getSource()).equals(button.get(x))) 
			{
				for(int y = 0; y < m.getNames().size(); y++)
				{
					if(((AbstractButton) e.getSource()).getText().equals(f.get(y).getName()))
					{
						index = y;
					}
				}
				p.buildPopup(f, f.get(index).getName(), index);
			}
		}
	}

	public void mouseClicked(MouseEvent e) 
	{
		if(e.getSource().equals(numberInput))
		{
			numberInput.setText("");
		}
	}
	//Mandatory for using MouseListener, will implement if needed
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}