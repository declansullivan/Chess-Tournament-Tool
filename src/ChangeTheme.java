import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class ChangeTheme extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel base, home, left, center, right;
	private JLabel red, green, blue;
	private JSlider redArea, greenArea, blueArea;
	private int r, g, b, low, high;
	private JButton execute;
	
	public ChangeTheme()
	{
		super();
		this.setSize(500, 250);
		this.setTitle("Color Interface");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setResizable(true);
		this.setAlwaysOnTop(true);
		
		r = 216;
		g = 216;
		b = 216;
		low = 0;
		high = 255;
		
		base = new JPanel();
		base.setLayout(new BorderLayout());
		add(base);
		
		home = new JPanel();
		home.setLayout(new GridLayout(3, 1));
		base.add(home, BorderLayout.CENTER);
		
		left = new JPanel();
		left.setLayout(new BorderLayout());
		
		center = new JPanel();
		center.setLayout(new BorderLayout());
		
		right = new JPanel();
		right.setLayout(new BorderLayout());
		
		home.add(left);
		home.add(center);
		home.add(right);
		
		red = new JLabel("Choose Red Value", SwingConstants.CENTER);
		green = new JLabel("Choose Green Value", SwingConstants.CENTER);
		blue = new JLabel("Choose Blue Value", SwingConstants.CENTER);
		
		left.add(red, BorderLayout.NORTH);
		center.add(green, BorderLayout.NORTH);
		right.add(blue, BorderLayout.NORTH);
		
		redArea = new JSlider(JSlider.HORIZONTAL, low, high, r);
		greenArea = new JSlider(JSlider.HORIZONTAL, low, high, g);
		blueArea = new JSlider(JSlider.HORIZONTAL, low, high, b);
		
		redArea.setMajorTickSpacing(15);
		redArea.setPaintTicks(true);
		redArea.setPaintLabels(true);
		
		blueArea.setMajorTickSpacing(15);
		blueArea.setPaintTicks(true);
		blueArea.setPaintLabels(true);
		
		greenArea.setMajorTickSpacing(15);
		greenArea.setPaintTicks(true);
		greenArea.setPaintLabels(true);
		
		left.add(redArea, BorderLayout.CENTER);
		center.add(greenArea, BorderLayout.CENTER);
		right.add(blueArea, BorderLayout.CENTER);
		
		execute = new JButton("Enter Values");
		execute.addActionListener(this);
		base.add(execute, BorderLayout.SOUTH);
		
	}
	
	public void newTheme(int x, int y, int z)
	{
		redArea.setValue(x);
		greenArea.setValue(y);
		blueArea.setValue(z);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if((e.getSource()).equals(execute))
		{
			r = redArea.getValue();
			g = greenArea.getValue();
			b = blueArea.getValue();
			Window.updateColors(r, g, b);
			setVisible(false);
		}
	}
}