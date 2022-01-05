package at.htl.entity;
import javax.persistence.*;


@NamedQueries({
        @NamedQuery(
                name = "Player.findAllByTeamName",
                query = "select p  from SC_Player p where p.team.name=:TEAMNAME"
        )
})
@Entity(name = "SC_Player")
public class Player {

    @Column(name = "P_FIRSTNAME")
    String firstname;

    @Column(name = "P_LASTNAME")
    String lastname;
    @ManyToOne @JoinColumn(name = "P_TEAM")
    Team team;

    @Column(name = "P_ID")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    public Player() {
    }

    public Player(String firstname, String lastname, Team team) {
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
