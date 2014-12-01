package airtrafficcontrol.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import airtrafficcontrol.AirShipPlan.FlightPlan;
import airtrafficcontrol.airCraftCoordinates.GeographicalPosition;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;
import airtrafficcontrol.app.exceptions.InvalidFlightIDException;
import airtrafficcontrol.hangar.AirCraft;
import airtrafficcontrol.hangar.Airship;
import airtrafficcontrol.hangar.CivilAirPlane;
import airtrafficcontrol.hangar.CivilHelicopter;
import airtrafficcontrol.hangar.MilitaryHelicopter;
import airtrafficcontrol.towerControl.Database;
import airtrafficcontrol.towerControl.ReadListOfFlights;

public class ReadListOfFlightsTest {

	ReadListOfFlights reader;
	Database database;
	Map<String, AirCraft> data;
	
	@Before
	public void buildTheDatabase() throws IOException, InvalidFlightIDException, InvalidArgumentException {
		reader  = new ReadListOfFlights();
		database = reader.readFlights("listOfFlightsTest.txt");
		data = database.getDatabase();
	}
	
	@Test
	public void testNumberOfAirplanes()
	{
		assertEquals(4, data.size());
	}
	
	@Test
	public void shouldHaveTheRightTypeOfAirplanes()
	{
		
		assertTrue(data.get("xptofligth01") instanceof airtrafficcontrol.hangar.MilitaryHelicopter);
		assertTrue(data.get("xptofligth02") instanceof airtrafficcontrol.hangar.CivilAirPlane);
		assertTrue(data.get("xptofligth03") instanceof airtrafficcontrol.hangar.CivilAirPlane);
		assertTrue(data.get("xptofligth04") instanceof airtrafficcontrol.hangar.CivilHelicopter);

	}
	
	@Test
	public void shouldReturnTheRightDatesOfLandingAndTakeOffOf1()
	{
		Airship transport = (Airship) data.get("xptofligth01");
		
		Calendar takeOff = transport.getTakeOffDate();
		Calendar landing = transport.getLandingDate();
		
		assertEquals(2014, takeOff.get(Calendar.YEAR));
		assertEquals(11 - 1, takeOff.get(Calendar.MONTH));
		assertEquals(6, takeOff.get(Calendar.DAY_OF_MONTH));
		assertEquals(9, takeOff.get(Calendar.HOUR_OF_DAY));
		assertEquals(22, takeOff.get(Calendar.MINUTE));
		
		assertEquals(2014, landing.get(Calendar.YEAR));
		assertEquals(11 - 1, landing.get(Calendar.MONTH));
		assertEquals(6, landing.get(Calendar.DAY_OF_MONTH));
		assertEquals(11, landing.get(Calendar.HOUR_OF_DAY));
		assertEquals(12, landing.get(Calendar.MINUTE));
	}
	
	@Test
	public void shouldReturnTheRightDatesOfLandingAndTakeOffOf2()
	{
		Airship airliner = (Airship) data.get("xptofligth02");
		
		Calendar takeOff = airliner.getTakeOffDate();
		Calendar landing = airliner.getLandingDate();
		
		assertEquals(2014, takeOff.get(Calendar.YEAR));
		assertEquals(11 - 1, takeOff.get(Calendar.MONTH));
		assertEquals(6, takeOff.get(Calendar.DAY_OF_MONTH));
		assertEquals(11, takeOff.get(Calendar.HOUR_OF_DAY));
		assertEquals(3, takeOff.get(Calendar.MINUTE));
		
		assertEquals(2014, landing.get(Calendar.YEAR));
		assertEquals(11 - 1, landing.get(Calendar.MONTH));
		assertEquals(6, landing.get(Calendar.DAY_OF_MONTH));
		assertEquals(15, landing.get(Calendar.HOUR_OF_DAY));
		assertEquals(43, landing.get(Calendar.MINUTE));
	}
	
	@Test
	public void shouldReturnTheRightDatesOfLandingAndTakeOffOf3()
	{
		Airship airliner = (Airship) data.get("xptofligth03");
		
		Calendar takeOff = airliner.getTakeOffDate();
		Calendar landing = airliner.getLandingDate();
		
		assertEquals(2014, takeOff.get(Calendar.YEAR));
		assertEquals(11 - 1, takeOff.get(Calendar.MONTH));
		assertEquals(6, takeOff.get(Calendar.DAY_OF_MONTH));
		assertEquals(14, takeOff.get(Calendar.HOUR_OF_DAY));
		assertEquals(57, takeOff.get(Calendar.MINUTE));
		
		assertEquals(2014, landing.get(Calendar.YEAR));
		assertEquals(11 - 1, landing.get(Calendar.MONTH));
		assertEquals(6, landing.get(Calendar.DAY_OF_MONTH));
		assertEquals(19, landing.get(Calendar.HOUR_OF_DAY));
		assertEquals(48, landing.get(Calendar.MINUTE));
	}
	
	@Test
	public void shouldReturnTheRightDatesOfLandingAndTakeOffOf4()
	{
		Airship cHeli =  (Airship) data.get("xptofligth04");
		
		Calendar takeOff = cHeli.getTakeOffDate();
		Calendar landing = cHeli.getLandingDate();
		
		assertEquals(2014, takeOff.get(Calendar.YEAR));
		assertEquals(11 - 1, takeOff.get(Calendar.MONTH));
		assertEquals(6, takeOff.get(Calendar.DAY_OF_MONTH));
		assertEquals(20, takeOff.get(Calendar.HOUR_OF_DAY));
		assertEquals(34, takeOff.get(Calendar.MINUTE));
		
		assertEquals(2014, landing.get(Calendar.YEAR));
		assertEquals(11 - 1, landing.get(Calendar.MONTH));
		assertEquals(7, landing.get(Calendar.DAY_OF_MONTH));
		assertEquals(4, landing.get(Calendar.HOUR_OF_DAY));
		assertEquals(43, landing.get(Calendar.MINUTE));
	}
	

