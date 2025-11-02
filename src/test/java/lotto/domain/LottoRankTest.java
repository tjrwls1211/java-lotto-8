package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @DisplayName("일치 개수와 보너스 번호로 등수를 판정한다 - 1등")
    @Test
    void 일치_개수로_1등을_판정한다() {
        LottoRank rank = LottoRank.from(6, false);
        assertThat(rank).isEqualTo(LottoRank.FIRST);
        assertThat(rank.getPrize()).isEqualTo(2_000_000_000);
    }

    @DisplayName("일치 개수와 보너스 번호로 등수를 판정한다 - 2등")
    @Test
    void 일치_개수와_보너스로_2등을_판정한다() {
        LottoRank rank = LottoRank.from(5, true);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
        assertThat(rank.getPrize()).isEqualTo(30_000_000);
    }

    @DisplayName("일치 개수와 보너스 번호로 등수를 판정한다 - 3등")
    @Test
    void 일치_개수로_3등을_판정한다() {
        LottoRank rank = LottoRank.from(5, false);
        assertThat(rank).isEqualTo(LottoRank.THIRD);
        assertThat(rank.getPrize()).isEqualTo(1_500_000);
    }

    @DisplayName("일치 개수와 보너스 번호로 등수를 판정한다 - 4등")
    @Test
    void 일치_개수로_4등을_판정한다() {
        LottoRank rank = LottoRank.from(4, false);
        assertThat(rank).isEqualTo(LottoRank.FOURTH);
        assertThat(rank.getPrize()).isEqualTo(50_000);
    }

    @DisplayName("일치 개수와 보너스 번호로 등수를 판정한다 - 5등")
    @Test
    void 일치_개수로_5등을_판정한다() {
        LottoRank rank = LottoRank.from(3, false);
        assertThat(rank).isEqualTo(LottoRank.FIFTH);
        assertThat(rank.getPrize()).isEqualTo(5_000);
    }

    @DisplayName("일치 개수가 적으면 꽝을 반환한다.")
    @Test
    void 일치_개수가_적으면_꽝을_반환한다() {
        LottoRank rank1 = LottoRank.from(2, false);
        LottoRank rank2 = LottoRank.from(1, false);
        LottoRank rank3 = LottoRank.from(0, false);

        assertThat(rank1).isEqualTo(LottoRank.MISS);
        assertThat(rank2).isEqualTo(LottoRank.MISS);
        assertThat(rank3).isEqualTo(LottoRank.MISS);
        assertThat(LottoRank.MISS.getPrize()).isEqualTo(0);
    }

    @DisplayName("일치하는 숫자가 없는 경우 꽝을 반환한다.")
    @Test
    void 일치하는_숫자가_없는_경우_꽝을_반환한다() {
        for (int i = 2; i >= 0; i--) {
            LottoRank rank = LottoRank.from(i, false);
            assertThat(rank).isEqualTo(LottoRank.MISS);
            assertThat(rank.getPrize()).isEqualTo(0);
        }

    }

}

