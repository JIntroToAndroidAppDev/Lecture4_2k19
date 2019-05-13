package com.myfirstandroidapp;

import com.myfirstandroidapp.servicesdemo.HTTPHandler;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testHttpHandler() throws IOException {
        System.out.println(new HTTPHandler().getCountryByName("Russia"));
    }
}