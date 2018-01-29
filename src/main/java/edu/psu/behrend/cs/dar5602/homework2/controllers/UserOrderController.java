package edu.psu.behrend.cs.dar5602.homework2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserOrderController {

    @GetMapping (path = "/createOrder")
    public int createOrder(){


        return 0;
    }
}
