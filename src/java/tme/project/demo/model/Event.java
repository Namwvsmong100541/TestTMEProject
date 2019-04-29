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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tme.project.demo.datasource.ConnectionBuilder;

/**
 *
 * @author LENOVO
 */
public class Event {

    private int id;
    private String name;
    private String desc;
    private String place;
    private String phoneNumber;
    private int status;
    private long stdId;

    public Event() {
    }

    public Event(String desc, String phoneNumber, long stdId) {
        this.desc = desc;
        this.phoneNumber = phoneNumber;
        this.stdId = stdId;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getStdId() {
        return stdId;
    }

    public void setStdId(long stdId) {
        this.stdId = stdId;
    }
    
    
    public static Event getEventById(int id) {
        Event e = null;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sqlCmd = "SELECT * FROM Emergency_Notify WHERE event_id = ?";
            PreparedStatement pstm = con.prepareStatement(sqlCmd);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                e = new Event();
                ORM(e, rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    private static void ORM(Event e, ResultSet rs) {
        try {
            e.setId(rs.getInt("event_id"));
            e.setDesc(rs.getString("desc_emergency"));
            e.setPlace(rs.getString("location"));
            e.setStatus(rs.getInt("status_id_fk"));
            e.setStdId(rs.getInt("officer_id_fk"));
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Event> getAllEvents() {
        Event e = null;
        List<Event> events = null;
        try {
            Connection conn = ConnectionBuilder.getConnection();
            Statement stmt = conn.createStatement();
            String sqlCmd = "SELECT * FROM emergency_notify";
            ResultSet rs = stmt.executeQuery(sqlCmd);
            while (rs.next()) {
                e = new Event();
                ORM(e, rs);
                if (events == null) {
                    events = new ArrayList<Event>();
                }
                events.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        return events;
    }

    public static List<Event> getMyEvents(int userId) {
        Event e = null;
        List<Event> events = null;
        try {
            Connection conn = ConnectionBuilder.getConnection();
            Statement stmt = conn.createStatement();
            String sqlCmd = "SELECT * FROM `emergency_notify` WHERE event_id = " + userId;
            ResultSet rs = stmt.executeQuery(sqlCmd);
            while (rs.next()) {
                e = new Event();
                ORM(e, rs);
                if (events == null) {
                    events = new ArrayList<Event>();
                }
                events.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        return events;
    }

    public boolean addEvent() {
        if (desc.length() > 0 && phoneNumber.length() > 0) {
            try {
                Connection conn = ConnectionBuilder.getConnection();
                String sqlCmd = "INSERT INTO Emergency_Notify(Desc_Emergency, Phonenumber,Status_ID,Student_ID) VALUES(?,?,0,?)";
                PreparedStatement pstm = conn.prepareStatement(sqlCmd);
                pstm.setString(1, desc);
                pstm.setString(2, phoneNumber);
                pstm.setLong(3, stdId);
                int result = pstm.executeUpdate();
                if (result != 0) {
                    return true;
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return false;
    }

    public static boolean update(int event_id, int status_id) {
        try {
            Connection conn = ConnectionBuilder.getConnection();
            String sqlCmd = "UPDATE Emergency_Notify SET Status_ID_FK = " + status_id + " WHERE Event_ID = " + event_id;
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            int result = pstm.executeUpdate();
            if (result != 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return false;
    }

    public static Event getEvent(int event_id) {
        Event e = null;
        try {
            Connection conn = ConnectionBuilder.getConnection();
            Statement stmt = conn.createStatement();
            String sqlCmd = "SELECT * FROM Emergency_Notify WHERE Event_ID = " + event_id;
            ResultSet rs = stmt.executeQuery(sqlCmd);
            while (rs.next()) {
                e = new Event();
                ORM(e, rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    public static boolean delete(int event_id) {
        try {
            Connection conn = ConnectionBuilder.getConnection();
            String sqlCmd = "DELETE FROM Emergency_Notify WHERE Event_ID = " + event_id;
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            int result = pstm.executeUpdate();
            if (result != 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return false;

    }

    public String getStatusName() {
        if (status == 0) {
            return "Accepted";
        } else if (status == 1) {
            return "Pending";
        } else if (status == 2) {
            return "Finished";
        }
        return "";
    }
}
