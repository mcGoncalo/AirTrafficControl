package airtrafficcontrol.airCraftCoordinates;

import airtrafficcontrol.app.exceptions.InvalidArgumentException;

public abstract class AGeographicalCoordinate
{
	private double geographicalCoordinate;

	private double max;
	private double min;
	
	public AGeographicalCoordinate( double geographicalCoordinate, double max, double min) throws InvalidArgumentException
	{
		this.max = max;
		this.min = min;
		if( geographicalCoordinate <= max && geographicalCoordinate >= min )
			this.geographicalCoordinate = geographicalCoordinate;
		
		else throw new InvalidArgumentException( "INVALID LATITUDE VALUE!" );
	}
	
	public AGeographicalCoordinate( double geographicalCoordinate, double min) throws InvalidArgumentException
	{
		this.min = min;
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



