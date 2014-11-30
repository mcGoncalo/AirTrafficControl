package airtrafficcontrol.tests;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import airtrafficcontrol.AirShipPlan.AirCorridorInTime;
import airtrafficcontrol.AirShipPlan.AltitudeCorridor;
import airtrafficcontrol.AirShipPlan.FlightPlan;
import airtrafficcontrol.airCraftCoordinates.GeographicalPosition;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;
import airtrafficcontrol.hangar.CivilHelicopter;
import airtrafficcontrol.hangar.Helicopter;
import airtrafficcontrol.towerControl.ReadListOfFlights;


/**
 * @author (Revisão) Filipa Estiveira, Filipa Gonçalves, Gonçalo Carvalho, José Oliveira
 */
public class CivilHelicopterTest {

	private static GeographicalPosition geo;
	private int initialAtltitude = 1;
	private int initialLatitude = 12;
	private int initialLongitude = 10;
	
	CivilHelicopter cheli1;
	CivilHelicopter cheli2;
	Calendar date1;
	Calendar date2;
	
	@Before
	public void constructTwoAirplanes() throws InvalidArgumentException
	{
		date1 = new GregorianCalendar();
		date2 = ReadListOfFlights.createDefensiveCopyOfTheDate(date1);
		date2.add(Calendar.MINUTE, 20);
		
		geo = new GeographicalPosition(initialLatitude, initialLongitude, initialAtltitude);
		cheli1 = new CivilHelicopter("mgrf", geo, new FlightPlan(date1, date2, 9 ,9, 6), 10);
		cheli2 = new CivilHelicopter("mgrf1", geo, new FlightPlan(date1, date2, 9 ,9, 6), 12);
	}
	
