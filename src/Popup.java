import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Popup extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;

	private JPanel base, middle;
	
	private JButton close;
	
	private JLabel name, black, white, games, unopposed, points,
						blackOut, whiteOut, gamesOut, unopposedOut, pointsOut;
	
	public Popup()
	{
		super();
		this.setSize(200, 400);
		this.setTitle("Player Staticstics");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		setResizable(true);
		this.setAlwaysOnTop(true);

		base = new JPanel();
		base.setLayout(new BorderLayout());
		add(base, BorderLayout.CENTER);
		
		middle = new JPanel();
		middle.setLayout(new GridLayout(5, 2));
		middle.setBorder(new LineBorder(Color.GRAY));
		
		close = new JButton("Close Window");
		close.addActionListener(this);
		add(close, BorderLayout.SOUTH);
		
		name = new JLabel("",  SwingConstants.CENTER);
		name.setBorder(new LineBorder(Color.GRAY));
		
		black = new JLabel("Times Black:", SwingConstants.RIGHT);
		blackOut = new JLabel("", SwingConstants.CENTER);
		
		white = new JLabel("Times White:", SwingConstants.RIGHT);
		whiteOut = new JLabel("", SwingConstants.CENTER);
		
		points = new JLabel("Score:", SwingConstants.RIGHT);
		pointsOut = new JLabel("", SwingConstants.CENTER);
		
		unopposed = new JLabel("Unopposed:", SwingConstants.RIGHT);
		unopposedOut = new JLabel("", SwingConstants.CENTER);
		
		games = new JLabel("Games Played:", SwingConstants.RIGHT);
		gamesOut = new JLabel("", SwingConstants.CENTER);
		
		base.add(name, BorderLayout.NORTH);
		base.add(middle, BorderLayout.CENTER);
		
		middle.add(games);
		middle.add(gamesOut);
		middle.add(unopposed);
		middle.add(unopposedOut);
		middle.add(black);
		middle.add(blackOut);
		middle.add(white);
		middle.add(whiteOut);
		middle.add(points);
		middle.add(pointsOut);
	}
	
	public void buildPopup(ArrayList<Player> p, String s, int x)
	{
			name.setText(s);
			blackOut.setText(String.valueOf(p.get(x).getBlack()));
			whiteOut.setText(String.valueOf(p.get(x).getWhite()));
			gamesOut.setText(String.valueOf(p.get(x).getGames()));
			pointsOut.setText(String.valueOf(p.get(x).getPoints()));
			unopposedOut.setText(String.valueOf(p.get(x).getTimesUnopposed()));
			
			setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
    {
		if((e.getSource()).equals(close))
		{
			setVisible(false);
		}
    }
}