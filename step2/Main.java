package step2;

public class Main {
    public static void main(String[] args) {
        // 택시 번호 자동 생성
        System.out.println("<택시 생성>");
        Taxi taxi1 = new Taxi();
        Taxi taxi2 = new Taxi();

        System.out.println(taxi1);
        System.out.println(taxi2);

        // 승객 탑승
        System.out.println("\n" + "승객 2명 탑승, 목적지 : 서울역, 거리 : 2(km)");
        System.out.println("변경전 -> " + taxi1);
        taxi1.addCur_passenger(2);
        taxi1.setDestination("서울역");
        taxi1.setDest_dist(2);
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
        taxi1.addCur_passenger(5);
        System.out.println("변경후 -> " + taxi1);

        // 승객 탑승
        System.out.println("\n" + "승객 2명 탑승, 목적지 : 서울역, 거리 : 2(km)");
        System.out.println("변경전 -> " + taxi1);
        taxi1.addCur_passenger(3);
        taxi1.setDestination("구로디지털단지역");
        taxi1.setDest_dist(12);
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
