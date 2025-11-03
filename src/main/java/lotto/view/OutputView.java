package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

public class OutputView {
    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void printResult(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<LottoRank, Long> rankCount = result.getRankCount();

        List<LottoRank> sortedRanks = Arrays.asList(
                LottoRank.FIFTH,
                LottoRank.FOURTH,
                LottoRank.THIRD,
                LottoRank.SECOND,
                LottoRank.FIRST
        );

        for (LottoRank rank : sortedRanks) {
            String label = formatRankMessage(rank);
            System.out.printf("%s - %d개%n", label, rankCount.getOrDefault(rank, 0L));
        }

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("총 수익률은 " + df.format(result.calculateProfitRate()) + "%입니다.");
    }


    private static String formatRankMessage(LottoRank rank) {
        switch (rank) {
            case FIRST -> {
                return "6개 일치 (2,000,000,000원)";
            }
            case SECOND -> {
                return "5개 일치, 보너스 볼 일치 (30,000,000원)";
            }
            case THIRD -> {
                return "5개 일치 (1,500,000원)";
            }
            case FOURTH -> {
                return "4개 일치 (50,000원)";
            }
            case FIFTH -> {
                return "3개 일치 (5,000원)";
            }
            default -> {
                return "";
            }
        }
    }
}
