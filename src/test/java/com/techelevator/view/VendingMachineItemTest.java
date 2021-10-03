package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class VendingMachineItemTest {

    @Test
    public void depleteStock() {
        VendingMachineItem A1 = new VendingMachineItem("A1", "CHIP", 5.00, 5);
        A1.depleteStock();
        Assert.assertEquals(4, A1.getItemStock());
    }
}
