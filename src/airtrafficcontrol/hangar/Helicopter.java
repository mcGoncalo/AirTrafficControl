package airtrafficcontrol.hangar;

import airtrafficcontrol.AirShipPlan.FlightPlan;
import airtrafficcontrol.airCraftCoordinates.GeographicalPosition;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;

/**
 *  This is an abstract class, it is the abstraction of helicopter, not any particular one 
 * @author (revisão) Filipa Estiveira, Filipa Gonçalves, Gonçalo Carvalho, José Oliveira
 */
public abstract class Helicopter extends Airship
{
	
	/**
	 * This constructor identifies an helicopter, throwing an exception if the 
	 * helicopter isn't properly identified
	 */
	public Helicopter( String flightID, GeographicalPosition statingPosition,
			FlightPlan flightPlan) throws InvalidArgumentException
	{
		super(flightID, statingPosition, flightPlan);
	}
}
