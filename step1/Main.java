package step1;

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
        bus1.addCur_passenger(2);
        System.out.println("변경후 -> " + bus1);

        // 주유량 변경
        System.out.println("\n" + "주유량 변경 (-50)");
        System.out.println("변경전 -> " + bus1);
        bus1.chgFueling(-50);
        System.out.println("변경후 -> " + bus1);

        // 상태 변경
        System.out.println("\n" + "차고지행으로 변경");
        System.out.println("변경전 -> " + bus1);
        bus1.setStatus("종료");
        System.out.println("변경후 -> " + bus1);

        // 주유량 변경
        System.out.println("\n" + "주유량 변경 (+10)");
        System.out.println("변경전 -> " + bus1);
        bus1.chgFueling(10);
        System.out.println("변경후 -> " + bus1);

        // 상태 변경
        System.out.println("\n" + "운행중으로 변경");
        System.out.println("변경전 -> " + bus1);
        bus1.setStatus("운행");
        System.out.println("변경후 -> " + bus1);

        // 승객 탑승 - 최대 승객 수 이하일때만 가능
        System.out.println("\n" + "승객 45명 탑승");
        System.out.println("변경전 -> " + bus1);
        bus1.addCur_passenger(45);
        System.out.println("변경후 -> " + bus1);

        // 승객 탑승
        System.out.println("\n" + "승객 5명 탑승");
        System.out.println("변경전 -> " + bus1);
        bus1.addCur_passenger(5);
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
        bus1.addCur_passenger(3);
        System.out.println("변경후 -> " + bus1);
    }
}
