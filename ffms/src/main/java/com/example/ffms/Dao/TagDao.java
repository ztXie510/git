package com.example.ffms.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.ffms.entity.Tag;

/**
 * Tag DAO — flexible label CRUD.
 */
@Mapper
public interface TagDao {

    @Insert("INSERT INTO tag (name, color, ledger_id, created_by) " +
            "VALUES (#{name}, #{color}, #{ledger.id}, #{createdBy.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Tag tag);

    @Update("<script>" +
            "UPDATE tag SET 1=1" +
            "<if test='name != null'>, name = #{name}</if>" +
            "<if test='color != null'>, color = #{color}</if>" +
            "<if test='ledger != null'>, ledger_id = #{ledger.id}</if>" +
            " WHERE id = #{id}" +
            "</script>")
    int update(Tag tag);

    @Delete("DELETE FROM tag WHERE id = #{id}")
    int deleteById(Integer id);

    @Select("SELECT * FROM tag WHERE id = #{id}")
    Tag selectById(Integer id);

    @Select("SELECT * FROM tag WHERE ledger_id = #{ledgerId} ORDER BY id")
    List<Tag> selectByLedgerId(Integer ledgerId);

    @Select("<script>" +
            "SELECT * FROM tag WHERE 1=1" +
            "<if test='name != null'> AND name LIKE CONCAT('%', #{name}, '%')</if>" +
            "<if test='color != null'> AND color = #{color}</if>" +
            "<if test='ledger != null'> AND ledger_id = #{ledger.id}</if>" +
            "<if test='createdBy != null'> AND created_by = #{createdBy.id}</if>" +
            " ORDER BY id" +
            "</script>")
    List<Tag> selectList(Tag condition);

    @Select("SELECT COUNT(*) FROM tag WHERE ledger_id = #{ledgerId}")
    long countByLedgerId(Integer ledgerId);
}
