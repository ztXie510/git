package com.example.ffms.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.ffms.entity.SysUser;

/**
 * SysUser DAO — user account CRUD.
 */
@Mapper
public interface SysUserDao {

    @Insert("INSERT INTO sys_user (username, password, email, phone, nickname, avatar_url, role, status, created_at, updated_at, last_login_at) " +
            "VALUES (#{username}, #{password}, #{email}, #{phone}, #{nickname}, #{avatarUrl}, #{role}, #{status}, #{createdAt}, #{updatedAt}, #{lastLoginAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(SysUser user);

    @Update("<script>" +
            "UPDATE sys_user SET updated_at = NOW()" +
            "<if test='password != null'>, password = #{password}</if>" +
            "<if test='email != null'>, email = #{email}</if>" +
            "<if test='phone != null'>, phone = #{phone}</if>" +
            "<if test='nickname != null'>, nickname = #{nickname}</if>" +
            "<if test='avatarUrl != null'>, avatar_url = #{avatarUrl}</if>" +
            "<if test='role != null'>, role = #{role}</if>" +
            "<if test='status != null'>, status = #{status}</if>" +
            " WHERE id = #{id}" +
            "</script>")
    int update(SysUser user);

    @Delete("DELETE FROM sys_user WHERE id = #{id}")
    int deleteById(Integer id);

    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    SysUser selectById(Integer id);

    @Select("SELECT * FROM sys_user WHERE username = #{username}")
    SysUser selectByUsername(String username);

    @Select("<script>" +
            "SELECT * FROM sys_user WHERE 1=1" +
            "<if test='username != null'> AND username = #{username}</if>" +
            "<if test='email != null'> AND email = #{email}</if>" +
            "<if test='role != null'> AND role = #{role}</if>" +
            "<if test='status != null'> AND status = #{status}</if>" +
            "<if test='nickname != null'> AND nickname LIKE CONCAT('%', #{nickname}, '%')</if>" +
            " ORDER BY created_at DESC" +
            "</script>")
    List<SysUser> selectList(SysUser condition);

    @Select("SELECT COUNT(*) FROM sys_user")
    long count();
}
