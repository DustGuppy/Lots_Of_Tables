package edu.psu.behrend.cs.dar5602.homework2.controllers;

import edu.psu.behrend.cs.dar5602.homework2.dtos.UserOrder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;

@RestController
public class UserOrderController {

    private HashMap<Integer, UserOrder> userOrderHashMap;


    /**
     * Method to get items available to order
     * @return inventory string
     */
    @GetMapping (path = "/getUserOrder")
    public UserOrder getUserOrder(@RequestParam ("id") int id){
        return userOrderHashMap.get(id);
    }

    /**
     * Returns the users order
     * @param id users id
     * @return user order
     */
    @GetMapping (path = "/getOrder")
    public UserOrder getOrder(@RequestParam (value = "id") int id){
        return this.userOrderHashMap.get(id);
    }

    /**
     * Creates a new order for a new customer
     * @param order order method
     * @return maxKey
     */
    @PostMapping(path = "/createOrder")
    public int createOrder(@RequestBody UserOrder order){
        if(this.userOrderHashMap == null){
            this.userOrderHashMap = new HashMap<>();
        }

        int maxKey = 0;

        if(this.userOrderHashMap.size() !=  1){
            maxKey = Collections.max( this.userOrderHashMap.keySet() ) + 1;
        }

        this.userOrderHashMap.put(maxKey, order);

        return maxKey;
    }

    /**
     * Method to update the users order to comply with what they want
     * @param id is the id associated with the user
     * @param order is the new order that they want
     */
    @PutMapping (path = "/updateOrder")
    public void updateOrder(@RequestParam ("id") int id, @RequestBody UserOrder order){
        if(this.userOrderHashMap.containsKey(id)){
            this.userOrderHashMap.put(id,order);
        }
    }

    /**
     * Method to delete user's order
     * @param id id of the user
     * @param order user's order
     */
    @DeleteMapping (path = "/deleteOrder")
    public void deleteOrder (@RequestParam ("id") int id, @RequestBody UserOrder order){
        if(this.userOrderHashMap.containsKey(id)){
            this.userOrderHashMap.remove(id, order);
        }
    }
}
