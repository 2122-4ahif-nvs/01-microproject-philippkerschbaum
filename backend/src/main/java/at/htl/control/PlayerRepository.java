package at.htl.control;

import at.htl.entity.Player;
import at.htl.entity.Team;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PlayerRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Player save(Player player){
        return em.merge(player);
    }

    public List<Player> getAllPlayersPerTeam(String name){
        return em.createNamedQuery("Player.findAllByTeamName",Player.class)
                .setParameter("TEAMNAME",name)
                .getResultList();
    }
}
