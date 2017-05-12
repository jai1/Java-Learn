package org.pulsar;

import java.util.TreeSet;
import java.util.Set;

public class Descriptor {
    public long numberOfTimesIgnored = 0;
    public Set<String> timeIgnored = new TreeSet<String>();
    
    public long numberOfTimesAcked = 0;
    public Set<String> timeAcked = new TreeSet<String>();
    
    @Override
    public String toString() {
        return "Descriptor [numberOfTimesIgnored=" + numberOfTimesIgnored + ", timeIgnored=" + timeIgnored
                + ", numberOfTimesAcked=" + numberOfTimesAcked + ", timeAcked=" + timeAcked + "]";
    }
}
