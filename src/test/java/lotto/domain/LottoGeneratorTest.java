package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class LottoGeneratorTest {

    @DisplayName("로또 번호 6개를 추첨한다.")
    @RepeatedTest(5)
    void 로또_번호_6개를_추첨한다() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = lottoGenerator.generate();

        List<Integer> lotteryNumbers = lotto.getNumbers();

        assertThat(lotteryNumbers).hasSize(6);
    }
}
