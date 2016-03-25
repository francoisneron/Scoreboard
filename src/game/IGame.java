package game;

/**
 * @author FNERON
 * Abstraction for any type of game.
 * Basketball, Soccer, etc...
 */
public interface IGame {
	public String start(String awayTeam, String homeTeam);
	public String print();
	public String score(int minute, String team, String player);
	public String end();
	public String invalid();
}
