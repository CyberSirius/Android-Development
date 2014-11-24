package com.mentormate.academy.classwork241114;

import android.test.InstrumentationTestCase;

/**
 * Created by Strashimir on 24.11.2014 г..
 */
public class FirstTest extends InstrumentationTestCase{
   public void test() throws Exception {
       int expected=10;
       int reality=10;
       assertEquals(expected,reality);
   }
}