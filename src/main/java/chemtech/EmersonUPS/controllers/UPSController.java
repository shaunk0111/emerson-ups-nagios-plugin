package chemtech.EmersonUPS.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import chemtech.EmersonUPS.app.CliOptions;
import chemtech.EmersonUPS.models.UPSOidModel;
import chemtech.snmp.controllers.SnmpDataController;
import chemtech.snmp.models.SnmpOidModel;

public final class UPSController {

	private SnmpDataController dataController;
	private CliOptions cli;
	
	/**
	 * Controls Emerson UPS
	 * @param dataController
	 * @param cli
	 * @param dataList
	 */
	public UPSController(SnmpDataController dataController, 
			CliOptions cli, LinkedList<SnmpOidModel> dataList) {
		this.dataController = dataController;
		this.dataController.setData(dataList);
		this.cli = cli;
	}
	
	/**
	 * Event triggers data to be refreshed
	 * @throws Exception
	 */
	public void retrieveData() throws Exception {
		dataController.retrieveData();
	}
	
	/**
	 * List of value states
	 * @return List
	 * @throws Exception
	 */
	public List<Integer> getStatus() throws Exception {
		
		 return Arrays.asList(
				checkPowerStatus(), 
				checkLoadStatus(), 
				checkTemperatureStatus() );
	}
	
	/**
	 * Check the state of the power
	 * @param listOk
	 * @param listWarning
	 * @param listCritical
	 * @return OK 0, Warning 1, Critical 2, Unknown 3
	 * @throws Exception
	 */
	public int checkPowerStatus() throws Exception {
		return dataController.getStatusByStrings(
				UPSOidModel.systemStatus.getSymbol(), 
				cli.getStatusList());
	}
	
	/**
	 * Check the state of the load
	 * @return OK 0, Warning 1, Critical 2, Unknown 3
	 * @throws Exception
	 */
	public int checkLoadStatus() throws Exception {
		return dataController.getStatusByLimits(
				UPSOidModel.outputLoad.getSymbol(), cli.getLoadLimits()); 
	}
	/**
	 * Check the state of the temperature
	 * @return OK 0, Warning 1, Critical 2, Unknown 3
	 * @throws Exception
	 */
	public int checkTemperatureStatus() throws Exception {
		return dataController.getStatusByLimits(
				UPSOidModel.airInletTemperature.getSymbol(), cli.getTempLimits()); 
	}
		        
}
