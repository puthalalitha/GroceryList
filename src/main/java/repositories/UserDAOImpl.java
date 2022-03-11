package repositories;

import models.User;

import java.sql.*;

/*
* what is JDBC?
*   - Java DataBase Connectivity
*       - allows us to
*
* what is needed to connect to our postgressql database on AWS using JDBC
*   - endpoint (location of our database)
*       - syntax: jdbc:postgresql://[AWS_RDS_ENDPOINT]/[DATABASE_NAME]
*   - username for our aws.database
*   - password our aws database
*   - driver
*
* Interfaces and classes of JDBC
*   -Connection (Interface): active connection
*   - DriverManager: retrieves the connection from our database
*   - Statement : object representation of the sql statement (prevents sql injection)
*       - PreparedStatement : object representation of the
* the most common error I see connectiong
* */
public class UserDAOImpl implements UserDAD{
    String url = "jdbc:postgresql:";
    String username = "postgres";
    String password = "p4ssw0rd";
    @Override
    public User getUserGivenUsername(String username) {
        User user = null;
        try{
            Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
            String sql = "";

            //preparing our sql statement
            PreparedStatement ps = conn.prepareStatement(sql);

            //we are adding the username into the question mark in the sql statement
            ps.setString(parameterIndex:1, username);
            ResultSet rs = ps.excuteQuery();

            while(rs.next()){
                user = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getTimestamp(6));
            }
        }catch (SQLException){
            sqle.printStackTrace();
        }
            return user;
    }

    @Override
    public void createUser(User user) {
        try{
            Connection conn = DriverManager.getConnection((this.url, this.username, this.password));
            String sqql = "";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstname());
            ps.setString(4, user.getLastname());

        }catch (SQLException sqle){

        }
    }
}
