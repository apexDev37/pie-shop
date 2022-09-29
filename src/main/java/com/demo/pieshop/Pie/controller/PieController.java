package com.demo.pieshop.Pie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PieController {

    @RequestMapping("/")
    public String getIndexPage() {
        return "index";
    }


    @RequestMapping("/pies")
    public String getPiesPage() {
        return "pies";
    }

    @RequestMapping("/pies-trial")
    public String getPiesTrialPage() {
        return "pies-trial";
    }


    @RequestMapping("/contact")
    public String getContactPage() {
        return "contact";
    }


    @RequestMapping("/order")
    public String getOrderPage() {
        return "order";
    }

    @RequestMapping("/order-status")
    public String getOrderSuccessPage() {
        return "order-status";
    }
}
