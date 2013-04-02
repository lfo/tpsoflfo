package com.bissy.distrib.ws;

import java.util.Date;
import javax.jws.WebService;

@WebService
public interface DateService {

    public Date getOfficialDate();

}
