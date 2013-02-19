package server;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class ServiceCommunicate {
	
	   //Namespace of web service
    final static String NAMESPACE = "http://tempuri.org/";
	//Method to return an SoapObject
    public SoapObject GetSoapObject(String id,String URL)
    {
                            final  String SOAP_ACTION = "http://tempuri.org/GetMedicalDetail";
        final String METHOD_NAME = "GetMedicalDetail";
        SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
        PropertyInfo pi=new PropertyInfo();
        pi.setName("PatientID");
        pi.setValue(id);
        pi.setType(String.class);
        Request.addProperty(pi);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    envelope.dotNet = true;
    envelope.setOutputSoapObject(Request);
    HttpTransportSE http = new HttpTransportSE("http://"+URL+"/sale.asmx?WSDL");
    try{
            http.call(SOAP_ACTION, envelope);
            SoapObject response=(SoapObject)envelope.getResponse();
            response=(SoapObject)response.getProperty(1);
            response=(SoapObject)response.getProperty(0);
            response=(SoapObject)response.getProperty(0);

            return response;
    }catch(Exception e){
            return null;
    }
    }
}
