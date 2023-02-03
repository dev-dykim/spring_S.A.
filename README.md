# Spring S.A. - 클래스 설계

## step1. Bus class 만들기

### 1. 변수설정
```java
private final int bus_number;     // 버스 번호
private int max_passenger;  // 최대 승객 수
private int cur_passenger;  // 현재 승객 수
private int fee;            // 요금
private int fueling;        // 주유량
private int speed;          // 현재 속도
private String status;      // 상태

static int bus_idx = 0;     // 버스 객체 생성 시, 버스 번호를 고유번호로 생성하기 위해 필요한 클래스 변수
```

### 2. 생성자
```java
public Bus() {
    bus_number = ++bus_idx;
    status = "운행";
}

public Bus(int max_passenger, int cur_passenger, int fee, int fueling, int speed) {
    this();
    this.max_passenger = max_passenger;
    this.cur_passenger = cur_passenger;
    this.fee = fee;
    this.fueling = fueling;
    this.speed = speed;

    System.out.println(this.bus_number + "번 버스가 생성되었습니다.");
}
```
* 버스 번호는 고유값으로 생성
* 버스 상태의 default 값은 "운행"
* 나머지 변수들은 객체 생성 시 입력받는다.

### 3. 메서드
* `String toString()` : 버스 객체 상태를 쉽게 보기 위해 toString() 메서드를 오버라이딩했다.
* `int getFueling()` : 현재 주유량을 return
* `void setFueling(int fueling)` : 주유량을 넣어주고 10 미만인지 체크한다.
* `void checkFueling()` : 현재 주유량이 10 미만이라면 메시지를 출력, 0이라면 상태를 "차고지행"으로 바꾼다.
* `void setStatus(String status)` : "종료" 또는 "운행"을 입력받아 현재 상태를 바꾼다. 상태를 바꿀 때 주유량을 체크한다.
* `String getStatus()` : 현재 상태를 return 한다.
* `void setCur_passenger(int passenger)` : 입력받은 passenger 수만큼 현재 승객 수를 업데이트한다. 단, 최대 승객 수를 넘지 않아야 하고 운행중인 버스여야 한다.
* `void setSpeed(String sign, int speed)` : "+" 또는 "-", 속도를 입력받아 현재 속도를 업데이트한다. 단, 주유량이 10 이상인 경우 속도 업데이트가 가능하며, 미만인 경우 경고 메시지를 출력한다.
