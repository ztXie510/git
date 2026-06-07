package com.example.ffms.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.ffms.entity.Account;

/**
 * Account DAO — payment account CRUD.
 */
@Mapper
public interface AccountDao {

    @Insert("INSERT INTO account (name, type, balance, currency, icon, ledger_id, is_active, sort_order) " +
            "VALUES (#{name}, #{type}, #{balance}, #{currency}, #{icon}, #{ledger.id}, #{isActive}, #{sortOrder})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Account account);

    @Update("<script>" +
            "UPDATE account SET 1=1" +
            "<if test='name != null'>, name = #{name}</if>" +
            "<if test='type != null'>, type = #{type}</if>" +
            "<if test='balance != null'>, balance = #{balance}</if>" +
            "<if test='currency != null'>, currency = #{currency}</if>" +
            "<if test='icon != null'>, icon = #{icon}</if>" +
            "<if test='ledger != null'>, ledger_id = #{ledger.id}</if>" +
            "<if test='isActive != null'>, is_active = #{isActive}</if>" +
            "<if test='sortOrder != null'>, sort_order = #{sortOrder}</if>" +
            " WHERE id = #{id}" +
            "</script>")
    int update(Account account);

    @Delete("DELETE FROM account WHERE id = #{id}")
    int deleteById(Integer id);

    @Select("SELECT * FROM account WHERE id = #{id}")
    Account selectById(Integer id);

    @Select("SELECT * FROM account WHERE ledger_id = #{ledgerId} ORDER BY sort_order, id")
    List<Account> selectByLedgerId(Integer ledgerId);

    @Select("<script>" +
            "SELECT * FROM account WHERE 1=1" +
            "<if test='name != null'> AND name LIKE CONCAT('%', #{name}, '%')</if>" +
            "<if test='type != null'> AND type = #{type}</if>" +
            "<if test='currency != null'> AND currency = #{currency}</if>" +
            "<if test='ledger != null'> AND ledger_id = #{ledger.id}</if>" +
            "<if test='isActive != null'> AND is_active = #{isActive}</if>" +
            " ORDER BY sort_order, id" +
            "</script>")
    List<Account> selectList(Account condition);

    @Select("SELECT COUNT(*) FROM account WHERE ledger_id = #{ledgerId}")
    long countByLedgerId(Integer ledgerId);

    @Update("UPDATE account SET balance = #{balance} WHERE id = #{id}")
    int updateBalance(@Param("id") Integer id, @Param("balance") java.math.BigDecimal balance);
}
