package codegym.nguyenhoangduy_c0324_m4_finalexam.repository;

import codegym.nguyenhoangduy_c0324_m4_finalexam.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
