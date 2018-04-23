package chemtech.EmersonUPS.models;

import java.util.LinkedList;

import chemtech.snmp.models.SnmpOidModel;

public final class UPSOidModel {
	
	public static SnmpOidModel inputVoltage = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.4096", "Input Voltage", "V", "InputVoltage");
	public static SnmpOidModel inputCurrent = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.4113", "Input Current", "I", "InputCurrent"); 
	public static SnmpOidModel inputFrequency = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.4105", "Input Frequency", "Hz", "InputFrequency"); 
	public static SnmpOidModel outputVoltage = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.4128", "Output Voltage", "V", "OutputVoltage"); 
	public static SnmpOidModel outputCurrent = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.4204", "Output Current", "I", "OutputCurrent"); 
	public static SnmpOidModel outputFrequency = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.4207", "Output Frequecy", "Hz", "OutputFrequecy");
	public static SnmpOidModel outputLoad = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.5861", "Output Load", "%", "OutputLoad"); 
	public static SnmpOidModel batteryCharge = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.4153", "Battery Charge", "%", "BatteryCharge"); 
	public static SnmpOidModel batteryTimeRemaining = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.4150", "Battery Time Remaining", "M", "BatteryTimeRemaining");
	public static SnmpOidModel airInletTemperature = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.4291", "Inlet Air Temperature", "C", "InletAirTemperature"); 
	public static SnmpOidModel systemStatus = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.3.20.1.4123", "System Status", "", "SystemStatus");
	
	private static LinkedList<SnmpOidModel> dataList = new LinkedList<SnmpOidModel>();

	public static LinkedList<SnmpOidModel> List() {
		
		dataList.add(inputVoltage);
		dataList.add(inputCurrent);
		dataList.add(inputFrequency);
		dataList.add(outputVoltage);
		dataList.add(outputCurrent);
		dataList.add(outputFrequency);
		dataList.add(outputLoad);
		dataList.add(batteryCharge);
		dataList.add(batteryTimeRemaining);
		dataList.add(airInletTemperature);
		dataList.add(systemStatus);	
		
		return dataList;
	}
}