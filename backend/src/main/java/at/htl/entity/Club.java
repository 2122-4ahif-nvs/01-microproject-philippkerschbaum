package at.htl.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "Club.findAll",
                query = "select c from Club c"
        ),
        @NamedQuery(
                name = "Club.deleteByName",
                query = "delete from Club c where c.name like :NAME"
        )
})
@Entity(name = "SC_CLUB")
public class Club {

    @Column(name = "C_NAME")
    String name;

    @Column(name = "C_ID")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    public Club() {
    }
    public Club(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
