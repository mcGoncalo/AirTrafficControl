package airtrafficcontrol.tests;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import airtrafficcontrol.AirShipPlan.FlightPlan;
import airtrafficcontrol.airCraftCoordinates.GeographicalPosition;
import airtrafficcontrol.airCraftCoordinates.*;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;
import airtrafficcontrol.hangar.AirCraft;
import airtrafficcontrol.hangar.AirPlane;
import airtrafficcontrol.hangar.CivilAirPlane;
import airtrafficcontrol.towerControl.ReadListOfFlights;
import airtrafficcontrol.towerControl.ReportGenerator;

public class AirlinerTest {
	
	Calendar date1;
	Calendar date2;
	CivilAirPlane air1;
	CivilAirPlane air2;
	AirCraft air3;
	AirCraft air4;
	
	@Before
	public void constructTwoAirplanes() throws InvalidArgumentException
	{
		date1 = new GregorianCalendar();
		date2 = ReadListOfFlights.createDefensiveCopyOfTheDate(date1);
		date2.add(Calendar.MINUTE, 20);
		Latitude latitude = new Latitude(0);
		Longitude longitude = new Longitude(0);
		Altitude altitude = new Altitude(0);
		GeographicalPosition geoPosition = new GeographicalPosition(latitude, longitude, altitude);
		
		air1 = new CivilAirPlane("mgrf", geoPosition, new FlightPlan(date1, date2, 8, 10, 4), 202);
		air2 = new CivilAirPlane("mgrf", geoPosition, new FlightPlan(date1, date2, 8, 10, 4), 441);
	}
	
	@Test
	public void shouldReturnTheCorredtNumberOfPassengers()
	{
		assertEquals(202, air1.getPassengersNumber());
		assertEquals(441, air2.getPassengersNumber());
	}
	
//	@Test
//	public void shouldAlterTheNumberOfMinutesToTakeOffOfAllThePreviouslyConstructedAircraftAndAllThatWillBeConstructedInTheFuture() throws InvalidArgumentException {
//		assertEquals(8, arl.getNumberOfMinutesToTakeOff());
//		assertEquals(8, arl2.getNumberOfMinutesToTakeOff());
//		assertEquals(8, arl.getNumberOfMinutesToTakeOff());
//		
//		arl.setNumberOfMinutesToTakeOff(14);
//		
//		assertEquals(14, arl.getNumberOfMinutesToTakeOff());
//		assertEquals(14, arl2.getNumberOfMinutesToTakeOff());
//		assertEquals(14, arl.getNumberOfMinutesToTakeOff());
//
//		arl3 = new AirPlane("mgrf", new GeographicalPosition(0,0,0), 
//				new FlightPlan(date1, date2),1);
//		arl4 = new AirPlane("mgrf", new GeographicalPosition(0,0,0), 
//				new FlightPlan(date1, date2),1);
//		
//		assertEquals(14, arl3.getNumberOfMinutesToTakeOff());
//		assertEquals(14, arl4.getNumberOfMinutesToTakeOff());
//		assertEquals(14, arl.getNumberOfMinutesToTakeOff());
//	}
//	
//	@Test
//	public void shouldAlterTheNumberOfMinutesToLandOfAllThePreviouslyConstructedAircraftAndAllThatWillBeConstructedInTheFuture() throws InvalidArgumentException {
//		assertEquals(10, arl.getNumberOfMinutesToLand());
//		assertEquals(10, arl2.getNumberOfMinutesToLand());
//		assertEquals(10, arl.getNumberOfMinutesToLand());
//		
//		arl.setNumberOfMinutesToLand(20);
//		
//		assertEquals(20, arl.getNumberOfMinutesToLand());
//		assertEquals(20, arl2.getNumberOfMinutesToLand());
//		assertEquals(20, arl.getNumberOfMinutesToLand());
//
//		arl3 = new AirPlane("mgrf", new GeographicalPosition(0,0,0), 
//				new FlightPlan(date1, date2),1);
//		arl4 = new AirPlane("mgrf", new GeographicalPosition(0,0,0), 
//				new FlightPlan(date1, date2),1);
//		
//		assertEquals(20, arl3.getNumberOfMinutesToLand());
//		assertEquals(20, arl4.getNumberOfMinutesToLand());
//		assertEquals(20, arl.getNumberOfMinutesToLand());
//	}
//	
//	@Test
//	public void shouldAlterTheNumberOfMinutesToSwitchCorridorOfAllThePreviouslyConstructedAircraftAndAllThatWillBeConstructedInTheFuture() throws InvalidArgumentException {
//		
//		assertEquals(4, arl.getNumberOfMinutesToSwitchCorridor());
//		assertEquals(4, arl2.getNumberOfMinutesToSwitchCorridor());
//		assertEquals(4, arl.getNumberOfMinutesToSwitchCorridor());
//		
//		arl.setNumberOfMinutesToSwitchCorridor(1);
//		
//		assertEquals(1, arl.getNumberOfMinutesToSwitchCorridor());
//		assertEquals(1, arl2.getNumberOfMinutesToSwitchCorridor());
//		assertEquals(1, arl.getNumberOfMinutesToSwitchCorridor());
//
//		arl3 = new AirPlane("mgrf", new GeographicalPosition(0,0,0), 
//				new FlightPlan(date1, date2),1);
//		arl4 = new AirPlane("mgrf", new GeographicalPosition(0,0,0), 
//				new FlightPlan(date1, date2),1);
//		
//		assertEquals(1, arl3.getNumberOfMinutesToSwitchCorridor());
//		assertEquals(1, arl4.getNumberOfMinutesToSwitchCorridor());
//		assertEquals(1, arl.getNumberOfMinutesToSwitchCorridor());
//	}
}
