package Swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import command.ICommand;
import parser.GameParser;


public class Scoreboard extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextPane scorePanel;
	private JTextField inputPanel;
	private JButton inputButton;
	
	private GameParser gameParser;

	/**
	 * Construct the scoreboard frame.
	 */
	
	public Scoreboard(GameParser gameParser) {
		
		this.gameParser = gameParser;
		
		setTitle("Football scoreboard");
		setResizable(false);
		setBounds(350, 350, 700, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		initScorePanel();
		initInputPanel();
		initInputButton();
		
		getContentPane().add(scorePanel);
		getContentPane().add(inputPanel);
		getContentPane().add(inputButton);
		
		//StyledDocument doc = scorePanel.getStyledDocument();
		
		//Append hacks.
		//SimpleAttributeSet keyWord = new SimpleAttributeSet();
		//StyleConstants.setForeground(keyWord, Color.RED);
		//StyleConstants.setBackground(keyWord, Color.YELLOW);
		//StyleConstants.setBold(keyWord, true);
		
		inputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ICommand command = gameParser.parse(inputPanel.getText());
				scorePanel.setText(command.execute());
				inputPanel.setText("");
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initScorePanel() {	
		scorePanel = new JTextPane();
		scorePanel.setText("Welcome!");
		scorePanel.setBounds(50, 35, 600, 150);
		scorePanel.setEditable(false);
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initInputPanel() {
		
		inputPanel = new JTextField();
		inputPanel.setBounds(100, 225, 337, 37);
		inputPanel.setColumns(10);	
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initInputButton() {
		inputButton = new JButton("Submit");
		inputButton.setBounds(500, 228, 111, 30);	
		inputButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	}
}
