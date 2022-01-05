package at.htl.control;

import at.htl.entity.Team;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TeamRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Team save(Team team){
        return em.merge(team);
    }

    public List<Team> getAll(){
        return em.createNamedQuery("Team.findAll",Team.class).getResultList();
    }

    public Team getTeamByName(String name){
        return em.createNamedQuery("Team.findByName",Team.class)
                .setParameter("TEAMNAME",name)
                .getSingleResult();
    }
}
