package lt.bit.java2.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Employee {
    private Integer empNo;
    private String firstName;
    private String lastName;
    private String gender;
//    private Date birthDate;
//    private Date hireDate;
    private LocalDate birthDate;
    private LocalDate hireDate;
    public Integer getEmpNo() {
        return empNo;
    }

    public static Employee fromResultSet(ResultSet resultSet) {
        try {
            Employee employee = new Employee();
            employee.setEmpNo(resultSet.getInt("emp_no"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setGender(resultSet.getString("gender"));
            employee.setBirthDate(resultSet.getDate("birth_date").toLocalDate());
            employee.setHireDate(resultSet.getDate("hire_date").toLocalDate());
            return employee;

        } catch (SQLException e) {
            return null;
        }
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}
