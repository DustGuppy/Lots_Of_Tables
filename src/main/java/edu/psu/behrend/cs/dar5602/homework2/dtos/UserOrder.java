package edu.psu.behrend.cs.dar5602.homework2.dtos;

public class UserOrder {
    public int smallTable = 0;
    public int largeTable = 0;
    public int longTable = 0;
    public int roundTable = 0;


    public UserOrder(){
        this.smallTable = smallTable;
        this.largeTable = largeTable;
        this.longTable = longTable;
        this.roundTable = roundTable;
    }


    public int getSmallTable() {
        return smallTable;
    }

    public void setSmallTable(int smallTable) {
        this.smallTable = smallTable;
    }

    public int getLargeTable() {
        return largeTable;
    }

    public void setLargeTable(int largeTable) {
        this.largeTable = largeTable;
    }

    public int getLongTable() {
        return longTable;
    }

    public void setLongTable(int longTable) {
        this.longTable = longTable;
    }

    public int getRoundTable() {
        return roundTable;
    }

    public void setRoundTable(int roundTable) {
        this.roundTable = roundTable;
    }



}
