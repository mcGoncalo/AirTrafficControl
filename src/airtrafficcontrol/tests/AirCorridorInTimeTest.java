package airtrafficcontrol.tests;


import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import airtrafficcontrol.AirShipPlan.AirCorridorInTime;
import airtrafficcontrol.AirShipPlan.AltitudeCorridor;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;

public class AirCorridorInTimeTest {

	AirCorridorInTime corridorInTime;
	AltitudeCorridor corridor;
	Calendar date1;
	Calendar date2;
	
	@Before
	public void instanciateCorridors() throws InvalidArgumentException
	{
		corridor = new AltitudeCorridor(5,10);
		date1 = new GregorianCalendar();
		date2 = new GregorianCalendar();
		date2.add(12, 20);
		corridorInTime = new AirCorridorInTime(date1, date2, corridor);
	}
	
	@Test
	public void shouldReturnStartingHour() {
		assertTrue(date1.equals(corridorInTime.getStartingHour()));
	}
	
	@Test
	public void shouldReturnEndingHour() {
		assertTrue(date2.equals(corridorInTime.getEndingHour()));
	}
	
	@Test
	public void shouldReturnTheCorridor()
	{
		assertTrue(corridor.equals(corridorInTime.getCorridor()));
		assertEquals(corridor.getLowerLimit(), corridorInTime.getCorridor().getLowerLimit(), 0.01);
		assertEquals(corridor.getUpperLimit(), corridorInTime.getCorridor().getUpperLimit(), 0.01);
	}
	
	@Test
	public void shouldSwitchTheDatesWhenTheyAreIntroducedInTheWrongOrder() throws InvalidArgumentException
	{
		AirCorridorInTime newAirCorridor = new AirCorridorInTime(date2, date1, corridor);
		
		assertEquals(date1, newAirCorridor.getStartingHour());
		assertEquals(date2, newAirCorridor.getEndingHour());
	}
	
}
