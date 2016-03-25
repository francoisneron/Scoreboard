package command;

import java.util.logging.Logger;

import game.IGame;

/**
 * @author FNERON
 * Finish the current game.
 * 
 */
public class StopCommand implements ICommand {
	
	private final static Logger LOGGER = Logger.getLogger(StopCommand.class.getName());
	
	private IGame game;

	public StopCommand(IGame game){
	      this.game = game;
	}
	
	@Override
	public String execute() {
		return game.end();
	}

}
