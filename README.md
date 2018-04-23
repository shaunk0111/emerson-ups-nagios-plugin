# snmp-nagios-plugin
Nagios and Icinga compliant plugin to work with Emerson UPS Vertiv Liebert SNMP card's.

# Example use
-hostname 10.65.205.61
 
-port 161 

-community LiebertEM 

-retries 2 

-timeout 1000 

-templimits 0,0,26,28 [

-loadlimits 0,0,80,90 

-statuslimits "Normal Operation,StartUp.Normal with Warning.Normal with Alarm,Abnormal Operation" 

