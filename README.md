# snmp-nagios-plugin
Nagios and Icinga compliant plugin to work with Emerson UPS Vertiv Liebert SNMP card's.

### Use
```
java -jar ./emerson-ups-nagious-plugin -hostname 10.65.205.61 -port 161 -community public -retries 2 -timeout 1000 -templimits 0,0,26,28 -loadlimits 0,0,80,90 -statuslimits "Normal Operation,StartUp.Normal with Warning.Normal with Alarm,Abnormal Operation" 
```
### Icinga hosts.conf
```
object Host "chem-tpf-ups1" {
  import "generic-host"
  vars.building = "F11"
  vars.room = "151"
  vars.device = "ups"
  vars.man = "emerson"
  vars.type = "snmp"
  address = "10.65.205.61"

 vars.notification["mail"] = {
    groups = [ "icingaadmins" ]
  }
}
```
### Icinga command.conf
```
object CheckCommand "emerson-ups-check" {

  command = [ "java", "-jar" , CustomPluginDir + "/emerson-ups-nagios-plugin/build/libs/emerson-ups-nagios-plugin-all-1.0.0.jar"  ]

  arguments = {
        "-hostname" = {
                value =  "$hostname$"
                required = true
        }
        "-port" =  {
                value = "$port$"
                required = true
        }
        "-retries" = {
                value = "$retries$"
                required = true
        }
        "-timeout" = {
                value = "$timeout$"
                required = true
        }
        "-loadlimits" = {
                value = "$loadlimits$"
                required = true
        }
        "-templimits" = {
                value = "$templimits$"
                required = true
        }
        "-statuslimits" = {
                value = "$statuslimits$"
                required = true
        }
        "-community" = {
                value = "$comm$"
                required = true
        }
  }
}
```
### Icinga services.conf
```
apply Service "emerson-ups" {
 import "generic-service"

 check_command = "emerson-ups-check"
 check_interval = 10

 vars.hostname = host.address
 vars.port = "161"
 vars.retries = "3"
 vars.timeout = "1000"
 vars.templimits = "0,0,25,28"
 vars.loadlimits = "0,0,80,90"
 vars.statuslimits = "Normal Operation,StartUp.Normal with Warning.Normal with Alarm,Abnormal Operation"
 vars.comm = "LiebertEM"

 assign where host.vars.device == "ups" && host.vars.man == "emerson" && host.vars.type == "snmp"
}
```
