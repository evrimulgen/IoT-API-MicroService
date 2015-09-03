package io.pivotal.sensor.rest;

import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.EurekaInstanceConfig;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.config.ConfigurationManager;
//import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.shared.Applications;

/**
 * Sample requests:
 * http://localhost:8080/get-weather-by-sensorid/need-a-sensor-id
 * http://localhost:8080/get-all-weather-readings-by-sensorid/need-a-sensor-id/between/2014-06-12T00:00:00.000Z/2015-11-12T00:00:00.000Z
 * 
 * @author belle
 *
 */
//@EnableDiscoveryClient
@RestController
public class DefaultRestAPI {
	
	// ApplicationInfoManager.getInstance().setInstanceStatus(InstanceStatus.UP);
	
	private static String getHostname() {
        String hostname = null;
        try {
         //   hostname = InetAddress.getLocalHost().getHostAddress();
            hostname = InetAddress.getLocalHost().getCanonicalHostName();
          //  hostname = InetAddress.getLocalHost().getAddress();
        } catch (UnknownHostException e) {
            //logger.error("Cannot get host info", e);
        }
        return hostname;
    }
	String name = getHostname();
	
//	@Autowired
//	private DiscoveryClient discoveryClient;
//	
//	EurekaInstanceConfig eur;
//	
//	String name = eur.getAppname();
	
//	public URI serviceUrl() {
//	//	InstanceInfo instance = discoveryClient.getNextServerFromEureka("IotAPIApplication", false);
//		List<ServiceInstance> list = discoveryClient.getInstances("RFID");
//		if (list != null && list.size() > 0 ) {
//	        return list.get(0).getUri();
//	    }
//	    return null;	}
//	
//	String url = serviceUrl().toString();
//	DiscoveryManager manager;
//	
//	ConfigurationManager manager1;
//	
//	//Applications port1 = manager.getInstance().getDiscoveryClient().getApplications();
//	
//	String appId = ConfigurationManager.getDeploymentContext().getApplicationId();
//	
//	String port = manager.getInstance().getEurekaClientConfig().getEurekaServerPort();
//	
	InstanceInfo nextServerInfo = DiscoveryManager.getInstance().getDiscoveryClient().getNextServerFromEureka("IoTOnEureka", false);
//	
	int serverPort = nextServerInfo.getPort();
	
	//int serverPort = 2224;
		
	//System.out.println("PORT -- PORT -- " + ServerPort + " -- PORT");

	
	

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String defaultResponse() {
		return "Welcome to Arduino API </br></br> " 
				+"http://localhost:"+serverPort+"/get-all-users </br></br>"
				+"http://localhost:2224/get-all-rfids </br>"
				+"http://localhost:2224/get-rfid-events-by-rfid/need-a-sensor-id </br>"
				+"http://localhost:2224/get-rfid-by-user/1 </br>"
				+"http://localhost:2224/get-all-rfid-events-by-rfid/need-a-sensor-id/between/2014-06-12T00:00:00.000Z/2015-11-12T00:00:00.000Z </br>"
				+"http://localhost:2224/get-weather-by-sensorid/sampleID </br>"
				+"http://localhost:2224/get-all-weather-readings-by-sensorid/sampleID/between/2014-06-12T00:00:00.000Z/2015-11-12T00:00:00.000Z </br></br>"
				+"http://localhost:2224/get-all-tilt-switches </br>"
				+"http://localhost:2224/get-tilt-events-by-tiltId/need-a-sensor-id </br>"
				+"http://localhost:2224/get-tilt-switches-by-tiltId/need-a-sensor-id </br>"
				+"http://localhost:2224/get-all-tilt-events-by-tiltId/need-a-sensor-id/between/2014-06-12T00:00:00.000Z/2015-11-12T00:00:00.000Z </br></br>"
				+"</br> Coming soon..... </br>"
				+"http://localhost:2224/get-all-gas-smoke-events-by-sensorid/09 </br>"
				+"http://localhost:2224/get-all-gas-smoke-events-by-sensorid/12/between/2014-06-12T00:00:00.000Z/2014-11-12T00:00:00.000Z </br>";
							 
							 
	}

	
}
