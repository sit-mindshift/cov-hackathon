# ShopSafe Frontend

This is the ShopSafe Frontend. 
It is based on Vue.js & Typescript - optimized with 
[Class-Style-Components](https://vuejs.org/v2/guide/typescript.html#Class-Style-Vue-Components).

[Apple MapKit](https://developer.apple.com/documentation/mapkit) is used to visualize the Shops based on the Backend Response.

## Project setup

First you need to add a valid Apple MapKit Id in the MapKit Setup in the [main.ts](src/main.ts).

The Backend Application needs to be started in order to request nearby Shops. 

You can use the [vue-cli](https://cli.vuejs.org/) UI functionality to run the view application 
or run it via npm with the following commands.
#### Install dependencies

```
npm install
```

##### Compiles and hot-reloads for development
```
npm run serve
```

#### Compiles and minifies for production
```
npm run build
```

#### Run your tests
```
npm run test
```

#### Lints and fixes files
```
npm run lint
```

### Run with Docker
```
$ docker build
--build-arg API_URL=http://35.232.171.127:8080  
-t frontend .
```
```
$ docker build --build-arg API_URL=http://localhost:8080 -t frontend .
```

## Special Dev Hints and Tweaks
#### Shop Naming workaround
The Shops are named **Shop** in the view, but **Store** in the Backend. 
This is due to Vue using the *vuex-global-store* holding the naming pattern of store for *storage*.
But our big Example Data Set in the Backend all Shop Instances are called Store, mapping this would be a lot of unnecessary effort.

Therefore we are using **Shop** in the Frontend and **Store** in the Backend.
