/**
 *
 */
package com.spankr.tutorial.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author lee_vettleson
 *
 */
@Entity
@Table(name = "ElectronicParts")
public class Part implements Serializable {

    @Id
    @Column(name = "PartId", unique = true, nullable = false)
    private long id;

    @Column(name = "PartNumber")
    private String name;

    @Column(name = "ManufacturerPartNumber")
    private String mfgNumber;

    @Column(name = "RohsCode")
    private int rohsStatus;

    @ManyToOne
    @JoinColumn(name = "MfgId", nullable = false)
    private Supplier supplier;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMfgNumber() {
        return mfgNumber;
    }

    public void setMfgNumber(String mfgNumber) {
        this.mfgNumber = mfgNumber;
    }

    public int getRohsStatus() {
        return rohsStatus;
    }

    public void setRohsStatus(int rohsStatus) {
        this.rohsStatus = rohsStatus;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
