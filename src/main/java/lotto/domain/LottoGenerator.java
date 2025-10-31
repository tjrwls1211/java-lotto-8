package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {

    public Lotto generate() {
        List<Integer> lotteryNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .toList();

        return new Lotto(lotteryNumbers);
    }
}
