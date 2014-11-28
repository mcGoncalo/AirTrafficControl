package airtrafficcontrol.app.utils;

import airtrafficcontrol.app.exceptions.InvalidArgumentException;

/**
 * This class represents a Longitude value.
 * @author Eva Gomes, Hugo Leal, Lucas Andrade
 *  
 * @author (revisão) Filipa Estiveira, Filipa Gonçalves, Gonçalo Carvalho, José Oliveira
 */

public class Longitude extends AGeographicalCoordinate
{	
	private static final double MAX_LONGITUDE = 180;
	private static final double MIN_LONGITUDE = -180;
	
	/**
	 * Constructs a value of longitude
	 * @param lon longitude value
	 */
	public Longitude( double longitude ) throws InvalidArgumentException
	{
		super( longitude, MAX_LONGITUDE, MIN_LONGITUDE );
	}
}