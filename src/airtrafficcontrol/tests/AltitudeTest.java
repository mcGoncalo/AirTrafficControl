package airtrafficcontrol.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import airtrafficcontrol.airCraftCoordinates.AGeographicalCoordinate;
import airtrafficcontrol.airCraftCoordinates.Altitude;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;


/**
 * @author Eva Gomes, Hugo Leal, Lucas Andrade
 */

public class AltitudeTest {
	
	@Test 
	public void shouldReturnAltitudeValue() throws InvalidArgumentException 
	{
		Altitude _alt = new Altitude(60.00);
		assertTrue(60.00 == _alt.getGeographicalCoordinate());
	}
}
