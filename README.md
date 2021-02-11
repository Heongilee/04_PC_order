# PC방 음식 주문 및 채팅 서비스
> 04조_객체지향설계기술 팀 프로젝트   
![imgs](https://img.shields.io/badge/Language-Java-orange) ![imgs](https://img.shields.io/badge/Database-MySQL-blue) ![imgs](https://img.shields.io/badge/Build%20Tool-Apache%20Maven-red)
---
## 프로젝트 개요 :scroll:
   
```
모의 PC방 음식 주문 및 채팅 서비스 입니다. 

Java의 Swing 라이브러리를 활용해 클라이언트 개발, MySQL DB를 사용해 음식, 고객, 주문 테이블의 CRUD 연산과 비즈니스 로직 처리,
스레드로 사용자를 관리함에 따른 다수 사용자 지원, 그리고 Server socket을 사용해 스레드간의 채팅 서비스를 구현했습니다.
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
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85_%EC%A4%91%EB%B3%B5%EA%B2%80%EC%82%AC.png?raw=true" width=800><img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85_%EC%A4%91%EB%B3%B5%EA%B2%80%EC%82%AC_%EB%8B%A4%EC%9D%B4%EC%96%BC%EB%A1%9C%EA%B7%B8%EB%A9%94%EC%8B%9C%EC%A7%80.png?raw=true" width=800>
   
``` 
우리 서비스의 사용자로 등록하기 위한 절차인 회원가입 화면입니다.
```
[:arrow_forward:시연영상 보기](https://github.com/Heongilee/04_PC_order#%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85-1 "회원가입")
   
### 로그인 관련 예외처리
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/%EB%A1%9C%EA%B7%B8%EC%9D%B8RadioButton.png?raw=true" width=800><img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/%EB%A1%9C%EA%B7%B8%EC%9D%B8_%EB%8B%A4%EC%9D%B4%EC%96%BC%EB%A1%9C%EA%B7%B8.png?raw=true" width=800>
   
``` 
로그인 화면에서 사용자 모드와 관리자 모드로 나누어 로그인할 수 있으며 정상적인 로그인 시도가 아닐경우
예외 처리를 진행했습니다.
```
[:arrow_forward:시연영상 보기](https://github.com/Heongilee/04_PC_order#%EC%98%88%EC%99%B8%EC%B2%98%EB%A6%AC "로그인")
   
### 사용자 메인화면
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/%EC%82%AC%EC%9A%A9%EC%9E%90_%EB%A9%94%EC%9D%B8%ED%99%94%EB%A9%B4.png?raw=true" width=800><img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/%ED%8F%AC%EC%9D%B8%ED%8A%B8%EA%B2%B0%EC%A0%9C.png?raw=true" width=800><img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/User2Admin.png?raw=true" width=800>
   
``` 
사용자로 로그인했을때 맨 처음 보이는 화면입니다. 
여기선 포인트로 음식 주문과 관리자와의 채팅을 이용할 수 있습니다.
```
[:arrow_forward:시연영상 보기](https://github.com/Heongilee/04_PC_order#%EC%83%81%ED%92%88-%EA%B5%AC%EB%A7%A4 "사용자화면")
   
### 관리자 메인화면
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/%EA%B4%80%EB%A6%AC%EC%9E%90%ED%99%94%EB%A9%B4.png?raw=true" width=800><img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/Admin2User(Talk).png?raw=true" width=800><img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/Admin2User(Broadcast).png?raw=true" width=800>
   
``` 
관리자로 로그인하면 고객관리와 상품관리 두 가지 기능을 수행할 수 있습니다. 
여기선 현재 고객이 주문한 음식목록과 사용자와의 채팅이 이루어집니다.
```
[:arrow_forward:시연영상 보기](https://github.com/Heongilee/04_PC_order#%EC%82%AC%EC%9A%A9%EC%9E%90%EA%B0%80-%EA%B4%80%EB%A6%AC%EC%9E%90%EC%97%90%EA%B2%8C-%EB%A9%94%EC%8B%9C%EC%A7%80%EB%A5%BC-%EB%B3%B4%EB%83%84talk-%EA%B8%B0%EB%8A%A5 "관리자화면")
   
### 관리자 화면 > 고객 관리
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/%EA%B4%80%EB%A6%AC%EC%9E%90%ED%99%94%EB%A9%B4.png?raw=true" width=800><img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/Admin2User(Talk).png?raw=true" width=800><img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/Admin2User(Broadcast).png?raw=true" width=800>
   
``` 
관리자로 로그인하면 고객관리와 상품관리 두 가지 기능을 수행할 수 있습니다.   
여기선 현재 고객이 주문한 음식목록과 사용자와의 채팅이 이루어집니다.
```
[:arrow_forward:시연영상 보기](https://github.com/Heongilee/04_PC_order#%EA%B4%80%EB%A6%AC%EC%9E%90%EA%B0%80-%EC%82%AC%EC%9A%A9%EC%9E%90%EC%97%90%EA%B2%8C-%EB%A9%94%EC%8B%9C%EC%A7%80%EB%A5%BC-%EB%B3%B4%EB%83%84broadcast-%EA%B8%B0%EB%8A%A5 "관리자_고객관리")
   
### 관리자 화면 > 상품 관리
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/%EC%83%81%ED%92%88%EA%B4%80%EB%A6%AC%ED%8E%98%EC%9D%B4%EC%A7%80.png?raw=true" width=800><img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/%EC%83%81%ED%92%88%EA%B4%80%EB%A6%AC%ED%8E%98%EC%9D%B4%EC%A7%80(Create).png?raw=true" width=800>
   
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/%EC%83%81%ED%92%88%EA%B4%80%EB%A6%AC%ED%8E%98%EC%9D%B4%EC%A7%80(Read_all).png?raw=true" width=400 height=400> <img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/%EC%83%81%ED%92%88%EA%B4%80%EB%A6%AC%ED%8E%98%EC%9D%B4%EC%A7%80(Specific_Read).png?raw=true" width=400 height=400>
   
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/%EC%83%81%ED%92%88%EA%B4%80%EB%A6%AC%ED%8E%98%EC%9D%B4%EC%A7%80(Update).png?raw=true" width=800>
   
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/%EC%83%81%ED%92%88%EA%B4%80%EB%A6%AC%ED%8E%98%EC%9D%B4%EC%A7%80(Delete).png?raw=true" width=800>
   
``` 
관리자로 로그인하면 고객관리와 상품관리 두 가지 기능을 수행할 수 있습니다.   
여기선 우리 서비스에서 판매하는 상품들의 재고를 관리할 수 있습니다.
```
[:arrow_forward:시연영상 보기](https://github.com/Heongilee/04_PC_order#%EC%9E%AC%EA%B3%A0-%EA%B4%80%EB%A6%AC "관리자_상품관리")
   
## 시연 :computer:
### 회원가입   
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/01.gif?raw=true" width=400> <img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/02.gif?raw=true" width=400>   
   
```
회원가입을 하기 위해 모든 필드를 채워야 하며, 아이디, 닉네임, 이메일 주소 중복체크를 마쳐야 사용자로 등록할 수 있습니다.
```

### 예외처리
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/03.gif?raw=true" width=266> <img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/04.gif?raw=true" width=266> <img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/05.gif?raw=true" width=266>
   
```
사용자가 관리자 모드(Server mode)에 접근하려는 경우, 사용자가 존재하지 않는 아이디로 로그인 시도할 경우, 사용자가 비밀번호를 잘못 입력한 경우, 모두 에러메시지를 출력합니다.
```

### 중복 로그인 예외 처리
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/06.gif?raw=true" width=800>   
   
```
이미 로그인중인 계정을 다른 클라이언트가 로그인을 시도할 경우 로그인이 막히도록 구현했습니다.   
```
   
### 상품 구매
* 포인트 부족
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/07.gif?raw=true" width=800>   
   
```
포인트가 부족하면 상품을 구매할 수 없습니다.   
```
  
  #
* 상품 결제시 관리자 컴퓨터에 반영   
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/09.gif?raw=true" width=800>   
   
```
상품을 결제하면 관리자 컴퓨터에는 사용자가 로그인한 좌석에 주문한 상품이 표시됩니다.   
```
   
### 사용자가 관리자에게 메시지를 보냄(Talk 기능)
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/10.gif?raw=true" width=800>   
   
```
사용자가 보낸 메시지는 관리자에게만 보여집니다.
```
   
### 관리자가 사용자에게 메시지를 보냄(Broadcast 기능)
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/11.gif?raw=true" width=800>   
   
```
관리자가 보낸 메시지는 모든 사용자들에게 보여집니다.
```
   
### 관리자가 특정 사용자에게 메시지를 보냄(Talk 기능)
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/12.gif?raw=true" width=800>   
   
```
관리자는 특정 사용자만 볼 수 있는 메시지를 전송할 수 있습니다.
```
   
### 사용자가 로그아웃하면 관리자 컴퓨터에 반영
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/18.gif?raw=true" width=800>   
   
```
사용자가 로그아웃하면 좌석은 빈자리로 초기화되며, 관리자 측에 해당 사용자가 접속을 종료했다는 알림메시지가 출력됩니다.
```
   
### 재고 관리
* (Create) 상품 생성하기   
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/14.gif?raw=true" width=800>   
   
```
상품명, 단가, 제조사, 카테고리를 선택하면 원하는 품목을 추가시킬 수 있습니다.
```
  
  #
* (Read) 상품 불러오기   
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/13.gif?raw=true" width=400> <img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/15.gif?raw=true" width=400>   
   
```
전체 상품을 조회하거나 특정 상품만 콤보박스에서 선택해 조회할 수 있습니다.
```
  
  #
* (Update) 상품 수정하기   
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/16.gif?raw=true" width=800>   
   
```
상품 조회 후 수정하고자 하는 필드를 수정하면 상품 정보가 수정됩니다.
```
  
  #
* (Delete) 상품 삭제하기   
<img src="https://github.com/Heongilee/04_PC_order/blob/master/README%20assets/17.gif?raw=true" width=800>   
   
```
원하는 상품을 선택 후 삭제를 할 수 있습니다.
```
  
  #
---
  ※	프로그램 실행 순서	※ 
  
-> Controller\PCServer.java

-> com.PCorder\App.java


* 메이븐 프로젝트이므로 라이브러리 따로 Import 시킬 필요 없습니다.
### Q. 메이븐 라이브러리가 제대로 가져오지 못 할 경우

/사용자/.m2/repository 안에 모든 폴더를 삭제 (repository 폴더 자체를 삭제 X)

이클립스 실행 -> 프로젝트 우클릭 -> maven\Update Proj 클릭.
