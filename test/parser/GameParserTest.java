/**
 * 
 */
package parser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import command.ICommand;
import command.InvalidCommand;
import command.PrintCommand;
import command.ScoreCommand;
import command.StartCommand;
import command.StopCommand;
import game.IGame;

/**
 * @author FNERON
 *
 */
public class GameParserTest {
	
	private final IGame game = Mockito.mock(IGame.class);
	private GameParser gameParser;
	
	/**
	 * String inputs to test.
	 * 1)	Start: '<Name of Home Team>' vs. '<Name of AwayTeam>'
	 * 2)	<minute> '<Team>' <name of scorer>
	 * 3)	print
	 * 4)	end
	 */
	private String startParse;
	private String printParse;
	private String endParse;
	private String scoreParse;
	private String invalidParse;

	@Before
	public void createGameParser() {
		gameParser = new GameParser(game);
		
		startParse = "Start: 'cats' vs. 'bob'";
		printParse = "print";
		endParse = "end";
		scoreParse = "11 'cats' player1";
		invalidParse = "blabla";
	}
	
	@Test
	public void testParserReturnStartCommand() {
		ICommand tested = gameParser.parse(startParse);
		Assert.assertTrue(tested instanceof StartCommand);
	}
	
	@Test
	public void testParserReturnStopCommand() {
		ICommand tested = gameParser.parse(endParse);
		Assert.assertTrue(tested instanceof StopCommand);
	}
	
	@Test
	public void testParserReturnPrintCommand() {
		ICommand tested = gameParser.parse(printParse);
		Assert.assertTrue(tested instanceof PrintCommand);
	}
	
	@Test
	public void testParserReturnScoreCommand() {
		ICommand tested = gameParser.parse(scoreParse);
		Assert.assertTrue(tested instanceof ScoreCommand);
	}
	
	@Test
	public void testParserReturnInvalidCommand() {
		ICommand tested = gameParser.parse(invalidParse);
		Assert.assertTrue(tested instanceof InvalidCommand);
	}

}
