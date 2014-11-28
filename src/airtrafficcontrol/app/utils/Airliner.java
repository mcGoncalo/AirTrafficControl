package airtrafficcontrol.app.utils;

import airtrafficcontrol.app.exceptions.InvalidArgumentException;

/**
 * Creates an airliner
 * 
 * @author Eva Gomes, Hugo Leal, Lucas Andrade
 *  
 * @author (revisão) Filipa Estiveira, Filipa Gonçalves, Gonçalo Carvalho, José Oliveira
 */

public class Airliner extends Airship{

	private int passengersNum;
	
	public Airliner(String flightID, GeographicalPosition statingPosition, FlightPlan flightPlan, int passengers) throws InvalidArgumentException {
		super(flightID, statingPosition, flightPlan);
		
		passengersNum = passengers;
	}

	
	/**
	 * @return the number of passengers in the airplane
	 */
	public int getPassengersNumber()
	{
		return passengersNum;
	}
	
	/**
	 * sets the number of passengers to 0
	 */
	protected void removePassengers()
	{
		passengersNum = 0;
	}
	
	
	/**
	 * Verifies if the airliner is with 0 passengers
	 * @param airliner
	 * @return true if the airliner has 0 passengers else returns false
	 */
	public boolean isEmpty(Airliner airliner)
	{
		if(airliner.getPassengersNumber() == 0)
			return true;
		else 
			return false;
	}
}
