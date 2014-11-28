package airtrafficcontrol.hangar;

import airtrafficcontrol.AirShipPlan.FlightPlan;
import airtrafficcontrol.airCraftCoordinates.GeographicalPosition;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;

public class CivilAirPlane extends AirPlane implements ICivil
{
	private int passengersNum;
	
	public CivilAirPlane(String flightID, GeographicalPosition statingPosition,
			FlightPlan flightPlan, int passengers)
			throws InvalidArgumentException
	{
		super(flightID, statingPosition, flightPlan );
		this.passengersNum = passengers;
	}
	
	/**
	 * @return the number of passengers in the airplane
	 */
	public int getPassengersNumber()
	{
		return passengersNum;
	}
	
	/**
	 * sets the number of passengers to 0
	 */
	protected void removePassengers()
	{
		passengersNum = 0;
	}
	
		
	/**
	 * @param airliner
	 * @return true if the CivilAirPlane has 0 passengers, false otherwise
	 */
	public boolean isEmpty()
	{
		if( getPassengersNumber() == 0 )
			return true;
		else 
			return false;
	}

}
