package airtrafficcontrol.app.utils;

import airtrafficcontrol.app.exceptions.*;

/**
 * Creates a military transport airplane. 
 * @author Eva Gomes, Hugo Leal, Lucas Andrade
 *  
 * @author (revisão) Filipa Estiveira, Filipa Gonçalves, Gonçalo Carvalho, José Oliveira
 */

public class CivilCargoAirCraft extends TransportAirship{
	

	private int passengersNum;

	/**
	 * Creates a new airplane, with all its properties 
	 * @param flightID - the id of the flight
	 * @param statingPosition - the take off coordinates
	 * @param flightPlan - the plan of the flight
	 * @param armament - whether it carries armament or not
	 * @throws InvalidArgumentException 
	 */
	public CivilCargoAirCraft(String flightID, GeographicalPosition statingPosition, FlightPlan flightPlan, int passengersNum) throws InvalidArgumentException {
		super(flightID, statingPosition, flightPlan );
		
		this.passengersNum = passengersNum;
		
		if(flightID==null || statingPosition == null || flightPlan == null)
			throw new InvalidArgumentException();
	}
	

	@Override
	public int getPassengersNumber()
	{
		return passengersNum;
	}
}
