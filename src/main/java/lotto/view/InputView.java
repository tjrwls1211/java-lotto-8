package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static int readPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                return InputValidator.validatePurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> readWinningNumbers() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String input = Console.readLine();

                List<Integer> numbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();

                InputValidator.validateWinningNumbers(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int readBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                return InputValidator.validateBonusNumber(input, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
