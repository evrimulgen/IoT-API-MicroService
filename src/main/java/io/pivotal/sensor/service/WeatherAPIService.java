package io.pivotal.sensor.service;

import io.pivotal.sensor.model.Weather;

import java.util.Date;
import java.util.List;


import org.springframework.web.bind.annotation.PathVariable;

public interface WeatherAPIService {
	
	public List<Weather> findBySensorID( String sensorID);
	
	public List<Weather> findWeatherSensorReadingBetween(@PathVariable String sensorID, Date startDate, Date endDate);

}
