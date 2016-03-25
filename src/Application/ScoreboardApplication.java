package Application;

import Swing.Scoreboard;
import game.Football;
import parser.GameParser;


//TODO Can we handle multiple game at once ?
//TODO Do we have to take for granted that it's a score board only for football?
//TODO Add a timer to end game after 80 minutes. Not specified in problems. (Thread)
//TODO Ask more question about the game definitions (level of abstractions)
//TODO Ask for more corner case and refined current corner case.

/**
 * Develop an application that prints out a scoring dashboard as text during a football match.
 * @author FNERON
 * Possible inputs
 * 1)	Start: '<Name of Home Team>' vs. '<Name of AwayTeam>'
 * 2)	<minute> '<Team>' <name of scorer>
 * 3)	print
 * 4)	end
 */
public class ScoreboardApplication {
	
	public static void main(String[] args) {
		
		Football footBall = new Football();
		GameParser gameParser = new GameParser(footBall);
		
		Scoreboard window = new Scoreboard(gameParser);
		window.setVisible(true);
	}
}
