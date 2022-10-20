package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.domain.Street;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DirectoryDao {

    private Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jc_student",
                "kirillgromov", "P@ssw0rd");

        return con;
    }

    public List<Street> findStreets(String pattern) throws Exception{

        List<Street> result = new LinkedList<>();
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        String sql = "select street_code, upper(street_name) from jc_street" +
                "where upper(street_name) like upper('%fir%');";
        ResultSet rs = stmt.executeQuery("select * from jc_street");

        while(rs.next()){
            Street str =  new Street(rs.getLong("street_code"), rs.getString("street_name"));
            result.add(str);
        }
        return result;
    }
}