package hr.ntp.resttutory.ads;

import java.util.List;

public class AdDemand {
    private String user;
    private List<String> fields;
    private String location;

    public AdDemand(){

    }
    public AdDemand(String user, List<String> fields, String location) {
        this.user = user;
        this.fields = fields;
        this.location = location;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "AdDemand{" +
                "user='" + user + '\'' +
                ", fields=" + fields +
                ", location='" + location + '\'' +
                '}';
    }
}
