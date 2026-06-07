package com.example.ffms.Dao;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.ffms.entity.Bill;

/**
 * Bill DAO — recurring fixed bill CRUD with reminder support.
 */
@Mapper
public interface BillDao {

    @Insert("INSERT INTO bill (name, amount, due_date, bill_type, status, account_id, ledger_id, " +
            "created_by, paid_at, remind_before, repeat_type, created_at, updated_at) " +
            "VALUES (#{name}, #{amount}, #{dueDate}, #{billType}, #{status}, #{account.id}, #{ledger.id}, " +
            "#{createdBy.id}, #{paidAt}, #{remindBefore}, #{repeatType}, #{createdAt}, #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Bill bill);

    @Update("<script>" +
            "UPDATE bill SET updated_at = NOW()" +
            "<if test='name != null'>, name = #{name}</if>" +
            "<if test='amount != null'>, amount = #{amount}</if>" +
            "<if test='dueDate != null'>, due_date = #{dueDate}</if>" +
            "<if test='billType != null'>, bill_type = #{billType}</if>" +
            "<if test='status != null'>, status = #{status}</if>" +
            "<if test='account != null'>, account_id = #{account.id}</if>" +
            "<if test='paidAt != null'>, paid_at = #{paidAt}</if>" +
            "<if test='remindBefore != null'>, remind_before = #{remindBefore}</if>" +
            "<if test='repeatType != null'>, repeat_type = #{repeatType}</if>" +
            " WHERE id = #{id}" +
            "</script>")
    int update(Bill bill);

    @Delete("DELETE FROM bill WHERE id = #{id}")
    int deleteById(Integer id);

    @Select("SELECT * FROM bill WHERE id = #{id}")
    Bill selectById(Integer id);

    @Select("SELECT * FROM bill WHERE ledger_id = #{ledgerId} ORDER BY due_date ASC, id DESC")
    List<Bill> selectByLedgerId(Integer ledgerId);

    @Select("<script>" +
            "SELECT * FROM bill WHERE ledger_id = #{ledgerId}" +
            "<if test='status != null'> AND status = #{status}</if>" +
            "<if test='billType != null'> AND bill_type = #{billType}</if>" +
            " ORDER BY due_date ASC, id DESC" +
            "</script>")
    List<Bill> selectByLedgerAndFilters(@Param("ledgerId") Integer ledgerId,
                                         @Param("status") String status,
                                         @Param("billType") String billType);

    @Select("SELECT * FROM bill WHERE due_date = #{dueDate} AND status != 'PAID'")
    List<Bill> selectUnpaidByDueDate(LocalDate dueDate);

    @Select("<script>" +
            "SELECT * FROM bill WHERE status != 'PAID' AND due_date BETWEEN #{startDate} AND #{endDate}" +
            " ORDER BY due_date ASC" +
            "</script>")
    List<Bill> selectUnpaidBetweenDates(@Param("startDate") LocalDate startDate,
                                         @Param("endDate") LocalDate endDate);

    @Select("<script>" +
            "SELECT * FROM bill WHERE 1=1" +
            "<if test='name != null'> AND name LIKE CONCAT('%', #{name}, '%')</if>" +
            "<if test='amount != null'> AND amount = #{amount}</if>" +
            "<if test='dueDate != null'> AND due_date = #{dueDate}</if>" +
            "<if test='billType != null'> AND bill_type = #{billType}</if>" +
            "<if test='status != null'> AND status = #{status}</if>" +
            "<if test='account != null'> AND account_id = #{account.id}</if>" +
            "<if test='ledger != null'> AND ledger_id = #{ledger.id}</if>" +
            "<if test='repeatType != null'> AND repeat_type = #{repeatType}</if>" +
            " ORDER BY due_date ASC, id DESC" +
            "</script>")
    List<Bill> selectList(Bill condition);

    @Select("SELECT COUNT(*) FROM bill WHERE ledger_id = #{ledgerId}")
    long countByLedgerId(Integer ledgerId);

    @Update("UPDATE bill SET status = #{status}, updated_at = NOW() WHERE id = #{id}")
    int updateStatus(@Param("id") Integer id, @Param("status") String status);
}
