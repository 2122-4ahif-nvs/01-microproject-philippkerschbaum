package at.htl.control;

import at.htl.entity.Club;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ClubRepositoryTest {

    @Inject
    ClubRepository clubRepository;

    @Test
    void insertClub_ok(){
        Club club=new Club("Niederneukirchen");

        clubRepository.save(club);
        assertThat(clubRepository.findAll().size()).isEqualTo(2);
    }
    @Test
    void deleteClub_ok(){
        Club club=new Club("Niederneukirchen");
        clubRepository.delete(club);
        assertThat(clubRepository.findAll().size()).isEqualTo(1);
    }
}