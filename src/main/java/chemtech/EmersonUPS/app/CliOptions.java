package chemtech.EmersonUPS.app;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.snmp4j.mp.SnmpConstants;

public final class CliOptions {
	
	private static Options options = new Options();
	private static CommandLineParser parser = new DefaultParser();
	private static String hostname;
	private static String port;
	private static String community;
	private static int retries;
	private static int timeout;
	private static int version;
	private static String sloadLimits;
	private static String stempLimits;
	private static String sStatusLimits;
	
	public CliOptions(String[] args) throws ParseException {
		
		options.addOption("hostname", true, "hostname of target");
		options.addOption("port", true, "SNMP port number of target");
		options.addOption("community", true, "SNMP Community String");
		options.addOption("retries", true, "number of retries");
		options.addOption("timeout", true, "time until timeout");
		options.addOption("templimits", true, "limits of temperature lower to upper in format 0,0,0,0");
		options.addOption("loadlimits", true, "limits of load lower to upper in format 0,0,0,0");
		options.addOption("statuslimits", true, "limits of load lower to upper in format ok.ok,warn.warn,crit.crit");
		
		// Get arguments
		CommandLine cmd = parser.parse(CliOptions.options, args);
		hostname = cmd.getOptionValue("hostname");
		port = cmd.getOptionValue("port");
		community = cmd.getOptionValue("community");
		retries = Integer.parseInt(cmd.getOptionValue("retries"));
		timeout = Integer.parseInt(cmd.getOptionValue("timeout"));
		version = SnmpConstants.version2c; // Application must run SNMP v2c
		sloadLimits = cmd.getOptionValue("loadlimits");	
		stempLimits = cmd.getOptionValue("templimits");
		sStatusLimits = cmd.getOptionValue("statuslimits");
	}
	//"Normal Operation,StartUp.Normal with Warning.Normal with Alarm,Abnormal Operation"
	public String getHostname() {
		return hostname;
	}
	
	public String getPort() {
		return port;
	}
	
	public String getCommunity() {
		return community;
	}
	
	public int getRetires() {
		return retries;
	}
	
	public int getTimeout() {
		return timeout;
	}
	
	public int getVerison() {
		return version;
	}
	
	public String getTempLimits() {
		return stempLimits; 
	}
	
	public String getLoadLimits() {
		return sloadLimits;
	}
	
	public String getStatusList() {
		return sStatusLimits;
	}
			
}
