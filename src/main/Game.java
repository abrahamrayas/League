package main;

public class Game {
	
	private Team local;
	private Team visiting;

	public Team getLocal() {
		return local;
	}
	
	public void setLocal(Team local) {
		this.local = local;
	}
	
	public Team getVisiting() {
		return visiting;
	}
	
	public void setVisiting(Team visiting) {
		this.visiting = visiting;
	}
	
	/**
	 * This method execute the game and assign the points for the result
	 */
	public void executeGame() {
		int scoreLocal = local.getScore();
		int scoreVisiting = visiting.getScore();
		if (scoreLocal == scoreVisiting) {
			local.addPoints(1);
			visiting.addPoints(1);
		} else if (scoreLocal > scoreVisiting) {
			local.addPoints(3);
		} else {
			visiting.addPoints(3);
		}
	}
}
