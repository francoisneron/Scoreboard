package command;

import java.util.logging.Logger;

import game.IGame;

/**
 * @author FNERON
 * Print command for the current game score. 
 * 
 */
public class PrintCommand implements ICommand {
	
	private final static Logger LOGGER = Logger.getLogger(PrintCommand.class.getName());

	private IGame game;

	public PrintCommand(IGame game){
	      this.game = game;
	}
	
	@Override
	public String execute() {
		return game.print();
	}

}
