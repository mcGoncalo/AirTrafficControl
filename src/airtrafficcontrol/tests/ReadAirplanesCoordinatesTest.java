package airtrafficcontrol.tests;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import airtrafficcontrol.AirShipPlan.AirCorridorInTime;
import airtrafficcontrol.AirShipPlan.AltitudeCorridor;
import airtrafficcontrol.AirShipPlan.FlightPlan;
import airtrafficcontrol.airCraftCoordinates.GeographicalPosition;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;
import airtrafficcontrol.app.exceptions.InvalidFlightIDException;
import airtrafficcontrol.hangar.AirCraft;
import airtrafficcontrol.hangar.AirPlane;
import airtrafficcontrol.hangar.CivilAirPlane;
import airtrafficcontrol.hangar.MilitaryAirPlane;
import airtrafficcontrol.towerControl.Database;
import airtrafficcontrol.towerControl.ReadAirplanesCoordinates;
import airtrafficcontrol.towerControl.ReportGenerator;



public class ReadAirplanesCoordinatesTest {

	ReadAirplanesCoordinates read;
	ReportGenerator rep;
	Database data;
	AirPlane airlWithZeroPass;
	AirPlane airlWithSameID;
	MilitaryAirPlane carg;
	FlightPlan plan;
	Map<String, AirCraft> dataMap;
	String source = "newCoordinatesTest.txt";
	MilitaryAirPlane transOutsideCorr;
	
	@Before
	public void constructAirplanesAndDatabase() throws InvalidArgumentException, InvalidFlightIDException
	{
		rep = new ReportGenerator();
		
		Calendar date1 = new GregorianCalendar();
		Calendar date2 = new GregorianCalendar();
		date2.add(12, 10);
		
		AltitudeCorridor corr = new AltitudeCorridor(80, 120);
		plan = new FlightPlan(date1, date2, 9,9,6);
		plan.addEvent(new AirCorridorInTime(date1, date2, corr));
		
		airlWithZeroPass = new CivilAirPlane("airl123", new GeographicalPosition(0,0,100), plan, 0);
		airlWithSameID = new CivilAirPlane("airl123", new GeographicalPosition(0,0,100), plan, 200);
		transOutsideCorr = new MilitaryAirPlane("trp123", new GeographicalPosition(0,0,50), plan, false);
		carg = new MilitaryAirPlane("crg123", new GeographicalPosition(0,0,100), plan, false);
		
		data = new Database();
		
		data.addAirship(airlWithZeroPass);
		data.addAirship(transOutsideCorr);
		
		dataMap = data.getDatabase();
	}
	
	
	@Test
	public void shouldGetEmptyFieldsFromFile() throws InvalidFlightIDException, InvalidArgumentException, IOException
	{
		// Arrange
		String sourceOfFlights = "newCoordinatesTest.txt";
		read = new ReadAirplanesCoordinates();
		String emptyFieldsExpected = "Empty Fields at Line: 5" + "\n";
		
		// Act
		read.readFromFile(sourceOfFlights, data);
		
		// Assert
		Assert.assertTrue(emptyFieldsExpected.equals(read.getEmptyFields()));
	}

}
