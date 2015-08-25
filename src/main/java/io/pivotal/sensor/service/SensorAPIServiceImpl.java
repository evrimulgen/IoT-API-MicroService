package io.pivotal.sensor.service;

import io.pivotal.sensor.model.RFID;
import io.pivotal.sensor.model.RFIDEvent;
import io.pivotal.sensor.model.TiltSwitch;
import io.pivotal.sensor.model.TiltSwitchEvent;

import java.util.Date;

import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SensorAPIServiceImpl implements SensorAPIService {

	RestTemplate rest = new RestTemplate();
	
	@Override
	public Iterable<RFID> getAllRFIDs() {
		Iterable<RFID> rfid = rest.getForObject("http://localhost:2225/get-all-rfids-ms", Iterable.class);
		return rfid;

	}
//
	@Override
	public Iterable<RFIDEvent> findAllRfidEventsByRfid(String rfid) {
		
		Iterable<RFIDEvent> rfid2 = rest.getForObject("http://localhost:2225/get-rfid-events-by-rfid-ms/"+rfid, Iterable.class);		
		return rfid2;
	}

	@Override
	public RFID findRFIDByUserId(Long userId) {
		RFID rfid = rest.getForObject("http://localhost:2225/get-rfid-by-user-ms/"+userId+"", RFID.class);
		return rfid;
	}

	@Override
	public Iterable<RFIDEvent> findAllRfidEventsByRfidBetween(String rfid,
			Date startDate, Date endDate) {
		
		Iterable<RFIDEvent> rfidEvent = rest.getForObject("http://localhost:2225/get-all-rfid-events-by-rfid-ms/"+rfid
				+"/between/"+startDate+"/"+endDate, Iterable.class);
		return rfidEvent;
	}

	@Override
	public Iterable<TiltSwitch> getAllTiltSwitches() {
		
		@SuppressWarnings("unchecked")
		Iterable<TiltSwitch> tilt = rest.getForObject("http://localhost:2225/get-all-tilt-switches-ms", Iterable.class);
		
		return tilt;
	}

	@Override
	public TiltSwitch getTiltSwitchByTiltSwitchID(String tiltSwitchId) {
		String url = "http://localhost:2225/get-tilt-switches-by-tiltId-ms/" + tiltSwitchId + "";
		TiltSwitch tilt = rest.getForObject(url, TiltSwitch.class);
		return tilt;
	}

	@Override
	public Iterable<TiltSwitchEvent> getAllTiltSwitchEventsByTiltSwitchID(
			String tiltSwitchId) {
		String url = "http://localhost:2225/get-tilt-events-by-tiltId-ms/"+tiltSwitchId+"";
		Iterable<TiltSwitchEvent> tilt =rest.getForObject(url, Iterable.class);
		return tilt;
	}

	@Override
	public Iterable<TiltSwitchEvent> getAllTiltSwitchEventsByTiltSwitchIDBetween(
			String tiltSwitchId, Date startDate, Date endDate) {
		
		String url = "http://localhost:2225/get-all-tilt-events-by-tiltId-ms/"+tiltSwitchId+"/between/"+startDate+"/"+endDate;

		Iterable<TiltSwitchEvent> tilt =rest.getForObject(url, Iterable.class);

		return tilt;
	}
	

}
