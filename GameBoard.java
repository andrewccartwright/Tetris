package tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard extends JPanel
{
	public GameBoard()
	{
		super();
		this.setBackground(new Color(27, 23, 61));
		this.setLayout(null);
		
		JLabel Score = new JLabel("12345");
		Score.setForeground(new Color (14, 45, 79));
		Score.setFont(new Font("Monospaced", Font.BOLD, 30));
		Score.setBounds(400, 0, 280, 147);
		Score.setVisible(true);
		this.add(Score);
		
		JLabel GamePanel = new JLabel();
		GamePanel.setBounds(0,0, 255, 505);
		GamePanel.setIcon(new ImageIcon("Images\\GameBackground.png"));
		this.add(GamePanel);
		
		JLabel ScorePanel = new JLabel("");
		ScorePanel.setForeground(Color.WHITE);
		ScorePanel.setIcon(new ImageIcon("Images\\ScoreBackground.png"));
		ScorePanel.setBounds(new Rectangle(263, 0, 280, 147));
		this.add(ScorePanel);
		
		this.add(Test.GBack);
	}	
}
