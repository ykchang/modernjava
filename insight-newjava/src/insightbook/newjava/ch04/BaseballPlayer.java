package insightbook.newjava.ch04;

public class BaseballPlayer implements Comparable<BaseballPlayer> {
	private String teamName;
	private String playerName;
	private String position;
	private int ranking;
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public int getRanking() {
		return ranking;
	}
	
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	@Override
	public int compareTo(BaseballPlayer baseballPlayer) {
		return playerName.compareTo(baseballPlayer.getPlayerName());
	}
}