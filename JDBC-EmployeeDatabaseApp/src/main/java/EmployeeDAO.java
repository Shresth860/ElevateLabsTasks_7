import java.sql.*;
import java.util.*;

public class EmployeeDAO {

    // CREATE
    public void addEmployee(Employee emp) {
        String sql = "INSERT INTO employees (name, age, salary) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emp.getName());
            stmt.setInt(2, emp.getAge());
            stmt.setDouble(3, emp.getSalary());
            stmt.executeUpdate();

            System.out.println("Employee Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ (All Employees)
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getDouble("salary")
                );
                list.add(emp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // UPDATE
    public void updateEmployee(Employee emp) {
        String sql = "UPDATE employees SET name=?, age=?, salary=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emp.getName());
            stmt.setInt(2, emp.getAge());
            stmt.setDouble(3, emp.getSalary());
            stmt.setInt(4, emp.getId());
            stmt.executeUpdate();

            System.out.println("Employee Updated Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Employee Deleted Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
