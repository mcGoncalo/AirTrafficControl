package airtrafficcontrol.airCraftCoordinates;

import airtrafficcontrol.app.exceptions.InvalidArgumentException;

/**
 * This class represents an Altitude value.
 */
public class Altitude extends AGeographicalCoordinate
{
	private static final double MIN_ALTITUDE = 0;
	private double altitude;

	/**
	 * Constructs a value of altitude
	 * @param alt altitude value
	 */
	public Altitude( double altitude ) throws InvalidArgumentException
	{
		super( altitude, MIN_ALTITUDE );
		this.altitude = altitude;
	}
	
	/**
	 * Sets a new altitude value
	 * @param alt new altitude value
	 */
	public void setAltitude(double alt) throws InvalidArgumentException
	{
		this.altitude = alt;
		if(alt < 0 )
			throw new InvalidArgumentException();
	}
	
	/**
	 * Sets a new altitude value
	 * @param alt object that contains the new altitude value
	 */
	public void setAltitude(Altitude alt)throws InvalidArgumentException
	{
		this.altitude = alt.getGeographicalCoordinate();
	}
}
