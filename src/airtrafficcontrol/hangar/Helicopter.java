package airtrafficcontrol.hangar;

import airtrafficcontrol.AirShipPlan.FlightPlan;
import airtrafficcontrol.airCraftCoordinates.GeographicalPosition;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;

/**
 *  
 * @author (revisão) Filipa Estiveira, Filipa Gonçalves, Gonçalo Carvalho, José Oliveira
 */
public abstract class Helicopter extends Airship
{
	public Helicopter( String flightID, GeographicalPosition statingPosition,
			FlightPlan flightPlan) throws InvalidArgumentException
	{
		super(flightID, statingPosition, flightPlan);
	}
}
