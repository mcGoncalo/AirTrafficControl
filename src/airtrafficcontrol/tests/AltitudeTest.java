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
	
	AGeographicalCoordinate _alt;

	@Before
	public void newAltitudeValue() throws InvalidArgumentException 
	{
		_alt = new Altitude(60.00);
	}

	
	@Test 
	public void shouldReturnAltitudeValue()
	{
		assertTrue(60.00 == _alt.getGeographicalCoordinate());
	}
	
//	@Test 
//	public void shouldIncrementAltitudeWithDoubleValue()
//	{
//		//Arrange
//		double alt = 10.00;
//		
//		//Act
//		_alt.incrementAltitude(alt);
//		
//		//Assert
//		assertTrue(70.00 == _alt.getAltitudeValue());
//	}
	
//	@Test 
//	public void shouldIncrementAltitudeWithAnAltitudeObject() throws InvalidArgumentException
//	{
//		//Arrange
//		Altitude alt = new Altitude(10.00);
//		
//		//Act
//		_alt.incrementAltitude(alt);
//		
//		//Assert
//		assertTrue(70.00 == _alt.getAltitudeValue());
//	}
	
//	@Test 
//	public void shouldSetAltitudeValueWithADoubleValue() throws InvalidArgumentException
//	{
//		//Arrange
//		double alt = 10.00;
//		
//		//Act
//		_alt.setAltitude(alt);
//		
//		//Assert
//		assertTrue(10.00 == _alt.getAltitudeValue());
//	}
//	
//	@Test 
//	public void shouldSetAltitudeWithAnAltitudeObject() throws InvalidArgumentException
//	{
//		//Arrange
//		Altitude alt = new Altitude(10.00);
//		
//		//Act
//		_alt.setAltitude(alt);
//		
//		//Assert
//		assertTrue(10.00 == _alt.getAltitudeValue());
//	}
//	
}
