package com.example.ffms.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.ffms.entity.TransactionTag;

/**
 * TransactionTag DAO — many-to-many join between transactions and tags.
 * UNIQUE(transaction_id, tag_id).
 */
@Mapper
public interface TransactionTagDao {

    @Insert("INSERT INTO transaction_tag (transaction_id, tag_id) VALUES (#{transaction.id}, #{tag.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TransactionTag tt);

    @Delete("DELETE FROM transaction_tag WHERE id = #{id}")
    int deleteById(Integer id);

    @Delete("DELETE FROM transaction_tag WHERE transaction_id = #{transactionId} AND tag_id = #{tagId}")
    int deleteByTransactionAndTag(@Param("transactionId") Integer transactionId, @Param("tagId") Integer tagId);

    @Delete("DELETE FROM transaction_tag WHERE transaction_id = #{transactionId}")
    int deleteByTransactionId(Integer transactionId);

    @Select("SELECT * FROM transaction_tag WHERE id = #{id}")
    TransactionTag selectById(Integer id);

    @Select("SELECT * FROM transaction_tag WHERE transaction_id = #{transactionId}")
    List<TransactionTag> selectByTransactionId(Integer transactionId);

    @Select("SELECT * FROM transaction_tag WHERE tag_id = #{tagId}")
    List<TransactionTag> selectByTagId(Integer tagId);

    @Select("SELECT COUNT(*) FROM transaction_tag WHERE transaction_id = #{transactionId}")
    long countByTransactionId(Integer transactionId);
}
