bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties

./kafka-consumer-groups.sh --bootstrap-server 127.0.0.1:9092 --group avtor31-test-group --describe
--
GROUP              TOPIC           PARTITION  CURRENT-OFFSET  LOG-END-OFFSET  LAG             CONSUMER-ID                                     HOST
      CLIENT-ID
avtor31-test-group avtor31-test    0          600             600             0               consumer-1-cfd40725-b8f3-42ca-ae62-6476e10d3c02 /192.168.1
.66   consumer-1

reset offset for groupId - as a result: all the messages will be read from topic once again
./kafka-consumer-groups.sh --bootstrap-server 127.0.0.1:9092  --group avtor31-test-group  --topic avtor31-test  --reset-offsets --to-earliest --execut
e

For consumer skipping some messages use 0 --to-offset 100
./kafka-consumer-groups.sh --bootstrap-server 127.0.0.1:9092  --group avtor31-test-group  --topic avtor31-test  --reset-offsets --group avtor31-test-g
roup --topic avtor31-test:0 --to-offset 100 --execute

Note
The consumer group must have no running instance when performing the reset. Otherwise the reset will be rejected.
There are many other resetting options, run kafka-consumer-groups for details
--shift-by <positive_or_negative_integer>
--to-current
--to-latest
--to-offset <offset_integer>
--to-datetime <datetime_string>
--by-duration <duration_string>
The command also provides an option to reset offsets for all topics the consumer group subscribes to: --all-topics

for example
./kafka-consumer-groups.sh --bootstrap-server 127.0.0.1:9092  --group avtor31-test-group  --topic avtor31-test  --reset-offsets  --to-latest  --execute


