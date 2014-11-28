package airtrafficcontrol.app.utils;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;

/**
 * 
 * class of civil aircraft used to transport cargo
 *
 * @author Eva Gomes, Hugo Leal, Lucas Andrade
 *  
 * @author (revisão) Filipa Estiveira, Filipa Gonçalves, Gonçalo Carvalho, José Oliveira
 */


public class CargoAircraft extends Airship{


	/**
	 * creates a new cargo airplane with all its properties
	 * 
	 * @param flightID - the ID of the flight
	 * @param statingPosition - the coordinates of where the airplane will take off
	 * @param flightPlan - the plan of the flight
	 */
	public CargoAircraft(String flightID, GeographicalPosition statingPosition,
			FlightPlan flightPlan) throws InvalidArgumentException {
		super(flightID, statingPosition, flightPlan);
		
	}
	
}
