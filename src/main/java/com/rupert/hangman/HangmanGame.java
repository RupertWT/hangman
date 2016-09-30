package com.rupert.hangman;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class HangmanGame {

    public static DetailsPanel myPanel;
    public static JLabel label;
    public static JLabel hidans;
    public static String HiddenAnswer = "";
    public static String Answer = "";
    public static int count = 1;
    public static boolean loserGeorgeRules = false;
    public static int consecutiveGuesses = 0;

    public HangmanGame() throws ParseException {
        myPanel = new DetailsPanel();
        JFrame myframe = new JFrame();

        JPanel content = new JPanel(new BorderLayout());
        content.add(new ImagePane());
        
//      Find a word for the game
        gameWord();
       
        content.add(new GuessPane(), BorderLayout.SOUTH);
        content.setBorder(BorderFactory.createTitledBorder("Hangman"));

        myframe.getContentPane().add(content, BorderLayout.CENTER);
        myframe.getContentPane().add(myPanel, BorderLayout.SOUTH);
        myframe.setTitle("Hangman Game");
        myframe.pack();
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setLocationRelativeTo(null);
        myframe.setVisible(true);
    }

	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                try {
                    new HangmanGame();
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public class ImagePane extends JPanel {

        public ImagePane() {
            setLayout(new BorderLayout());
            label = new JLabel();
            add(label);
            try {
                label.setIcon(new ImageIcon(ImageIO.read(HangmanGame.class.getResource("/1.png"))));
            } catch (IOException ex) {
                label.setText("Bad Image");
                ex.printStackTrace();
            }
        }

    }

    public static class GuessPane extends JPanel {

        public GuessPane() {
            hidans = new JLabel(HiddenAnswer);
            add(hidans);	
//          JLabel ans = new JLabel(Answer);
//          add(ans);
        }

    }

    public static class DetailsPanel extends JPanel {

		public DetailsPanel() {
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createTitledBorder(" Click here "));

            JPanel letterPanel = new JPanel(new GridLayout(0, 5));
            for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
                String buttonText = String.valueOf(alphabet);
                
                final JButton letterButton = new JButton(buttonText);
                letterButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent ae) {
                		String actionCommand = ae.getActionCommand();
                        System.out.println("actionCommand is: " + actionCommand);
//                        System.out.println("X is: " + letterButton.getX());
//                        System.out.println("Y is: " + letterButton.getY());
//                		letterButton.setEnabled(false);
                		play(actionCommand);
                     }
                });
                letterPanel.add(letterButton, BorderLayout.CENTER);
            }
            add(letterPanel, BorderLayout.CENTER);
        }

    }
  
    
    
    private static void gameWord() {
        HangmanWords word = new HangmanWords();
		Answer = word.main();
//		Answer = "Awesome";
						
		for(int i = 0; i < Answer.length(); i++) {
			HiddenAnswer = HiddenAnswer + "?";
		}
		
	}  
        
    private static void play(String letter) {	 	
    	HangmanLogic logic = new HangmanLogic();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list = logic.main(Answer, letter);	
    	
    	if (list.size() == 0) {
    		wrongGuess();
    	}
    	
    	if (list.size() > 0) {
	    	for (int i = 0; i < list.size(); i++) {
	    		char c = letter.charAt(0);
	    		
	            StringBuffer buf = new StringBuffer(HiddenAnswer);
	            buf.setCharAt(list.get(i), c);
	            HiddenAnswer = buf.toString();
	    		
	    		hidans.setText(HiddenAnswer);
	    	}
	    	
	    	if (loserGeorgeRules) {
	    		consecutiveGuesses++;
	    		twoConsecutiveGuesses();
	    	}
	    	
    	}
    	
    	if (HiddenAnswer.indexOf("?")==-1) {
    		win();
    	}
    	
    }
    
    private static void twoConsecutiveGuesses() {
    	    	
    	if (consecutiveGuesses == 2) {
    		count = count - 1;
    		
    		if (count < 1) {
    			count = 1;
    		}
    		
        	try {
                label.setIcon(new ImageIcon(ImageIO.read(HangmanGame.class.getResource("/" + count + ".png"))));
            } catch (IOException ex) {
                label.setText("Bad Image");
                ex.printStackTrace();
            }
    		
    	}
    }
    
	private static void wrongGuess() {
		count = count + 1;
		consecutiveGuesses = 0;
    	try {
            label.setIcon(new ImageIcon(ImageIO.read(HangmanGame.class.getResource("/" + count + ".png"))));
        } catch (IOException ex) {
            label.setText("Bad Image");
            ex.printStackTrace();
        }
		
    	if (count == 8) {
    		lose();
    	}
    	
	}

	private static void lose() {
		if(JOptionPane.showConfirmDialog(new JFrame("You lost!"), "You lost fool! The answer was '" + Answer + "'! Do you want to play again?") == JOptionPane.YES_OPTION) {
			reset();
		} else {
			System.exit(0);
		}
	}
	
	private static void win() {
		if(JOptionPane.showConfirmDialog(new JFrame("You won!"), "You won genius! Do you want to play again?") == JOptionPane.YES_OPTION) {
			reset();
		} else {
			System.exit(0);
		}	
	}

	private static void reset() {
		HiddenAnswer = "";
		Answer = "";
		count = 1;
		consecutiveGuesses = 0;
		
		try {
            label.setIcon(new ImageIcon(ImageIO.read(HangmanGame.class.getResource("/1.png"))));
        } catch (IOException ex) {
            label.setText("Bad Image");
            ex.printStackTrace();
        }
		
		gameWord();
		hidans.setText(HiddenAnswer);

	}
    
}