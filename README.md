# Dynatrace tracer for WSO2 API Manager

This is an implementation for OpenTracing in WSO2 API manager which uses pure OpenTracing classes for being able to use the Dynatrace OneAgent with WSO2.

It is based on [this](https://apim.docs.wso2.com/en/3.2.0/administer/logging-and-monitoring/monitoring/monitoring-with-opentracing/#use-custom-tracer-implementation) implementation of a custom Tracer.

**There are no dependencies to Dynatrace in this component.**

## How to use
- Copy custom.opentelemetry.tracer-1.0.0-SNAPSHOT.jar to *WSO2_DIR*/repository/components/dropins
- Edit *WSO2_DIR*/repository/conf/deployment.toml and add the following 3 lines:
```
[apim.open_tracer]
remote_tracer.enable = true
remote_tracer.name = "opentelemetry"
```

## Using with Dynatrace
- This requires at least OneAgent version 1.221 as WSO2 API Manager uses an old version of OpenTracing (0.31). The Dynatrace OneAgent needs to be installed on the machine running WSO2.

- Enable W3C Trace context and at least one of the two OpenTracing options for Java (in Settings - Server-side service monitoring - Deep monitoring):
![image](https://user-images.githubusercontent.com/48479537/134170111-43b89753-86d7-418a-b24f-232ff8e4af2a.png)

- Create the following Span Context Propagation rule:

![image](https://user-images.githubusercontent.com/48479537/134140123-e2033e9a-862f-4c54-8d16-e27b6b2099ff.png)

- Disable the Java web service sensor as this will interfere with the context propagation rule:
![image](https://user-images.githubusercontent.com/48479537/134180207-694709eb-fe8c-42b7-b173-1858e5f919e4.png)

The resulting trace will look like this:
![image](https://user-images.githubusercontent.com/48479537/134142593-9bf54e7d-ccd3-4fa1-9947-85439d35bfbc.png)

# License

[Apache License 2.0](https://github.com/tbrandl-dynatrace/wso2-apimanager-dynatrace/blob/05102e2f98571479a0f4aed7a555e479d01b110d/custom.opentelemetry.tracer/target/maven-shared-archive-resources/META-INF/LICENSE)

# Support
This is a community-developed project. There is no official Dynatrace support for this project.
