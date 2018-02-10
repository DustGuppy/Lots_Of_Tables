package edu.psu.behrend.cs.dar5602.homework2.controllers;

import edu.psu.behrend.cs.dar5602.homework2.dtos.UserInformation;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class UserInformationControllerTest {

    private HashMap<Integer,UserInformation> userInformationHashMap;

    @Test
    public void getUserInfo(){
        UserInformationController userInformationController = new UserInformationController();
        this.userInformationHashMap = new HashMap<>();

        int user0 = 0;
        int user1 = 1;

        UserInformation userInformation0 = new UserInformation("Doug","Jones", "djones@gmail.com","17073");
        UserInformation userInformation1 = new UserInformation("Natalie","Peirce", "nataliepeirce12@yahoo.com","dynamicrabbit");

        this.userInformationHashMap.put(user0,userInformation0);
        this.userInformationHashMap.put(user1,userInformation1);

        userInformationController.getUserInfo(user0);
        userInformationController.getUserInfo(user1);

        Assert.assertEquals(userInformationController.getUserInfo(user0),userInformationController.getUserInfo(user1)); //False

        Assert.assertNotEquals(user0,user1); //True

    }

    @Test
    public void createUser(){
        UserInformationController userInformationController = new UserInformationController();
        this.userInformationHashMap = new HashMap<>();

        UserInformation userInformation0 = new UserInformation("Troy","Green","tjg217@verizon.com","2012hummingbirds");
        UserInformation userInformation1 = new UserInformation("Sierra", "West","themostimportantwest@msn.com","shadeyglasses77");

        int user0 = userInformationController.createUser(userInformation0);//Can you tell me why this does not work
        int user1 = userInformationController.createUser(userInformation1);//Can you tell me why this does not work

        this.userInformationHashMap.put(user0, userInformation0);
        this.userInformationHashMap.put(user1, userInformation1);

        Assert.assertNotEquals(this.userInformationHashMap.get(user0),this.userInformationHashMap.get(user1)); //True

        Assert.assertNotNull(this.userInformationHashMap.get(user0)); //False
    }

    @Test
    public void updateUserInfo(){
        UserInformationController userInformationController = new UserInformationController();
        this.userInformationHashMap = new HashMap<>();

        int userId = 0;
        UserInformation userInformation = new UserInformation("Nicole", "Rigby", "sexygirl69@babellon.com","throwmethemoney");
        UserInformation newUserInformation = new UserInformation("Kitty", "Morgan", "ilovecats@cats.com","cats");

        this.userInformationHashMap.put(userId,userInformation);

        Assert.assertEquals(this.userInformationHashMap.get(userId),userInformation); //True

        userInformationController.updateUserInfo(userId,newUserInformation); //Can you tell me why this does not work

        Assert.assertNotEquals(this.userInformationHashMap.get(userId),newUserInformation); //False
    }

    @Test
    public void deleteUser(){
        UserInformationController userInformationController = new UserInformationController();
        this.userInformationHashMap = new HashMap<>();

        int user = 0;
        UserInformation userInformation = new UserInformation("Camryn","Resele","smartcookie@email.com","28564088");

        this.userInformationHashMap.put(user,userInformation);

        userInformationController.deleteUser(user);

        Assert.assertNull(this.userInformationHashMap.get(user));   //True
        Assert.assertTrue(this.userInformationHashMap.containsKey(user)); //False
    }
}
