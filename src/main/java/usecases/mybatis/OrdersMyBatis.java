package usecases.mybatis;


import lombok.Getter;
import lombok.Setter;
import mybatis.dao.MyorderMapper;
import mybatis.model.Myorder;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Model
public class OrdersMyBatis {
    @Inject
    private MyorderMapper myorderMapper;

    @Getter
    @Setter
    private Myorder orderToCreate = new Myorder();

    @Getter
    private List<Myorder> allOrders;

    @PostConstruct
    public void init() {
        allOrders = myorderMapper.selectAll();
    }

    @Transactional
    public String createOrder() {
        orderToCreate.setDate(new Date(System.currentTimeMillis()));
        myorderMapper.insert(orderToCreate);
        return "index?faces-redirect=true";
    }

    @Transactional
    public String removeOrder(Integer orderId) {
        myorderMapper.deleteFromOrderedTrees(orderId);
        myorderMapper.deleteByPrimaryKey(orderId);
        return "index?faces-redirect=true";
    }
}
