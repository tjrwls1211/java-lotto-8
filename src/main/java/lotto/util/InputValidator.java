package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static int validatePurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);

            if (amount <= 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
            }
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    public static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> unique = new HashSet<>(numbers);
        if (unique.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }

        for (int num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static int validateBonusNumber(String input, List<Integer> winningNumbers) {
        try {
            int bonus = Integer.parseInt(input);

            if (bonus < 1 || bonus > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (winningNumbers.contains(bonus)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }

            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }
}
