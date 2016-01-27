package sg.jbossws.ejb;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class XMLDateUtil {
  public static XMLGregorianCalendar toXmlDate(Date from) {
    GregorianCalendar gc = new GregorianCalendar();
    gc.setTime(from);
    try{
      return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
    }
    catch(Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static Date toDate(XMLGregorianCalendar from) {
    return from.toGregorianCalendar().getTime();
  }
}