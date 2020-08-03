# Hypothesis Testing

## Getting started / Use

The Hypothesis Testing component has a pre-configured docker image which will be deployed on your machine on port 4581.
The full list of APIs which can be consumed by other components and their descriptions can be found in the below link:
* [API Documentation](https://git.activageproject.eu/Data_Analytics/Hypothesis_Testing/wiki/API+Documentation)


## How to build, install, or deploy it

Before you can build this project, you must install and configure the following dependencies on your machine:

1. [Node.js](https://nodejs.org/en/): We use Node to run a development web server and build the project.
   Depending on your system, you can install Node either from source or as a pre-packaged bundle.
2. [Yarn](https://yarnpkg.com/): We use Yarn to manage Node dependencies.
   Depending on your system, you can install Yarn either from source or as a pre-packaged bundle.

After installing Node, you should be able to run the following command to install development tools.
You will only need to run this command when dependencies change in [package.json](package.json).

    yarn install

We use [Gulp](https://gulpjs.com/) as our build system. Install the Gulp command-line tool globally with:

    yarn global add gulp-cli

[Bower](https://bower.io/) is used to manage CSS and JavaScript dependencies used in this application. You can upgrade dependencies by
specifying a newer version in [bower.json](bower.json). You can also run `bower update` and `bower install` to manage dependencies.
Add the `-h` flag on any command to see how you can use it. For example, `bower update -h`.

3. Install java 8
4. Install maven
5. Run the following commands in two separate terminals to create a blissful development experience where your browser
auto-refreshes when files change on your hard drive.

    ./mvnw
    gulp

### Building for production

To optimize the simlife application for production, run:

    ./mvnw -Pprod clean package

This will concatenate and minify the client CSS and JavaScript files. It will also modify `index.html` so it references these new files.
To ensure everything worked, run:

    java -jar target/*.war

Then navigate to [http://localhost:8080](http://localhost:8080) in your browser.

## Using Docker to simplify development (optional)

You can use Docker to improve your Simlife development experience. A number of docker-compose configuration are available in the [src/main/docker](src/main/docker) folder to launch required third party services.

For example, to start a mongodb database in a docker container, run:

    docker-compose -f src/main/docker/mongodb.yml up -d

To stop it and remove the container, run:

    docker-compose -f src/main/docker/mongodb.yml down

You can also fully dockerize your application and all the services that it depends on.
To achieve this, first build a docker image of your app by running:

    ./mvnw verify -Pprod dockerfile:build

Then run:

    docker-compose -f src/main/docker/app.yml up -d

## Testing

To launch your application's tests, run:

    ./mvnw clean test

### Client tests

Unit tests are run by [Karma](https://karma-runner.github.io/latest/index.html) and written with [Jasmine](https://jasmine.github.io/). They're located in [src/test/javascript/](src/test/javascript/) and can be run with:

    gulp test

UI end-to-end tests are powered by [Protractor](https://www.protractortest.org/#/), which is built on top of WebDriverJS. They're located in [src/test/javascript/e2e](src/test/javascript/e2e)
and can be run by starting Spring Boot in one terminal (`./mvnw spring-boot:run`) and running the tests (`gulp itest`) in a second one.

### Other tests

Performance tests are run by [Gatling](https://gatling.io/) and written in Scala. They're located in [src/test/gatling](src/test/gatling) and can be run with:

    ./mvnw gatling:execute

## Further Information

Further information can be found in below links:

* [Hypothesis Testing Wiki](https://git.activageproject.eu/Data_Analytics/Hypothesis_Testing/wiki)
* [API Documentation](https://git.activageproject.eu/Data_Analytics/Hypothesis_Testing/wiki/API+Documentation)

## License
    
The Hypothesis Testing is licensed under [EUPL 1.2](https://eupl.eu/).
