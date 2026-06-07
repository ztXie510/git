package com.example.ffms.Dao;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.ffms.entity.Transaction;

/**
 * Transaction DAO — income/expense record CRUD, the core DAO of FFMS.
 */
@Mapper
public interface TransactionDao {

    @Insert("INSERT INTO transaction (type, amount, category_id, account_id, transaction_date, description, " +
            "created_by, ledger_id, status, created_at, updated_at) " +
            "VALUES (#{type}, #{amount}, #{category.id}, #{account.id}, #{transactionDate}, #{description}, " +
            "#{createdBy.id}, #{ledger.id}, #{status}, #{createdAt}, #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Transaction tx);

    @Update("<script>" +
            "UPDATE transaction SET updated_at = NOW()" +
            "<if test='type != null'>, type = #{type}</if>" +
            "<if test='amount != null'>, amount = #{amount}</if>" +
            "<if test='category != null'>, category_id = #{category.id}</if>" +
            "<if test='account != null'>, account_id = #{account.id}</if>" +
            "<if test='transactionDate != null'>, transaction_date = #{transactionDate}</if>" +
            "<if test='description != null'>, description = #{description}</if>" +
            "<if test='status != null'>, status = #{status}</if>" +
            " WHERE id = #{id}" +
            "</script>")
    int update(Transaction tx);

    @Delete("DELETE FROM transaction WHERE id = #{id}")
    int deleteById(Integer id);

    @Select("SELECT * FROM transaction WHERE id = #{id}")
    Transaction selectById(Integer id);

    @Select("SELECT * FROM transaction WHERE ledger_id = #{ledgerId} ORDER BY transaction_date DESC, id DESC")
    List<Transaction> selectByLedgerId(Integer ledgerId);

    @Select("<script>" +
            "SELECT * FROM transaction WHERE ledger_id = #{ledgerId}" +
            "<if test='type != null'> AND type = #{type}</if>" +
            "<if test='categoryId != null'> AND category_id = #{categoryId}</if>" +
            "<if test='accountId != null'> AND account_id = #{accountId}</if>" +
            "<if test='startDate != null'> AND transaction_date &gt;= #{startDate}</if>" +
            "<if test='endDate != null'> AND transaction_date &lt;= #{endDate}</if>" +
            "<if test='status != null'> AND status = #{status}</if>" +
            " ORDER BY transaction_date DESC, id DESC" +
            "</script>")
    List<Transaction> selectByConditions(@Param("ledgerId") Integer ledgerId,
                                         @Param("type") String type,
                                         @Param("categoryId") Integer categoryId,
                                         @Param("accountId") Integer accountId,
                                         @Param("startDate") LocalDateTime startDate,
                                         @Param("endDate") LocalDateTime endDate,
                                         @Param("status") String status);

    @Select("<script>" +
            "SELECT * FROM transaction WHERE 1=1" +
            "<if test='type != null'> AND type = #{type}</if>" +
            "<if test='amount != null'> AND amount = #{amount}</if>" +
            "<if test='category != null'> AND category_id = #{category.id}</if>" +
            "<if test='account != null'> AND account_id = #{account.id}</if>" +
            "<if test='transactionDate != null'> AND transaction_date = #{transactionDate}</if>" +
            "<if test='ledger != null'> AND ledger_id = #{ledger.id}</if>" +
            "<if test='createdBy != null'> AND created_by = #{createdBy.id}</if>" +
            "<if test='status != null'> AND status = #{status}</if>" +
            " ORDER BY transaction_date DESC, id DESC" +
            "</script>")
    List<Transaction> selectList(Transaction condition);

    @Select("SELECT COUNT(*) FROM transaction WHERE ledger_id = #{ledgerId}")
    long countByLedgerId(Integer ledgerId);

    @Select("<script>" +
            "SELECT SUM(amount) FROM transaction WHERE ledger_id = #{ledgerId} AND type = 'INCOME'" +
            "<if test='startDate != null'> AND transaction_date &gt;= #{startDate}</if>" +
            "<if test='endDate != null'> AND transaction_date &lt;= #{endDate}</if>" +
            "</script>")
    java.math.BigDecimal sumIncomeByLedgerAndPeriod(@Param("ledgerId") Integer ledgerId,
                                                     @Param("startDate") LocalDateTime startDate,
                                                     @Param("endDate") LocalDateTime endDate);

    @Select("<script>" +
            "SELECT SUM(amount) FROM transaction WHERE ledger_id = #{ledgerId} AND type = 'EXPENSE'" +
            "<if test='startDate != null'> AND transaction_date &gt;= #{startDate}</if>" +
            "<if test='endDate != null'> AND transaction_date &lt;= #{endDate}</if>" +
            "</script>")
    java.math.BigDecimal sumExpenseByLedgerAndPeriod(@Param("ledgerId") Integer ledgerId,
                                                      @Param("startDate") LocalDateTime startDate,
                                                      @Param("endDate") LocalDateTime endDate);
}
