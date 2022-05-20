package hr.ntp.resttutory.fields;

import java.sql.Date;

public class Field2 {
    private Long id;
    private String name;

    public Field2(){

    }
    public Field2(Long id, String name) {
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
