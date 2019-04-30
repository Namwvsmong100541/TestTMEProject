/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tme.project.demo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import tme.project.demo.datasource.ConnectionBuilder;

/**
 *
 * @author LENOVO
 */
public class User {

    static User getStudent(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int id;
    private String name;
    private String surname;
    private long stdId;
    private String gender;
    private String faculty;
    private String email;
    private String username;
    private String password;
    private int position;

    public User() {
    }

    public User(int id, String name, String surname, long stdId, String gender, String faculty, String email, String username, String password, int position) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.stdId = stdId;
        this.gender = gender;
        this.faculty = faculty;
        this.email = email;
        this.username = username;
        this.password = password;
        this.position = position;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getStdId() {
        return this.stdId;
    }

    public void setStdId(long stdId) {
        this.stdId = stdId;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public User id(int id) {
        this.id = id;
        return this;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    public User surname(String surname) {
        this.surname = surname;
        return this;
    }

    public User stdId(long stdId) {
        this.stdId = stdId;
        return this;
    }

    public User gender(String gender) {
        this.gender = gender;
        return this;
    }

    public User faculty(String faculty) {
        this.faculty = faculty;
        return this;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    public User username(String username) {
        this.username = username;
        return this;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    public User position(int position) {
        this.position = position;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && stdId == user.stdId && Objects.equals(gender, user.gender) && Objects.equals(faculty, user.faculty) && Objects.equals(email, user.email) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && position == user.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, stdId, gender, faculty, email, username, password, position);
    }

    @Override
    public String toString() {
        return "{"
                + " id='" + getId() + "'"
                + ", name='" + getName() + "'"
                + ", surname='" + getSurname() + "'"
                + ", stdId='" + getStdId() + "'"
                + ", gender='" + getGender() + "'"
                + ", faculty='" + getFaculty() + "'"
                + ", email='" + getEmail() + "'"
                + ", username='" + getUsername() + "'"
                + ", password='" + getPassword() + "'"
                + ", position='" + getPosition() + "'"
                + "}";
    }

    private static void ORM(User u, ResultSet rs) {
        try {
            u.setId(rs.getInt("user_id"));
            u.setName(rs.getString("user_name"));
            u.setSurname(rs.getString("user_surname"));
            u.setFaculty(rs.getString("user_faculty"));
            u.setEmail(rs.getString("user_email"));
            u.setUsername(rs.getString("user_username"));
            u.setPassword(rs.getString("Password"));
            u.setStdId(rs.getLong("Student_ID"));
            u.setGender(rs.getString("user_gender"));
            u.setPosition(rs.getInt("user_position"));
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public boolean addUser() {
        try {
            Connection conn = ConnectionBuilder.getConnection();
            String sqlCmd = "INSERT INTO Student(user_name, user_surname, user_stdId, user_gender, user_faculty, user_email,"
                    + " user_username, user_password, user_position) VALUES(?,?,?,?,?,?,?,?,?)";
           PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            pstm.setString(1, name);
            pstm.setString(2, surname);
            pstm.setLong(3, stdId);
            pstm.setString(4, gender);
            pstm.setString(5, faculty);
            pstm.setString(6, email);
            pstm.setString(7, username);
            pstm.setString(8, password);
            pstm.setInt(9, position);
            int result = pstm.executeUpdate();
            if (result != 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
       }
        return false;
    }

    public static User getStudent(long stdId) {
        User u = null;
        try {
            Connection conn = ConnectionBuilder.getConnection();
            Statement stmt = conn.createStatement();
            String sqlCmd = "SELECT * FROM `Student` WHERE `Student_ID` = " + stdId;
            ResultSet rs = stmt.executeQuery(sqlCmd);
            while (rs.next()) {
                u = new User();
                ORM(u, rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    public static long getIdByUsername(String username) throws SQLException {
        String sqlCmd = "SELECT `Student_ID` FROM `Student` WHERE `Student_ID` = '" + username + "'";
        Connection conn = ConnectionBuilder.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlCmd);

        long id = 0;

        long stdId = 0;

        if (rs.next()) {

            id = rs.getLong("Student_ID");

            stdId =  rs.getLong("Student_ID");

        }
        return stdId;
    }

//    public static int getPositionByUsername(String username) throws SQLException {
//        String sqlCmd = "SELECT `member_position` FROM `member` WHERE member_username = '" + username + "'";
//        Connection conn = ConnectionBuilder.getConnection();
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery(sqlCmd);
//        int id = 0;
//        if (rs.next()) {
//            id = rs.getInt("user_position");
//        }
//        return id;
//    }

    public static boolean isStudent(String user_username, String user_password) {
        try {
            Connection conn = ConnectionBuilder.getConnection();
            String sqlCmd = "SELECT * FROM `Student` WHERE `Student_ID` = '" + user_username + "' AND `Password` = '"
                    + user_password + "'";
            PreparedStatement ps = conn.prepareStatement(sqlCmd);
            ResultSet rs = ps.executeQuery();
            
            System.out.println("--------------------------");
            System.out.println(rs);
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    
    
    public static boolean isOfficer(String user_username, String user_password) {
        try {
            Connection conn = ConnectionBuilder.getConnection();
            String sqlCmd = "SELECT * FROM `Officer` WHERE `Officer_ID` = '" + user_username + "' AND `Password` = '"
                    + user_password + "'";
            PreparedStatement ps = conn.prepareStatement(sqlCmd);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
        }
    }