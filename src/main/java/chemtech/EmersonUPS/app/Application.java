package chemtech.EmersonUPS.app;

import chemtech.snmp.controllers.SnmpDataController;
import chemtech.EmersonUPS.controllers.UPSController;
import chemtech.EmersonUPS.models.UPSOidModel;
import chemtech.snmp.controllers.SnmpConnectionController;
import chemtech.snmp.controllers.SnmpConnectionJava;
import chemtech.snmp.controllers.SnmpConnectionLinuxNative;
import chemtech.snmp.controllers.SnmpConsoleController;
import chemtech.snmp.models.SnmpConfigModel;

public class Application {
	
	static SnmpConnectionController connectionController;
	static SnmpDataController dataController;
	static SnmpConsoleController consoleController;
	static UPSController upsController;
	
	static CliOptions cli;
	
	public static void main(String[] args){
				
		try {
			// Get argumentsSnmpConnectionLinuxNative
			cli = new CliOptions(args);
			SnmpConfigModel config = new SnmpConfigModel(
					cli.getHostname(),cli.getPort(),cli.getVerison(),
					cli.getCommunity(),cli.getRetires(),cli.getTimeout());
			
			connectionController = new SnmpConnectionLinuxNative(config);
			//connectionController.createConnection();
			
			dataController = new SnmpDataController(connectionController);
			
			upsController = new UPSController(dataController, cli, UPSOidModel.List());
			upsController.retrieveData();	
			
			consoleController = new SnmpConsoleController(connectionController,dataController);
			consoleController.printOutputandExit(upsController.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(3);  // Service status Unknown
		}
	}
	
}