package baseball.Model;

public class UserNumber {
    private int userNumber;


    public void setUserNumber(String userNumber) {
        this.userNumber = validationNumber(userNumber);
    }

    public int getUserNumber() {
        return userNumber;
    }


    private  int validationNumber(String input) {
        try {
            int num = Integer.parseInt(input);
            if (num < 1) {
                throw new IllegalArgumentException("0 이하의 수를 입력할 수 없습니다.");
            }
            else if (num > 999) {
                throw new IllegalArgumentException("3개의 숫자를 입력해주세요");
            }
            else if (num < 100) {
                throw new IllegalArgumentException("3개의 숫자를 입력해주세요");
            }
            else
            {
                if (!checkNumber(input)) {
                    throw new IllegalArgumentException("중복된 숫자를 입력하셨습니다.");
                }
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닙니다.");
        }
    }

    private boolean checkNumber(String input){
        if(input.substring(0,1).equals(input.substring(1,2))||input.substring(0,1).equals(input.substring(2,3))||input.substring(1,2).equals(input.substring(2,3))){
            return false;
        }
        return true;
    }


}
