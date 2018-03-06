# Storm-Kafka
This is a simple wordcount example of Apache Storm which I am integrating with Kafka using KafkaSpout API which is 
given by Storm and running it in local machine.

## Getting Started
Clone this or download the project. If you have NetBeans installed you can Download zip file and 
directly import using file->import->import from zip option given by **NetBeans**


### Prerequisites

* You need IDE either **NetBeans** or **Eclipse** with maven Plugin installed. This projec is developed using NetBeans.
[you can download NetBeans by clicking this link](https://netbeans.org/downloads/)
* Zookeeper (Optional, for running this project not required since You can use the convenience script packaged with kafka 
       to get a quicksingle-node ZooKeeper instance.) 
* Kafka
[Download kafka](https://www.apache.org/dyn/closer.cgi?path=/kafka/1.0.0/kafka_2.11-1.0.0.tgz)

### Running in your local machine
* clone this project or download as a zip.
* open NetBeans and import this project (it gives errors don't worry build the project erros will be gone).
* before running do following steps
* 1. unzip kafka that you downloaded.
* 2. go to the kafka folder and open command prompt
* 3. start zookeeper by typing command this will take some time and print some messages don't worry
```
> bin/zookeeper-server-start.sh config/zookeeper.properties
```
* 4. start kafka server by typing command (type this in new command prompt in kafka folder)
```
> bin/kafka-server-start.sh config/server.properties
```
* 5. create 2 topics named "words" and "wordsoutput"
```
> bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic words
```
```
> bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic wordsoutput
```
And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc
