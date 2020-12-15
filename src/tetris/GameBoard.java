package tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tetris.mechanics.PlayingField;
import tetris.shapes.Brick;

public class GameBoard extends JPanel
{
	//classic
	public static ImageIcon CYAN = new ImageIcon("Images" + File.separator + "Classic" + File.separator + "CyanBlock.png");
	public static ImageIcon YELLOW = new ImageIcon("Images" + File.separator + "Classic" + File.separator + "YellowBlock.png");
	public static ImageIcon ORANGE = new ImageIcon("Images" + File.separator + "Classic" + File.separator + "OrangeBlock.png");
	public static ImageIcon PINK = new ImageIcon("Images" + File.separator + "Classic" + File.separator + "PinkBlock.png");
	public static ImageIcon PURPLE = new ImageIcon("Images" + File.separator + "Classic" + File.separator + "PurpleBlock.png");
	public static ImageIcon RED = new ImageIcon("Images" + File.separator + "Classic" + File.separator + "RedBlock.png");
	public static ImageIcon GREEN = new ImageIcon("Images" + File.separator + "Classic" + File.separator + "GreenBlock.png");
	
	public static ImageIcon[] classic = {CYAN, YELLOW, ORANGE, PINK, PURPLE, RED, GREEN};
	
	//BerryBlast
	public static ImageIcon BLACKBERRY = new ImageIcon("Images" + File.separator + "BerryBlast" + File.separator + "BlackBerry.png");
	public static ImageIcon BLUEBERRY = new ImageIcon("Images" + File.separator + "BerryBlast" + File.separator + "Blueberry.png");
	public static ImageIcon BOISONBERRY = new ImageIcon("Images" + File.separator + "BerryBlast" + File.separator + "Boisonberry.png");
	public static ImageIcon PEACHBERRY = new ImageIcon("Images" + File.separator + "BerryBlast" + File.separator + "Peachberry.png");
	public static ImageIcon RASPBERRY = new ImageIcon("Images" + File.separator + "BerryBlast" + File.separator + "Raspberry.png");
	public static ImageIcon STARBERRY = new ImageIcon("Images" + File.separator + "BerryBlast" + File.separator + "Starberry.png");
	public static ImageIcon STRAWBERRY = new ImageIcon("Images" + File.separator + "BerryBlast" + File.separator + "Strawberry.png");
	
	public static ImageIcon[] berryBlast = {BLACKBERRY, BLUEBERRY, BOISONBERRY, PEACHBERRY, RASPBERRY, STARBERRY, STRAWBERRY};
	
	//ColorShift
	public static ImageIcon BLACKSHIFT = new ImageIcon("Images" + File.separator + "ColorShift" + File.separator + "Black.png");
	public static ImageIcon BLUESHIFT = new ImageIcon("Images" + File.separator + "ColorShift" + File.separator + "Blue.png");
	public static ImageIcon GRAYSHIFT = new ImageIcon("Images" + File.separator + "ColorShift" + File.separator + "Gray.png");
	public static ImageIcon GREENSHIFT = new ImageIcon("Images" + File.separator + "ColorShift" + File.separator + "Green.png");
	public static ImageIcon ORANGESHIFT = new ImageIcon("Images" + File.separator + "ColorShift" + File.separator + "Orange.png");
	public static ImageIcon PINKSHIFT = new ImageIcon("Images" + File.separator + "ColorShift" + File.separator + "Pink.png");
	public static ImageIcon PURPLESHIFT = new ImageIcon("Images" + File.separator + "ColorShift" + File.separator + "Purple.png");
	public static ImageIcon YELLOWSHIFT = new ImageIcon("Images" + File.separator + "ColorShift" + File.separator + "Yellow.png");
	
	public static ImageIcon[] colorShift = {BLACKSHIFT, BLUESHIFT, GRAYSHIFT, GREENSHIFT, ORANGESHIFT, PINKSHIFT, PURPLESHIFT, YELLOWSHIFT};
	
	//Cuppacino
	public static ImageIcon CREME = new ImageIcon("Images" + File.separator + "Cuppacino" + File.separator + "Creme.png");
	public static ImageIcon DARK = new ImageIcon("Images" + File.separator + "Cuppacino" + File.separator + "Dark.png");
	public static ImageIcon FRAPPE = new ImageIcon("Images" + File.separator + "Cuppacino" + File.separator + "Frappe.png");
	public static ImageIcon FRENCH = new ImageIcon("Images" + File.separator + "Cuppacino" + File.separator + "French.png");
	public static ImageIcon FROTH = new ImageIcon("Images" + File.separator + "Cuppacino" + File.separator + "Froth.png");
	public static ImageIcon MILK = new ImageIcon("Images" + File.separator + "Cuppacino" + File.separator + "Milk.png");
	public static ImageIcon MOCHA = new ImageIcon("Images" + File.separator + "Cuppacino" + File.separator + "Mocha.png");
	public static ImageIcon SUGAR = new ImageIcon("Images" + File.separator + "Cuppacino" + File.separator + "Sugar.png");

