package view;

import java.util.List;

import dao.NBA;
import model.Team;

public class Prueba {

	public static void main(String[] args) {
		List<Team> teams = new NBA().getTeams();
		for (Team team:teams) {
			System.out.println(team.toString());
		}
	}
}