	@Test
	public void shouldReturnTheCorrectNumberOfPassengers()
	{
		assertEquals(10, cheli1.getPassengersNumber());
		assertEquals(12, cheli2.getPassengersNumber());
	}

	
	@Test
	public void shouldReturnTheFlightID()
	{
		assertEquals("mgrf", cheli1.getFlightID());
		assertEquals("mgrf1", cheli2.getFlightID());
	}
	
	
	@Test
	public void shouldReturnTheCorrectGeographicalPosition()
	{
		assertEquals(geo, cheli1.getGeographicPosition());
		assertEquals(geo, cheli2.getGeographicPosition());
	}
	
	
	@Test
	public void shouldUpdateTheGeographicalPositionToANewOne() throws InvalidArgumentException
	{
		GeographicalPosition newGeographicalPosition = new GeographicalPosition(18, 11, 20);
		cheli1.updateGeographicPosition(newGeographicalPosition);
		
		assertEquals(newGeographicalPosition, cheli1.getGeographicPosition());
	}
	
	
	@Test
	public void shouldGetTheCorridorNullBecauseItIsStillGainingAltitude() throws InvalidArgumentException
	{
		Helicopter cheli3 = makeAnAirplaneWithAPlan(-10);
		assertEquals(cheli3.getCurrentCorridor(), null);
	}
	
	
	@Test
	public void shouldGetTheCorridorNullBecauseItIsLanding() throws InvalidArgumentException
	{
		Helicopter cheli3 = makeAnAirplaneWithAPlan(-50);
		assertEquals(cheli3.getCurrentCorridor(), null);
	}
	
	
	@Test
	public void shouldGetMidFlightCorridor() throws InvalidArgumentException
	{
		Helicopter cheli3 = makeAnAirplaneWithAPlan(-30);
		double maxAlt = cheli3.getCurrentCorridor().getUpperLimit();
		double minAlt = cheli3.getCurrentCorridor().getLowerLimit();
		
		assertEquals(120, (int)maxAlt);
		assertEquals(100, (int)minAlt);
	}
	
	
	@Test
	public void shoudGetTheRightObservation_TakingOff() throws InvalidArgumentException
	{
		Helicopter cheli3 = makeAnAirplaneWithAPlan(-10);
		assertEquals(cheli3.getObservations(), "The air plane has took off and is gaining altitude.");
	}
	
	
	@Test
	public void shouldGetTheRightObservation_Landing() throws InvalidArgumentException
	{
		Helicopter cheli3 = makeAnAirplaneWithAPlan(-50);
		assertEquals(cheli3.getObservations(), "The airplane has started its descent in order to land.");
	}
	
	
	@Test
	public void shouldGetTheRightObservation_OutsideCorridor() throws InvalidArgumentException
	{
		Helicopter cheli3 = makeAnAirplaneWithAPlan(-30);
		assertEquals(cheli3.getObservations(), "WARNING: The airplane is outside of the corridor.");
	}
	
	
	@Test
	public void shouldGetTheRightObservation_NoObservation() throws InvalidArgumentException
	{
		Helicopter cheli3 = makeAnAirplaneWithAPlan(-30);
		GeographicalPosition newGeographicalPosition = new GeographicalPosition(40, 15, 110);
		cheli3.updateGeographicPosition(newGeographicalPosition);

		assertEquals(cheli3.getObservations(), "");
	}
	
	
	@Test
	public void shouldGetTheRightObservation_HasNotTakenOff() throws InvalidArgumentException
	{
		Helicopter cheli3 = makeAnAirplaneWithAPlan(10);
		assertEquals(cheli3.getObservations(), "The airplane has not taken off yet.");
	}
	
	
	@Test
	public void shouldGetTheRightObservation_HasAlreadyLanded() throws InvalidArgumentException
	{
		Helicopter cheli3 = makeAnAirplaneWithAPlan(-70);
		assertEquals(cheli3.getObservations(), "The airplane has already landed.");
	}
	
	
	@Test 
	public void shouldCorrectlySetTheNewArrivalDate() throws InvalidArgumentException
	{
		Helicopter cheli3 = makeAnAirplaneWithAPlan(0);
		Calendar newLanding = new GregorianCalendar();
		newLanding.add(12, 80);
		cheli3.setNewArrivalHour(newLanding);
		
		assertEquals(cheli3.getPlan().getLastEvent().getEndingHour(), newLanding);
		
		newLanding.add(12, -20);
		assertEquals(cheli3.getPlan().getLastEvent().getStartingHour(), newLanding);
	}
	
	
	@Test
	public void shouldReturnTheCorrectTakeOffDate() throws InvalidArgumentException
	{
		Calendar hourTakeOff = new GregorianCalendar();
		Calendar hourLand = new GregorianCalendar();
		hourLand.add(12, 20);
		
		CivilHelicopter cheli4 = new CivilHelicopter("rj351", geo, new FlightPlan(hourTakeOff, hourLand, 4,7,2), 15);
		assertEquals(hourTakeOff, cheli4.getTakeOffDate());
	}
	
	
	@Test
	public void shouldReturnTheCorrectLandingDate() throws InvalidArgumentException
	{
		Calendar hourTakeOff = new GregorianCalendar();
		Calendar hourLand = new GregorianCalendar();
		hourLand.add(12, 20);
		
		CivilHelicopter cheli3 = new CivilHelicopter("rj351", geo, new FlightPlan(hourTakeOff, hourLand, 10, 12, 5), 10);
		assertEquals(hourLand, cheli3.getLandingDate());
	}
	
	
//	@Test
//	public void shouldReturnTheCorrectString() throws InvalidArgumentException
//	{
//		AirPlane airliner2 = makeAnAirplaneWithAPlan(-30);
//		assertEquals("id123 12.0 10.0 1.0 " + airliner2.getObservations(), airliner2.positionToString());
//	}
//	


	
	private static CivilHelicopter makeAnAirplaneWithAPlan(int diff) throws InvalidArgumentException
	{
		Calendar hourDep = new GregorianCalendar();
		Calendar hourLand = new GregorianCalendar();
		Calendar startCorr = new GregorianCalendar();
		Calendar endCorr = new GregorianCalendar();
		
		hourDep.add(12, diff);
		startCorr.add(12, 20 + diff);
		endCorr.add(12, 40 + diff);
		hourLand.add(12, 60 + diff);
		
		int maxAlt = 100;
		int minAlt = 120;
		AltitudeCorridor corr = new AltitudeCorridor(maxAlt, minAlt);
		
		AirCorridorInTime gainingAltitude = new AirCorridorInTime(hourDep, startCorr, null);
		AirCorridorInTime corridor = new AirCorridorInTime(startCorr, endCorr, corr);
		AirCorridorInTime landing = new AirCorridorInTime(endCorr, hourLand, null);
		
		FlightPlan plan = new FlightPlan(hourDep, hourLand, 9, 9, 6);
		
		plan.addEvent(gainingAltitude);
		plan.addEvent(corridor);
		plan.addEvent(landing);
		
		return new CivilHelicopter("id123", geo, plan, 10);
	}

}
