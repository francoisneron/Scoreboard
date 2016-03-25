package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import command.ICommand;
import command.InvalidCommand;
import command.PrintCommand;
import command.ScoreCommand;
import command.StartCommand;
import command.StopCommand;
import game.IGame;

/**
 * @author FNERON
 * Handles parsing from string inputs. Acts as a model.
 * Command and creation factory.
 */
public final class GameParser {
	
	private String awayTeam;
	private String homeTeam;
	
	private String team;
	private int minutes;
	private String player;
	
	private IGame game;
	
	/**
	 * Constructor
	 * @param IGame game
	 */
	public GameParser(IGame game) {
		this.game = game;
	}
	
	/**
	 * Depending inputs handle the creation of commands.
	 * @param String string
	 * @return ICommand command
	 */
	public ICommand parse(String string) {
		if(Pattern.matches("^Start: '(.+)' vs. '(.+)'$", string)) {
			Pattern r = Pattern.compile("Start: '(.+)' vs. '(.+)'$"); 
			
			Matcher m = r.matcher(string);
			
			while (m.find()) {
				awayTeam = m.group(1);
				homeTeam = m.group(2);
			}
			
			return new StartCommand(game, this);
		}
		else if(Pattern.matches("^(\\d+) '(.+)' (.+)$", string)) {
			Pattern pattern = Pattern.compile("(\\d+) '(.+)' (.+)");
			Matcher matcher = pattern.matcher(string);
			
			while (matcher.find()) {
				minutes = Integer.parseInt(matcher.group(1));
				team = matcher.group(2);
				player = matcher.group(3);
			}
			
			return new ScoreCommand(game, this);
		}
		else if(string.equals("print")) {
			return new PrintCommand(game);
		}
		else if(string.equals("end")) {
			return new StopCommand(game);
		}
		else
			return new InvalidCommand(game);
	}
	
	public String getAwayTeam() {
		return awayTeam;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public String getTeam() {
		return team;
	}

	public int getMinutes() {
		return minutes;
	}

	public String getPlayer() {
		return player;
	}
}
