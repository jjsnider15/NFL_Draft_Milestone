package Draft;

import java.util.*;

public class Player implements Comparable<Player> {
	
	private String name;
	private int round;
	
	public Player(String name, int round) {
		
		this.setName(name);
		this.setRound(round);
	}
	
	public String setName(String name) {
		
		this.name = name;
		
		return name;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public int setRound(int round) {
		this.round = round;
		
		return round;
	}
	
	public int getRound() {
		return this.round;
	}
	
	public int compareTo(Player otherPlayer) {
		return Integer.compare(this.getRound(), otherPlayer.getRound());
	}
}