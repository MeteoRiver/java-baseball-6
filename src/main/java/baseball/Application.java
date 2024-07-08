package baseball;

import baseball.Controller.NumberController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberController numberController = new NumberController();
        System.out.println("숫자 야구 게임을 시작합니다.");
        NumberController numberController2 = new NumberController();
        numberController.playGame();

    }
}
