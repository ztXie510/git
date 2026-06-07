package com.example.ffms.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.ffms.entity.LedgerMember;

/**
 * LedgerMember DAO — ledger-member association CRUD.
 * UNIQUE(ledger_id, user_id).
 */
@Mapper
public interface LedgerMemberDao {

    @Insert("INSERT INTO ledger_member (ledger_id, user_id, role, joined_at) " +
            "VALUES (#{ledger.id}, #{user.id}, #{role}, #{joinedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(LedgerMember member);

    @Update("<script>" +
            "UPDATE ledger_member SET 1=1" +
            "<if test='role != null'>, role = #{role}</if>" +
            " WHERE id = #{id}" +
            "</script>")
    int update(LedgerMember member);

    @Delete("DELETE FROM ledger_member WHERE id = #{id}")
    int deleteById(Integer id);

    @Delete("DELETE FROM ledger_member WHERE ledger_id = #{ledgerId} AND user_id = #{userId}")
    int deleteByLedgerAndUser(@Param("ledgerId") Integer ledgerId, @Param("userId") Integer userId);

    @Select("SELECT * FROM ledger_member WHERE id = #{id}")
    LedgerMember selectById(Integer id);

    @Select("SELECT * FROM ledger_member WHERE ledger_id = #{ledgerId}")
    List<LedgerMember> selectByLedgerId(Integer ledgerId);

    @Select("SELECT * FROM ledger_member WHERE user_id = #{userId}")
    List<LedgerMember> selectByUserId(Integer userId);

    @Select("SELECT * FROM ledger_member WHERE ledger_id = #{ledgerId} AND user_id = #{userId}")
    LedgerMember selectByLedgerAndUser(@Param("ledgerId") Integer ledgerId, @Param("userId") Integer userId);

    @Select("<script>" +
            "SELECT * FROM ledger_member WHERE 1=1" +
            "<if test='ledger != null'> AND ledger_id = #{ledger.id}</if>" +
            "<if test='user != null'> AND user_id = #{user.id}</if>" +
            "<if test='role != null'> AND role = #{role}</if>" +
            " ORDER BY joined_at DESC" +
            "</script>")
    List<LedgerMember> selectList(LedgerMember condition);

    @Select("SELECT COUNT(*) FROM ledger_member WHERE ledger_id = #{ledgerId}")
    long countByLedgerId(Integer ledgerId);
}
