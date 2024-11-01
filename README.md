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
