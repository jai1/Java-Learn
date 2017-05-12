package org.pulsar;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FileParser {

    public static void main(String[] args) {
        String pattern = ".*(\\d+:\\d+:\\d+.\\d+).*ledgerId=(\\d+), entryId=(\\d+).*";
        Pattern r = Pattern.compile(pattern);

        if (args.length != 2) {
            System.out.println("Usage: FileParser <Input File name> <Output File Name>");
            System.exit(-1);
        }

        TreeMap<PositionImpl, Descriptor> positionImplMap = new TreeMap<PositionImpl, Descriptor>();
        // read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(args[0]))) {
            stream.forEach((line) -> {
                Matcher m = r.matcher(line);
                if (m.find() && m.groupCount() == 3) {

                    // Match found
                    PositionImpl position = new PositionImpl(Integer.parseInt(m.group(2)),
                            Integer.parseInt(m.group(3)));
                    String time = m.group(1);
                    Descriptor desc = new Descriptor();
                    if (positionImplMap.containsKey(position)) {
                        // Received the position before
                        desc = positionImplMap.get(position);
                    } else {
                        positionImplMap.put(position, desc);
                    }

                    if (line.contains("Acking message")) {
                        desc.numberOfTimesAcked++;
                        desc.timeAcked.add(time);
                    } else {
                        desc.numberOfTimesIgnored++;
                        desc.timeIgnored.add(time);
                    }
                } else {
                    System.out.println("Ignoring line " + line);
                }
            });

        } catch (

        IOException e) {
            e.printStackTrace();
        }
        
      //create a file first    
        try (PrintWriter outputfile = new PrintWriter(args[1])) {
            for (Entry<PositionImpl, Descriptor> entry: positionImplMap.entrySet()) {
                outputfile.println(entry.getKey() + "-> " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
