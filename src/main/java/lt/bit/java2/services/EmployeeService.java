package lt.bit.java2.services;

import lt.bit.java2.model.Employee;

import java.util.List;

public class EmployeeService {

    /**
     * Grazinti employee puslapi
     * @param pageNo puslapio numeris (numeruojame nuo 0)
     * @param pageSize puslapio dydis
     * @return
     */
    public static List<Employee> loadEmployees(int pageNo, int pageSize) {
        // TODO - uzkrauti employee irasus kartu su salary is DB
        return null;
    }


    // SELECT * FROM employees  LIMIT 5 OFFSET 10
    // SELECT * FROM employees  LIMIT 10,5

    // SELECT * FROM employees  LIMIT ? OFFSET ?
    // 1? <= 10
    // 2? <= 5


}
