/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

import static org.junit.Assert.*;

import com.entertainment.catalog.Catalog;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class TelevisionTest {

  private Television tvActual;

  @Test
  public void testSetVolume() {
    Television tv = new Television();
    
    tv.setVolume(0);  // valid volume, min value
    assertEquals(0, tv.getVolume());
    
    tv.setVolume(100);  // valid volume, max value
    assertEquals(100, tv.getVolume());
  }
  
  /**
   * Written using try-catch-or-fail technique.
   * This allows us to trap the exception and verify its message.
   * It also allows us to test multiple calls to the business method in one test method (which may not always be desirable).
   * We are testing both lower and upper bounds in this one test method (mainly to show the technique, and that you can).
   */
  @Test
  public void testSetVolumeIllegalArgumentException() {
    Television tv = new Television();
    
    try {
      tv.setVolume(-1);  // if method works correctly, exception is thrown and control jumps to catch block
      fail("Should have thrown IllegalArgumentException");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid volume: -1. Allowed range: [0,100].", e.getMessage());  // verify the exception message
    }
    
    try {
      tv.setVolume(101); // if method works correctly, exception is thrown and control jumps to catch block
      fail("Should have thrown IllegalArgumentException");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Invalid volume: 101. Allowed range: [0,100].", e.getMessage());  // verify the exception message
    }
  }
  
  @Test
  public void testChangeChannel() throws InvalidChannelException {  // throws clause needed because it's an unhandled checked exception
    Television tv = new Television();
    
    tv.changeChannel(1);  // valid channel, min value
    assertEquals(1, tv.getCurrentChannel());
    
    tv.changeChannel(999);  // valid channel, max value
    assertEquals(999, tv.getCurrentChannel());
  }
  
  /**
   * The two test methods below are Written using the @Test annotation's 'expected' attribute.
   * This is simpler and more compact than the try-catch-or-fail approach.
   * But we forego the opportunity to verify the exception's message,
   * and we can only make one business call per test method.
   *  This is because once the exception is thrown, we don't catch it here, which means it propagates back to the caller of
   *  the test method (the JUnit test runner), and method execution terminates immediately - normal exception behavior.
   */
  @Test(expected=InvalidChannelException.class)
  public void testChangeChannelInvalidChannelException_LowerBound() throws InvalidChannelException {  // unhandled checked exception
    Television tv = new Television();
    tv.changeChannel(0);
    tv.changeChannel(1000);  // WRONG: this is never reached, need another test method (see next test method)
  }
  
  @Test(expected=InvalidChannelException.class)
  public void testChangeChannelInvalidChannelException_UpperBound() throws InvalidChannelException {  // unhandled checked exception
    Television tv = new Television();
    tv.changeChannel(1000);
  }
  
  @Test
  public void testEquals() {  // brand, volume, display
    Television tv1 = new Television("RCA", 10, DisplayType.LED);
    Television tv2 = new Television("RCA", 10, DisplayType.LED);
    assertEquals(tv1, tv2);
    assertEquals(tv2, tv1);
    
    tv2.setBrand("X");
    assertNotEquals(tv1, tv2);
  }
  
  @Test
  public void testHashCode() {  // brand, volume, display
    Television tv1 = new Television("RCA", 10, DisplayType.LED);
    Television tv2 = new Television("RCA", 10, DisplayType.LED);
    // equal objects must have equal hashcodes
    assertEquals(tv1.hashCode(), tv2.hashCode());
  }
  
  @Test
  public void testCompareTo() { // natural order defined by brand only
    Television tv1 = new Television("RCA");
    Television tv2 = new Television("Sony");
    Television tv3 = new Television("Zenith");
    assertTrue(tv1.compareTo(tv2) < 1);  // RCA < Sony
    assertTrue(tv3.compareTo(tv2) > 1);  // Zenith > Sony
    
    tv2.setBrand("RCA");
    assertTrue(tv1.compareTo(tv2) == 0); // RCA = RCA
  }


  //Arrange and create the object

  @Test
  //Act and invoke the method associated with the object
  public void findByBrandWithNoMatches() {
    Collection <Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  public void findByBrandWithAName(){
    //arrange
    Collection<Television> tvs = Catalog.findByBrand("Sony");

    //act
    //create your expected value
    Collection <Television> expectedCollection = new ArrayList<>();

    //assert
    Assert.assertEquals(expectedCollection, tvs);

  }




}