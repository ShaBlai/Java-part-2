package com.javatunes.personnel;
import org.junit.Before;
import org.junit.Test;
import java.sql.Date;
import static org.junit.Assert.assertEquals;


public class SalariedEmployeeTest {
    private SalariedEmployee salariedEmployee;


    @Before
    public void setUp() throws Exception {
        salariedEmployee = new SalariedEmployee("Jeff", Date.valueOf("2021-10-16"), 20000.50);
    }

    @Test
    public void testPay() {
        assertEquals(20000.50, salariedEmployee.pay(),.0001);
    }


    @Test
    public void testPayTaxes() {
        assertEquals(6000.15,salariedEmployee.payTaxes(),.0001);
    }
}