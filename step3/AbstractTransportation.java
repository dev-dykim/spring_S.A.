package step3;

public abstract class AbstractTransportation implements Transportation {
    int number;     // 번호
    int maxPassenger;  // 최대 승객 수
    int curPassenger;  // 현재 승객 수
    int fueling = 100;        // 주유량
    int speed = 10;          // 현재 속도
    String status;      // 상태
    int basicFee;       // 기본 요금
    int totalFee;       // 누적 요금

    public void chgFueling(int fueling) {
        this.fueling += fueling;
        checkFueling();
    }

    public void checkPassengerNum(int passenger) {
        if (curPassenger + passenger > maxPassenger)
            System.out.println("최대 승객 수는 " + maxPassenger
                    + "명 입니다. 탑승 승객 수는 잔여 승객 수인 " + (maxPassenger - curPassenger) + "명을 초과할 수 없습니다.");
    }

}
