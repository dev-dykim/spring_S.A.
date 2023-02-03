package step2;

public class Taxi {
    private final int taxi_num;
    private int max_passenger;
    private int cur_passenger;
    private int fueling;
    private int speed;
    private String destination;
    private int basic_dist;
    private int dest_dist;
    private int basic_fee;
    private int dist_fee;
    private int psg_fee;    // 승객이 내야할 금액
    private int total_fee;  // 택시가 번 요금 총액(누적요금)
    private String status;

    static int taxi_idx = 0;

    public Taxi() {
        taxi_num = ++taxi_idx;
        max_passenger = 4;
        fueling = 100;
        speed = 0;
        basic_dist = 1;  // 기본거리 1km
        basic_fee = 3000;   // 기본요금 3000원
        dist_fee = 1000;     // 거리당 요금 1km 1000원
        status = "일반";

        System.out.println(taxi_num + "번 택시가 생성되었습니다.");
    }

    public void initTaxi() {
        cur_passenger = 0;
        destination = "";
        dest_dist = 0;
        psg_fee = 0;
        status = "일반";
        checkFueling();
    }

    public String toString() {
        return "(택시 번호 : " + taxi_num +
                ", 최대 승객 수 : " + max_passenger + ", 현재 승객 수 : " + cur_passenger +
                ", 기본 요금 : " + basic_fee + ", 목적지 : " + destination + ", 목적지까지 거리 : " + dest_dist + "km" +
                ", 지불할 요금 : " + psg_fee + ", 주유량 : " + fueling + ", 현재 속도 : " + speed + ", 상태 : " + status +
                ", 누적 요금 : " + total_fee +")";
    }

    public void chgFueling(int fueling) {
        this.fueling += fueling;
        checkFueling();
    }

    public void checkFueling() {
        if (this.fueling < 10 && !status.equals("운행")) {
            System.out.println("주유가 필요합니다.");
            this.status = "운행불가";
        }
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDest_dist(int dest_dist) {
        this.dest_dist = dest_dist;
        calculatePsg_fee(); // 승객이 지불할 요금 계산
    }

    public void addCur_passenger(int passenger) {
        if (this.cur_passenger + passenger > this.max_passenger)
            System.out.println("최대 승객 수는 " + this.max_passenger
                    + "명 입니다. 탑승 승객 수는 잔여 승객 수인 " + (max_passenger - cur_passenger) + "명을 초과할 수 없습니다.");

        if (!this.status.equals("일반"))
            System.out.println("현재 택시 상태는 " + this.status + " 입니다. 택시가 일반 상태인 경우에만 승객이 탑승할 수 있습니다.");

        if (this.cur_passenger + passenger <= this.max_passenger && this.status.equals("일반")) {
            this.cur_passenger += passenger;
            status = "운행중";
        }
    }

    public void chgSpeed(int speed) {
        this.speed += speed;
    }

    public void calculatePsg_fee() {
        psg_fee = (dest_dist <= basic_dist) ? basic_fee : basic_fee + (dest_dist - basic_dist) * dist_fee;
    }

    public void payFee() {
        total_fee += psg_fee;
        initTaxi();
    }
}
