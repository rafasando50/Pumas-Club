package api.dto;

public class JugadorDTO {

    private long id;
    private String name;
    private String position;
    private String team;
    private String country;
    private int age;
    private int matches;
    private int goals;

    public JugadorDTO(long id, String name, String position, String team, String country, int age, int matches, int goals) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.team = team;
        this.country = country;
        this.age = age;
        this.matches = matches;
        this.goals = goals;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
