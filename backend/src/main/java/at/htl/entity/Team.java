package at.htl.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "Team.findByName",
                query = "select t from  SC_TEAM t where t.name=:TEAMNAME"
        ),
        @NamedQuery(
                name = "Team.findAll",
                query = "select t from SC_TEAM t"
        )
})
@Entity(name = "SC_TEAM")
public class Team {


    @JoinColumn(name = "T_CLUB")
    @ManyToOne(cascade = CascadeType.ALL)
    Club club;

    @Column(name = "T_NAME")
    String name;

    @Column(name = "T_ID")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    public Team() {
    }

    public Team(Club club, String name) {
        this.club = club;
        this.name = name;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
