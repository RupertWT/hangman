package com.rupert.hangman;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

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
	}

	public void init_icons() {
		
		try{
			Image x = ImageIO.read(HangmanGame.class.getResource("/x.png"));
			Image o = ImageIO.read(HangmanGame.class.getResource("/o.png"));
			
//			xIcon = new ImageIcon(x.getScaledInstance(grid[0].getWidth(), grid[0].getHeight(),Image.SCALE_SMOOTH));
//			oIcon = new ImageIcon(o.getScaledInstance(grid[0].getWidth(), grid[0].getHeight(),Image.SCALE_SMOOTH));
//			
//			for(int i=0; i<9; i++) {
//				if (grid[i].getIcon() != null) 
//						grid[i].setIcon(board[i] == 1 ? xIcon : oIcon);
//			}
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
}
