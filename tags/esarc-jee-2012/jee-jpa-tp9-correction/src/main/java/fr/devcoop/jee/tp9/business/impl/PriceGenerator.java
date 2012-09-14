package fr.devcoop.jee.tp9.business.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Random;
import javax.ejb.Singleton;

/**
 *
 * @author lforet
 */
@Singleton
public class PriceGenerator {

    private Random random = new Random(System.currentTimeMillis());
    
    public BigDecimal getPrice(String title) {
        BigDecimal toReturn = new BigDecimal(random.nextDouble()*100);
        toReturn = toReturn.setScale(2, RoundingMode.UP);
        return toReturn;
    }
}

