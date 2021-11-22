package at.htl.control;

import at.htl.entity.Club;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ClubRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Club save(Club club) {
        return em.merge(club);
    }

    @Transactional
    public void delete(Club club){
        Query query = em.createNamedQuery("Club.deleteByName").setParameter("NAME",club.getName());
        query.executeUpdate();
    }

    public List<Club> findAll() {
        return em.createNamedQuery("Club.findAll", Club.class).getResultList();
    }
}
