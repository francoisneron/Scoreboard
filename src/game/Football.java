package game;

import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

/**
 * @author FNERON
 * Implements the game for a football.
 * 
 */
public class Football implements IGame {
	
	public static enum State {
		START, PLAYING ,END
	}
	
	private final static Logger LOGGER = Logger.getLogger(Football.class.getName());
			
	private String awayTeam;
	private String homeTeam;
	
	private int awayScore;
	private int homeScore;
	
	private Map<Integer, String> goalAwayTeam;
	private Map<Integer, String> goalHomeTeam;
	
	private State state;
	
	/**
	 * Constructor
	 */
	public Football(){
		reset();
	}
	
	/**
	 * Start a new game
	 * @param String awayTeam, String homeTeam
	 * @return String message
	 */
	@Override
	public String start(String awayTeam, String homeTeam) {
		reset();
			
		state = State.START;
		
		this.awayTeam = awayTeam;
		this.homeTeam = homeTeam;
		
		return String.format("%s %d vs. %s %d\n", this.awayTeam, awayScore, this.homeTeam, homeScore);

	}
	
	/**
	 * Print the current game info.
	 * @return String message
	 */
	@Override
	public String print() {
		if (state == State.END) {
			return "No game currently in progress";
		}
		
		return printInfo();
	}
	
	/**
	 * Adds a goal to the game.
	 * @param int minutes, String team, String player
	 * @return String message
	 */
	@Override
	public String score(int minutes, String team, String player) {
		if (state == State.END) {
			return "No game currently in progress";
		}
		
		state = State.PLAYING;
		
		if(this.awayTeam.equals(team)) {
			awayScore++;
			goalAwayTeam.put(minutes, player);
		}
		
		if(this.homeTeam.equals(team)) {
			homeScore++;
			goalHomeTeam.put(minutes, player);
		}
		
		return "Goal!!!\n" + printInfo();
	}
	
	/**
	 * Finish the game.
	 * @return String message
	 */
	@Override
	public String end() {
		if(state == State.END) {
			return "No game currently in progress";
		}

		String info = printInfo();
		
		state = State.END;
		reset();
		
		return "The game has ended!\n" + info;	
	}
	
	/**
	 * Will return the current info on the football game as a String.
	 * TODO: Use the StringBuffer for optimization.
	 * @return String info
	 */
	public String printInfo(){
		
		String string = awayTeam + " " + awayScore + " ";
		
		if (!goalAwayTeam.isEmpty()){
			string += "(";
			for (Map.Entry<Integer, String> entry : goalAwayTeam.entrySet()) {
				string += entry.getValue() + " " + entry.getKey() + "' ";
			}
			string = string.substring(0, string.length() -1);
			string += ")";
		}
		
		string += " vs. " + homeTeam + " " + homeScore + " ";
		
		if (!goalHomeTeam.isEmpty()){
			string += "(";
			for (Map.Entry<Integer, String> entry : goalHomeTeam.entrySet()) {
				string += entry.getValue() + " " + entry.getKey() + "' ";
			}
			string = string.substring(0, string.length() -1);
			string += ")";
		}
		
		return string;
	}
	
	/**
	 * Handles the invalid input on state.
	 * @return String message
	 */
	@Override
	public String invalid() {
		if((state == State.START || state == State.PLAYING )) {
			return " 'input error - please type 'print' for game details'.";
		}
		else
			return " 'input error - please start a game through typing 'Start:'<Name of Home Team>' vs. '<Name of Away Team>''.";
	}
	
	/**
	 * Reset the game to a new one.
	 */
	public void reset() {
		awayTeam = "";
		homeTeam = "";
		awayScore = 0;
		homeScore = 0;
		goalAwayTeam = new TreeMap<Integer, String>();
		goalHomeTeam = new TreeMap<Integer, String>();
		state = State.END;
	}

	public State getState() {
		return state;
	}
}
