package airtrafficcontrol.app.utils;

import airtrafficcontrol.app.exceptions.InvalidArgumentException;

/**
 * Creates an airliner
 * 
 * @author Eva Gomes, Hugo Leal, Lucas Andrade
 *  
 * @author (revisão) Filipa Estiveira, Filipa Gonçalves, Gonçalo Carvalho, José Oliveira
 */

public class PrivateJet extends Airliner{

	
	public PrivateJet(String flightID, GeographicalPosition statingPosition,
			FlightPlan flightPlan, int passengers) throws InvalidArgumentException {
		super(flightID, statingPosition, flightPlan, passengers);
		
	}

}
