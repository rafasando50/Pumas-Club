package api.dto;

import java.util.List;

public class UpdateJugadorDTO {
    
    private String name;
    private String position;
    private String team;
    private String country;
    private Integer age;
    private Integer matches;
    private Integer goals;
    private List<String> historyTeams;

    public UpdateJugadorDTO() {

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getMatches() {
        return matches;
    }
    public void setMatches(Integer matches) {
        this.matches = matches;
    }
    public Integer getGoals() {
        return goals;
    }
    public void setGoals(Integer goals) {
        this.goals = goals;
    }
    public List<String> getHistoryTeams() {
        return historyTeams;
    }
    public void setHistoryTeams(List<String> historyTeams) {
        this.historyTeams = historyTeams;
    }
}
