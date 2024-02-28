package est.gi.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import est.gi.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
