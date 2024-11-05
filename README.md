# pingPerf


## Building Semeru Images
First, insert the security token into the .env file. (You can ask me for it).

```
./build.semeru.sh
```
This will build pingperf quarkus images with semeru and CRAC for 1,2, and 4 cpus.

Note: You may need to change to a newer JDK build (line 93) or newer Tomcat build (line 132) in Dockerfile.quarkus.semeru.base. 

Note: The heap is set to 128m by default (see startQuarkus.sh to change).

Note: The executor threads are set to 2 by default (see startQuarkus.sh to change).

## Building Native Image
```
./build.native.sh
```
Note: The heap is set to 128m by default (see Dockerfile.quarkus.native to change).

Note: The executor threads are set to 2 by default (see Dockerfile.quarkus.native to change).


## Test First Request and Footprint at First Request
```
mkdir logs
./testFirstRequest.sh [IMAGE] [NUMBER_OF_CPUS]
```

Example
```
./testFirstRequest.sh pingperf-native 1
```

Note: You may need to change to your time zone on line 34 of doFirstRequestTests.sh. (Currently EDT).

# Throughput Instructions.

## Start Server on SUT (System Under Test)

Example
```
podman run --privileged -d --net=host --memory=1g --cpuset-cpus 2 pingperf-native
```

## On another machine (the driver), configure and run jmeter.

### Download and unzip Apache JMeter. https://dlcdn.apache.org//jmeter/binaries/apache-jmeter-5.6.3.zip (/opt/apache-jmeter-5.6.3/ for this example)

### Edit the following /opt/apache-jmeter-5.6.3/bin/jmeter.properties
```
#---------------------------------------------------------------------------
# Summariser - Generate Summary Results - configuration (mainly applies to non-GUI mode)
#---------------------------------------------------------------------------
#
# Comment the following property to disable the default non-GUI summariser
# [or change the value to rename it]
# (applies to non-GUI mode only)
summariser.name=summary
#
# interval between summaries (in seconds) default 30 seconds
summariser.interval=5
#
# Write messages to log file
summariser.log=true
#
# Write messages to System.out
summariser.out=true
```

### Copy the scripts in jmeter-scripts to this machine.
### The getFootprint.sh needs to access the System Under Test without needing a password. So allow that or comment it out of the run_pingPerf.sh script.

### Run Jmeter
```
./run_pingPerf.sh [JMETER_HOME] [SUT]
```
Example:
```
./run_pingPerf.sh /opt/apache-jmeter-5.6.3 checkers06.rtp.raleigh.ibm.com
```

