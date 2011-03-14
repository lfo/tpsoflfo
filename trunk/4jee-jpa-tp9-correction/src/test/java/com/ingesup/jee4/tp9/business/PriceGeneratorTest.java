package com.ingesup.jee4.tp9.business;

import com.ingesup.jee4.tp9.business.impl.PriceGenerator;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.naming.NamingException;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author lforet
 */
public class PriceGeneratorTest extends BusinessTestAbs {

    @Test
    public void test() throws NamingException {
        PriceGenerator priceGenerator = (PriceGenerator) ctx.lookup("java:global/classes/PriceGenerator");
        Assert.assertNotNull(priceGenerator);
        
        BigDecimal decimal = priceGenerator.getPrice("test");
        Assert.assertTrue(decimal.compareTo(new BigDecimal(0))>0);
        System.out.println(decimal);
    }
    
}
