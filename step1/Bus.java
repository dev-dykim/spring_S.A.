package step1;

public class Bus {
    private final int bus_number;     // 버스 번호
    private int max_passenger;  // 최대 승객 수
    private int cur_passenger;  // 현재 승객 수
    private int fee;            // 요금
    private int fueling;        // 주유량
    private int speed;          // 현재 속도
    private String status;      // 상태

    static int bus_idx = 0;
    static final int BASIC_FEE = 1000;

    public Bus() {
        bus_number = ++bus_idx;
        max_passenger = 30;
        cur_passenger = 0;
        fee = 0;
        fueling = 100;
        speed = 50;
        status = "운행";

        System.out.println(this.bus_number + "번 버스가 생성되었습니다.");
    }

    public String toString() {
        return "(버스 번호 : " + bus_number +
                ", 최대 승객 수 : " + max_passenger + ", 현재 승객 수 : " + cur_passenger +
                ", 요금 : " + fee + ", 주유량 : " + fueling +
                ", 현재 속도 : " + speed + ", 상태 : " + status + ")";
    }

    public int getFueling() {
        return this.fueling;
    }

    public void chgFueling(int fueling) {
        this.fueling += fueling;
        checkFueling();
    }

    public void checkFueling() {
        if (this.fueling < 10) {
            System.out.println("주유가 필요합니다.");
            this.status = "차고지행";
        }
    }

    public void setStatus(String status) {
        if (status.equals("종료")) {
            this.status = "차고지행";
        } else if (status.equals("운행")) {
            this.status = "운행";
        } else {
            System.out.println("운행 / 종료 두 상태로 변경할 수 있습니다.");
        }
        checkFueling();
    }

    public void addCur_passenger(int passenger) {
        if (this.cur_passenger + passenger > this.max_passenger)
            System.out.println("최대 승객 수는 " + this.max_passenger + "명 입니다. 현재 승객 수는 최대 승객 수를 초과할 수 없습니다.");

        if (this.status.equals("차고지행"))
            System.out.println("현재 버스 상태는 " + this.status + " 입니다. 버스가 운행중일 때만 승객이 탑승할 수 있습니다.");

        if (this.cur_passenger + passenger <= this.max_passenger && this.status.equals("운행")) {
            this.cur_passenger += passenger;
        }

        this.fee = BASIC_FEE * this.cur_passenger;
    }

    public void chgSpeed(int speed) {
        if (getFueling() < 10) {
            System.out.println("주유량을 확인해주세요.");
            return;
        }

        this.speed += speed;
    }

}


