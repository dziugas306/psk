package usecases.jpa;

import entinties.Tree;
import entinties.TreeSpecies;
import lombok.Getter;
import lombok.Setter;
import persistence.TreeDAO;
import persistence.TreeSpeciesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class TreeSpeciesDetailed {
    @Inject
    TreeSpeciesDAO treeSpeciesDAO;

    @Inject
    TreeDAO treeDAO;

    @Setter
    @Getter
    TreeSpecies treeSpecies;

    @Setter
    @Getter
    Tree treeToCreate = new Tree();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer treeSpeciesId = Integer.parseInt(requestParameters.get("treeSpeciesId"));
        this.treeSpecies = treeSpeciesDAO.findOne(treeSpeciesId);

    }

    @Transactional
    public String updateTreeSpecies() {
        treeSpeciesDAO.update(treeSpecies);
        return "treeSpecies.xhtml?treeSpeciesId=" + treeSpecies.getId() + "faces-redirect=true";
    }

    @Transactional
    public String removeTree(Tree tree){
        treeDAO.remove(tree);
        return "treeSpecies.xhtml?treeSpeciesId=" + treeSpecies.getId() + "faces-redirect=true";
    }

    @Transactional
    public String createTree(){
        treeToCreate.setTreeSpecies(this.treeSpecies);
        treeDAO.save(treeToCreate);
        return "treeSpecies.xhtml?treeSpeciesId=" + treeSpecies.getId() + "faces-redirect=true";
    }

}
