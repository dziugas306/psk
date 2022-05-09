package persistence;

import entinties.Order;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class OrderDAO {
    @Inject
    private EntityManager em;

    public List<Order> loadAll() {
        return em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public Order findOne(Integer id) {
        return em.find(Order.class, id);
    }

    public void save(Order order) {
        em.persist(order);
    }

    public Order update(Order order) {
        return em.merge(order);
    }

    public void remove(Order order){
        em.remove(order);
    }
}
