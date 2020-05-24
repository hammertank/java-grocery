package hammertank.grocery.spring.jpa.dao;

import hammertank.grocery.spring.jpa.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> {

}
