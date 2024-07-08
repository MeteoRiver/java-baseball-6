package baseball.Controller;

import baseball.Model.RandomNumber;
import baseball.Model.UserNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class NumberController {
    private final String BALL = "볼";
    private final String STRIKE = "스트라이크";
    private final String NOTHING = "낫싱";

    //게임 시작
    public void playGame() {
        List<Integer> list1 = new ArrayList<>(random());

        while (true) {
            List<Integer> list2 = new ArrayList<>(inputNumbers(numbers()));
            String s = compare(list1, list2);
            if(s.equals("end")) {
                System.out.println("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                newgame();
            }
            System.out.println(s);

        }
    }

    public void newgame() {
        System.out.println("새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (validationResetGame(Console.readLine()) == 1) {
        playGame();
        } else {
            System.out.println("게임 종료");
            System.exit(0);
        }
    }


    private int validationResetGame(String input) {
        if (input.equals("1") || input.equals("2")) {
            return Integer.parseInt(input);
        } else {
            throw new IllegalArgumentException();
        }
    }

    //랜덤 숫자
    public List<Integer> random() {
        RandomNumber randomNumber = new RandomNumber();
        List<Integer> list = randomNumber.getRandomNumbers();
        return list;
    }

    //숫자 입력받기
    private String numbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String s = Console.readLine();
        return s;
    }

    //숫자 넘기기
    private List<Integer> inputNumbers(String number) {
        UserNumber usernumber = new UserNumber();
        usernumber.setUserNumber(number);
        List<Integer> list = new ArrayList<>();
        list.add(usernumber.getUserNumber()/100);
        list.add((usernumber.getUserNumber()%100)/10);
        list.add((usernumber.getUserNumber()%10));
        return list;
    }


    //3스트라이크 판정
    private String compare(List<Integer> list1, List<Integer> list2) {
        int strike = 0;
        int ball = 0;
        if (list1.equals(list2)) {
            return "end";
        } if (list1.get(0).equals(list2.get(0))) {
            strike++;
        } if (list1.get(0).equals(list2.get(1))) {
            ball++;
        } if (list1.get(0).equals(list2.get(2))) {
            ball++;
        } if (list1.get(1).equals(list2.get(0))) {
            ball++;
        } if (list1.get(1).equals(list2.get(1))) {
            strike++;
        } if (list1.get(1).equals(list2.get(2))) {
            ball++;
        } if (list1.get(2).equals(list2.get(0))) {
            ball++;
        } if (list1.get(2).equals(list2.get(1))) {
            ball++;
        } if (list1.get(2).equals(list2.get(2))) {
            strike++;
        }

        if(strike==0&&ball==0) {
            return "낫싱";
        }
        else if (strike>0&&ball>0) {
            return ball+"볼 "+strike+"스트라이크";
        }
        else if (strike==0&&ball!=0) {
            return ball+"볼";
        }
        else if (strike!=0&&ball==0) {
            return strike+"스트라이크";
        }
        return "";
    }
}
