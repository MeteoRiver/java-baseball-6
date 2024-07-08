package baseball.Model;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class RandomNumber {
    private final List<Integer> randomNumbers;


    public RandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
            }
        }
        this.randomNumbers = computer;
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
