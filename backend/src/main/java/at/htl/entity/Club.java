package at.htl.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NamedQueries({
        @NamedQuery(
                name = "Club.findAll",
                query = "select c from SC_CLUB c"
        ),
        @NamedQuery(
                name = "Club.findByName",
                query = "delete from SC_CLUB c where c.name like :NAME"
        )
})
@Entity(name = "SC_CLUB")
public class Club {

    @NotBlank(message="Clubname may not be blank")
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
