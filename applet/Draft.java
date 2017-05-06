package Draft;

import java.util.*;

public class Draft {
	
	 public static Team[] teams = new Team[8];

	  
	 public static List<Player> players = new ArrayList<Player>();

		
	 public static String[] teamNames = {"Dallas Cowboys", "New England Patriots",
		        "Seattle Seahawks", "Oakland Raiders", "Greenbay Packers",
		        "Pittsburgh Steelers", "San Francisco 49ers", "Denver Broncos"};
	 
	 public static String[] playerNames = {"J.J. Watt", "Aaron Rodgers", 
		        "Tom Brady", "DeMarco Murray", "Peyton Manning", "Calvin Johnson",
		        "Andrew Luck", "Antonio Brown", "Marshawn Lynch", "Rob Gronkowski",
		        "Richard Sherman", "Jamaal Charles", "Julio Jones", "Luke Kuechly", 
		        "Dez Bryant", "Le'Veon Bell", "Darrelle Revis", "Jordy Nelson",
		        "Patrick Peterson", "Demaryius Thomas", "Earl Thomas", 
		        "Russell Wilson", "Joe Haden", "Joe Thomas", "Justin Houston",
		        "Gerald McCoy", "LeSean McCoy", "Drew Brees", "Jimmy Graham", 
		        "Von Miller", "Tony Romo", "Tyron Smith"};
	 
	 public static void main(String[] args) {
		 
		 createTeams();
		 
		 rankTeams();
		 
		 rankPlayers();
		 
		 draftPick();
	 }
	 
	 public static int generateRandomNumber(int upperLimit) {
		 Random randomGenerator = new Random();
		 int randomInt = randomGenerator.nextInt(upperLimit) + 1;
		 
		 return randomInt;
	 }
	 
	 public static int createTeams() {
		 
		 for (int i = 0; i < teams.length; i++) {
			 teams[i] = new Team(teamNames[i]);
		 }
		 
		 return 0;
	 }
	 
	 public static int rankTeams() {
		 
		 for (int i = 0; i < teams.length; i++) {
			 
			 int randomWinningPercentage = generateRandomNumber(100);
			 
			 int winningPercentage = teams[i].setWinningPercentage(randomWinningPercentage);
		 }
		 
		 Arrays.sort(teams);
		 
		 for (int i = 0; i < teams.length; i++) {
			 teams[i].setRank(i + 1);
		 }
		 
		 final Object[][] rankTable = new String[8][3];
		 
		 for(int i = 0; i < teams.length; i++) {
			 rankTable[i] = new String[] {teams[i].getName(), Integer.toString(teams[i].getRank()),
					 Integer.toString(teams[i].getWinningPercentage())};
			 }
		 
		 System.out.println("\nWelcome to the NFL Draft Pick!\n");
	        System.out.println("Here are the statistics, including " +
	            "each team's winning percentage from last season" +
	            " and the corresponding draft rank:\n");

	        System.out.format("%-25s%-5s%-9s\n\n", "TEAM", "RANK", "WINNING %");
	        for (final Object[] row : rankTable) {
	            System.out.format("%-25s%-5s%-9s\n", row);
		 }
	        
	     System.out.println("\n");
	     
	     return 0;
	 }
	 
	 public static int rankPlayers() {
		 
		 List<Integer> roundNumbers = new ArrayList<Integer>();
		 
		 int randomRound = 0;
		 
		 for (int i = 0; i < 8; i++) {
			 roundNumbers.add(1);
			 roundNumbers.add(2);
			 roundNumbers.add(3);
			 roundNumbers.add(4);
		 }
		 
		 for (String playerName : playerNames) {
			 
			 if (roundNumbers.size() > 1) {
				 randomRound = roundNumbers.remove(generateRandomNumber(roundNumbers.size()-1));
			 }
			 else { 
				 randomRound = roundNumbers.remove(0);
			 }
			 
			 players.add(new Player(playerName, randomRound));
		 }
		 
		 Collections.sort(players);
		 
		 final Object [][] playersTable = new String[32][2];
		 
		 for (int i = 0; i < players.size(); i++) {
			 playersTable[i] = new String[] {players.get(i).getName(),
					 Integer.toString(players.get(i).getRound())};
			 }
		 
		 System.out.println("Here are the players' randomly selected draft" +
		            " rounds:\n");
		 
		        System.out.format("%-20s%-5s\n\n", "PLAYER", "ROUND");
				int i = 0;
		        for (final Object[] row : playersTable) {
					if (i > 0 && i % 8 == 0) {
						System.out.println("");
					}
		            System.out.format("%-20s%-5s\n", row);
					i++;
		 }
		        
		 System.out.println("\n");
		 
		 return 0;
	 }
	 
	 public static int draftPick() {
		 
		 for (int round = 1; round <= 4; round++) {
			 for (int index = 7; index >= 0; index--){
				 if (index == 0) {
					 teams[index].addDraftPick(players.remove(index));	 
				 }
				 else {
					 int randomIndex = generateRandomNumber(index);
					 teams[index].addDraftPick(players.remove(randomIndex));
				 }
			 }
		 }
		 System.out.println("Here are the Draft results:\n");
		 
		 System.out.format("%-25s%-20s%-5s\n\n", "TEAM", "PLAYER", "ROUND");
	        
			// Print table of results
			for (int i = 0; i < 4; i++) {
				for (Team team : teams) {
					System.out.format("%-25s%-20s%-5s\n", team.getName(), 
						team.getDraftPick(i).getName(), i+1);
				}
				
				System.out.println("");
			}
			
	        // Print a new line to separate from next section
	        System.out.println("");		
			
			return 0;
	 }
}