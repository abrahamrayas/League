package main;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class League {

	private List<Team> teams;

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	/**
	 * The current method is comparing the points and the names of the teams to show the final table.
	 * @return
	 */
	public List<Team> getTeamsPositions() {
		Comparator<Team> comparator = Comparator.comparing(Team::getPoints)
				.reversed()
				.thenComparing(Team::getName); 
		teams = teams.stream().sorted(comparator).collect(Collectors.toList());
		return teams;
	}
}
