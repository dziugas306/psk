package persistence;

import entinties.TreeSpecies;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TreeSpeciesDAO {
    @Inject
    private EntityManager em;

    public List<TreeSpecies> loadAll() {
        return em.createNamedQuery("TreeSpecies.findAll", TreeSpecies.class).getResultList();
    }

    public TreeSpecies findOne(Integer id) {
        return em.find(TreeSpecies.class, id);
    }

    public void save(TreeSpecies treeSpecies) {
        em.persist(treeSpecies);
    }

    public TreeSpecies update(TreeSpecies treeSpecies) {
        return em.merge(treeSpecies);
    }

    public void remove(TreeSpecies treeSpecies){
        em.remove(treeSpecies);
    }
}
