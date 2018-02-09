package edu.psu.behrend.cs.dar5602.homework2.dtos;

public class UserOrder {
    public int smallTable;
    public int largeTable;
    public int longTable;
    public int roundTable;

    public UserOrder(int smallTable, int largeTable, int longTable, int roundTable) {
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
