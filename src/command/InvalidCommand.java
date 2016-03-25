package command;

import java.util.logging.Logger;

import game.IGame;

/**
 * @author FNERON
 * Invalid command on the game.
 * 
 */
public class InvalidCommand implements ICommand {
	
	private final static Logger LOGGER = Logger.getLogger(InvalidCommand.class.getName());
	
	private IGame game;

	public InvalidCommand(IGame game){
	      this.game = game;
	}
	
	@Override
	public String execute() {
		return game.invalid();
	}

}
