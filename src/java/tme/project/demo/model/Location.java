/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tme.project.demo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import tme.project.demo.datasource.ConnectionBuilder;

/**
 *
 * @author LENOVO
 */
public class Location {

    private String name_of_location;
    private int locationdetail_id;
    private int floor;

    public Location() {
    }

    public String getName_of_location() {
        return name_of_location;
    }

    public void setName_of_location(String name_of_location) {
        this.name_of_location = name_of_location;
    }

    public int getLocationdetail_id() {
        return locationdetail_id;
    }

    public void setLocationdetail_id(int locationdetail_id) {
        this.locationdetail_id = locationdetail_id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Location(int locationdetail_id, int floor) {
        this.locationdetail_id = locationdetail_id;
        this.floor = floor;
    }

    private static void ORM(Location l, ResultSet rs) {
        try {
            l.setLocationdetail_id(rs.getInt("locationdetail_id"));
            l.setName_of_location(rs.getString("name_of_location"));

        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getNameById(int id) throws SQLException {
        String sqlCmd = "SELECT `name_of_location` FROM `location_detail` WHERE locationdetail_id = '" + id + "'";
        Connection conn = ConnectionBuilder.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlCmd);
        String name = "";
        if (rs.next()) {
            name = rs.getString("name_of_location");
        }
        return name;
    }

    public static Location getPlaceById(int locationdetail_id) {
        Location l = null;
        try {
            Connection conn = ConnectionBuilder.getConnection();
            Statement stmt = conn.createStatement();
            String sqlCmd = "SELECT * FROM location_detail WHERE locationdetail_id = " + locationdetail_id;
            ResultSet rs = stmt.executeQuery(sqlCmd);
            while (rs.next()) {
                l = new Location();
                ORM(l, rs);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public static ArrayList<Location> getAllLocation() {
        Location l = null;
        ArrayList<Location> locations = null;
        try {
            Connection conn = ConnectionBuilder.getConnection();
            Statement stmt = conn.createStatement();
            String sqlCmd = "SELECT * FROM location_detail";
            ResultSet rs = stmt.executeQuery(sqlCmd);
            while (rs.next()) {
                l = new Location();
                ORM(l, rs);
                if (locations == null) {
                    locations = new ArrayList<Location>();
                }
                locations.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        return locations;
    }

}
