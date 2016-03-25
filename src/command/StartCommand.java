package command;

import java.util.logging.Logger;

import game.IGame;
import parser.GameParser;

/**
 * @author FNERON
 * Start a new game.
 * 
 */
public class StartCommand implements ICommand {
	
	private final static Logger LOGGER = Logger.getLogger(StartCommand.class.getName());
	
	private IGame game;
	private GameParser gameParser;
	
	public StartCommand(IGame game, GameParser gameParser){
	      this.game = game;
	      this.gameParser = gameParser;
	}
	
	@Override
	public String execute() {
		return game.start(gameParser.getAwayTeam(), gameParser.getHomeTeam());
	}

}
