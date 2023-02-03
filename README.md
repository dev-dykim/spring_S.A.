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

## step2. Taxi class 만들기

### 1. 변수설정
```java
private final int taxi_num;  // 택시 번호
private int max_passenger;  // 최대 승객 수
private int cur_passenger;  // 현재 승객 수
private int fueling;        // 주유량
private int speed;          // 속도
private String destination; // 목적지
private int basic_dist;     // 기본 거리
private int dest_dist;      // 목적지까지 거리
private int basic_fee;      // 기본 요금
private int dist_fee;       // 거리당 요금
private int psg_fee;        // 승객이 내야할 금액
private int total_fee;      // 택시가 번 요금 총액(누적요금)
private String status;      // 택시 상태

static int taxi_idx = 0;    // 택시 객체 생성 시, 택시 번호를 고유번호로 생성하기 위해 필요한 클래스 변수
```

### 2. 생성자
```java
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
```
* 택시 번호는 고유값으로 생성
* 초기값 - 최대 승객 수 4, 주유량 100, 속도 0, 기본거리 1(km), 기본요금 3000(원), 거리당 요금(1000원)상태 "일반"

### 3. 메서드
* `void initTaxi()` : 승객이 내린 후 택시 상태를 초기화한다.
* `String toString()` : 택시 객체 상태를 쉽게 보기 위해 toString() 메서드를 오버라이딩했다.
* `void chgFueling(int fueling)` : 주유량을 입력받은만큼 넣어주고 10 미만인지 체크한다.
* `void checkFueling()` : 운행 전 주유량이 10 미만이라면 메시지를 출력하고 "운행불가" 상태로 만든다.
* `void setDestination(String destination)` : 목적지를 넣어준다.
* `setDest_dist(int dest_dist)` : 목적지까지의 거리를 넣어주고, 승객이 지불할 요금을 계산하는 함수(`calculatePsg_fee`)를 호출한다.
* `void addCur_passenger(int passenger)` : 입력받은 passenger 수만큼 현재 승객 수를 업데이트한다. 단, 최대 승객 수를 넘지 않아야 하고 일반 상태의 택시여야 한다.
* `void chgSpeed(int speed)` : 속도를 입력받아 현재 속도를 업데이트한다.
* `void calculatePsg_fee()` : 승객이 내야할 요금을 계산한다.
* `void payFee()` : 승객이 요금을 지불한 후, 택시의 누적금액을 더해준다. 지불이 끝난 택시의 상태를 초기화해준다.

## step3. 추상클래스 및 인터페이스 확장

### 1. 추상클래스 
* `abstract class AbstractTransportation`
    * 공통 변수 선언
```java
int number;     // 번호
int maxPassenger;  // 최대 승객 수
int curPassenger;  // 현재 승객 수
int fueling = 100;        // 주유량
int speed = 10;          // 현재 속도
String status;      // 상태
int basicFee;       // 기본 요금
int totalFee;       // 누적 요금
```
* 공통 메서드 선언
  * `void chgFueling(int fueling)` : 주유량 변경 메서드
  * `void checkPassengerNum(int passenger)` : 승객 수 체크 메서드

### 2. 인터페이스
* `Transportation` : 공통 사용
  * `void checkFueling()` : 연료량 10 미만인지 체크
  * `void addCurPassenger(int passenger)` : 승객 탑승
  * `void chgSpeed(int spped)` : 속도 변경
  * `void payFee()` : 요금 계₩
* `ChangeStatusWithParameter` : 상태값 변경(파라미터 있는 경우) 
  * `void chgStatus(String status)`
* `ChangeStatusWithNoParameter` : 상태값 변경(파라미터 없는 경우)
  * `void chgStatus()`
* `setDestination` : 목적지 세팅
  * `void setDestination(String destination)` : 목적지 설정
  * `void setDestDist(int DestDist)` : 목적지까지 거리 설정

### 3. 구현
* class `Bus` extends `AbstractTransportation` implements `ChangeStatusWithParameter` 
* class `Taxi` extends `AbstractTransportation` implements `ChangeStatusWithNoParameter`, `SetDestination`
