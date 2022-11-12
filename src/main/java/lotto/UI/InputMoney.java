package lotto.UI;

import camp.nextstep.edu.missionutils.Console;

public class InputMoney {
    private int money;

    public int input() {
        isValidMoney(Console.readLine());
        return money;
    }

    private void isValidMoney(String input) {
        if (isNumber(input)) {
            money = Integer.parseInt(input);
        }
        canBuyLotto(money);
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닙니다.");
        }
        return true;
    }

    private void canBuyLotto(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 1,000원 보다 커야합니다.");
        }
        if (money / 100 % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위가 아닙니다.");
        }
    }
}
