package model;

public class Team {
    public String name;
    public String teamLogoUrl;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeamLogoUrl() {
		return teamLogoUrl;
	}
	public void setTeamLogoUrl(String teamLogoUrl) {
		this.teamLogoUrl = teamLogoUrl;
	}
	@Override
	public String toString() {
		return "Team [name=" + name + ", teamLogoUrl=" + teamLogoUrl + "]";
	}
    
    

}
