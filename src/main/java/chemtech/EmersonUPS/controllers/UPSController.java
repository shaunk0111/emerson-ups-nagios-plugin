package chemtech.EmersonUPS.controllers;

import java.util.ArrayList;
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
	 * Push states into OID
	 * @return List
	 * @throws Exception
	 */
	public void pushStates() throws Exception {
		
		dataController.pushState(
				UPSOidModel.outputVoltage.getSymbol(),cli.getOutputList());
		dataController.pushState(
				UPSOidModel.inputVoltage.getSymbol(),cli.getInputList());
		dataController.pushState(
				UPSOidModel.outputLoad.getSymbol(), cli.getLoadLimits());
		dataController.pushState(
				UPSOidModel.airInletTemperature.getSymbol(), cli.getTempLimits()); 
	}
		        
}
