package edu.psu.behrend.cs.dar5602.homework2.controllers;

import edu.psu.behrend.cs.dar5602.homework2.dtos.UserOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;


public class UserOrderControllerTest {

    private HashMap<Integer, UserOrder> userOrderHashMap;

    @Test
    public void getMenu(){
        UserOrderController userOrderController = new UserOrderController();

        String orderMenu = userOrderController.getMenu();

        String menu = "Small Tables;$400";
        menu += "Large Tables;$600";
        menu += "Long Tables;$300";
        menu += "Round Tables;$4000";

        Assert.assertEquals(menu,orderMenu); //True

        String falseMenu = "Small Tables;0";
        falseMenu += "Large Tables;0";
        falseMenu += "Long Tables;0";
        falseMenu += "Round Tables;0";

        Assert.assertEquals(falseMenu,orderMenu); //False
    }
    @Test
    public void getUserOrder(){
        int user0 = 0;
        int user1 = 1;
        this.userOrderHashMap = new HashMap<>();
        UserOrderController userOrderController = new UserOrderController();

        UserOrder userOrder0 = new UserOrder(0,0,0,0);
        UserOrder userOrder1 = new UserOrder(1,1,1,1);

        this.userOrderHashMap.put(user0,userOrder0);
        this.userOrderHashMap.put(user1,userOrder1);

        Assert.assertEquals(userOrderController.getUserOrder(user0),userOrderController.getUserOrder(user1)); //False

        Assert.assertNotEquals(user0,user1); //True
    }

    @Test
    public void createUserOrder(){
        UserOrderController userOrderController = new UserOrderController();
        this.userOrderHashMap = new HashMap<>();

        UserOrder userOrder = new UserOrder(0,0,0,0);
        UserOrder userOrder1 = new UserOrder(1,1,1,1);

        int user0 = userOrderController.createUserOrder(userOrder);//Can you tell me why this does not work
        int user1 = userOrderController.createUserOrder(userOrder1);//Can you tell me why this does not work

        this.userOrderHashMap.put(user0, userOrder);
        this.userOrderHashMap.put(user1, userOrder1);

        Assert.assertNotEquals(this.userOrderHashMap.get(user0),this.userOrderHashMap.get(user1)); //True

        Assert.assertNotNull(this.userOrderHashMap.get(user0)); //False
    }

    @Test
    public void updateUserOrder(){
        UserOrderController userOrderController = new UserOrderController();

        int userId = 0;
        this.userOrderHashMap = new HashMap<>();

        UserOrder userOrder = new UserOrder(0,0,0,0);
        UserOrder newUserOrder = new UserOrder(1,1,1,1);

        this.userOrderHashMap.put(userId,userOrder);

        Assert.assertEquals(this.userOrderHashMap.get(userId),userOrder); //True

        userOrderController.updateUserOrder(userId,newUserOrder); //Can you tell me why this does not work

        Assert.assertNotEquals(this.userOrderHashMap.get(userId),newUserOrder); //False

    }
}
