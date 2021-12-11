package com.parcel.system.DateDifferenceFinder;

import com.parcel.system.DateDifferenceFinder.constant.AppConstant;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class ApplicationMainTest {


    private ApplicationMain applicationMain;
    private InputStream stdin;
    //private OutputStream stdOut;
    private PrintStream stdOut ;

    @Before
    public void init() {
        //applicationMain = new ApplicationMain();
        stdOut = System.out;
        stdin = System.in;
        System.out.flush();
    }

    @After
    public void afterClass() {
        System.out.flush();
        System.setIn(stdin);
        System.setOut(stdOut);
    }

    /**
     * Testing main class with invalid input
     */
    @Test
    public void testMain_withInvalidInput() throws IOException {

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Invalid Input".getBytes());
        System.setIn(byteArrayInputStream);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        ApplicationMain.main(null); // call the main method

        //reading all lines from console.
        String[] lines = byteArrayOutputStream.toString().split(System.lineSeparator());

        String actual = lines[lines.length - 1];

        Assert.assertEquals(AppConstant.ERROR_MESSAGE, actual.split("-")[1].trim());
        byteArrayInputStream.close();
        byteArrayOutputStream.close();

    }


}
