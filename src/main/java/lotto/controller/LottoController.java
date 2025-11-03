package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final LottoGenerator LottoGenerator = new LottoGenerator();

    public void run() {
        int purchaseAmount = InputView.readPurchaseAmount();
        int count = purchaseAmount / 1000;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(LottoGenerator.generate());
        }
        OutputView.printPurchasedLottos(lottos);

        List<Integer> winningNumbers = InputView.readWinningNumbers();
        int bonusNumber = InputView.readBonusNumber(winningNumbers);

        List<LottoRank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
            ranks.add(LottoRank.from(matchCount, hasBonus));
        }

        LottoResult result = new LottoResult(purchaseAmount, ranks);
        OutputView.printResult(result);
    }
}
