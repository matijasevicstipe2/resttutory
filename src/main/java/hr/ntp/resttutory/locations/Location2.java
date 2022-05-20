package hr.ntp.resttutory.locations;

public class Location2 {
    private Long id;
    private String name;

    public Location2(){

    }
    public Location2(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
