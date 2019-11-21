package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private String ConnectString;
    Connection con = null;

    public Database(String ConnectString) {
        this.ConnectString = ConnectString;
    }

    void open() {
        try {
            this.con = DriverManager.getConnection(this.ConnectString);
            System.out.println("Base de Datos abierta");
        } catch (SQLException ex) {
            System.out.println("ERROR: Database::open (SQLException) " + ex.getMessage());
        }
    }

    void close() {
        if (this.con != null) try {
            this.con.close();
            System.out.println("Base de Datos cerrada");
        } catch (SQLException ex) {
            System.out.println("ERROR: Database::close (SQLException) " + ex.getMessage());
        }
    }

    void select() {
        String sql = "SELECT * FROM PEOPLE";
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("ID\tName\tSurname\tDepartment");
            System.out.println("--\t----\t-------\t----------");
            while (rs.next()){
                System.out.println(rs.getInt("ID") + "\t" +
                                   rs.getString("Name") + "\t" +
                                   rs.getString("Surname") + "\t" +
                                   rs.getString("Department"));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: Database::select (SQLException) " + ex.getMessage());
        }
    }

    void insert(Person person) {
        String sql = "INSERT INTO PEOPLE(NAME, SURNAME, DEPARTMENT) VALUES(?,?,?)";
        try {
            PreparedStatement prepared = this.con.prepareStatement(sql);
            prepared.setString(1, person.getName());
            prepared.setString(2, person.getSurname());
            prepared.setString(3, person.getDepartment());
            prepared.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: Database::insert (SQLException) " + ex.getMessage());
        }
    }

}
