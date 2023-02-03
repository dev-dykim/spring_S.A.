package step3;

public class Main {
    public static void main(String[] args) {
        // 버스 번호 자동 생성
        System.out.println("<버스 생성>");
        Bus bus1 = new Bus();
        Bus bus2 = new Bus();

        System.out.println(bus1);
        System.out.println(bus2);

        // 승객 탑승
        System.out.println("\n" + "승객 2명 추가");
        System.out.println("변경전 -> " + bus1);
        bus1.addCurPassenger(2);
        System.out.println("변경후 -> " + bus1);

        // 주유량 변경
        System.out.println("\n" + "주유량 변경 (-50)");
        System.out.println("변경전 -> " + bus1);
        bus1.chgFueling(-50);
        System.out.println("변경후 -> " + bus1);

        // 상태 변경
        System.out.println("\n" + "차고지행으로 변경");
        System.out.println("변경전 -> " + bus1);
        bus1.chgStatus("종료");
        System.out.println("변경후 -> " + bus1);

        // 주유량 변경
        System.out.println("\n" + "주유량 변경 (+10)");
        System.out.println("변경전 -> " + bus1);
        bus1.chgFueling(10);
        System.out.println("변경후 -> " + bus1);

        // 상태 변경
        System.out.println("\n" + "운행중으로 변경");
        System.out.println("변경전 -> " + bus1);
        bus1.chgStatus("운행");
        System.out.println("변경후 -> " + bus1);

        // 승객 탑승 - 최대 승객 수 이하일때만 가능
        System.out.println("\n" + "승객 45명 탑승");
        System.out.println("변경전 -> " + bus1);
        bus1.addCurPassenger(45);
        System.out.println("변경후 -> " + bus1);

        // 승객 탑승
        System.out.println("\n" + "승객 5명 탑승");
        System.out.println("변경전 -> " + bus1);
        bus1.addCurPassenger(5);
        System.out.println("변경후 -> " + bus1);

        // 주유량 변경
        System.out.println("\n" + "주유량 변경 (-55)");
        System.out.println("변경전 -> " + bus1);
        bus1.chgFueling(-55);
        System.out.println("변경후 -> " + bus1);

        // 속도 변경 - 주유량 10 이상일때만 가능
        System.out.println("\n" + "속도 변경 (+10)");
        System.out.println("변경전 -> " + bus1);
        bus1.chgSpeed(10);
        System.out.println("변경후 -> " + bus1);

        // 주유량 변경
        System.out.println("\n" + "주유량 변경 (+10)");
        System.out.println("변경전 -> " + bus1);
        bus1.chgFueling(10);
        System.out.println("변경후 -> " + bus1);

        // 속도 변경
        System.out.println("\n" + "속도 변경 (+10)");
        System.out.println("변경전 -> " + bus1);
        bus1.chgSpeed(10);
        System.out.println("변경후 -> " + bus1);

        // 승객 탑승 - 운행중에만 가능
        System.out.println("\n" + "승객 탑승 (+3)");
        System.out.println("변경전 -> " + bus1);
        bus1.addCurPassenger(3);
        System.out.println("변경후 -> " + bus1);

        // 택시 번호 자동 생성
        System.out.println("-----------------------------");
        System.out.println("<택시 생성>");
        Taxi taxi1 = new Taxi();
        Taxi taxi2 = new Taxi();

        System.out.println(taxi1);
        System.out.println(taxi2);

        // 승객 탑승
        System.out.println("\n" + "승객 2명 탑승, 목적지 : 서울역, 거리 : 2(km)");
        System.out.println("변경전 -> " + taxi1);
        taxi1.addCurPassenger(2);
        taxi1.setDestination("서울역");
        taxi1.setDestDist(2);
        System.out.println("변경후 -> " + taxi1);

        // 속도 변경
        System.out.println("\n" + "속도 변경 (+60)");
        System.out.println("변경전 -> " + taxi1);
        taxi1.chgSpeed(60);
        System.out.println("변경후 -> " + taxi1);

        // 주유량 변경
        System.out.println("\n" + "주유량 변경 (-80)");
        System.out.println("변경전 -> " + taxi1);
        taxi1.chgFueling(-80);
        System.out.println("변경후 -> " + taxi1);

        // 요금 결제
        System.out.println("\n" + "요금 결제");
        System.out.println("변경전 -> " + taxi1);
        taxi1.payFee();
        System.out.println("변경후 -> " + taxi1);

        // 승객 탑승 -> 5명 탑승 불가
        System.out.println("\n" + "승객 5명 탑승");
        System.out.println("변경전 -> " + taxi1);
        taxi1.addCurPassenger(5);
        System.out.println("변경후 -> " + taxi1);

        // 승객 탑승
        System.out.println("\n" + "승객 2명 탑승, 목적지 : 서울역, 거리 : 2(km)");
        System.out.println("변경전 -> " + taxi1);
        taxi1.addCurPassenger(3);
        taxi1.setDestination("구로디지털단지역");
        taxi1.setDestDist(12);
        System.out.println("변경후 -> " + taxi1);

        // 주유량 변경
        System.out.println("\n" + "주유량 변경 (-20)");
        System.out.println("변경전 -> " + taxi1);
        taxi1.chgFueling(-20);
        System.out.println("변경후 -> " + taxi1);

        // 요금 결제
        System.out.println("\n" + "요금 결제");
        System.out.println("변경전 -> " + taxi1);
        taxi1.payFee();
        System.out.println("변경후 -> " + taxi1);
    }
}
