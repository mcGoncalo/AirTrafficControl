package airtrafficcontrol.hangar;

import airtrafficcontrol.AirShipPlan.FlightPlan;
import airtrafficcontrol.airCraftCoordinates.GeographicalPosition;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;

public class CivilAirPlane extends AirPlane implements ICivil
{
	private int passengersNum;
	
	public CivilAirPlane( 	String flightID,
							GeographicalPosition statingPosition,
							FlightPlan flightPlan,
							int passengers
						) throws InvalidArgumentException
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
	public boolean verifyEmptyPlaces()
	{
		if( getPassengersNumber() == 0 )
			return true;
		else 
			return false;
	}
	
	/**
	 * The number of minutes the airship has to land so that when he abandons
	 * the current established air corridor, this occurrence will not be reported
	 * as an error.
	 */
	public int getTimeToLand()
	{		
		return super.getPlan().getNumberOfMinutesToLand();
	}
	
	
	/**
	 * The number of minutes the airship has to take-off and reach the first air
	 * corridor.
	 */
	public int getTimeToTakeOff()
	{		
		return super.getPlan().getNumberOfMinutesToTakeOff();
	}
	
	
	/**
	 * The number of minutes the airship has to switch from an established
	 * altitude corridor to next one established.
	 */
	public int getTimeToSwitchCorridor()
	{		
		return super.getPlan().getNumberOfMinutesToSwitchCorridor();
	}
	
	
	

	public void setTimeToLand(int newTime) throws InvalidArgumentException
	
	{		
		
		super.getPlan().setNumberOfMinutesToLand(newTime);
	}
	
	
	/**
	 * The number of minutes the airship has to take-off and reach the first air
	 * corridor.
	 */
	public void setTimeToTakeOff(int newTime) throws InvalidArgumentException
	{		
		super.getPlan().setNumberOfMinutesToTakeOff(newTime);
	}
	
	
	/**
	 * The number of minutes the airship has to switch from an established
	 * altitude corridor to next one established.
	 */
	public void setTimeToSwitchCorridor(int newTime) throws InvalidArgumentException
	{		
		super.getPlan().setNumberOfMinutesToSwitchCorridor(newTime);
	}

}
