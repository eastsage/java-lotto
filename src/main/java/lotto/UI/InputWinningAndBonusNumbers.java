package lotto.UI;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Application;
import lotto.domain.Lotto;

public class InputWinningAndBonusNumbers {
    private Lotto winningNumbers;
    private Integer bonusNumber;

    public void inputWinningNumbers() {
        winningNumbers = drawWinningNumbers(Console.readLine());

    }

    public void inputBonusNumber() {
        bonusNumber = stringToInteger(Console.readLine());
    }

    private Integer stringToInteger(String s) throws IllegalArgumentException {
        Integer number = null;
        try {
            number = Integer.parseInt(s);
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] 각 로또 번호는 숫자이어야 합니다.");
            throw e;
        }
        return number;
    }

    private void validateBonusNumber() throws IllegalArgumentException {
        if (winningNumbers.get().contains(bonusNumber)) {
            throwException("[Error] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throwException("[Error] 보너스 번호는 1~45 사이의 숫자입니다.");
        }
    }

    private void throwException(String s) throws IllegalArgumentException {
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(s);
            throw e;
        }
    }

    private Lotto drawWinningNumbers(String numbers) {
        List<Integer> list = new ArrayList<>();
        for (String s : numbers.trim().split(",")) {
            list.add(stringToInteger(s));
        }
        return new Lotto(list);
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
