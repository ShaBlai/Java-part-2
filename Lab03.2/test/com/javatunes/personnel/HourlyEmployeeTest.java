package com.javatunes.personnel;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    private HourlyEmployee hourlyEmployee;


    @Before
    public void setUp() throws Exception {
        hourlyEmployee = new HourlyEmployee("Jeff", Date.valueOf("2010-12-10"), 20.00,20.00);
    }

    @Test
    public void testPay() {
        assertEquals(400.0, hourlyEmployee.pay(),.001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(100.0,hourlyEmployee.payTaxes(),.001);
    }

}