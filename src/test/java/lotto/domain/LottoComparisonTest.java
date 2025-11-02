package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoComparisonTest {

    @DisplayName("로또 번호와 당첨 번호를 비교하여 일치 개수를 계산한다.")
    @Test
    void 로또와_당첨번호를_비교하여_일치개수를_계산한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        int matchCount = lotto.countMatchingNumbers(winningLotto);

        assertThat(matchCount).isEqualTo(5);
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여 일치 개수를 계산한다 - 완전 일치")
    @Test
    void 로또와_당첨번호를_비교하여_일치개수를_계산한다_완전일치() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int matchCount = lotto.countMatchingNumbers(winningLotto);

        assertThat(matchCount).isEqualTo(6);
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여 일치 개수를 계산한다 - 불일치")
    @Test
    void 로또와_당첨번호를_비교하여_일치개수를_계산한다_불일치() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        int matchCount = lotto.countMatchingNumbers(winningLotto);

        assertThat(matchCount).isEqualTo(0);
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있는지 확인한다.")
    @Test
    void 로또_번호에_보너스_번호가_포함되어_있는지_확인한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        int bonusNumber = 7;

        boolean hasBonus = lotto.contains(bonusNumber);

        assertThat(hasBonus).isTrue();
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있지 않은지 확인한다.")
    @Test
    void 로또_번호에_보너스_번호가_포함되어_있지_않은지_확인한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        boolean hasBonus = lotto.contains(bonusNumber);

        assertThat(hasBonus).isFalse();
    }
}

