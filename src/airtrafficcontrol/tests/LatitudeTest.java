package airtrafficcontrol.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import airtrafficcontrol.airCraftCoordinates.Latitude;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;

public class LatitudeTest {
	
		
	@Test 
	public void shouldReturnLatitudeValue() throws InvalidArgumentException 
	{
		Latitude _lat = new Latitude(60.00);
		assertTrue(60.00 == _lat.getGeographicalCoordinate());
	}
	

}
