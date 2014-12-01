package airtrafficcontrol.airCraftCoordinates;

import airtrafficcontrol.app.exceptions.InvalidArgumentException;


/**
 * 
 *
 * @author Filipa Estiveira, Filipa Gonçalves, Gonçalo Carvalho, José Oliveira
 */

public abstract class AGeographicalCoordinate
{
	private double geographicalCoordinate;

	
	/**
	 * 
	 * @param geographicalCoordinate
	 * @param max
	 * @param min
	 * @throws InvalidArgumentException
	 */
	public AGeographicalCoordinate( double geographicalCoordinate, double max, double min) throws InvalidArgumentException
	{
		if( geographicalCoordinate <= max && geographicalCoordinate >= min )
			this.geographicalCoordinate = geographicalCoordinate;
		
		else throw new InvalidArgumentException( "INVALID LATITUDE VALUE!" );
	}
	
	/**
	 * 
	 * @param geographicalCoordinate
	 * @param min
	 * @throws InvalidArgumentException
	 */
	public AGeographicalCoordinate( double geographicalCoordinate, double min ) throws InvalidArgumentException
	{
		if( geographicalCoordinate >= min )
			this.geographicalCoordinate = geographicalCoordinate;
		
		else throw new InvalidArgumentException( "INVALID LATITUDE VALUE!" );
	}
	
	
	
	/**
	 * Returns the latitude's value.
	 * 
	 * @return The latitude's value.
	 */
	public double getGeographicalCoordinate()
	{
		return geographicalCoordinate;
	}
	
	
}



