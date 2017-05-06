package Draft;

import java.util.*;

public class Team implements Comparable<Team> {

	private String name;
	private int winningPercentage;
	private int rank;
	private List<Player> draftPicks = new ArrayList<Player>();
	
	public Team(String name) {
		super();
		this.setName(name);
	}
	
	public String setName(String name) {
		this.name = name;
		
		return name;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public int setWinningPercentage(int winningPercentage) {
		if (winningPercentage >= 0 && winningPercentage <= 100) {
			this.winningPercentage = winningPercentage;
			return winningPercentage;
		}
		else {
			System.out.println("Error: Winning percentage must be between 0 and 100.");
			return -1;
		}
	}
	
	public int getWinningPercentage() {
		return this.winningPercentage;
	}
	
	public int setRank(int rank) {
		if (rank > 0 && rank < 9) {
			this.rank = rank;
			return rank;
		}
		else {
			System.out.println("Error: Rank must be between 1 and 8.");
			return -1;
		}
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public Player addDraftPick(Player draftPick) {
		if (this.draftPicks.size() <=4) {
			this.draftPicks.add(draftPick);
		}
		else {
			System.out.println("Error: The " + this.name + " have already chosen all four "
					+ "of their draft picks.");
		}
		
		return draftPick;
	}
	
	public Player getDraftPick(int playerIndex) {
		return draftPicks.get(playerIndex);
	}
	
	public int compareTo(Team otherTeam) {
		return Integer.compare(this.getWinningPercentage(), otherTeam.getWinningPercentage());
	}
}
