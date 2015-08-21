package io.pivotal.sensor.service;

import io.pivotal.sensor.model.Weather;

import java.util.Date;
import java.util.List;

import org.springframework.web.client.RestTemplate;

public class WeatherAPIServiceImpl implements WeatherAPIService {

	RestTemplate rest = new RestTemplate();
	
	@Override
	public List<Weather> findBySensorID(String sensorID) {
		
		List<Weather> weather = rest.getForObject("http://localhost:2223/get-weahter-by-sensor-id-ms", List.class);
		// TODO Auto-generated method stub
		return weather;
	}

	@Override
	public List<Weather> findWeatherSensorReadingBetween(String sensorID,
			Date startDate, Date endDate) {
		
		List<Weather> weatherRes = rest.getForObject("http://localhost:2223/get-all-weather-reading-by-sensorid"+sensorID+
				"/between"+startDate+"/"+endDate, List.class);
				
		
		return weatherRes;
	}

}
