package main;

public class Team implements Comparable<Team> {
	
	private String name;
	private Integer points = 0;
	private Integer score;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void addPoints(int points) {
		this.points = this.points + points;
	}

	@Override
	public int compareTo(Team o) {
		// TODO Auto-generated method stub
		if (getPoints() == null || o.getPoints() == null) {
			return 0;
	    }
		return o.getPoints().compareTo(getPoints());
	}
}
