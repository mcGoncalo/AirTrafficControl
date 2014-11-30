package airtrafficcontrol.airCraftCoordinates;

import airtrafficcontrol.app.exceptions.InvalidArgumentException;

/**
 * This class represents a Longitude value.
 *
 */

public class Longitude extends AGeographicalCoordinate
{	
	private static final double MAX_LONGITUDE = 180;
	private static final double MIN_LONGITUDE = -180;
	private double longitude;
	
	/**
	 * Constructs a value of longitude
	 * @param lon longitude value
	 */
	public Longitude( double longitude ) throws InvalidArgumentException
	{
		super( longitude, MAX_LONGITUDE, MIN_LONGITUDE );
		this.longitude = longitude;
	}
	
	/**
	 *  Sets a new longitude value
	 * @param lon new longitude value
	 */
	public void setLongitude(double lon) throws InvalidArgumentException
	{
		if(longitude < MAX_LONGITUDE && longitude > MIN_LONGITUDE )
			this.longitude = lon;
			else
				throw new InvalidArgumentException();
	}
	
	/**
	 * Sets a new longitude value
	 * @param lon object that contains the new longitude value
	 */
	public void setLongitude(Longitude lon)
	{
		this.longitude = lon.getGeographicalCoordinate();
	}
}