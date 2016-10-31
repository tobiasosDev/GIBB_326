package Controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tobiasluscher on 26.10.16.
 */
public class ControllerTest {
    Controller controller;
    @Before
    public void setUp() throws Exception {
        controller = new Controller();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void returnOne() throws Exception {
        assertTrue(controller.returnOne() == 1);
    }

}