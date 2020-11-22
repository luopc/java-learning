package com.luopc.base.enumerate.enumSet;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PizzaTest {

    @Test
    public void givenPizaOrders_whenRetrievingUnDeliveredPzs_thenCorrectlyRetrieved() {
        List<Pizza> pzList = new ArrayList<>();
        Pizza pz1 = new Pizza();
        pz1.setStatus(PizzaStatus.DELIVERED);

        Pizza pz2 = new Pizza();
        pz2.setStatus(PizzaStatus.ORDERED);

        Pizza pz3 = new Pizza();
        pz3.setStatus(PizzaStatus.ORDERED);

        Pizza pz4 = new Pizza();
        pz4.setStatus(PizzaStatus.READY);

        pzList.add(pz1);
        pzList.add(pz2);
        pzList.add(pz3);
        pzList.add(pz4);

        List<Pizza> undeliveredPzs = Pizza.getAllUndeliveredPizzas(pzList);
        assertTrue(undeliveredPzs.size() == 3);
    }

    @Test
    public void givenPizzaOrder_whenDelivered_thenPizzaGetsDeliveredAndStatusChanges() {
        Pizza pz = new Pizza();
        pz.setStatus(PizzaStatus.READY);
        pz.deliver();
        assertTrue(pz.getStatus() == PizzaStatus.DELIVERED);
    }
}
