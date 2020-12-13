package tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tetris.mechanics.PlayingField;
import tetris.shapes.Brick;

public class GameBoard extends JPanel
{
	public static ImageIcon CYAN = new ImageIcon("Images\\CyanBlock.png");
	public static ImageIcon YELLOW = new ImageIcon("Images\\YellowBlock.png");
	public static ImageIcon ORANGE = new ImageIcon("Images\\OrangeBlock.png");
	public static ImageIcon PINK = new ImageIcon("Images\\PinkBlock.png");
	public static ImageIcon PURPLE = new ImageIcon("Images\\PurpleBlock.png");
	public static ImageIcon RED = new ImageIcon("Images\\RedBlock.png");
	public static ImageIcon GREEN = new ImageIcon("Images\\GreenBlock.png");
	
	private ImageIcon GamePanelBackground = new ImageIcon("Images\\GameBackground.png");
	
	private HashMap<Brick, JLabel> bricksOnField = new HashMap<Brick, JLabel>();
	private final int aY = 27 - 25;
	private final int aX = 28 - 25;
	private JLabel GamePanel;
	private int score = 0;
	private JLabel Score;
	
	public GameBoard()
	{
		super();
		this.setBackground(new Color(27, 23, 61));
		this.setLayout(null);
		
		Score = new JLabel("Score: " + Integer.toString(score));
		Score.setForeground(new Color (14, 45, 79));
		Score.setFont(new Font("Monospaced", Font.BOLD, 30));
		Score.setBounds(400 - 75, 0, 280, 147);
		Score.setVisible(true);
		this.add(Score);
		
		GamePanel = new JLabel();
		GamePanel.setBounds(0,0, 255, 505);
		GamePanel.setIcon(new ImageIcon("Images\\GameBackground.png"));
		
		JLabel ScorePanel = new JLabel("");
		ScorePanel.setForeground(Color.WHITE);
		ScorePanel.setIcon(new ImageIcon("Images\\ScoreBackground.png"));
		ScorePanel.setBounds(new Rectangle(263, 0, 280, 147));
		this.add(ScorePanel);
		
		this.add(Test.GBack);
		
		this.repaint();
	}
	
//	public void paint(Graphics g)
//	{
//		g.drawRect(10, 10, 100, 100);
//	}
	
	public void addBricks(Brick[] newBricks)
	{
		for (Brick b : newBricks)
		{
			JLabel temp = new JLabel("ttttttttttt");
			temp.setIcon(b.getColor());
			temp.setBounds(aX + b.getWidth() * b.getXPos(),(b.getHeight() * b.getYPos()) + aY - 450, b.getWidth(), b.getHeight());
			System.out.println(temp.getX() + ", " + temp.getY() + " for icon." + this.isVisible());
			bricksOnField.put(b, temp);
			this.add(temp);
		}
		this.add(GamePanel);
	}
	
	public void deleteBricks()
	{
		bricksOnField.forEach((b,n) -> {
			if(b.getXPos() == -100) 
				n = null;
		});
		repaint();
	}
	
	public void moveBricks()
	{
		bricksOnField.forEach((b,n) -> n.setBounds(aX + b.getWidth() * b.getXPos(),475 - (b.getHeight() * b.getYPos()) + aY, b.getWidth(), b.getHeight()));
		repaint();
	}
	
	public void addScore(int newScore)
	{
		this.score = this.score + newScore;
		this.Score.setText("Score: " + Integer.toString(score));
		System.out.println(score);
		repaint();
	}
}
