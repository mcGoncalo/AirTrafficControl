package airtrafficcontrol.hangar;

import java.util.LinkedList;

import airtrafficcontrol.airCraftCoordinates.GeographicalPosition;
import airtrafficcontrol.app.exceptions.InvalidArgumentException;

/**
 * tem uma posiçao e ID
 * @author 
 */
public abstract class AirCraft
{
	/**
	 * This airship's flightID.
	 */
	private String flightID;
	
	/**
	 * This airship's last know geographical positions.
	 */
	private LinkedList< GeographicalPosition > lastKnownGeograficalPositions;
	
	/**
	 * 
	 */
	private boolean positionWasUpdated = false;
	
	/**
	 * Constructs an airplane with the ID {@code flightID}, the take off
	 * coordinates {@code statingPostition} and the flight plan
	 * {@code flightPlan}. Also creates a structure to save the airship's last
	 * known geographical positions.
	 * 
	 * @param flightID
	 *            The flight's ID.
	 * @param statingPosition
	 *            The coordinates where the airship will take-off.
	 * @param flightPlan
	 *            The plan of the flight.
	 * @throws InvalidArgumentException
	 *             If {@code flightID}, {@code statingPosition} or
	 *             {@code flightPlan} are null.
	 */
	public AirCraft( String flightID, GeographicalPosition statingPosition ) throws InvalidArgumentException
	{
		if( flightID == null || statingPosition == null)
			throw new InvalidArgumentException();
		
		this.flightID = flightID;
		this.lastKnownGeograficalPositions = new LinkedList< GeographicalPosition >();
		lastKnownGeograficalPositions.add( statingPosition );
	}
	
	/**
	 * @return the ID of the plane
	 */
	public String getFlightID()
	{
		return flightID;
	}
	
	/**
	 * @return the geographical position of the airplane
	 */
	public GeographicalPosition getGeographicPosition() {
		return lastKnownGeograficalPositions.getFirst();
	}
	
	/**
	 * all the last known geographic positions of the aircraft
	 * 
	 * @return an array of objects of type object, where all the known
	 *         geographic positions of the aircraft are saved as
	 *         GeographicalPosition objects
	 */
	public Object[] getLastKnownGeographicPosition() {
		return lastKnownGeograficalPositions.toArray();
	}
	

	
	/**
	 * @param newGeographicalPosition
	 *            - updates the geographical position to a new one
	 * @throws InvalidArgumentException
	 */
	public void updateGeographicPosition( GeographicalPosition newGeographicalPosition )
			throws InvalidArgumentException
	{
		if( newGeographicalPosition == null )
			throw new InvalidArgumentException();
		
		positionWasUpdated = true;
		lastKnownGeograficalPositions.addFirst( newGeographicalPosition );
	}
	
	/**
	 * @return true if the position was updated since the last time
	 *         positionToString() was called
	 * @return false if it was not
	 */
	public boolean wasPositionUpdated()
	{
		return positionWasUpdated;
	}
	
	/**
	 * sets positionWasUpdated to false
	 */
	protected void setToNotUpdated()
	{
		positionWasUpdated = false;
	}
	
	/**
	 * returns if the airship is flying
	 * 
	 * @param airship
	 * @return true if airship is flying else returns false
	 */
	public boolean isFlying( Airship airship )
	{
		double currentAltitude = airship.getGeographicPosition().getAltitude();
		if( currentAltitude != 0 )
			return true;
		else return false;
	}
	
//TODO
//ver depois
//	/**
//	 * @return returns a string with the id, position, and observations about
//	 *         the airplane
//	 * @throws InvalidArgumentException
//	 */
//	public String positionToString() throws InvalidArgumentException
//	{
//		StringBuilder builder = new StringBuilder();
//		GeographicalPosition pos = getGeographicPosition();
//		builder.append( flightID ).append( " " ).append( pos.getLatitude() )
//				.append( " " ).append( pos.getLongitude() ).append( " " )
//				.append( pos.getAltitude() ).append( " " )
//				.append( getObservations() );
//		return builder.toString();
//	}
	
}
