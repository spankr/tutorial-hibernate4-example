/**
 *
 */
package com.spankr.tutorial.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author lee_vettleson
 *
 */
@Entity
@Table(name = "Manufacturers")
public class Supplier implements Serializable {

    @Id
    @Column(name = "MfgId", unique = true, nullable = false)
    private long id;

    @Column(name = "MfgName")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier")
    private List<Part> parts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        if (name == null) {
            return null;
        }
        return name.trim();
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Part> getParts() {
        return parts;
    }
}