	public static ImageIcon[] cuppacino = {CREME, DARK, FRAPPE, FRENCH, FROTH, MILK, MOCHA, SUGAR};
	
	//Pastel
	public static ImageIcon BLUEPASTEL = new ImageIcon("Images" + File.separator + "Pastel" + File.separator + "BluePastel.png");
	public static ImageIcon CYANPASTEL = new ImageIcon("Images" + File.separator + "Pastel" + File.separator + "CyanPastel.png");
	public static ImageIcon GREENPASTEL = new ImageIcon("Images" + File.separator + "Pastel" + File.separator + "GreenPastel.png");
	public static ImageIcon PINKPASTEL = new ImageIcon("Images" + File.separator + "Pastel" + File.separator + "PinkPastel.png");
	public static ImageIcon ORANGEPASTEL = new ImageIcon("Images" + File.separator + "Pastel" + File.separator + "OrangePastel.png");
	public static ImageIcon PURPLEPASTEL = new ImageIcon("Images" + File.separator + "Pastel" + File.separator + "PurplePastel.png");
	public static ImageIcon REDPASTEL = new ImageIcon("Images" + File.separator + "Pastel" + File.separator + "RedPastel.png");
	public static ImageIcon YELLOWPASTEL = new ImageIcon("Images" + File.separator + "Pastel" + File.separator + "YellowPastel.png");

	public static ImageIcon[] pastel = {BLUEPASTEL, CYANPASTEL, GREENPASTEL, PINKPASTEL, ORANGEPASTEL, PURPLEPASTEL, REDPASTEL, YELLOWPASTEL};
	
	//Winter
	public static ImageIcon CHOCOLATE = new ImageIcon("Images" + File.separator + "Winter" + File.separator + "Choclate.png");
	public static ImageIcon GRAPE = new ImageIcon("Images" + File.separator + "Winter" + File.separator + "Grape.png");
	public static ImageIcon ICE = new ImageIcon("Images" + File.separator + "Winter" + File.separator + "Ice.png");
	public static ImageIcon MIDNIGHT = new ImageIcon("Images" + File.separator + "Winter" + File.separator + "Midnight.png");

	public static ImageIcon[] winter = {CHOCOLATE, GRAPE, ICE, MIDNIGHT, CHOCOLATE, GRAPE, ICE};
	
	private ImageIcon GamePanelBackground = new ImageIcon("Images" + File.separator + "GameBackground.png");
	
	private HashMap<Brick, JLabel> bricksOnField = new HashMap<Brick, JLabel>();
	private final int aY = 27 - 25;
	private final int aX = 28 - 25;
	private JLabel GamePanel;
	private static int score = 0;
	private JLabel Score;
	private static JLabel splashScreen;
	private static JLabel finalScore;
	
	public GameBoard()
	{
		super();
		this.setBackground(new Color(27, 23, 61));
		this.setLayout(null);
		
		finalScore = new JLabel("00000");
		finalScore.setForeground(new Color (14, 45, 79));
		finalScore.setFont(new Font("Monospaced", Font.BOLD, 40));
		finalScore.setBounds(280, 220, 280, 147);
		finalScore.setVisible(false);
		this.add(finalScore);
		
		splashScreen = new JLabel();
		splashScreen.setBounds(30, 100, 451, 301);
		splashScreen.setIcon(new ImageIcon("Images" + File.separator + "YouWin.png"));
		splashScreen.setVisible(false);
		this.add(splashScreen);
		
		Score = new JLabel(Integer.toString(score));		
		Score.setForeground(new Color (14, 45, 79));
		Score.setFont(new Font("Monospaced", Font.BOLD, 30));
		Score.setBounds(400, 0, 280, 147);
		Score.setVisible(true);
		this.add(Score);
		
		GamePanel = new JLabel();
		GamePanel.setBounds(0,0, 255, 505);
		GamePanel.setIcon(new ImageIcon("Images" + File.separator + "GameBackground.png"));
		
		JLabel ScorePanel = new JLabel("");
		ScorePanel.setForeground(Color.WHITE);
		ScorePanel.setIcon(new ImageIcon("Images" + File.separator + "ScoreBackground.png"));
		ScorePanel.setBounds(new Rectangle(263, 0, 280, 147));
		this.add(ScorePanel);
		
		this.add(Test.GBack);
		
		this.repaint();
	}
	
//	public void paint(Graphics g)
//	{
//		g.drawRect(10, 10, 100, 100);
//	}
	
	public static void displayScore()
	{
		finalScore.setText(Integer.toString(score));
		score = 0;
		finalScore.setVisible(true);
		splashScreen.setVisible(true);
	}
	
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
		this.Score.setText(Integer.toString(score));
		//System.out.println(score);
		repaint();
	}
}
