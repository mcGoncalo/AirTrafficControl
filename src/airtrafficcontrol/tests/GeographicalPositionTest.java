package airtrafficcontrol.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import airtrafficcontrol.airCraftCoordinates.Altitude;
import airtrafficcontrol.airCraftCoordinates.GeographicalPosition;
import airtrafficcontrol.airCraftCoordinates.Latitude;
import airtrafficcontrol.airCraftCoordinates.Longitude;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;

public class GeographicalPositionTest {

	GeographicalPosition _geoPosObj;
	GeographicalPosition _geoPosVal;
	Latitude _lat;
	Longitude _lon;
	Altitude _alt;

	
	
	@Before
	public void newGepgraphicalPosition() throws InvalidArgumentException 
	{
		_lat = new Latitude(60.00);
		_lon = new Longitude(160.00);
		_alt = new Altitude(1600.00);
		
		_geoPosObj = new GeographicalPosition(_lat, _lon, _alt);
		
		_geoPosVal = new GeographicalPosition(60.00, 160.00, 1600.00);
	}
	
	@Test
	public void shouldReturnLatitudeValue()
	{
		assertTrue(_geoPosObj.getLatitude() == _geoPosVal.getLatitude());
	}

	@Test
	public void shouldReturnLongitudeValue()
	{
		assertTrue(_geoPosObj.getLongitude() == _geoPosVal.getLongitude());
	}
	
	@Test
	public void shouldReturnAltitudeValue()
	{
		assertTrue(_geoPosObj.getAltitude() == _geoPosVal.getAltitude());
	}
	
	
}
