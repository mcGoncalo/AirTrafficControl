package airtrafficcontrol.hangar;

/**
 * All classes that implements this interface must have a integer field which indicates the number of passengers
 * This condition must be passed by the constructor.
 * 
 * @author Filipa Estiveira, Filipa Gonçalves, Gonçalo Carvalho, José Oliveira
 */
public interface ICivil
{
	/**
	 * @return the number of passengers
	 */
	public int getPassengersNumber();

}
