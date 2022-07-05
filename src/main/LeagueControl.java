package main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeagueControl {
	
	private static List<String> games = new ArrayList<String>();
	
	/**
	 * This method read the file and save each line in a list
	 * @param fileName
	 */
	public static void readGames(String fileName) throws Exception {
		URL file = LeagueControl.class.getResource(fileName);
		if (file == null) {
			throw new Exception("The file [" + fileName + "] is not exist.");
		}
		try (Stream<String> stream = Files.lines(Paths.get(file.toURI()))) {
			games = stream.collect(Collectors.toList());
		} catch (IOException | URISyntaxException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * this method execute the games and execute the method to assign the points for each game
	 * @return List<Team>
	 */
	public static League executeGames() throws Exception {
		League league = new League();
		Map<String, Team> teams = new HashMap();
		games.forEach(gs -> {
			Game game = new Game();
			Team team = new Team();
			boolean isLocalTeam = true;
			Pattern pattern = Pattern.compile("((?=[a-zA-Z]+ *[a-zA-Z]*\\s[\\d]+\\s[\\d]+)[a-zA-Z]+ *[a-zA-Z]*\\s[\\d]+|[a-zA-Z]+ *[a-zA-Z]*)|[\\d]+");
			Matcher m = pattern.matcher(gs);
			String teamName = null;
			while (m.find()) {
				String match = m.group(0).trim();
				if (team.getName() == null) {
					if (teams.size() > 0) {
						if (teams.containsKey(match)) {
							team = teams.get(match);
						}
					}
					teamName = match;
					team.setName(teamName);
				} else {
					team.setScore(Integer.valueOf(match));
					if (isLocalTeam) {
						game.setLocal(team);
						isLocalTeam = false;
						teams.put(teamName, team);
						team = new Team();
					} else {
						game.setVisiting(team);
						teams.put(teamName, team);
					}
				}
			}
			game.executeGame();
		});
		league.setTeams(new ArrayList<>(teams.values()));
		return league;
	}
	
	public static void executeLeague(String fileName) throws Exception {
		LeagueControl.readGames(fileName + ".txt");
		League league = LeagueControl.executeGames();
		List<Team> teams = league.getTeamsPositions();
		AtomicInteger count=new AtomicInteger(1);
		teams.forEach(team -> {
			System.out.println(count.getAndIncrement() + ". " + team.getName() + " - " + team.getPoints());
		});
	}
}
