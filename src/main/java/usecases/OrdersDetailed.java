package usecases;

import entinties.Order;
import entinties.Tree;
import lombok.Getter;
import lombok.Setter;
import persistence.OrderDAO;
import persistence.TreeDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class OrdersDetailed {

    @Inject
    TreeDAO treeDAO;

    @Inject
    OrderDAO orderDAO;

    @Getter
    private List<Tree> allTrees;

    @Getter
    @Setter
    private Order order;

    @PostConstruct
    public void init() {
        allTrees = treeDAO.loadAll();
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer orderId = Integer.parseInt(requestParameters.get("orderId"));
        this.order = orderDAO.findOne(orderId);
    }

    @Transactional
    public String removeTree(Tree tree){
        order.getTrees().remove(tree);
        orderDAO.update(order);
        return "orders.xhtml?orderId=" + order.getId() +"&faces-redirect=true";
    }

    @Transactional
    public String addTree(Tree tree){
        order.getTrees().add(tree);
        orderDAO.update(order);
        return "orders.xhtml?orderId=" + order.getId() +"&faces-redirect=true";
    }
}
