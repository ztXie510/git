package me.spring.dao;
import me.spring.entity.AreaSelect;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface AreaSelectDao extends BaseDao<AreaSelect>{

    @Select("SELECT * FROM area_select WHERE code=#{code}")
    AreaSelect getByCode(String code);

    @Select("SELECT * FROM area_select WHERE id = #{id}")
    AreaSelect getById(@Param("id") Integer id);

    @Select("SELECT * FROM area_select")
    List<AreaSelect> list();

    @Insert("INSERT INTO area_select(code,name) VALUES(#{code},#{name})")
    int insert(AreaSelect areaSelect);

    @Update("UPDATE area_select SET code=#{code},name=#{name} WHERE id=#{id}")
    int update(AreaSelect areaSelect);

    @Delete("DELETE FROM area_select WHERE id=#{id}")
    int delete(@Param("id") Integer id);
}