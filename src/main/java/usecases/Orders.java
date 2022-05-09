package usecases;

import entinties.Order;
import lombok.Getter;
import lombok.Setter;
import persistence.OrderDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Model
public class Orders implements Serializable {
    @Inject
    private OrderDAO orderDAO;

    @Getter
    @Setter
    private Order orderToCreate = new Order();

    @Getter
    private List<Order> allOrders;

    @PostConstruct
    public void init() {
        allOrders = orderDAO.loadAll();
    }

    @Transactional
    public String createOrder() {
        orderToCreate.setDate(new Date(System.currentTimeMillis()));
        orderDAO.save(orderToCreate);
        return "index?faces-redirect=true";
    }

    @Transactional
    public String removeOrder(Order order) {
        orderDAO.remove(order);
        return "index?faces-redirect=true";
    }
}
