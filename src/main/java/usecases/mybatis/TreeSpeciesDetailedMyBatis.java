package usecases.mybatis;


import lombok.Getter;
import lombok.Setter;
import mybatis.dao.TreeMapper;
import mybatis.dao.TreeSpeciesMapper;
import mybatis.model.Tree;
import mybatis.model.TreeSpecies;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class TreeSpeciesDetailedMyBatis {
    @Inject
    TreeSpeciesMapper treeSpeciesMapper;

    @Inject
    TreeMapper treeMapper;

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
        this.treeSpecies = treeSpeciesMapper.selectByPrimaryKey(treeSpeciesId);

    }

    @Transactional
    public String updateTreeSpecies() {
        treeSpeciesMapper.updateByPrimaryKey(treeSpecies);
        return "treeSpecies.xhtml?treeSpeciesId=" + treeSpecies.getId() + "faces-redirect=true";
    }

    @Transactional
    public String removeTree(Tree tree){
        treeMapper.deleteByPrimaryKey(tree.getId());
        return "treeSpecies.xhtml?treeSpeciesId=" + treeSpecies.getId() + "faces-redirect=true";
    }

    @Transactional
    public String createTree(){
        treeToCreate.setTreeSpeciesId(treeSpecies.getId());
        treeMapper.insert(treeToCreate);
        return "treeSpecies.xhtml?treeSpeciesId=" + treeSpecies.getId() + "faces-redirect=true";
    }
}
