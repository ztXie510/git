package me.spring.dao;

import me.spring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByLedger_IdAndType(Integer ledgerId, String type);
    List<Category> findByLedger_Id(Integer ledgerId);
    List<Category> findByLedger_IdAndParent_Id(Integer ledgerId, Integer parentId);
}
