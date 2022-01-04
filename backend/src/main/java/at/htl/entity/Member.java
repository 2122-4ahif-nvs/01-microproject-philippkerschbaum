package at.htl.entity;
import javax.persistence.*;

@Entity(name = "SC_MEMBER")
public class Member {

    @Column(name = "M_FIRSTNAME")
    String firstname;

    @Column(name = "M_LASTNAME")
    String lastname;
    @ManyToOne @JoinColumn(name = "M_TEAM")
    Team team;

    @Column(name = "M_ID")
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
