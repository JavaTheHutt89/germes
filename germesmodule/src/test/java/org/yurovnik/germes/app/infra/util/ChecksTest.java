package org.yurovnik.germes.app.infra.util;

import org.junit.Assert;
import org.junit.Test;
import org.yurovnik.germes.app.infra.exception.flow.InvalidParameterException;

public class ChecksTest {

    @Test
    public void testCheckParameterGetException(){
        try {
            Checks.checkParameter(false, "test");
            Assert.assertTrue(false);
        } catch (Exception ex){
            Assert.assertSame(ex.getClass(), InvalidParameterException.class);
            Assert.assertEquals(ex.getMessage(), "test");
        }
    }

    @Test
    public void testCheckParameterNoException(){
        Checks.checkParameter(true, "test");
        Assert.assertTrue(true);
    }
}
