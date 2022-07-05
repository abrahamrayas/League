package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import main.League;
import main.LeagueControl;
import main.Team;

class LeagueTest {

	@Test
    public void positionTeamsTest() throws Exception {
		LeagueControl.readGames("games.txt");
		League league = LeagueControl.executeGames();
		List<Team> teams = league.getTeamsPositions();
		
		assertNotNull(teams);
		assertEquals("Tarantulas", teams.get(0).getName());
		assertEquals(6, teams.get(0).getPoints());
		assertEquals("Lions", teams.get(1).getName());
		assertEquals(5, teams.get(1).getPoints());
		assertEquals("FC Awesome", teams.get(2).getName());
		assertEquals(1, teams.get(2).getPoints());
		assertEquals("Snakes", teams.get(3).getName());
		assertEquals(1, teams.get(3).getPoints());
		assertEquals("Grouches", teams.get(4).getName());
		assertEquals(0, teams.get(4).getPoints());
	}
	
	@Test
    public void positionTeams2Test() throws Exception {
		LeagueControl.readGames("games2.txt");
		League league = LeagueControl.executeGames();
		List<Team> teams = league.getTeamsPositions();
		
		assertNotNull(teams);
		assertEquals("Tarantulas", teams.get(0).getName());
		assertEquals(9, teams.get(0).getPoints());
		assertEquals("Lions", teams.get(1).getName());
		assertEquals(6, teams.get(1).getPoints());
		assertEquals("Schalke 04", teams.get(2).getName());
		assertEquals(4, teams.get(2).getPoints());
		assertEquals("Grouches", teams.get(3).getName());
		assertEquals(3, teams.get(3).getPoints());
		assertEquals("FC Awesome", teams.get(4).getName());
		assertEquals(2, teams.get(4).getPoints());
		assertEquals("Snakes", teams.get(5).getName());
		assertEquals(2, teams.get(5).getPoints());
	}
}
