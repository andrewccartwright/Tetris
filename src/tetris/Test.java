package tetris;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import tetris.mechanics.GameOptions;
import tetris.mechanics.PlayingField;

public class Test extends JFrame
{
	private JLabel menu;
	private JLabel options;
	private JLabel credits;
	private GameBoard game;
	static JButton GBack;
	public ImageIcon mainmenu;
	boolean gameOn = false;
	public Clip clip;

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

	public Test() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		AudioInputStream audio = AudioSystem.getAudioInputStream(new File("Music\\song.wav"));
		clip = AudioSystem.getClip();
		clip.open(audio);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 420);
		setResizable(false);
		setFocusable(true);
		addKeyListener(new KeyListener()
				{
			@Override
			public void keyTyped(KeyEvent e)
			{
				if(gameOn)
					if (e.getKeyCode() == KeyEvent.VK_S)
						System.out.println("TEST");
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(gameOn)
				{
					if (e.getKeyCode() == KeyEvent.VK_S)
						GameOptions.mainGame.moveDown();
					if (e.getKeyCode() == KeyEvent.VK_A)
						GameOptions.mainGame.currentShape.moveLeft();
					if (e.getKeyCode() == KeyEvent.VK_D)
						GameOptions.mainGame.currentShape.moveRight();
					if (e.getKeyCode() == KeyEvent.VK_RIGHT)
						GameOptions.mainGame.currentShape.rotateRight();
					if (e.getKeyCode() == KeyEvent.VK_LEFT)
						GameOptions.mainGame.currentShape.rotateLeft();
				}
			}
			@Override
			public void keyReleased(KeyEvent e){}
				});
		
		GBack = new JButton("");
		GBack.setBorder(null);
		GBack.setBounds(290, 400, 206, 76);
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
			setSize(465, 420);
			repaint();
			revalidate();
			gameOn = false;
		}
			});
		
		game = new GameBoard();
		
		menu = new JLabel("");
		menu.setIcon(new ImageIcon("Images\\MainMenu-01.png"));
		menu.setLayout(null);
		menu.setFocusable(false);
		
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
				game = new GameBoard();
				setSize(540, 540);
				setContentPane(game);
				repaint();
				revalidate();
				gameOn = true;
				clip.start();
				start();
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
			setSize(465, 420);
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
			setSize(465, 420);
			repaint();
			revalidate();
		}
			});
		credits.add(CBack);
	}
	
	public void start()
	{
		GameOptions.mainGame = new PlayingField(this);
	}
	
	public void end()
	{
		setContentPane(menu);
		setSize(465, 420);
		repaint();
		revalidate();
		gameOn = false;
	}
	
	public void deleteBricks()
	{
		
	}
	
	public GameBoard getGameBoard() {return game;}
}
