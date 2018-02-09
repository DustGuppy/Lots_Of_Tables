package edu.psu.behrend.cs.dar5602.homework2.controllers;

import edu.psu.behrend.cs.dar5602.homework2.dtos.UserInformation;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;

@RestController
public class UserInformationController {

    private HashMap<Integer,UserInformation> userInformationHashMap;


    /**
     * Default json constructor
     * @return new user object
     */
    @GetMapping(path = "/defaultUserInformation")
    public UserInformation test()
    {
        return new UserInformation("fname", "lname", "email", "pass");
    }


    /**
     * Gets the users information
     * @return users information
     */
    @GetMapping (path = "/userInfo")
    public UserInformation getUserInfo(@RequestParam ("id") int id){
        return userInformationHashMap.get(id);
    }

    /**
     * Sets the users information
     * @param userInformation userInformation model
     * @return users key
     */
    @PostMapping (path = "/createUser")
    public int createUser(@RequestBody UserInformation userInformation){

        if(this.userInformationHashMap == null){
            this.userInformationHashMap = new HashMap<>();
        }

        int maxKey = 0;

        if(this.userInformationHashMap.size() != 0){
            maxKey = Collections.max(this.userInformationHashMap.keySet()) + 1;
        }

        this.userInformationHashMap.put(maxKey,userInformation);

        return maxKey;
    }

    @PutMapping (path = "/updateUserInfo")
    public void updateUserInfo(@RequestParam ("id") int id, @RequestBody UserInformation userInformation) {
        if (this.userInformationHashMap.containsKey(id)) {
            this.userInformationHashMap.put(id, userInformation);
        }
    }

    @DeleteMapping (path = "/deleteUser")
    public void deleteUser(@RequestParam ("id") int id){
        this.userInformationHashMap.remove(id);
    }

}
