package usecases;

import entinties.Tree;
import lombok.Getter;
import lombok.Setter;
import persistence.TreeDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class TreeDetailed implements Serializable {

    @Inject
    private TreeDAO treeDAO;

    @Setter
    @Getter
    private Tree tree;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer treeId = Integer.parseInt(requestParameters.get("treeId"));
        this.tree = treeDAO.findOne(treeId);
    }

    @Transactional
    public String updateTree(){
        treeDAO.update(tree);
        return "trees.xhtml?treeId=1faces-redirect=true";
    }
}
