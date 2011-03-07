package com.ingesup.jee4.tp9.business;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * @author lforet
 */
public class BusinessTestAbs {

    protected static EJBContainer ec;
    protected static Context ctx;

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================
    @BeforeClass
    public static void initContainer() throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));
        properties.put("org.glassfish.ejb.embedded.glassfish.installation.root",
                "./src/test/resources/glassfish");
        ec = EJBContainer.createEJBContainer(properties);
        ctx = ec.getContext();
    }

    @AfterClass
    public static void closeContainer() throws Exception {
        if (ec != null) {
            ec.close();
        }
    }
}
