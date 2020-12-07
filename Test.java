package tetris;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.Rectangle;

public class Test extends JFrame 
{
	private JLabel menu;
	private JLabel options;
	private JLabel credits;
	private JLabel game;
	public ImageIcon mainmenu;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Test() 
	{	
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 420);
		setResizable(false);
		
		game = new JLabel("");
		game.setIcon(new ImageIcon("Images\\Background.png"));
		game.setLayout(null);
		
		menu = new JLabel("");
		menu.setIcon(new ImageIcon("Images\\MainMenu-01.png"));
		menu.setLayout(null);
		
		options = new JLabel("");
		options.setIcon(new ImageIcon("Images\\OptionsMenu.png"));
		options.setLayout(null);
		
		credits = new JLabel("");
		credits.setIcon(new ImageIcon("Images\\CreditsMenu.png"));
		credits.setLayout(null);
		
		setContentPane(menu);
		
		JButton StartButton = new JButton("");
		StartButton.setBorder(null);
		StartButton.setBounds(10, 204, 206, 76);
		StartButton.setIcon(new ImageIcon ("Images\\StartButton.png"));
		StartButton.setFocusPainted(false);
		StartButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		StartButton.setContentAreaFilled(false);
		StartButton.addActionListener(new ActionListener()
				{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setContentPane(game);
				resize(540, 542);
				repaint();
				revalidate();
			}
				});
		menu.add(StartButton);
		
		JButton OptionsButton = new JButton("");
		OptionsButton.setBorder(null);
		OptionsButton.setBounds(10, 300, 206, 76);
		OptionsButton.setIcon(new ImageIcon ("Images\\OptButton.png"));
		OptionsButton.setFocusPainted(false);
		OptionsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		OptionsButton.setContentAreaFilled(false);
		OptionsButton.addActionListener(new ActionListener()
				{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setContentPane(options);
				repaint();
				revalidate();
			}
				});
		menu.add(OptionsButton);
		
		JButton CreditsButton = new JButton("");
		CreditsButton.setBorder(null);
		CreditsButton.setBounds(229, 204, 206, 76);
		CreditsButton.setIcon(new ImageIcon ("Images\\CredButton.png"));
		CreditsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CreditsButton.setFocusPainted(false);
		CreditsButton.setContentAreaFilled(false);
		CreditsButton.addActionListener(new ActionListener()
				{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setContentPane(credits);
				repaint();
				revalidate();
			}
				});
		menu.add(CreditsButton);
		
		JButton Quit = new JButton("");
		Quit.setBorder(null);
		Quit.setBounds(229, 300, 206, 76);
		Quit.setIcon(new ImageIcon("Images\\QuitButton.png"));
		Quit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Quit.setFocusPainted(false);
		Quit.setContentAreaFilled(false);
		Quit.addActionListener(new ActionListener()
			{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			System.exit(0);
		}
			});
		menu.add(Quit);
		
		JLabel GamePanel = new JLabel();
		GamePanel.setBounds(0,0, 255, 505);
		GamePanel.setIcon(new ImageIcon("Images\\GameBackground.png"));
		game.add(GamePanel);
		
		JLabel ScorePanel = new JLabel("Current Score");
		ScorePanel.setForeground(Color.WHITE);
		ScorePanel.setIcon(null);
		ScorePanel.setBounds(new Rectangle(255, 0, 280, 150));
		game.add(ScorePanel);
		
		JButton GBack = new JButton("");
		GBack.setBorder(null);
		GBack.setBounds(300, 400, 206, 76);
		GBack.setIcon(new ImageIcon("Images\\BackButton.png"));
		GBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GBack.setFocusPainted(false);
		GBack.setContentAreaFilled(false);
		GBack.addActionListener(new ActionListener()
			{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			setContentPane(menu);
			resize(465, 420);
			repaint();
			revalidate();
		}
			});
		game.add(GBack);
		
		JButton OBack = new JButton("");
		OBack.setBorder(null);
		OBack.setBounds(229, 300, 206, 76);
		OBack.setIcon(new ImageIcon("Images\\BackButton.png"));
		OBack.setContentAreaFilled(false);
		OBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		OBack.setFocusPainted(false);
		OBack.addActionListener(new ActionListener()
			{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			setContentPane(menu);
			resize(465, 420);
			repaint();
			revalidate();
		}
			});
		options.add(OBack);
		
		JButton CBack = new JButton("");
		CBack.setBorder(null);
		CBack.setBounds(229, 300, 206, 76);
		CBack.setIcon(new ImageIcon("Images\\BackButton.png"));
		CBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CBack.setFocusPainted(false);
		CBack.setContentAreaFilled(false);
		CBack.addActionListener(new ActionListener()
			{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			setContentPane(menu);
			resize(465, 420);
			repaint();
			revalidate();
		}
			});
		credits.add(CBack);
	}
}
