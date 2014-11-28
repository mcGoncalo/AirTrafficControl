package airtrafficcontrol.hangar;

import airtrafficcontrol.AirShipPlan.FlightPlan;
import airtrafficcontrol.airCraftCoordinates.GeographicalPosition;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;

public class MilitaryAirPlane extends AirPlane implements IMilitary
{
	private boolean hasArmament;

	public MilitaryAirPlane(String flightID,
			GeographicalPosition statingPosition, FlightPlan flightPlan,
			boolean hasArmament) throws InvalidArgumentException
	{
		super(flightID, statingPosition, flightPlan );
		this.hasArmament = hasArmament;
	}

	@Override
	public boolean hasArmament()
	{
		return hasArmament;
	}

}
