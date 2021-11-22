package at.htl.control;

import at.htl.entity.Club;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class InitBean {

    @Inject
    ClubRepository clubRepository;

    void init(@Observes StartupEvent event) {
        Club c = new Club("Hofkirchen");
        clubRepository.save(c);
    }
}
