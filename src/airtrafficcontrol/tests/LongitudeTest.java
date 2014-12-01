package airtrafficcontrol.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import airtrafficcontrol.airCraftCoordinates.Longitude;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;

public class LongitudeTest {

	
	@Test 
	public void shouldReturnLongitudeValue() throws InvalidArgumentException 
	{
		Longitude _lon = new Longitude(60.00);
		
		assertTrue(60.00 == _lon.getGeographicalCoordinate());
	}
	
	
}
