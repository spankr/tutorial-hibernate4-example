/**
 *
 */
package com.spankr.tutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spankr.tutorial.dao.PartDao;
import com.spankr.tutorial.dao.SupplierDao;
import com.spankr.tutorial.entity.Part;
import com.spankr.tutorial.entity.Supplier;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lee_vettleson
 *
 */
@Controller
public class ExampleController {

    protected static Logger logger = LoggerFactory.getLogger(ExampleController.class);
    @Autowired
    protected SupplierDao suppliers;

    @Autowired
    protected PartDao parts;

    @RequestMapping("/index")
    public String getIndexPage() {
        // populate some suppliers and parts to play with
        Supplier s;
        Part p;

        s = suppliers.get("MacDougals");
        if (s == null) {
            s = new Supplier();
            s.setName("MacDougals");
            suppliers.upsert(s);
            p = new Part();
            p.setMfgNumber("LX-510");
            p.setRohsStatus(1);
            p.setName("Hoop 510");
            p.setSupplier(s);
            parts.upsert(p);

            p = new Part();
            p.setMfgNumber("LX-510B");
            p.setRohsStatus(2);
            p.setName("Lead Hoop 510");
            p.setSupplier(s);
            parts.upsert(p);
        }

        s = suppliers.get("Aveenol");
        if (s == null) {
            s = new Supplier();
            s.setName("Aveenol");
            suppliers.upsert(s);
            p = new Part();
            p.setMfgNumber("XY-109A");
            p.setRohsStatus(1);
            p.setName("Box A");
            p.setSupplier(s);
            parts.upsert(p);

            p = new Part();
            p.setMfgNumber("XY-109B");
            p.setRohsStatus(1);
            p.setName("Box B");
            p.setSupplier(s);
            parts.upsert(p);
        }

        // okay, lets call our index view
        return "index";
    }

    /**
     * Display a listing of suppliers
     * @param m
     * @return 
     */
    @RequestMapping("/suppliers")
    public String getSupplierList(Model m) {
        m.addAttribute("suppliers", suppliers.getAllSuppliers());
        return "suppliers";
    }

    /**
     * Display the details on a specific supplier
     * @param id
     * @param m
     * @return 
     */
    @RequestMapping("/supplier/{id}")
    public String getSupplierById(@PathVariable("id") long id, Model m) {
        Supplier supplier = suppliers.getSupplierWithParts(id);
        logger.debug("Number of parts {}", supplier.getParts().size());
        m.addAttribute("supplier", supplier);
        return "supplier-details";
    }

    /**
     * Display details about a specific part
     * @param id
     * @return 
     */
    @RequestMapping("/part/{id}")
    @ResponseBody
    public String getPartById(@PathVariable("id") long id) {
        Part p = parts.get(id);
        return p.getSupplier().getName();
    }
}
