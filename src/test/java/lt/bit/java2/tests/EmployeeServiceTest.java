package lt.bit.java2.tests;

import lt.bit.java2.model.Employee;
import lt.bit.java2.services.DBService;
import lt.bit.java2.services.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest extends DBTestBase {

    @Test
    void testInitData() throws SQLException {
        Connection connection = DBService.getConnectionFromCP();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT COUNT(*) FROM employees");
        assertTrue(resultSet.next());
        assertEquals(14, resultSet.getInt(1));
        connection.close();
    }

    @Test
    void test() {
        // Page #:         0         1            2
        // Employees:  1-2-3-4-5 6-7-8-9-10 11-12-13-14
        // Salaries:   - - - - - - - - - -  2  3  -  -
        List<Employee> employees = EmployeeService.loadEmployees(2, 5);
        assertNotNull(employees);
        assertEquals(4, employees.size());
        assertNotNull(employees.get(0).getSalaries());
        assertEquals(2, employees.get(0).getSalaries().size());
        assertEquals(3, employees.get(1).getSalaries().size());
    }

    @Test
    void testOk() {
        // visada OK :)
    }
}
