package at.htl.entity;

public class Member {
    String firstname;
    String lastname;
    Team team;

    public Member() {
    }

    public Member(String firstname, String lastname, Team team) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.team = team;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
