package usecases;

import entinties.Tree;
import lombok.Getter;
import lombok.Setter;
import persistence.TreeDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class Trees implements Serializable {

    @Inject
    private TreeDAO treeDAO;

    @Getter
    @Setter
    private Tree treeToCreate = new Tree();

    @Getter
    private List<Tree> allTrees;

    @PostConstruct
    public void init() {
        allTrees = treeDAO.loadAll();
    }

    @Transactional
    public String createTree() {
        treeDAO.save(treeToCreate);
        return "index?faces-redirect=true";
    }

    @Transactional
    public String removeTree(Tree tree) {
        treeDAO.remove(tree);
        return "index?faces-redirect=true";
    }

}
