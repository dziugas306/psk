package usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import mybatis.dao.MyorderMapper;
import mybatis.dao.TreeMapper;
import mybatis.model.Myorder;
import mybatis.model.Tree;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class OrdersDetailedMyBatis {
    @Inject
    TreeMapper treeMapper;

    @Inject
    MyorderMapper orderMapper;

    @Getter
    private List<Tree> allTrees;

    @Getter
    @Setter
    private Myorder order;

    @PostConstruct
    public void init() {
        allTrees = treeMapper.selectAll();
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer orderId = Integer.parseInt(requestParameters.get("orderId"));
        this.order = orderMapper.selectByPrimaryKey(orderId);
    }

    @Transactional
    public String removeTree(Tree tree){
        orderMapper.deleteTreeFromOrder(tree);
        return "orders.xhtml?orderId=" + order.getId() +"&faces-redirect=true";
    }

    @Transactional
    public String addTree(Tree tree){
        orderMapper.insertTreeToOrder(order.getId(), tree.getId());
        return "orders.xhtml?orderId=" + order.getId() +"&faces-redirect=true";
    }
}
