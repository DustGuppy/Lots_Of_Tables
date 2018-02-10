package edu.psu.behrend.cs.dar5602.homework2.controllers;

import edu.psu.behrend.cs.dar5602.homework2.dtos.UserOrder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;

@RestController
public class UserOrderController {

    private HashMap<Integer, UserOrder> userOrderHashMap;


    @GetMapping (path = "/defaultUserOrder")
    public UserOrder test(){
        return new UserOrder(0,0,0,0);
    }

    /**
     *
     * @return menu for customer
     */
    @GetMapping (path = "/menu")
    public String getMenu(){
        String menu = "Small Tables;$400";
        menu += "Large Tables;$600";
        menu += "Long Tables;$300";
        menu += "Round Tables;$4000";

        return menu;
    }

    /**
     * Returns the users order
     * @param id users id
     * @return user order
     */
    @GetMapping (path = "/getUserOrder")
    public UserOrder getUserOrder(@RequestParam (value = "id") int id){
        return this.userOrderHashMap.get(id);
    }

    /**
     * Creates a new order for a new customer
     * @param order order method
     * @return maxKey
     */
    @PostMapping(path = "/createOrder")
    public int createUserOrder(@RequestBody UserOrder order){
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
    public void updateUserOrder(@RequestParam ("id") int id, @RequestBody UserOrder order){
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
    public void deleteUserOrder (@RequestParam ("id") int id, @RequestBody UserOrder order){
        if(this.userOrderHashMap.containsKey(id)){
            this.userOrderHashMap.remove(id, order);
        }
    }
}
