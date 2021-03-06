package mybatis.dao;

import java.util.List;
import mybatis.model.Tree;
import org.mybatis.cdi.Mapper;

@Mapper
public interface TreeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TREE
     *
     * @mbg.generated Mon May 09 12:02:09 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TREE
     *
     * @mbg.generated Mon May 09 12:02:09 EEST 2022
     */
    int insert(Tree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TREE
     *
     * @mbg.generated Mon May 09 12:02:09 EEST 2022
     */
    Tree selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TREE
     *
     * @mbg.generated Mon May 09 12:02:09 EEST 2022
     */
    List<Tree> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TREE
     *
     * @mbg.generated Mon May 09 12:02:09 EEST 2022
     */
    int updateByPrimaryKey(Tree record);

    //added manually

    int deleteByTreeSpeciesId(Integer treeSpeciesId);
}