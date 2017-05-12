package org.pulsar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTut3 {

    public static void main(String args[]) {
            String line = "@40000000590a7b07085a0214.s:00:31:39.084 pulsar-external-listener-43-1 INFO  - Ignoring message id MessageIdImpl{ledgerId=4089201, entryId=1601, partitionIndex=-1} for topic - persistent://perf-tests-st16/perf-bf2/redelivery-shared-consumer_0/jai10topic, subscription com.yahoo.cloud.messaging.systemtest.consumer.RedeliverySharedConsumer-0"; 
            String pattern = ".*(:\\d+:\\d+:\\d+.\\d+).*ledgerId=(\\d+), entryId=(\\d+).*";

            // Create a Pattern object
            Pattern r = Pattern.compile(pattern);

            // Now create matcher object.
            Matcher m = r.matcher(line);

            System.out.println(m.groupCount());
            
            if (m.find()) {
                System.out.println("Found value: " + m.group(0));
                System.out.println("Found value: " + m.group(1));
                System.out.println("Found value: " + m.group(2));
                System.out.println("Found value: " + m.group(3));
            } else {
                System.out.println("NO MATCH");
            }
        }
}
