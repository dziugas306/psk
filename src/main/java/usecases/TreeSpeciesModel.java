package usecases;

import entinties.TreeSpecies;
import lombok.Getter;
import lombok.Setter;
import persistence.TreeSpeciesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;


@Model
public class TreeSpeciesModel {
    @Inject
    private TreeSpeciesDAO treeSpeciesDAO;

    @Getter
    @Setter
    private TreeSpecies treeSpeciesToCreate = new TreeSpecies();

    @Getter
    private List<TreeSpecies> allTreeSpecies;

    @PostConstruct
    public void init() {
        allTreeSpecies = treeSpeciesDAO.loadAll();
    }

    @Transactional
    public String createTreeSpecies() {
        treeSpeciesDAO.save(treeSpeciesToCreate);
        return "index?faces-redirect=true";
    }

    @Transactional
    public String removeTreeSpecies(TreeSpecies treeSpecies) {
        treeSpeciesDAO.remove(treeSpecies);
        return "index?faces-redirect=true";
    }
}
