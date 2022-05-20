package hr.ntp.resttutory.ads;

public class Ad {
    private String title;
    private String field;
    private String info;
    private String location;
    private String price;
    private String user;

    public Ad(){

    }

    public Ad(String title, String field, String info, String location, String price, String user) {
        this.title = title;
        this.field = field;
        this.info = info;
        this.location = location;
        this.price = price;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "title='" + title + '\'' +
                ", field='" + field + '\'' +
                ", info='" + info + '\'' +
                ", location='" + location + '\'' +
                ", price='" + price + '\'' +
                ", user='" + user + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public String getField() {
        return field;
    }

    public String getLocation() {
        return location;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
