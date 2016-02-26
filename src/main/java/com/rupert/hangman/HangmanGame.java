package com.rupert.hangman;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HangmanGame {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangmanGame window = new HangmanGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public HangmanGame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try{
			Image a = ImageIO.read(HangmanGame.class.getResource("/1.png"));
			Image b = ImageIO.read(HangmanGame.class.getResource("/2.png"));
			Image c = ImageIO.read(HangmanGame.class.getResource("/3.png"));
			Image d = ImageIO.read(HangmanGame.class.getResource("/4.png"));
			Image e = ImageIO.read(HangmanGame.class.getResource("/5.png"));
			Image f = ImageIO.read(HangmanGame.class.getResource("/6.png"));
			Image g = ImageIO.read(HangmanGame.class.getResource("/7.png"));
			Image h = ImageIO.read(HangmanGame.class.getResource("/8.png"));	
			
			JLabel picLabel = new JLabel(new ImageIcon(a.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH)));
						
		}catch(IOException ex) {
			ex.printStackTrace();
		}
 		
	}
	
}
