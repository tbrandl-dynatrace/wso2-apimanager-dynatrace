# Dynatrace tracer for WSO2 API Manager

This is an implementation for OpenTracing in WSO2 API manager which uses pure OpenTracing classes for being able to use the Dynatrace OneAgent with WSO2.

It is based on [this](https://apim.docs.wso2.com/en/3.2.0/administer/logging-and-monitoring/monitoring/monitoring-with-opentracing/#use-custom-tracer-implementation) implementation of a custom Tracer

**There are no dependencies to Dynatrace in this component**

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
* Optional: 
  * Add this custom service:
![image](https://user-images.githubusercontent.com/48479537/128139727-9676a0cb-00d1-4d84-9ce4-731505bde9ef.png)
  * Add this request attribute:
![image](https://user-images.githubusercontent.com/48479537/128139850-b8f927f8-38b1-49b2-8d62-1243fa71ed5a.png)
  * Add the following request naming rule on the service:
![image](https://user-images.githubusercontent.com/48479537/128140107-681d3fc3-3e3a-4160-bf6e-deb46d033c6b.png)


As a result, the traces will look like this:
![image](https://user-images.githubusercontent.com/48479537/128140380-c14f909f-9c9d-4b07-8393-060343abaf65.png)
