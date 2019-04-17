/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tme.project.demo.model;

import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class Location {

    private String nameOfLocation;
    private int locationId;
    private int floor;

    public Location() {
    }

    public Location(String nameOfLocation, int locationId, int floor) {
        this.nameOfLocation = nameOfLocation;
        this.locationId = locationId;
        this.floor = floor;
    }

    public String getNameOfLocationDetail() {
        return this.nameOfLocation;
    }

    public void setNameOfLocationDetail(String nameOfLocationDetail) {
        this.nameOfLocation = nameOfLocation;
    }

    public int getLocationDetailId() {
        return this.locationId;
    }

    public void setLocationDetailId(int locationDetailId) {
        this.locationId = locationDetailId;
    }

    public int getFloor() {
        return this.floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Location nameOfLocationDetail(String nameOfLocationDetail) {
        this.nameOfLocation = nameOfLocationDetail;
        return this;
    }

    public Location locationDetailId(int locationDetailId) {
        this.locationId = locationId;
        return this;
    }

    public Location floor(int floor) {
        this.floor = floor;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Location)) {
            return false;
        }
        Location location = (Location) o;
        return Objects.equals(nameOfLocation, location.nameOfLocation) && locationId == location.locationId && floor == location.floor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfLocation, locationId, floor);
    }

    @Override
    public String toString() {
        return "{"
                + " nameOfLocationDetail='" + getNameOfLocationDetail() + "'"
                + ", locationDetailId='" + getLocationDetailId() + "'"
                + ", floor='" + getFloor() + "'"
                + "}";
    }
}
