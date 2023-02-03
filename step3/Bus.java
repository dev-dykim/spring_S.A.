package step3;

public class Bus extends AbstractTransportation implements ChangeStatusWithParameter {

    static int bus_idx = 0;

    public Bus() {
        number = ++bus_idx;
        maxPassenger = 30;
        status = "운행";

        System.out.println(number + "번 버스가 생성되었습니다.");
    }

    public String toString() {
        return "(버스 번호 : " + number +
                ", 최대 승객 수 : " + maxPassenger + ", 현재 승객 수 : " + curPassenger +
                ", 요금 : " + totalFee + ", 주유량 : " + fueling +
                ", 현재 속도 : " + speed + ", 상태 : " + status + ")";
    }

    @Override
    public void checkFueling() {
        if (fueling < 10) {
            System.out.println("주유가 필요합니다.");
            status = "차고지행";
        }
    }

    @Override
    public void addCurPassenger(int passenger) {
        checkPassengerNum(passenger);

        if (!status.equals("운행"))
            System.out.println("현재 상태는 " + status + " 입니다. 운행중일 때만 승객이 탑승할 수 있습니다.");

        if (curPassenger + passenger <= maxPassenger && status.equals("운행"))
            curPassenger += passenger;

        payFee();
    }

    @Override
    public void chgSpeed(int speed) {
        if (fueling < 10)
            System.out.println("주유량을 확인해주세요.");
        else
            this.speed += speed;
    }

    @Override
    public void payFee() {
        totalFee = basicFee * curPassenger;
    }

    @Override
    public void chgStatus(String status) {
        if (status.equals("종료")) {
            this.status = "차고지행";
        } else if (status.equals("운행")) {
            this.status = status;
        } else {
            System.out.println("운행 / 종료 두 상태로 변경할 수 있습니다.");
        }
        checkFueling();
    }
}
