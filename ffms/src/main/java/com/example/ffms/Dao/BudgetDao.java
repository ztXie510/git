package com.example.ffms.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.ffms.entity.Budget;

/**
 * Budget DAO — monthly spending budget CRUD.
 */
@Mapper
public interface BudgetDao {

    @Insert("INSERT INTO budget (category_id, amount, spent, period_type, start_date, end_date, " +
            "ledger_id, created_by, alert_threshold, created_at, updated_at) " +
            "VALUES (#{category.id}, #{amount}, #{spent}, #{periodType}, #{startDate}, #{endDate}, " +
            "#{ledger.id}, #{createdBy.id}, #{alertThreshold}, #{createdAt}, #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Budget budget);

    @Update("<script>" +
            "UPDATE budget SET updated_at = NOW()" +
            "<if test='category != null'>, category_id = #{category.id}</if>" +
            "<if test='amount != null'>, amount = #{amount}</if>" +
            "<if test='spent != null'>, spent = #{spent}</if>" +
            "<if test='periodType != null'>, period_type = #{periodType}</if>" +
            "<if test='startDate != null'>, start_date = #{startDate}</if>" +
            "<if test='endDate != null'>, end_date = #{endDate}</if>" +
            "<if test='ledger != null'>, ledger_id = #{ledger.id}</if>" +
            "<if test='alertThreshold != null'>, alert_threshold = #{alertThreshold}</if>" +
            " WHERE id = #{id}" +
            "</script>")
    int update(Budget budget);

    @Delete("DELETE FROM budget WHERE id = #{id}")
    int deleteById(Integer id);

    @Select("SELECT * FROM budget WHERE id = #{id}")
    Budget selectById(Integer id);

    @Select("SELECT * FROM budget WHERE ledger_id = #{ledgerId} ORDER BY start_date DESC, id DESC")
    List<Budget> selectByLedgerId(Integer ledgerId);

    @Select("<script>" +
            "SELECT * FROM budget WHERE ledger_id = #{ledgerId}" +
            "<if test='periodType != null'> AND period_type = #{periodType}</if>" +
            "<if test='categoryId != null'> AND category_id = #{categoryId}</if>" +
            " ORDER BY start_date DESC, id DESC" +
            "</script>")
    List<Budget> selectByLedgerAndFilters(@Param("ledgerId") Integer ledgerId,
                                           @Param("periodType") String periodType,
                                           @Param("categoryId") Integer categoryId);

    @Select("<script>" +
            "SELECT * FROM budget WHERE 1=1" +
            "<if test='category != null'> AND category_id = #{category.id}</if>" +
            "<if test='amount != null'> AND amount = #{amount}</if>" +
            "<if test='periodType != null'> AND period_type = #{periodType}</if>" +
            "<if test='ledger != null'> AND ledger_id = #{ledger.id}</if>" +
            "<if test='createdBy != null'> AND created_by = #{createdBy.id}</if>" +
            " ORDER BY start_date DESC, id DESC" +
            "</script>")
    List<Budget> selectList(Budget condition);

    @Select("SELECT COUNT(*) FROM budget WHERE ledger_id = #{ledgerId}")
    long countByLedgerId(Integer ledgerId);

    @Update("UPDATE budget SET spent = #{spent}, updated_at = NOW() WHERE id = #{id}")
    int updateSpent(@Param("id") Integer id, @Param("spent") java.math.BigDecimal spent);
}
