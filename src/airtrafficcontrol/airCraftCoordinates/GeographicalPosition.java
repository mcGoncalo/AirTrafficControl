package airtrafficcontrol.airCraftCoordinates;

import airtrafficcontrol.app.exceptions.InvalidArgumentException;


/**
 * Class whose instances represent geographical positions defined by a value of latitude, a value of longitude and
 * a value of altitude.
 */
public class GeographicalPosition
{
	/**
	 * This geographical position's latitude.
	 */
	private Latitude latitude;
	
	/**
	 * This geographical position's longitude.
	 */
	private Longitude longitude;
	
	/**
	 * This geographical position's altitude.
	 */
	private Altitude altitude;
	
	
	
	//CONSTRUTOR
	
	
	/**
	 * Constructs an instance of {@link GeographicalPosition} with latitude {@code lat}, longitude {@code lon} and altitude {@code alt}.
	 * 
	 * @param latitude
	 *            latitude
	 * @param lon
	 *            longitude
	 * @param alt
	 *            altitude
	 */
	public GeographicalPosition( Latitude latitude, Longitude longitude, Altitude altitude )
	{
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
	}
	
	
	/**
	 * Constructs a GeographicalPosition with latitude, longitude and altitude
	 * defined by lan, lon and alt
	 * 
	 * @param lat
	 *            latitude value
	 * @param lon
	 *            longitude value
	 * @param alt
	 *            altitude value
	 */
	public GeographicalPosition( double lat, double lon, double alt )
			throws InvalidArgumentException {
		latitude = new Latitude( lat );
		longitude = new Longitude( lon );
		altitude = new Altitude( alt );
	}
	
	
	/**
	 * @return longitude value
	 */
	public double getLongitude()
	{
		return longitude.getGeographicalCoordinate();
	}
	
	
	/**
	 * @return value of latitude
	 */
	public double getLatitude()
	{
		return latitude.getGeographicalCoordinate();
	}
	
	
	/**
	 * @return value of altitude
	 */
	public double getAltitude()
	{
		return altitude.getGeographicalCoordinate();
	}

	
	
	/**
	 * Sets a new GeographicalPosition with lat, lon and alt
	 * 
	 * @param lat
	 *            new latitude value
	 * @param lon
	 *            new longitude value
	 * @param alt
	 *            new altitude value
	 */
	public void setPosition( double lat, double lon, double alt )
			throws InvalidArgumentException {
		latitude.setLatitude( lat );
		longitude.setLongitude( lon );
		altitude.setAltitude( alt );
	}
	
	/**
	 * Sets a new GeographicalPosition with lat, lon and alt
	 * 
	 * @param lat
	 *            object with the new latitude value
	 * @param lon
	 *            object with the new longitude value
	 * @param alt
	 *            object with the new altitude value
	 */
	public void setPosition( Latitude lat, Longitude lon, Altitude alt )
			throws InvalidArgumentException {
		latitude.setLatitude( lat );
		longitude.setLongitude( lon );
		altitude.setAltitude( alt );
	}
	
		
	/**
	 * Sets a new value for altitude
	 * 
	 * @param alt
	 *            new value of altitude
	 */
	public void setAltitude( double alt ) throws InvalidArgumentException {
		altitude.setAltitude( alt );
	}
	
	
	
	/**
	 * Sets a new value for altitude
	 * 
	 * @param alt
	 *            object that contains the new altitude value
	 */
	public void setAltitude( Altitude alt ) throws InvalidArgumentException {
		altitude.setAltitude( alt );
	}
	
	
	
	/**
	 * Sets a new value for the latitude of this {@link GeographicalPosition}.
	 * 
	 * @param lat
	 *            The new value of latitude.
	 * @throws InvalidArgumentException
	 *             If {@code lat<}{@link {@link Latitude#MIN_LATITUDE
	 *             MIN_LATITUDE} or if {@code lat>}{@link
	 *             {@link Latitude#MAX_LATITUDE MAX_LATITUDE}.
	 */
	public void setLatitude( double lat ) throws InvalidArgumentException {
		latitude.setLatitude( lat );
	}
	
	/**
	 * Sets a new value for latitude
	 * 
	 * @param lat
	 *            object that contains the new latitude value
	 * @throws InvalidArgumentException
	 */
	public void setLatitude( Latitude lat ) throws InvalidArgumentException {
		latitude.setLatitude( lat );
	}
	
	
	
	/**
	 * Sets a new value for longitude
	 * 
	 * @param lon
	 *            new value of longitude
	 */
	public void setLongitude( double lon ) throws InvalidArgumentException {
		longitude.setLongitude( lon );
	}
	
	/**
	 * Sets a new value for longitude
	 * 
	 * @param lon
	 *            object that contains the new longitude value
	 */
	public void setLongitude( Longitude lon ) {
		longitude.setLongitude( lon );
	}
	
}