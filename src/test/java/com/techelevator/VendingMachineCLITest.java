package com.techelevator;

import com.techelevator.view.Menu;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineCLITest {

    @Test
    public void feedMoney() {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.feedMoney(100);
        Assert.assertEquals(100, cli.getMoney(), 0.00);
    }

    @Test
    public void subtractMoney() {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.feedMoney(100);
        cli.subtractMoney(50.00);
        Assert.assertEquals(50.00, cli.getMoney(), 0.00);
    }
}