# PC방 음식 주문 및 채팅 서비스
> 04조_객체지향설계기술 팀 프로젝트   
![imgs](https://img.shields.io/badge/Language-Java-orange) ![imgs](https://img.shields.io/badge/Database-MySQL-blue) ![imgs](https://img.shields.io/badge/Build%20Tool-Apache%20Maven-red)
---
## 프로젝트 개요 :scroll:
   
```
모의 PC방 음식 주문 및 채팅 서비스 입니다. 

Java의 Swing 라이브러리를 활용해 클라이언트 개발, MySQL DB를 사용해 음식, 고객, 
주문 데이터 CRUD 데이터 가공과 비즈니스 로직 처리, 스레드로 사용자를 관리함에 따른 다수 사용자 지원, 
그리고 Server socket을 사용해 스레드간의 채팅 서비스를 구현했습니다.
```

## 팀 구성 :sparkles:
   
:boy: 팀	장 : 이헌기	15012970  
:boy: 팀	원 : 정민영	15012971  
:girl: 팀	원 : 권동희	15012982  
:boy: 팀	원 : 김영현	17013139  

## 시스템 구조도 :triangular_ruler:
![sysconfigdiagram](https://github.com/Heongilee/04_PC_order/blob/master/UMLDiagram_v2.0/SysWithoutContributor.png?raw=true)
## 클래스 설계 :pencil2:
   
* Model
![model](https://github.com/Heongilee/04_PC_order/blob/master/UMLDiagram_v2.0/Model.gif?raw=true)
   
* View
![view](https://github.com/Heongilee/04_PC_order/blob/master/UMLDiagram_v2.0/View.gif?raw=true)
   
* Controller
![controller](https://github.com/Heongilee/04_PC_order/blob/master/UMLDiagram_v2.0/Controller.gif?raw=true)

## 기능스펙 :memo:
### 회원가입
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85_%EC%A4%91%EB%B3%B5%EA%B2%80%EC%82%AC.png?raw=true" width=800>
바로가기 : [Google](http://www.google.com "구글")


## 시연 :computer:
### 회원가입   
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/01.gif?raw=true" width=400> <img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/02.gif?raw=true" width=400>   

### 예외처리
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/03.gif?raw=true" width=266> <img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/04.gif?raw=true" width=266> <img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/05.gif?raw=true" width=266>   
사용자가 관리자 모드(Server mode)에 접근하려는 경우, 사용자가 존재하지 않는 아이디로 로그인 시도할 경우, 사용자가 비밀번호를 잘못 입력한 경우, 모두 에러메시지를 출력합니다.   
### 중복 로그인 예외 처리
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/06.gif?raw=true" width=800>   
이미 로그인중인 계정을 다른 클라이언트가 로그인을 시도할 경우 로그인이 막히도록 구현했습니다.   
   
### 상품 구매
* 포인트 부족
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/07.gif?raw=true" width=800>   
포인트가 부족하면 상품을 구매할 수 없습니다.   
  
  #
* 상품 결제시 관리자 컴퓨터에 반영   
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/09.gif?raw=true" width=800>   
상품을 결제하면 관리자 컴퓨터에는 사용자가 로그인한 좌석에 주문한 상품이 표시됩니다.   
   
### 사용자가 관리자에게 메시지를 보냄(Talk 기능)
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/10.gif?raw=true" width=800>   
사용자가 보낸 메시지는 관리자에게만 보여집니다.
   
### 관리자가 사용자에게 메시지를 보냄(Broadcast 기능)
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/11.gif?raw=true" width=800>   
관리자가 보낸 메시지는 모든 사용자들에게 보여집니다.
   
### 관리자가 특정 사용자에게 메시지를 보냄(Talk 기능)
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/12.gif?raw=true" width=800>   
관리자는 특정 사용자만 볼 수 있는 메시지를 전송할 수 있습니다.
   
### 사용자가 로그아웃하면 관리자 컴퓨터에 반영
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/18.gif?raw=true" width=800>   
사용자가 로그아웃하면 좌석은 빈자리로 초기화되며, 관리자 측에 해당 사용자가 접속을 종료했다는 알림메시지가 출력됩니다.
   
### 재고 관리
* (Create) 상품 생성하기   
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/14.gif?raw=true" width=800>   
상품명, 단가, 제조사, 카테고리를 선택하면 원하는 품목을 추가시킬 수 있습니다.
  
  #
* (Read) 상품 불러오기   
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/13.gif?raw=true" width=400> <img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/15.gif?raw=true" width=400>   
전체 상품을 조회하거나 특정 상품만 콤보박스에서 선택해 조회할 수 있습니다.
  
  #
* (Update) 상품 수정하기   
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/16.gif?raw=true" width=800>   
상품 조회 후 수정하고자 하는 필드를 수정하면 상품 정보가 수정됩니다.
  
  #
* (Delete) 상품 삭제하기   
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/17.gif?raw=true" width=800>   
원하는 상품을 선택 후 삭제를 할 수 있습니다.
  
  #
---
  ※	프로그램 실행 순서	※ 
  
-> Controller\PCServer.java

-> com.PCorder\App.java


* 메이븐 프로젝트이므로 라이브러리 따로 Import 시킬 필요 없습니다.
### Q. 메이븐 라이브러리가 제대로 가져오지 못 할 경우

/사용자/.m2/repository 안에 모든 폴더를 삭제 (repository 폴더 자체를 삭제 X)

이클립스 실행 -> 프로젝트 우클릭 -> maven\Update Proj 클릭.
