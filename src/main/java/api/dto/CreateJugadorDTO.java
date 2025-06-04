package api.dto;

import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CreateJugadorDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String position;
    
    private String team;

    @NotBlank
    private String country;

    @Min(16)
    private int age;

    private int matches;
    private int goals;

    private List<String> historyTeams;

    public CreateJugadorDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHistoryTeams() {
        return historyTeams;
    }

    public void setHistoryTeams(List<String> historyTeams) {
        this.historyTeams = historyTeams;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    

}
