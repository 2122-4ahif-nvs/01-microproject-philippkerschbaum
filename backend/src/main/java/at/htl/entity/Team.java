package at.htl.entity;

import javax.persistence.*;

@Entity
public class Team {

    @ManyToOne
    Club club;
    String name;

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
