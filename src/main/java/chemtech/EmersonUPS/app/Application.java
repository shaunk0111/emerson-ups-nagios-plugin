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
	
	private static SnmpConnectionController connectionController;
	private static SnmpDataController dataController;
	private static SnmpConsoleController consoleController;
	private static UPSController upsController;
	private static CliOptions cli;
	private static String systemName = "UPS";
	
	
	public static void main(String[] args){   
				
		try {
			// Get argumentsSnmpConnectionLinuxNative
			cli = new CliOptions(args);
			SnmpConfigModel config = new SnmpConfigModel(
					cli.getHostname(),cli.getPort(),cli.getVerison(),
					cli.getCommunity(),cli.getRetires(),cli.getTimeout());
			
			connectionController = new SnmpConnectionLinuxNative(config);
			
			dataController = new SnmpDataController(connectionController);
			
			upsController = new UPSController(dataController, cli, UPSOidModel.List());
			upsController.retrieveData();
			upsController.pushStates();
			
			consoleController = new SnmpConsoleController(connectionController,dataController,systemName);
			consoleController.printOutputandExit();

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(3);  // Service status Unknown
		}
	}
	
}