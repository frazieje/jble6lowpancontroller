# jble6lowpancontroller
Http service and web frontend for controlling the Bluetooth Low-Energy 6lowpan Daemon

The api for the controller uses JAX-RS, and uses HTTP to connect to the daemon jvm.

The front end for the Blutooth Low-Energy 6lowpan controller uses Vue.js and webpack

## Build Setup

The java project is built with gradle

To get started, first install the dependencies of the web frontend:

``` bash
# install frontend dependencies via npm
cd web
npm install
```

Build the java project with gradle

``` bash
gradle build
```

This will build the java components, and preprocess and minify the frontend components, copying them to the src/main/webapp directory.

Deploy ble6lowpancontroller.war to the application server of your choice.

## Rapid dev

For rapid ui development, you can use gradle to launch the hot reload dev server:

``` bash
# serve web front end with hot reload at localhost:8081
gradle devWeb
```

Alternatively if you have npm installed you can run directly from {project root}/web:

``` bash
# install frontend dependencies via npm
cd web
npm run dev
```
