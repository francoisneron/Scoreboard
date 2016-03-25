package command;

import java.util.logging.Logger;

import game.IGame;
import parser.GameParser;

/**
 * @author FNERON
 * Manage the scoring of the game.
 * 
 */
public class ScoreCommand implements ICommand {
	
	private final static Logger LOGGER = Logger.getLogger(ScoreCommand.class.getName());
	
	private IGame game;
	private GameParser gameParser;

	public ScoreCommand(IGame game,GameParser gameParser){
	      this.game = game;
	      this.gameParser = gameParser;
	}
	
	@Override
	public String execute() {
		return game.score(gameParser.getMinutes(), gameParser.getTeam(), gameParser.getPlayer());
	}

}
