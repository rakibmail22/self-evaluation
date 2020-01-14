# Google Analytics Like System
This project contains a high level concept design for a highly available
fault tolerant and scalabale analytics system.

Threre will be basically multiple service running in a clustered environment
to make server instances auto scalable. 

We will capture client data from API and send an acknowledgement to client.
After that we will start processing the data asynchronously and first 
pass these data to a message queue like JSM or data streaming clustered platform
like Kafka. These will process and save our data in a structured data store.

Then we will have another service which we are calling a data aggregator. Data aggregator
will call api server for processed data and store to it's own time series data store.

From there we will have a user dashboard service which will be responsible to 
fetch user viewable data from data aggregator service.

# Requirements
1. As we are running all our services in auto scalable clustered environment data
   volume for read and write operation will not be a problem.

2. We are storing initial data and processing it asyncronously to a structured
   pattern. So, with right amount of resources our processing would be parallel and fast.

3. As we are fetching data from a RDBMS to the data aggregator service, in future we can make
   amend to our legacy structured data and recalculate aggregated result.