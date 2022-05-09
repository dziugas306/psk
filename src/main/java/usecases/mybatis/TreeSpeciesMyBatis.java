package usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import mybatis.dao.TreeMapper;
import mybatis.dao.TreeSpeciesMapper;
import mybatis.model.TreeSpecies;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class TreeSpeciesMyBatis {
    @Inject
    private TreeSpeciesMapper treeSpeciesMapper;

    @Inject
    private TreeMapper treeMapper;

    @Getter
    @Setter
    private TreeSpecies treeSpeciesToCreate = new TreeSpecies();

    @Getter
    private List<TreeSpecies> allTreeSpecies;

    @PostConstruct
    public void init() {
        allTreeSpecies = treeSpeciesMapper.selectAll();
    }

    @Transactional
    public String createTreeSpecies() {
        treeSpeciesMapper.insert(treeSpeciesToCreate);
        return "index?faces-redirect=true";
    }

    @Transactional
    public String removeTreeSpecies(Integer treeSpeciesId) {
        treeMapper.deleteByTreeSpeciesId(treeSpeciesId);
        treeSpeciesMapper.deleteByPrimaryKey(treeSpeciesId);
        return "index?faces-redirect=true";
    }
}
