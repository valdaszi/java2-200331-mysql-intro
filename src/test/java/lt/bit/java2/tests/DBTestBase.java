package lt.bit.java2.tests;

import lt.bit.java2.services.DBService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.*;
import java.time.LocalDate;

public class DBTestBase {

    @BeforeEach
    void start() throws SQLException {
        // sukurti 14 employee irasus
        // is kuriu 11'as turi tureti 2 salary irasus, o 12'as turi tureti 3
        Connection connection = DBService.getConnectionFromCP();

        Statement stmt = connection.createStatement();
        // stmt.execute("drop table if exists employees");
        stmt.execute(
                "create table employees (" +
                        " emp_no int," +
                        " first_name varchar(14)," +
                        " last_name varchar(16)," +
                        " gender char(1)," +
                        " birth_date date," +
                        " hire_date date" +
                        ")");
//        stmt.execute(
//                "insert into employees values" +
//                        " (1, 'A1', 'B1', 'F', '2000-01-01', '2018-03-01')," +
//                        " (2, 'A2', 'B2', 'M', '2000-01-02', '2018-03-02')," +
//                        " (3, 'A3', 'B3', 'F', '2000-01-03', '2018-03-03')," +
//                        " (4, 'A4', 'B4', 'M', '2000-01-04', '2018-03-04')," +
//                        " (5, 'A5', 'B5', 'F', '2000-01-05', '2018-03-05')," +
//                        " (6, 'A6', 'B6', 'M', '2000-01-06', '2018-03-06')"
//                // TODO pabaigti
//
//        );

        PreparedStatement insertEmployeesStmt = connection.prepareStatement("insert into employees values(?,?,?,?,?,?)");
        for (int i = 0; i < 14; i++) {
            insertEmployeesStmt.setInt(1, i);
            insertEmployeesStmt.setString(2, "A" + i);
            insertEmployeesStmt.setString(3, "B" + i);
            insertEmployeesStmt.setString(4, i % 2 == 0 ? "M" : "F");
            insertEmployeesStmt.setDate(5, Date.valueOf(LocalDate.of(2000, 1, i + 1)));
            insertEmployeesStmt.setDate(5, Date.valueOf(LocalDate.of(2000, 3, i + 1)));
            insertEmployeesStmt.executeUpdate();
        }

        stmt.execute(
                "create table salaries (" +
                        " emp_no int," +
                        " from_date date," +
                        " to_date date," +
                        " salary int" +
                        ")");
        stmt.execute(
                "insert into salaries values" +
                        " (1, '2018-03-01', '9999-01-01', 1500)," +
                        " (11, '2018-03-03', '2018-04-01', 1000)," +
                        " (11, '2018-04-01', '9999-01-01', 2000)," +
                        " (12, '2018-03-04', '2018-05-01', 1100)," +
                        " (12, '2018-05-01', '2020-02-15', 1200)," +
                        " (12, '2020-02-15', '9999-01-01', 1300)"
        );

        connection.close();
    }

    @AfterEach
    void stop() throws SQLException {
        Connection connection = DBService.getConnectionFromCP();
        Statement stmt = connection.createStatement();
        stmt.execute("drop table if exists employees");
        stmt.execute("drop table if exists salaries");
        connection.close();
    }
}
