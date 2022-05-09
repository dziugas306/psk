package usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import mybatis.dao.TreeMapper;
import mybatis.model.Tree;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class TreeDetailedMyBatis {
    @Inject
    private TreeMapper treeMapper;

    @Setter
    @Getter
    private Tree tree;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer treeId = Integer.parseInt(requestParameters.get("treeId"));
        this.tree = treeMapper.selectByPrimaryKey(treeId);
    }

    @Transactional
    public String updateTree(){
        treeMapper.updateByPrimaryKey(tree);
        return "trees.xhtml?treeId=" + tree.getId() + "faces-redirect=true";
    }
}
