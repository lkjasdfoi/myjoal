package org.araymond.joal.core.bandwith.weight;

import org.araymond.joal.core.bandwith.Peers;

public class PeersAwareWeightCalculator {
    public double calculate(final Peers peers, String fileName) {
        final double leechersRatio = peers.getLeechersRatio();

        return (peers.getSeeders() == 0 || leechersRatio == 0 || fileName.startsWith("HR"))
                ? 0.0
                : leechersRatio * 100 * leechersRatio * peers.getLeechers();
    }
}
