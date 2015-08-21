package io.pivotal.sensor.service;

import java.util.Date;

import io.pivotal.sensor.model.RFID;
import io.pivotal.sensor.model.RFIDEvent;
import io.pivotal.sensor.model.TiltSwitch;
import io.pivotal.sensor.model.TiltSwitchEvent;

public interface SensorAPIService {
	
	
	Iterable<RFID> getAllRFIDs();

	Iterable<RFIDEvent> findAllRfidEventsByRfid(String rfid);

	RFID findRFIDByUserId(Long userId);

	Iterable<RFIDEvent> findAllRfidEventsByRfidBetween(String rfid,
			Date startDate, Date endDate);
	
	Iterable<TiltSwitch> getAllTiltSwitches();
	
	TiltSwitch getTiltSwitchByTiltSwitchID(String tiltSwitchId);
	
	Iterable<TiltSwitchEvent> getAllTiltSwitchEventsByTiltSwitchID(String tiltSwitchId);
	
	Iterable<TiltSwitchEvent> getAllTiltSwitchEventsByTiltSwitchIDBetween(String tiltSwitchId, Date startDate, Date endDate);

}