	@Test
	public void shouldReturnTheCorrectTakeOffCoordinatesOf1()
	{
		AirCraft mHeli = data.get("xptofligth01");
		GeographicalPosition pos = mHeli.getGeographicPosition();
		
		assertEquals(39.3, pos.getLatitude(), 0.01);
		assertEquals(8, pos.getLongitude(), 0.01);
		assertEquals(0, pos.getAltitude(), 0.01);
	}
	
	@Test
	public void shouldReturnTheCorrectTakeOffCoordinatesOf2()
	{
		AirCraft airliner = data.get("xptofligth02");
		GeographicalPosition pos = airliner.getGeographicPosition();
		
		assertEquals(-39.3, pos.getLatitude(), 0.01);
		assertEquals(16, pos.getLongitude(), 0.01);
		assertEquals(0, pos.getAltitude(), 0.01);
	}
	
	@Test
	public void shouldReturnTheCorrectTakeOffCoordinatesOf3()
	{
		AirCraft airliner = data.get("xptofligth03");
		GeographicalPosition pos = airliner.getGeographicPosition();
		
		assertEquals(52.89, pos.getLatitude(), 0.01);
		assertEquals(-60, pos.getLongitude(), 0.01);
		assertEquals(0, pos.getAltitude(), 0.01);
	}
	
	@Test
	public void shouldReturnTheCorrectTakeOffCoordinatesOf4()
	{
		AirCraft cHeli = data.get("xptofligth04");
		GeographicalPosition pos = cHeli.getGeographicPosition();
		
		assertEquals(0.3, pos.getLatitude(), 0.01);
		assertEquals(45.04, pos.getLongitude(), 0.01);
		assertEquals(0, pos.getAltitude(), 0.01);
	}
	
	
	@Test
	public void shouldReturnTrueBecauseTheFirstAirplaneHasArmament()
	{
		assertTrue(((MilitaryHelicopter) data.get("xptofligth01")).hasArmament());
	}
	
	@Test
	public void shouldReturnTheRightNumberOfPassengers()
	{
		assertEquals(203, ((CivilAirPlane)data.get("xptofligth02")).getPassengersNumber());
		assertEquals(0, ((CivilAirPlane)data.get("xptofligth03")).getPassengersNumber());
		assertEquals(24, ((CivilHelicopter) data.get("xptofligth04")).getPassengersNumber());
	}
	
	@Test 
	public void shouldReturnTheObservationThatTheAirplaneHasAlreadyLanded() throws InvalidArgumentException
	{
		assertEquals("The airplane has already landed.", ((Airship) data.get("xptofligth01")).getObservations());
	}
	
	@Test
	public void shouldReturnTheRightCorridorFor1() throws InvalidArgumentException
	{
		Airship mHeli = (Airship) data.get("xptofligth01");
		FlightPlan plan = mHeli.getPlan();
		
		assertEquals(null, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 9, 25)));
		assertEquals(11500, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 10, 30)).getUpperLimit(), 0.01);
		assertEquals(10500, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 10, 30)).getLowerLimit(), 0.01);
		assertEquals(null, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 10, 34)));

	}
	
	@Test
	public void shouldReturnTheRightCorridorFor2() throws InvalidArgumentException
	{
		Airship airliner = (Airship) data.get("xptofligth02");
		FlightPlan plan = airliner.getPlan();
		
		assertEquals(null, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 11, 4)));
		assertEquals(11000, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 12, 00)).getUpperLimit(), 0.01);
		assertEquals(10500, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 12, 00)).getLowerLimit(), 0.01);
		assertEquals(null, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 12, 10)));
		assertEquals(13000, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 12, 59)).getUpperLimit(), 0.01);
		assertEquals(12000, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 12, 59)).getLowerLimit(), 0.01);
		assertEquals(null, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 13, 01)));
		assertEquals(17000, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 13, 40)).getUpperLimit(), 0.01);
		assertEquals(15000, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 13, 40)).getLowerLimit(), 0.01);
		assertEquals(null, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 15, 42)));
	}
	
	@Test
	public void shouldReturnTheRightCorridorFor3() throws InvalidArgumentException
	{
		Airship airliner = (Airship) data.get("xptofligth03");
		FlightPlan plan = airliner.getPlan();
		
		assertEquals(null, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 14, 58)));
		assertEquals(11500, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 16, 00)).getUpperLimit(), 0.01);
		assertEquals(10500, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 16, 00)).getLowerLimit(), 0.01);
		assertEquals(null, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 12, 04)));
		assertEquals(12000, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 19, 00)).getUpperLimit(), 0.01);
		assertEquals(11000, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 19, 00)).getLowerLimit(), 0.01);
		assertEquals(null, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 19, 47)));
	}
	
	@Test
	public void shouldReturnTheRightCorridorFor4() throws InvalidArgumentException
	{
		Airship cHeli = (Airship) data.get("xptofligth04");
		FlightPlan plan = cHeli.getPlan();
		
		assertEquals(null, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 20, 35)));
		assertEquals(11000, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 23, 59)).getUpperLimit(), 0.01);
		assertEquals(10500, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 6, 23, 59)).getLowerLimit(), 0.01);
		assertEquals(null, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 7, 0, 03)));
		assertEquals(13000, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 7, 4, 00)).getUpperLimit(), 0.01);
		assertEquals(12000, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 7, 4, 00)).getLowerLimit(), 0.01);
		assertEquals(null, plan.getCorridorAtTime(new GregorianCalendar(2014, 10, 7, 4, 42)));
	}

}
