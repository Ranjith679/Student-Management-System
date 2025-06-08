import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
    int idStudent;
    String name;
    int age;
    int marks;

    public Student(int idStudent ,String name, int age, int marks) {
        this.idStudent = idStudent;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    //Insertion
   public static boolean addNewStudent(Student student){

        Connection con = null;
        PreparedStatement stmt = null;
        String query = "insert into students(name,age,marks) values (?,?,?)";
        try{
             con = JDBC_Connection.getConnection();
             stmt = con.prepareStatement(query);
            stmt.setString(1,student.name);
            stmt.setInt(2,student.age);
            stmt.setInt(3,student.marks);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }catch(Exception e){
            System.out.println("Insertion Failed" + e.getMessage());
            return false;
        }finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
   }
    // View All students

    public static void viewAllStudents(){
        Connection con = null;
        PreparedStatement stmt = null;
        String query = "select * from students";

        try{
            con = JDBC_Connection.getConnection();
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println("[ Student ID = "+ rs.getInt(1)+" Name = "+ rs.getString(2)+" Age = "+rs.getInt(3)+" Mark = "+rs.getInt(4) +"]" );
            }
        }catch (Exception e){
            System.out.println("Could not fetch records "+ e.getMessage());
        }finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    // Update student Record

    public static void updateStudent(Student student){
        Connection con = null;
        PreparedStatement stmt = null;
        String query = "update students set name = ?, age = ? ,marks = ? where idStudents = ?";

        try{
            con = JDBC_Connection.getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, student.name);
            stmt.setInt(2, student.age);
            stmt.setInt(3, student.marks);
            stmt.setInt(4,student.idStudent);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows >0)
                System.out.println("Updated successful");
            else
                System.out.println("no student id found for " + student.idStudent);
        } catch (Exception e) {
            System.out.println("Cannot Update the record "+ e.getMessage());
        }finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    // delete record

    public static void deleteStudent(int id){
        Connection con = null;
        PreparedStatement stmt = null;
        String query = "delete from students where idStudents = ?";

        try{
            con = JDBC_Connection.getConnection();
            stmt = con.prepareStatement(query);
            stmt.setInt(1,id);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows >0)
                System.out.println("Student has been deleted successfully");
            else
                System.out.println("no student if found for " +id);
        } catch (Exception e) {
            System.out.println("Cannot delete the record the record "+ e.getMessage());
        }finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
