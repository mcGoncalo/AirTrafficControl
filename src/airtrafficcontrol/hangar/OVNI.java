package airtrafficcontrol.hangar;

import airtrafficcontrol.airCraftCoordinates.GeographicalPosition;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;

public class OVNI extends AirCraft
{
	public OVNI( GeographicalPosition statingPosition)
			throws InvalidArgumentException
	{
		super("UFO", statingPosition);
	}
}
