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

/**
 * @author lee_vettleson
 *
 */
@Controller
public class ExampleController {

    protected static Logger logger = LoggerFactory.getLogger(ExampleController.class);
    @Autowired
    protected SupplierDao dao;

    @Autowired
    protected PartDao parts;

    @RequestMapping("/index")
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping("/suppliers")
    public String getSupplierList(Model m) {
        m.addAttribute("suppliers", dao.getAllSuppliers());
        return "suppliers";
    }

    @RequestMapping("/supplier/{id}")
    public String getSupplierById(@PathVariable("id") long id, Model m) {
        Supplier supplier = dao.getSupplierWithParts(id);
        logger.debug("Number of parts {}", supplier.getParts().size());
        m.addAttribute("supplier", supplier);
        return "supplier-details";
    }

    @RequestMapping("/part/{id}")
    @ResponseBody
    public String getPartById(@PathVariable("id") long id) {
        Part p = parts.get(id);
        return p.getSupplier().getName();
    }
}
