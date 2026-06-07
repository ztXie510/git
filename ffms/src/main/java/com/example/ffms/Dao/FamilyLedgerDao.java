package com.example.ffms.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.ffms.entity.FamilyLedger;

/**
 * FamilyLedger DAO — family ledger CRUD.
 */
@Mapper
public interface FamilyLedgerDao {

    @Insert("INSERT INTO family_ledger (name, description, created_by, is_default, created_at, updated_at) " +
            "VALUES (#{name}, #{description}, #{createdBy.id}, #{isDefault}, #{createdAt}, #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(FamilyLedger ledger);

    @Update("<script>" +
            "UPDATE family_ledger SET updated_at = NOW()" +
            "<if test='name != null'>, name = #{name}</if>" +
            "<if test='description != null'>, description = #{description}</if>" +
            "<if test='createdBy != null'>, created_by = #{createdBy.id}</if>" +
            "<if test='isDefault != null'>, is_default = #{isDefault}</if>" +
            " WHERE id = #{id}" +
            "</script>")
    int update(FamilyLedger ledger);

    @Delete("DELETE FROM family_ledger WHERE id = #{id}")
    int deleteById(Integer id);

    @Select("SELECT * FROM family_ledger WHERE id = #{id}")
    FamilyLedger selectById(Integer id);

    @Select("<script>" +
            "SELECT * FROM family_ledger WHERE 1=1" +
            "<if test='name != null'> AND name LIKE CONCAT('%', #{name}, '%')</if>" +
            "<if test='description != null'> AND description LIKE CONCAT('%', #{description}, '%')</if>" +
            "<if test='createdBy != null'> AND created_by = #{createdBy.id}</if>" +
            "<if test='isDefault != null'> AND is_default = #{isDefault}</if>" +
            " ORDER BY created_at DESC" +
            "</script>")
    List<FamilyLedger> selectList(FamilyLedger condition);

    @Select("SELECT COUNT(*) FROM family_ledger")
    long count();
}
