package codeTest.OA.eetainfinra;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestDemo {

    private Factory factory;

    @Before
    public void setUp(){
        factory = new Factory();
    }

    @Test
    public void testObject(){
        assertEquals("someString", factory.createObject());
    }
    @Test
    public void testNull(){
        assertEquals(null, factory.createNull());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException(){
        assertNotNull(factory.createException());
    }


    private class Factory{
        public String createObject(){
            return "someString";
        }
        public Object createNull(){
            return null;
        }
        public Object createException(){
            throw new IllegalArgumentException();
        }
    }
}
