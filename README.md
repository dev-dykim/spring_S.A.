# Spring S.A. - 클래스 설계

## step1. Bus class 만들기

### 1. 변수설정
```java
private final int bus_number;     // 버스 번호
private int max_passenger;  // 최대 승객 수
private int cur_passenger;  // 현재 승객 수
private int fee;            // 요금(승객 수 * 기본요금)
private int fueling;        // 주유량
private int speed;          // 현재 속도
private String status;      // 상태

static int bus_idx = 0;     // 버스 객체 생성 시, 버스 번호를 고유번호로 생성하기 위해 필요한 클래스 변수
static final int BASIC_FEE = 1000; // 1인당 기본요금 설정
```

### 2. 생성자
```java
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
}
```
* 버스 번호는 고유값으로 생성
* 초기값 - 최대 승객 수 30, 현재 승객 수 0, 현재 요금 0, 주유량 100, 속도 50, 상태 "운행"

### 3. 메서드
* `String toString()` : 버스 객체 상태를 쉽게 보기 위해 toString() 메서드를 오버라이딩했다.
* `int getFueling()` : 현재 주유량을 return
* `void chgFueling(int fueling)` : 주유량을 입력받은만큼 넣어주고 10 미만인지 체크한다.
* `void checkFueling()` : 현재 주유량이 10 미만이라면 메시지를 출력, 0이라면 상태를 "차고지행"으로 바꾼다.
* `void setStatus(String status)` : "종료" 또는 "운행"을 입력받아 현재 상태를 바꾼다. 상태를 바꿀 때 주유량을 체크한다.
* `void addCur_passenger(int passenger)` : 입력받은 passenger 수만큼 현재 승객 수를 업데이트한다. 단, 최대 승객 수를 넘지 않아야 하고 운행중인 버스여야 한다.
* `void chgSpeed(int speed)` : 속도를 입력받아 현재 속도를 업데이트한다. 단, 주유량이 10 이상인 경우 속도 업데이트가 가능하며, 미만인 경우 경고 메시지를 출력한다.
