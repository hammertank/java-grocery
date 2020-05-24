package hammertank.grocery.spring.jpa.dao;

import hammertank.grocery.spring.TestCase;
import hammertank.grocery.spring.jpa.entity.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.Optional;

@DataJpaTest
public class TestEmployeeDao extends TestCase {

    @Autowired
    private EmployeeDao dao;

    @Test
    public void findById() {
        Employee employee = new Employee();
        employee.setName("hammertank");
        employee.setPhoneNumbers(Arrays.asList("0123456789", "9876543210"));
        Employee persisted = dao.save(employee);
        Assert.assertNotNull("id is null", persisted.getId());
        Optional<Employee> found = dao.findById(persisted.getId());
        Assert.assertTrue(found.isPresent());
        Assert.assertEquals(2, found.get().getPhoneNumbers().size());
    }
}
