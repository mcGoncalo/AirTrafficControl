package airtrafficcontrol.app.utils;

import airtrafficcontrol.app.exceptions.InvalidArgumentException;

/**
 * Creates an airliner
 * 
 *
 *@author Eva Gomes
 *@author Hugo Leal
 *@author Lucas Andrade
 */
public class PrivateJet extends Airliner{

//	private int numberOfMinutesToTakeOff = 9;
//	private int numberOfMinutesToLand = 9;
//	private int numberOfMinutesToSwitchCorridor = 6;
//	private int newnumberOfMinutesToTakeOff;
//	private int newnumberOfMinutesToLand;
//	private int newnumberOfMinutesToSwitchCorridor;
//	private boolean newTakeOff = false;
//	private boolean newLand = false;
//	private boolean newSwitch = false;
	
	public PrivateJet(String flightID, GeographicalPosition statingPosition,
			FlightPlan flightPlan, int passengers) throws InvalidArgumentException {
		super(flightID, statingPosition, flightPlan, passengers);
		
	}
	
	
	
	
	
	
	
	
//	/**
//	 * sets a new number of minutes for the take off of this class' airplanes.
//	 * this will affect all the airplanes of this type, that were already constructed
//	 * and all that will be constructed in the future
//	 * @param newTime - the new number of minutes this class of airplane needs to take off
//	 */
//	public void setNumberOfMinutesToTakeOff(int newTime) throws InvalidArgumentException
//	{
//		if (newTime == 0)
//			throw new InvalidArgumentException();
//		
//		numberOfMinutesToTakeOff = newTime;
//		newnumberOfMinutesToTakeOff = newTime;
//		newTakeOff = true;
//	}
//	
//	/**
//	 * sets a new number of minutes for the land of this class' airplanes.
//	 * this will affect all the airplanes of this type, that were already constructed
//	 * and all that will be constructed in the future
//	 * @param newTime - the new number of minutes this class of airplane needs to land
//	 */
//	public void setNumberOfMinutesToLand(int newTime) throws InvalidArgumentException
//	{
//		if (newTime == 0)
//			throw new InvalidArgumentException();
//		
//		numberOfMinutesToLand = newTime;
//		newnumberOfMinutesToLand = newTime;
//		newLand = true;
//	}
//	
//	/**
//	 * sets a new number of minutes for switching lanes of this class' airplanes.
//	 * this will affect all the airplanes of this type, that were already constructed
//	 * and all that will be constructed in the future
//	 * @param newTime - the new number of minutes this class of airplane needs to switch lanes
//	 */
//	public void setNumberOfMinutesToSwitchCorridor(int newTime) throws InvalidArgumentException
//	{
//		if (newTime == 0)
//			throw new InvalidArgumentException();
//		
//		numberOfMinutesToSwitchCorridor = newTime;
//		newnumberOfMinutesToSwitchCorridor = newTime;
//		newSwitch = true;
//	}
//	
//	/**
//	 * @return the number of minutes the airplanes of this class need to take off
//	 */
//	public int getNumberOfMinutesToTakeOff()
//	{
//		return numberOfMinutesToTakeOff;
//	}
//	
//	/**
//	 * @return - the number of minutes the airplanes of this class need to land
//	 */
//	public int getNumberOfMinutesToLand()
//	{
//		return numberOfMinutesToLand;
//	}
//	
//	/**
//	 * @return - the number of minutes the airplanes of this class need to switch lanes
//	 */
//	public int getNumberOfMinutesToSwitchCorridor()
//	{
//		return numberOfMinutesToSwitchCorridor;
//	}

}
