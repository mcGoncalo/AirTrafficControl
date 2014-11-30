package airtrafficcontrol.hangar;

import airtrafficcontrol.AirShipPlan.FlightPlan;
import airtrafficcontrol.airCraftCoordinates.GeographicalPosition;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;

public class CivilHelicopter extends Helicopter implements ICivil
{
	private int passengers;
	
	public CivilHelicopter(String flightID,
			GeographicalPosition statingPosition, FlightPlan flightPlan, int passengers )
			throws InvalidArgumentException
	{
		super(flightID, statingPosition, flightPlan);
		this.passengers = passengers;
	}

	@Override
	public int getPassengersNumber()
	{
		return passengers;
	}

	@Override
	/**
	 * @param airliner
	 * @return true if the CivilAirPlane has 0 passengers, false otherwise
	 */
	public boolean verifyEmptyPlaces()
	{
		if( getPassengersNumber() == 0 )
			return true;
		else 
			return false;
	}
}
