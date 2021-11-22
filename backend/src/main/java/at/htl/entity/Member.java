package at.htl.entity;
import javax.persistence.*;

@Entity
public class Member {
    String firstname;
    String lastname;
    @ManyToOne
    Team team;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

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
