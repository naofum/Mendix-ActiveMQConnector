# Mendix-ActiveMQConnector

The **ActiveMQ connector** can be used to seamlessly connect to ActiveMQ (http://activemq.apache.org/).

Great thanks to Pim van der Noll of Appronto.

This module supports two patterns:

- Publish / Subscribe (Topic - one publisher, many subscribers, each message is received by all subscribers)
  
- Queue producer / comsumer (one publisher, one subscriber, each message is processed only once)

## Dependencies
* Mx Model reflection

## Installation
* Import the module **ActiveMQ connector** in your project (from the Mendix AppStore or by downloading and exporting the module from this project)

* You need to add the MxModelReflection module also from the appstore

- Add RMQConfiguration_Overview to your navigation
- Use the provided actions in Objects/subfolder
- Do not use microflows in /private folders
- Do not use Java actions

- Optionally, you can add the provided ASU action in /Resources to your after startup actions to start listening to all listening configurations

* You can use Amazon MQ as a broker.


## Configuration options
		
- Durable exchange: exchange survives reboot of the server


## Remarks
* Avoid fetching large amounts of data as it can lead to memory issues because all the ResultRow data is being loaded into memory at once.


## License
Licensed under the Apache license 2.0.

## Developers notes
* Open the ActiveMQConnector.mpr in the Mendix Studio Pro.
* Use *Deploy for Eclipse* option (F6) and you can then import this module as an Eclipse project to the Eclipse IDE.

## Version history
- 1.0.0 Converted to Mx 8.0.0
- 0.1 first functions for ActiveMQ implemented
