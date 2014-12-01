package airtrafficcontrol.airCraftCoordinates;

import airtrafficcontrol.app.exceptions.InvalidArgumentException;

/**
 * This class represents an Altitude value.
 */
public class Altitude extends AGeographicalCoordinate
{
	private static final double MIN_ALTITUDE = 0;
	
	/**
	 * Constructs a value of altitude
	 * @param alt altitude value
	 */
	public Altitude( double altitude ) throws InvalidArgumentException
	{
		super( altitude, MIN_ALTITUDE );
	}
	
}
