package com.bissy.distrib.ws.server;

import com.bissy.distrib.ws.DateService;
import java.util.Date;
import javax.jws.WebService;

/**
 *
 * @author lforet
 */
@WebService(endpointInterface = "com.bissy.distrib.ws.DateService",
            serviceName = "DateService")
public class DateServiceWS implements DateService {

    public Date getOfficialDate() {
        return new Date();
    }
    
}
