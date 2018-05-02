package chemtech.EmersonUPS.models;

import java.util.LinkedList;

import chemtech.snmp.models.SnmpOidModel;

public final class UPSOidModel {
	
    public static SnmpOidModel inputVoltage = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.4096", "Input Voltage", "V", "input-voltage");
    public static SnmpOidModel inputCurrent = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.4113", "Input Current", "I", "input-current");
    public static SnmpOidModel inputFrequency = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.4105", "Input Frequency", "Hz", "input-frequency");
    public static SnmpOidModel outputVoltage = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.4385", "Output Voltage", "V", "output-voltage");
    public static SnmpOidModel outputCurrent = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.4204", "Output Current", "I", "output-current");
    public static SnmpOidModel outputFrequency = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.4207", "Output Frequecy", "Hz", "output-frequecy");
    public static SnmpOidModel outputLoad = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.5861", "Output Load", "%", "output-load");
    public static SnmpOidModel batteryCharge = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.4153", "Battery Charge", "%", "battery-charge");
    public static SnmpOidModel batteryTimeRemaining = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.4150", "Battery Time Remaining", "M", "battery-time-remaining");
    public static SnmpOidModel airInletTemperature = new SnmpOidModel("1.3.6.1.4.1.476.1.42.3.9.20.1.20.1.2.1.4291", "Inlet Air Temperature", "C", "inlet-air-temperature");
 
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
		
		return dataList;
	}
}