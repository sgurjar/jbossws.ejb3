package sg.jbossws.ejb;

import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

public class HrServiceHelper {

  public static HrServiceHelper newInstance(){return new HrServiceHelper();}


  public HashMap<String,Object> requestHoliday(HashMap<String,Object> req) {

    String fname     = (String)req.get("fname");
    String lname     = (String)req.get("lname");
    Long   empno     = (Long  )req.get("empno");
    Date   startdate = (Date  )req.get("startdate");
    Date   enddate   = (Date  )req.get("enddate");

    HashMap<String,Object> resp = new HashMap<String,Object>();

    String msg = String.format("%s %s %s you request to vacation from %s to %s is %s",
                                empno, fname, lname, startdate, enddate,
                                (flipCoin() ? "permitted" : "denied"));
    resp.put("msg",msg);
    resp.put("code",0);
    resp.put("refno",UUID.randomUUID().toString());

    return resp;
  }

  boolean flipCoin() {
    return ThreadLocalRandom.current().nextInt(0,2)==0;
  }
}