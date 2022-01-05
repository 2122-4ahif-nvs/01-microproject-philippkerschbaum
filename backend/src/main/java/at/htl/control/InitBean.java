package at.htl.control;

import at.htl.entity.Club;
import at.htl.entity.Team;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class InitBean {

    @Inject
    ClubRepository clubRepository;

    @Inject
    TeamRepository teamRepository;

    void init(@Observes StartupEvent event) {
        Club c = new Club("PSG");
        clubRepository.save(c);

        Team t= new Team(c,"U17");
        teamRepository.save(t);
    }
}
