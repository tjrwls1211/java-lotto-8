package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private final int purchaseAmount;
    private final Map<LottoRank, Long> rankCount;

    public LottoResult(int purchaseAmount, List<LottoRank> ranks) {
        this.purchaseAmount = purchaseAmount;
        this.rankCount = ranks.stream().collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    public double calculateProfitRate() {
        long totalPrize = 0;

        for (LottoRank rank : rankCount.keySet()) {
            long count = rankCount.get(rank);
            long prize = rank.getPrize();
            totalPrize += prize * count;
        }

        double profitRate = ((double) totalPrize / purchaseAmount) * 100;
        return Math.round(profitRate * 10) / 10.0;
    }

    public Map<LottoRank, Long> getRankCount() {
        return rankCount;
    }
}
