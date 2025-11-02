package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("총 당첨금과 구입 금액을 기반으로 수익률을 계산한다.")
    @Test
    void shouldCalculateProfitRate() {
        List<LottoRank> ranks = List.of(
                LottoRank.FIFTH,    // 5,000
                LottoRank.FIFTH,    // 5,000
                LottoRank.THIRD     // 1,500,000
        );

        LottoResult result = new LottoResult(3000, ranks);
        double profitRate = result.calculateProfitRate();

        // 수익률 : (1,510,000 / 3,000) * 100 = 50333.3%
        assertThat(profitRate).isEqualTo(50333.3);
    }
}
