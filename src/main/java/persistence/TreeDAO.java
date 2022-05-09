package persistence;

import entinties.Tree;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TreeDAO {
    @Inject
    private EntityManager em;

    public List<Tree> loadAll() {
        return em.createNamedQuery("Tree.findAll", Tree.class).getResultList();
    }

    public Tree findOne(Integer id) {
        return em.find(Tree.class, id);
    }

    public void save(Tree tree) {
        em.persist(tree);
    }

    public Tree update(Tree tree) {
        return em.merge(tree);
    }

    public void remove(Tree tree) {
        em.remove(tree);
    }

}
