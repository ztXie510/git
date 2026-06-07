package me.spring.service;

import java.util.List;

/**
 * 通用基础服务接口
 * @param <T> 实体类型（需继承 IdEntity）
 */
public interface BaseService<T extends IdEntity> {

    /**
     * 分页查询
     * @param page 页码（从1开始）
     * @param size 每页条数
     * @return 分页数据列表
     */
    List<T> page(int page, int size);

    /**
     * 按编码查询
     * @param code 编码
     * @return 对应实体
     */
    T getByCode(String code);

    /**
     * 新增/修改
     * @param entity 实体对象
     * @return 影响行数
     */
    int update(T entity);

    /**
     * 删除
     * @param id 主键ID
     * @return 影响行数
     */
    int delete(Integer id);

    /**
     * 新增
     * @param entity 实体对象
     * @return 影响行数
     */
    int insert(T entity);

    /**
     * 按ID查询
     * @param id 主键ID
     * @return 对应实体
     */
    T getById(Integer id);

    /**
     * 查询所有
     * @return 全部数据列表
     */
    List<T> list();
}