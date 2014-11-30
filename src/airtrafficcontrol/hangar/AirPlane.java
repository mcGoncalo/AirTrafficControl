package airtrafficcontrol.hangar;

import airtrafficcontrol.AirShipPlan.FlightPlan;
import airtrafficcontrol.airCraftCoordinates.GeographicalPosition;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;

/**
 * Creates an airliner
 * 
 *
 *@author Eva Gomes
 *@author Hugo Leal
 *@author Lucas Andrade
 */
public abstract class AirPlane extends Airship
{
	
	
	public AirPlane(String flightID, GeographicalPosition statingPosition, FlightPlan flightPlan )
			throws InvalidArgumentException
	{
		super(flightID, statingPosition, flightPlan);
	}
	
	
	
}
