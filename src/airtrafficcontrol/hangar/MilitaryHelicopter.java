package airtrafficcontrol.hangar;

import airtrafficcontrol.AirShipPlan.FlightPlan;
import airtrafficcontrol.airCraftCoordinates.GeographicalPosition;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;




/**
 * This class defines if an aircraft is a military helicopter
 * @author Filipa Estiveira, Filipa Gonçalves, Gonçalo Carvalho, José Oliveira
 */
public class MilitaryHelicopter extends AirPlane implements IMilitary
{
	private boolean hasArmament;

	
	/**
	 * This constructor defines the military helicopter
	 */
	public MilitaryHelicopter(String flightID,
			GeographicalPosition statingPosition, FlightPlan flightPlan, boolean hasArmament) throws InvalidArgumentException
	{
		super(flightID, statingPosition, flightPlan );
		this.hasArmament = hasArmament;
	}

	
	/**
	 * This method differentiates military from civil
	 */
	@Override
	public boolean hasArmament()
	{
		return hasArmament;
	}

}
