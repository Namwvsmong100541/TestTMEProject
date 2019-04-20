/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tme.project.demo.datasource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionBuilder {

    public static Connection mainConnection = null;

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Properties property = new Properties();
            property.put("user", "root");
            property.put("password", "tme123456");
            property.put("useEncoding", "true");
            property.put("characterEncoding", "UTF-8");
            con = DriverManager.getConnection("jdbc:mariadb://35.240.139.209/tell_me_emergency?useUnicode=yes&amp;characterEncoding=utf8", property);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
