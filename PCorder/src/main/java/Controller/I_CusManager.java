package Controller;

public interface I_CusManager {   //고객관리 페이지 기능 인터페이스 정의
   void MultiChat_CBX();
   //콤보박스에는 {"전체", "user1", "user2", "userN", ...}의 항목들이 들어가며
   //콤보박스의 항목을 "전체"로 두었을 때는 모든 클라이언트에게 'BroadCast'하도록 기능을 수행하고,
   //콤보박스 아이템을 "userX"로 두면 해당 클라이언트와 'talk'하는 기능을 수행한다.
   
}
