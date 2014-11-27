package airtrafficcontrol.app.utils;

import airtrafficcontrol.app.exceptions.InvalidArgumentException;

/**
 * This class represents an Altitude value.
 *@author Eva Gomes
 *@author Hugo Leal
 *@author Lucas Andrade
 *
 * */
public class Altitude extends AGeographicalCoordinate
{
	private static final double MIN_ALTITUDE = 0;

	/**
	 * Constructs a value of altitude
	 * @param alt altitude value
	 */
	public Altitude( double altitude )throws InvalidArgumentException
	{
		super( altitude, MIN_ALTITUDE );
	}
}
