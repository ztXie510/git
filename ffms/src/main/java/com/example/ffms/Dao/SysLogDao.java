package com.example.ffms.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.ffms.entity.SysLog;

/**
 * SysLog DAO — system operation log CRUD for audit trail.
 */
@Mapper
public interface SysLogDao {

    @Insert("INSERT INTO sys_log (username, operation, method, params, ip, create_time, duration, result_status) " +
            "VALUES (#{username}, #{operation}, #{method}, #{params}, #{ip}, #{createTime}, #{duration}, #{resultStatus})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(SysLog log);

    @Insert("<script>" +
            "INSERT INTO sys_log (username, operation, method, params, ip, create_time, duration, result_status) VALUES " +
            "<foreach collection='list' item='log' separator=','>" +
            "(#{log.username}, #{log.operation}, #{log.method}, #{log.params}, #{log.ip}, " +
            "#{log.createTime}, #{log.duration}, #{log.resultStatus})" +
            "</foreach>" +
            "</script>")
    int insertBatch(List<SysLog> logs);

    @Update("<script>" +
            "UPDATE sys_log SET 1=1" +
            "<if test='username != null'>, username = #{username}</if>" +
            "<if test='operation != null'>, operation = #{operation}</if>" +
            "<if test='method != null'>, method = #{method}</if>" +
            "<if test='params != null'>, params = #{params}</if>" +
            "<if test='ip != null'>, ip = #{ip}</if>" +
            "<if test='duration != null'>, duration = #{duration}</if>" +
            "<if test='resultStatus != null'>, result_status = #{resultStatus}</if>" +
            " WHERE id = #{id}" +
            "</script>")
    int update(SysLog log);

    @Delete("DELETE FROM sys_log WHERE id = #{id}")
    int deleteById(Integer id);

    @Delete("DELETE FROM sys_log WHERE create_time &lt; #{before}")
    int deleteOlderThan(java.time.LocalDateTime before);

    @Select("SELECT * FROM sys_log WHERE id = #{id}")
    SysLog selectById(Integer id);

    @Select("<script>" +
            "SELECT * FROM sys_log WHERE 1=1" +
            "<if test='username != null'> AND username = #{username}</if>" +
            "<if test='operation != null'> AND operation LIKE CONCAT('%', #{operation}, '%')</if>" +
            "<if test='method != null'> AND method LIKE CONCAT('%', #{method}, '%')</if>" +
            "<if test='ip != null'> AND ip = #{ip}</if>" +
            "<if test='resultStatus != null'> AND result_status = #{resultStatus}</if>" +
            " ORDER BY create_time DESC" +
            "</script>")
    List<SysLog> selectList(SysLog condition);

    @Select("SELECT COUNT(*) FROM sys_log")
    long count();

    @Select("<script>" +
            "SELECT * FROM sys_log WHERE 1=1" +
            "<if test='username != null'> AND username = #{username}</if>" +
            "<if test='resultStatus != null'> AND result_status = #{resultStatus}</if>" +
            " ORDER BY create_time DESC" +
            " LIMIT #{limit}" +
            "</script>")
    List<SysLog> selectRecent(@Param("username") String username,
                               @Param("resultStatus") String resultStatus,
                               @Param("limit") int limit);
}
