/**
 * 
 */
package game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author FNERON
 *
 */
public class FootballTest {
	
	private Football football;

	@Before
	public void createFootball() {
		football = new Football();
	}
	
	@Test
	public void testStartGame() {
		String tested = football.start("bob", "cats");
		String expected = "bob 0 vs. cats 0\n";
		
		Assert.assertEquals(tested, expected);
		Assert.assertEquals(football.getState(), Football.State.START);
	}
	
	@Test
	public void testStopGame() {
		String tested = football.end();
		String expected = "No game currently in progress";
		
		Assert.assertEquals(tested, expected);
		Assert.assertEquals(football.getState(), Football.State.END);
	}
	
	@Test
	public void testPrintGameNoGameStarted() {
		String tested = football.print();
		String expected = "No game currently in progress";
		
		Assert.assertEquals(tested, expected);
	}
	
	@Test
	public void testPrintGame() {
		testStartGame();
		
		String tested = football.print();
		String expected = football.printInfo();
		
		Assert.assertEquals(tested, expected);
	}
	
	@Test
	public void testScoreGameNoGameStarted() {
		String tested = football.score(11, "bob", "player1");
		String expected = "No game currently in progress";
		
		Assert.assertEquals(tested, expected);
		Assert.assertEquals(football.getState(), Football.State.END);
	}
	
	@Test
	public void testScoreGame() {
		testStartGame();
		
		String tested = football.score(11, "bob", "player1");
		String expected = "Goal!!!\n" + football.printInfo();
		
		Assert.assertEquals(tested, expected);
		Assert.assertEquals(football.getState(), Football.State.PLAYING);
	}
	
	@Test
	public void testInvalid() {
		String tested = football.invalid();
		String expected = " 'input error - please start a game through typing 'Start:'<Name of Home Team>' vs. '<Name of Away Team>''.";
		
		Assert.assertEquals(tested, expected);
	}
	
	@Test
	public void testReset() {
		football.reset();
		
		Assert.assertEquals(football.getState(), Football.State.END);
	}
	
	@Test
	public void testPrintInfoNoGameStarted() {
		String tested = football.printInfo();
		String expected = " 0  vs.  0 ";
		
		Assert.assertEquals(tested, expected);
	}
	
	@Test
	public void testPrintInfo() {
		testStartGame();
		testScoreGame();
		
		String tested = football.printInfo();
		String expected = "bob 1 (player1 11') vs. cats 0 ";
		
		Assert.assertEquals(tested, expected);
	}

}
