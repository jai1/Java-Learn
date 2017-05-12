package org.pulsar;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class PositionImpl implements Comparable<PositionImpl> {
    long ledgerId;
    long entryId;

    PositionImpl(long ledgerId, long entryId) {
        this.ledgerId = ledgerId;
        this.entryId = entryId;
    }

    public int compareTo(PositionImpl other) {
        return ComparisonChain.start().compare(this.ledgerId, other.ledgerId).compare(this.entryId, other.entryId)
                .result();
    }

    @Override
    public String toString() {
        return "PositionImpl [ledgerId=" + ledgerId + ", entryId=" + entryId + "]";
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(ledgerId, entryId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PositionImpl) {
            PositionImpl other = (PositionImpl) obj;
            return ledgerId == other.ledgerId && entryId == other.entryId;
        }

        return false;
    }
}
