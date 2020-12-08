package tetris;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class GameBoard extends JPanel
{
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	public GameBoard()
	{
		super();
		this.setBackground(new Color(27, 23, 61));
		this.setLayout(null);
		
		requestFocus();
		
		JLabel GamePanel = new JLabel();
		GamePanel.setBounds(0,0, 255, 505);
		GamePanel.setIcon(new ImageIcon("Images\\GameBackground.png"));
		this.add(GamePanel);
		
		JLabel ScorePanel = new JLabel("Current Score");
		ScorePanel.setForeground(Color.WHITE);
		ScorePanel.setIcon(null);
		ScorePanel.setBounds(new Rectangle(255, 0, 280, 150));
		this.add(ScorePanel);
		
		this.add(Test.GBack);
	}	
}
