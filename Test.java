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

public class Test extends JFrame 
{
	private JLabel menu;
	private JLabel options;
	private JLabel credits;
	private JLabel game;
	public ImageIcon mainmenu = new ImageIcon("Images/MainMenu-01.png");

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
		//game.setIcon(new ImageIcon("C:\\Users\\haile\\Desktop\\Tetris Project workspace\\Images\\MainMenu-01.png"));
		game.setLayout(null);
		
		menu = new JLabel("");
		menu.setIcon(new ImageIcon("C:\\Users\\haile\\Desktop\\Tetris Project workspace\\Images\\MainMenu-01.png"));
		menu.setLayout(null);
		
		options = new JLabel("");
		options.setIcon(new ImageIcon("C:\\Users\\haile\\Desktop\\Tetris Project workspace\\Images\\MenuBackground.png"));
		options.setLayout(null);
		
		credits = new JLabel("");
		credits.setIcon(new ImageIcon("C:\\Users\\haile\\Desktop\\Tetris Project workspace\\Images\\MenuBackground.png"));
		credits.setLayout(null);
		
		setContentPane(menu);
		
		JButton StartButton = new JButton("");
		StartButton.setBorder(null);
		StartButton.setBounds(10, 204, 206, 76);
		StartButton.setIcon(new ImageIcon ("C:\\Users\\haile\\Desktop\\Tetris Project workspace\\Images\\Button-01.png"));
		StartButton.setFocusPainted(false);
		StartButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		StartButton.setContentAreaFilled(false);
		StartButton.addActionListener(new ActionListener()
				{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setContentPane(game);
				resize(550, 600);
				repaint();
				revalidate();
			}
				});
		menu.add(StartButton);
		
		JButton OptionsButton = new JButton("");
		OptionsButton.setBorder(null);
		OptionsButton.setBounds(10, 300, 206, 76);
		OptionsButton.setIcon(new ImageIcon ("C:\\Users\\haile\\Desktop\\Tetris Project workspace\\Images\\Button-01.png"));
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
		CreditsButton.setIcon(new ImageIcon ("C:\\Users\\haile\\Desktop\\Tetris Project workspace\\Images\\Button-01.png"));
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
		Quit.setIcon(new ImageIcon("C:\\Users\\haile\\Desktop\\Tetris Project workspace\\Images\\Button-01.png"));
		Quit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Quit.setFocusPainted(false);
		Quit.setContentAreaFilled(false);
		Quit.addActionListener(new ActionListener()
			{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			//TODO: close the game??
		}
			});
		menu.add(Quit);
		
		JButton GBack = new JButton("");
		GBack.setBorder(null);
		GBack.setBounds(229, 300, 206, 76);
		GBack.setIcon(new ImageIcon("C:\\Users\\haile\\Desktop\\Tetris Project workspace\\Images\\Button-01.png"));
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
		OBack.setIcon(new ImageIcon("C:\\Users\\haile\\Desktop\\Tetris Project workspace\\Images\\Button-01.png"));
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
		CBack.setIcon(new ImageIcon("C:\\Users\\haile\\Desktop\\Tetris Project workspace\\Images\\Button-01.png"));
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
