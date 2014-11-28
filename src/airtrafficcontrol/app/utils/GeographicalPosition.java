package airtrafficcontrol.app.utils;


/**
 * Class whose instances represent geographical positions defined by a value of latitude, a value of longitude and
 * a value of altitude.
 * @author Eva Gomes, Hugo Leal, Lucas Andrade
 *  
 * @author (revisão) Filipa Estiveira, Filipa Gonçalves, Gonçalo Carvalho, José Oliveira
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
	 * @param lat
	 *            latitude
	 * @param lon
	 *            longitude
	 * @param alt
	 *            altitude
	 */
	public GeographicalPosition( Latitude lat, Longitude lon, Altitude alt )
	{
		latitude = lat;
		longitude = lon;
		altitude = alt;
	}
	
	
	
	/**
	 * Gets the longitude value
	 * 
	 * @return longitude value
	 */
	public double getLongitude()
	{
		return longitude.getGeographicalCoordinate();
	}
	
	/**
	 * Gets the latitude value
	 * 
	 * @return value of latitude
	 */
	public double getLatitude()
	{
		return latitude.getGeographicalCoordinate();
	}
	
	/**
	 * Gets the altitude value
	 * 
	 * @return value of altitude
	 */
	public double getAltitude()
	{
		return altitude.getGeographicalCoordinate();
	}

	
}