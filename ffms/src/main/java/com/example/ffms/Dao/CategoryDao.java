package com.example.ffms.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.ffms.entity.Category;

/**
 * Category DAO — income/expense category CRUD.
 */
@Mapper
public interface CategoryDao {

    @Insert("INSERT INTO category (name, type, icon, parent_id, color, ledger_id, sort_order, is_system) " +
            "VALUES (#{name}, #{type}, #{icon}, #{parent.id}, #{color}, #{ledger.id}, #{sortOrder}, #{isSystem})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Category category);

    @Update("<script>" +
            "UPDATE category SET 1=1" +
            "<if test='name != null'>, name = #{name}</if>" +
            "<if test='type != null'>, type = #{type}</if>" +
            "<if test='icon != null'>, icon = #{icon}</if>" +
            "<if test='parent != null'>, parent_id = #{parent.id}</if>" +
            "<if test='color != null'>, color = #{color}</if>" +
            "<if test='ledger != null'>, ledger_id = #{ledger.id}</if>" +
            "<if test='sortOrder != null'>, sort_order = #{sortOrder}</if>" +
            "<if test='isSystem != null'>, is_system = #{isSystem}</if>" +
            " WHERE id = #{id}" +
            "</script>")
    int update(Category category);

    @Delete("DELETE FROM category WHERE id = #{id}")
    int deleteById(Integer id);

    @Select("SELECT * FROM category WHERE id = #{id}")
    Category selectById(Integer id);

    @Select("SELECT * FROM category WHERE ledger_id = #{ledgerId} ORDER BY sort_order, id")
    List<Category> selectByLedgerId(Integer ledgerId);

    @Select("SELECT * FROM category WHERE ledger_id = #{ledgerId} AND type = #{type} ORDER BY sort_order, id")
    List<Category> selectByLedgerAndType(@Param("ledgerId") Integer ledgerId, @Param("type") String type);

    @Select("SELECT * FROM category WHERE parent_id = #{parentId} ORDER BY sort_order, id")
    List<Category> selectByParentId(Integer parentId);

    @Select("<script>" +
            "SELECT * FROM category WHERE 1=1" +
            "<if test='name != null'> AND name LIKE CONCAT('%', #{name}, '%')</if>" +
            "<if test='type != null'> AND type = #{type}</if>" +
            "<if test='parent != null'> AND parent_id = #{parent.id}</if>" +
            "<if test='ledger != null'> AND ledger_id = #{ledger.id}</if>" +
            "<if test='isSystem != null'> AND is_system = #{isSystem}</if>" +
            " ORDER BY sort_order, id" +
            "</script>")
    List<Category> selectList(Category condition);

    @Select("SELECT COUNT(*) FROM category WHERE ledger_id = #{ledgerId}")
    long countByLedgerId(Integer ledgerId);
}
