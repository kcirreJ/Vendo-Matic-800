package com.techelevator.view;

public interface VendingMachineCalculator {
    static int money = 0;

     void feedMoney(int money);

    void subtractMoney(int money);
}
