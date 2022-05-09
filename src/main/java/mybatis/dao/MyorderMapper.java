package mybatis.dao;

import java.util.List;
import mybatis.model.Myorder;
import mybatis.model.Tree;
import org.mybatis.cdi.Mapper;

@Mapper
public interface MyorderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MYORDER
     *
     * @mbg.generated Mon May 09 12:02:09 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MYORDER
     *
     * @mbg.generated Mon May 09 12:02:09 EEST 2022
     */
    int insert(Myorder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MYORDER
     *
     * @mbg.generated Mon May 09 12:02:09 EEST 2022
     */
    Myorder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MYORDER
     *
     * @mbg.generated Mon May 09 12:02:09 EEST 2022
     */
    List<Myorder> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MYORDER
     *
     * @mbg.generated Mon May 09 12:02:09 EEST 2022
     */
    int updateByPrimaryKey(Myorder record);

    //added manually
    int deleteFromOrderedTrees(Integer orderId);

    int insertTreeToOrder(Integer orderId, Integer treeId);

    int deleteTreeFromOrder(Tree tree);
}