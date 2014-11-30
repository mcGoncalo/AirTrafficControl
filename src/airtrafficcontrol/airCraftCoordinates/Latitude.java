package airtrafficcontrol.airCraftCoordinates;


import airtrafficcontrol.app.exceptions.InvalidArgumentException;


/**
 * Class whose instances represent a latitude value.
  */
public class Latitude extends AGeographicalCoordinate
{
	private static final double MAX_LATITUDE = 90;
	private static final double MIN_LATITUDE = -90;
	private double latitude;

	/**
	 * Constructs an instance of {@link Latitude} with value {@code lat}.
	 * 
	 * @param lat
	 *            The latitude value.
	 * @throws InvalidArgumentException
	 *             If {@code lat > MAX_LATITUDE} or {@code lat < MIN_LATITUDE}.
	 */
	public Latitude( double latitude ) throws InvalidArgumentException
	{
		super( latitude, MAX_LATITUDE, MIN_LATITUDE );
		this.latitude = latitude;
	}
	
	
	/**
	 * Sets a new latitude value.
	 * 
	 * @param lat
	 *            The new latitude value.
	 * @throws InvalidArgumentException
	 *             If {@code lat > MAX_LATITUDE} or {@code lat < MIN_LATITUDE}.
	 */
	public void setLatitude( double lat ) throws InvalidArgumentException {
		
		if( lat <= MAX_LATITUDE && lat >= MIN_LATITUDE )
			this.latitude = lat;
		
		else throw new InvalidArgumentException( "INVALID LATITUDE VALUE!" );
		
	}

	
	/**
	 * Sets a new latitude value.
	 * 
	 * @param lat
	 *            The new latitude value.
	 * @throws InvalidArgumentException
	 *             If {@code lat} is {@code null}.
	 */
	public void setLatitude( Latitude lat ) throws InvalidArgumentException {
		
		if( lat == null )
			throw new InvalidArgumentException( "INVALID LATITUDE VALUE!" );
		
		this.latitude = lat.getGeographicalCoordinate();
	}
}
