# DMap
The Machine-actionable Data Management planning application (DMap) is being developed to improve the situation of research data management planning by providing automated workflows and the exchange among information systems. Please find out more about it [here](https://oblassers.github.io/dmap-mockups/).

## Development

### Technology stack
DMap has a Spring Boot backend connected to a MongoDB. The frontend is developed with Vue.js using the Vue CLI, Vuex for application state handling, Vue Router for client-side routing, Vuetify and other handy libraries for building a scalable and modern web application.

### Prerequisites
Please install manually or by using your favourite package manager:
* [Maven](https://maven.apache.org/index.html)
* [node and npm](https://www.npmjs.com/get-npm)
* [MongoDB](https://www.mongodb.com/)
* [Vue CLI](https://cli.vuejs.org/guide/installation.html)

### How to run
Run MongoDB (e.g. on macOS):

```
mongod
```

Build frontend and backend (inside root directory):

```
mvn clean install
```

Run the backend:

```
mvn --projects dmap-backend spring-boot:run
```

Start frontend development server:

```
cd dmap/dmap-frontend/
npm run serve
```

Go to http://localhost:3000/

### Development tools
For an awesome frontend development experience install [Vue.js devtools](https://github.com/vuejs/vue-devtools) in your browser.

## License
DMap is licensed under the [MIT license](https://github.com/oblassers/dmap/blob/master/LICENSE).
