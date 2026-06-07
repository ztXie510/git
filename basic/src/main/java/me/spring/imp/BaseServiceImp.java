package me.spring.service.impl;

import me.spring.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * 通用基础服务实现类
 * @param <T> 实体类型
 * @param <D> DAO接口类型
 */
public abstract class BaseServiceImp<T extends IdEntity, D extends BaseDao<T>> implements BaseService<T> {

    // 注入对应的DAO（由子类指定具体实现）
    @Autowired
    protected D dao;

    /**
     * 分页查询（基于PageHelper实现）
     */
    @Override
    public List<T> page(int page, int size) {
        PageHelper.startPage(page, size);
        return dao.list();
    }

    /**
     * 按ID查询
     */
    @Override
    public T getById(Integer id) {
        return dao.getById(id);
    }

    /**
     * 查询所有
     */
    @Override
    public List<T> list() {
        return dao.list();
    }

    /**
     * 新增
     */
    @Override
    public int insert(T entity) {
        return dao.insert(entity);
    }

    /**
     * 修改
     */
    @Override
    public int update(T entity) {
        return dao.update(entity);
    }

    /**
     * 删除
     */
    @Override
    public int delete(Integer id) {
        return dao.delete(id);
    }
}