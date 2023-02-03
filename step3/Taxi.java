package step3;

public class Taxi extends AbstractTransportation implements ChangeStatusWithNoParameter, SetDestination {
    private String destination;
    private int basicDist;
    private int destDist;
    private int distFee;
    private int psgFee;    // 승객이 내야할 금액

    static int taxi_idx = 0;

    public Taxi() {
        number = ++taxi_idx;
        maxPassenger = 4;
        basicDist = 1;  // 기본거리 1km
        basicFee = 3000;   // 기본요금 3000원
        distFee = 1000;     // 거리당 요금 1km 1000원
        status = "일반";

        System.out.println(number + "번 택시가 생성되었습니다.");
    }

    public String toString() {
        return "(택시 번호 : " + number +
                ", 최대 승객 수 : " + maxPassenger + ", 현재 승객 수 : " + curPassenger +
                ", 기본 요금 : " + basicFee + ", 목적지 : " + destination + ", 목적지까지 거리 : " + destDist + "km" +
                ", 지불할 요금 : " + psgFee + ", 주유량 : " + fueling + ", 현재 속도 : " + speed + ", 상태 : " + status +
                ", 누적 요금 : " + totalFee +")";
    }

    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public void setDestDist(int destDist) {
        this.destDist = destDist;
        calculatePsg_fee(); // 승객이 지불할 요금 계산
    }

    @Override
    public void checkFueling() {
        if (this.fueling < 10 && !status.equals("운행")) {
            System.out.println("주유가 필요합니다.");
            this.status = "운행불가";
        }
    }

    @Override
    public void addCurPassenger(int passenger) {
        checkPassengerNum(passenger);

        if (!status.equals("일반"))
            System.out.println("현재 택시 상태는 " + this.status + " 입니다. 일반 상태인 경우에만 승객이 탑승할 수 있습니다.");

        if (this.curPassenger + passenger <= this.maxPassenger && this.status.equals("일반")) {
            this.curPassenger += passenger;
            status = "운행중";
        }
    }

    @Override
    public void chgSpeed(int speed) {
        this.speed += speed;
    }

    @Override
    public void payFee() {
        totalFee += psgFee;
        chgStatus(); // 요금 낸 후 택시 상태 변경
    }

    @Override
    public void chgStatus() {
        curPassenger = 0;
        destination = null;
        destDist = 0;
        psgFee = 0;
        status = "일반";
        checkFueling();
    }

    public void calculatePsg_fee() {
        psgFee = (destDist <= basicDist) ? basicFee : basicFee + (destDist - basicDist) * distFee;
    }

}
