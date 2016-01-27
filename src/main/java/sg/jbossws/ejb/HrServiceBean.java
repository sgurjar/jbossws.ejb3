package sg.jbossws.ejb;

import com.mycompany.hr.schemas.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.*;
import java.math.*;

@javax.ejb.Stateless
@javax.ejb.Remote(value = sg.jbossws.ejb.HrServiceRemote.class)
@javax.ejb.Local(value = sg.jbossws.ejb.HrServiceLocal.class)
@javax.jws.WebService(
  endpointInterface = "com.mycompany.hr.definitions.HumanResource",
  targetNamespace = "http://mycompany.com/hr/definitions",
  serviceName = "HumanResourceService",
  portName = "HumanResourcePort",
  wsdlLocation = "META-INF/wsdl/hr.wsdl"
  )
@javax.annotation.security.RolesAllowed("HrService")
public class HrServiceBean {

  private HrServiceHelper helper = HrServiceHelper.newInstance(); // or injected

  public HolidayResponse holiday(HolidayRequest req) {

    EmployeeType employee = req.getEmployee();

    HashMap<String,Object> hm = new HashMap<String,Object>();
    hm.put("fname",employee.getFirstName());
    hm.put("lname",employee.getLastName());
    hm.put("empno",employee.getNumber().longValue());

    HolidayType holiday = req.getHoliday();

    hm.put("startdate", XMLDateUtil.toDate(holiday.getStartDate()));
    hm.put("enddate"  , XMLDateUtil.toDate(holiday.getEndDate()));

    hm = helper.requestHoliday(hm);

    HolidayResponse resp = new HolidayResponse();

    resp.setCode(BigInteger.valueOf(((Integer)hm.get("code")).longValue()));
    resp.setMessage((String)hm.get("msg"));
    resp.setReferenceNo((String)hm.get("refno"));

    return resp;
  }
}