package step1;

public class Main {
    public static void main(String[] args) {
        // 1. 버스 번호 자동 생성
        System.out.println("<버스 생성>");
        Bus bus1 = new Bus(15, 2, 1000, 20, 50);
        Bus bus2 = new Bus(25, 10,1500, 30, 60);
        Bus bus3 = new Bus(10, 3,2000, 9, 40);

        System.out.println(bus1);
        System.out.println(bus2);
        System.out.println(bus3);

        // 2. 버스 상태 변경
        System.out.println("\n" + "<버스 상태 변경>");
        // 2-1. 정상 변경
        bus1.setStatus("종료");
        System.out.println("bus1 상태 변경(종료) -> " + bus1);

        bus1.setStatus("운행");
        System.out.println("bus1 상태 변경(운행) -> " + bus1);

        // 2-2. 주유량이 떨어진 경우
        System.out.println("\n" + "bus2 주유량 0 설정");
        System.out.println("변경전 -> " + bus2);
        bus2.setFueling(0);
        System.out.println("변경후 -> " + bus2);

        // 2-3. 주유량이 10 미만인 경우 경고 메시지. 주유량 0이 아니면 운행은 가능
        System.out.println("\n" + "bus2 주유량 5 설정");
        bus2.setFueling(5);
        System.out.println("bus2 상태 변경(운행)");
        System.out.println("변경전 -> " + bus2);
        bus2.setStatus("운행");
        System.out.println("변경후 -> " + bus2);

        // 3. 승객 탒승
        System.out.println("\n" + "<승객 탑승>");
        // 3-1. 정상 추가
        System.out.println("bus1 승객 10명 추가");
        System.out.println("변경전 -> " + bus1);
        bus1.setCur_passenger(10);
        System.out.println("변경후 -> " + bus1);

        // 3-2. 최대 승객 수를 넘을 경우
        System.out.println("\n" + "bus1 승객 5명 추가");
        System.out.println("변경전 -> " + bus1);
        bus1.setCur_passenger(5);
        System.out.println("변경후 -> " + bus1);

        // 3-3. 운행중인 버스가 아닌 경우
        System.out.println("\n" + "bus3 운행 종료");
        bus3.setStatus("종료");
        System.out.println(bus3);
        System.out.println("bus3 승객 1명 추가");
        System.out.println("변경전 -> " + bus3);
        bus3.setCur_passenger(1);
        System.out.println("변경후 -> " + bus3);

        // 4. 속도 변경
        System.out.println("\n" + "<속도 변경>");
        // 4-1. 정상 변경
        System.out.println("bus1 속도 +10");
        System.out.println("변경전 -> " + bus1);
        bus1.setSpeed("+", 10);
        System.out.println("변경후 -> " + bus1);

        System.out.println("bus1 속도 -15");
        System.out.println("변경전 -> " + bus1);
        bus1.setSpeed("-", 15);
        System.out.println("변경후 -> " + bus1);

        // 4-2. 주유량이 10 미만인 경우 -> 속도 변경 불. 경고 메시지 출력
        System.out.println("\n" + "bus2 속도 +10");
        System.out.println("변경전 -> " + bus2);
        bus2.setSpeed("+", 10);
        System.out.println("변경후 -> " + bus2);
    }
}
