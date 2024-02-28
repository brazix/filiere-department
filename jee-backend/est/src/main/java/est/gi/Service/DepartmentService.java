package est.gi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import est.gi.DAO.DepartmentRepository;
import est.gi.entities.Department;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }
    
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }
    
    public Department updateDepartment(Long id, Department departmentDetails) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (department != null) {
            department.setName(departmentDetails.getName());
            // Mise à jour des autres attributs si nécessaire
            return departmentRepository.save(department);
        }
        return null;
    }
    
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
