package com.bloom.models;



import javax.persistence.*;

/**
 * Created by harshvardhan on 10/07/18.
 */
@Entity
@Table(name = "info")
@NamedQueries({
        @NamedQuery(name = "com.wordpress.nullpointerexception1.info.findAll",
                query = "select e from Info e")
})
public class Info {

    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "empid")
    private String empid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }
}
