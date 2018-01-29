package edu.psu.behrend.cs.dar5602.homework2.controllers;

import edu.psu.behrend.cs.dar5602.homework2.dtos.UserOrder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;

@RestController
public class UserOrderController {

    private HashMap<Integer, UserOrder> orderHashMap;


    /**
     * Method to get items available to order
     * @return inventory string
     */
    @GetMapping (path = "/inventory")
    public String getInventory(){
        String inventory = "Small Tables; $350" +
                "Large Tables; $750" +
                "Long Tables; $500" +
                "Round Tables; $1000";

        return inventory;
    }


    /**
     * Creates a new order for a new customer
     * @param order order method
     * @return maxKey
     */
    @PostMapping(path = "/createOrder")
    public int createOrder(@RequestParam UserOrder order){
        if(this.orderHashMap.isEmpty()){
            this.orderHashMap = new HashMap<>();
        }

        int maxKey = 0;

        if(!this.orderHashMap.isEmpty()){
            maxKey = Collections.max( this.orderHashMap.keySet() ) + 1;
        }

        this.orderHashMap.put(maxKey, order);

        return maxKey;
    }

    /**
     * Method to update the users order to comply with what they want
     * @param id is the id associated with the user
     * @param order is the new order that they want
     */
    @PutMapping (path = "/updateOrder")
    public void updateOrder(@RequestParam (value = "id") int id, @RequestParam UserOrder order){
        if(this.orderHashMap.containsKey(id)){
            this.orderHashMap.put(id,order);
        }
    }

    /**
     * Method to delete user's order
     * @param id id of the user
     * @param order user's order
     */
    @DeleteMapping (path = "/deleteOrder")
    public void deleteOrder (@RequestParam ("id") int id, @RequestParam UserOrder order){
        if(this.orderHashMap.containsKey(id)){
            this.orderHashMap.remove(id, order);
        }
    }
}
