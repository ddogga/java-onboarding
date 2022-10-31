package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;


        // 0번 : 100, 1번 : 1000, 2번 : 10000 각각의 369의 개수
        int[] countList = new int[3];

        countList[0] = tens(100);
        System.out.println("countList[0] = " + countList[0]);
        countList[1] = hundreds(1000, countList[0]);
        System.out.println("countList[1] = " + countList[1]);

        if (number == 10000) {return countList[3];}

        int placeValue = getPlaceValue(number);

        switch (placeValue) {
            case 1 :
                answer = units(number);
                break;

            case 2 :
                answer = tens(number);
                break;

            case 3 :
                answer = hundreds(number,countList[0]);
        }



        return answer;
    }


    //몇 자리수 인지 구하기
    public static int getPlaceValue(int number) {

        String num = Integer.toString(number);

        int cnt = num.length();

        // 1:1의 자리, 2:10의 자리 3:100의 자리 4:1000의 자리 5:10000의 자리
        return cnt;
    }


    public static int units(int number) {

        if (number == 0) {return 0;}

        return (int) number / 3;

    }

    public static int tens(int number) {

        if (number == 0) {return 0;}

        int ten = (int) number / 10;
        int unit = number % 10;
        int tensThreeCount = (int)ten/3;

        int result = 0;


        if (ten%3 == 0) {
            result = ten * 3 + 10 * (tensThreeCount-1) +(unit + 1) + units(unit);
        } else {
            result = ten * 3 + 10 * tensThreeCount + units(unit);
        }

        return result;
    }

    public static int hundreds(int number, int count100) {

        if (number == 0) {return 0;}

        int hundred = (int) number / 100;
        int ten = number - hundred * 100;

        int hundredsThreeCount = (int) hundred/3;

        int result = 0;


        if (hundred%3 == 0) {
            result = (hundredsThreeCount - 1) * 100 + count100 * hundred + (ten+1) + tens(ten);
        } else {
            result = hundredsThreeCount * 100 + count100 * hundred + tens(ten);
        }

        return result;
    }



    public static void main(String[] args) {
        int number = 639;

        System.out.println(solution(number));
    }

}
