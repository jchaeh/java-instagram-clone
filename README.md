# Java Instagram Clone (J-StarGram)

Java와 Eclipse를 사용해 제작한 Instagram 클론 SNS 팀 프로젝트입니다.  
클라이언트/서버를 분리하여 소켓 기반 통신으로 기능을 구현했습니다.  
(프로젝트 구조: `JStarGram_Client`, `JStarGram_Server`, `JStarGram_Comon/dto`)  

---

##  Main Features
- 회원가입 / 로그인
- 게시물(피드) 기능 (업로드/조회 등)
- 온라인 채팅 (1:1 / 그룹 채팅)
- 실시간 접속자 확인
  - 온라인 상태 표시
  - “몇 분 전 접속” 표시(Last Seen)
- 위치 확인 기능
  - 지도 데이터를 불러와 위치 표시

---

##  Project Structure
java-instagram-clone  
├── JStarGram_Client # 클라이언트(화면/UI + 기능 호출)  
├── JStarGram_Server # 서버(요청 처리/데이터 관리)  
└── JStarGram_Comon/dto # 공통 DTO(클라-서버 통신 데이터 포맷)  

---

## Tech Stack / Environment
- Java
- Eclipse IDE
- (통신) Socket 기반 네트워크

---

##  How to Run
1. 이 레포를 클론한 뒤 Eclipse에서 프로젝트 Import
2. **Server 먼저 실행**
   - `JStarGram_Server > src > main > ServerMain.java` 실행
3. **Client 실행**
   - `JStarGram_Client > src > main > ClientMain.java` 실행
4. 로그인 후 채팅 / 실시간 접속자 / 위치 기능 테스트 가능


---

##  My Role
- Client 파트 담당
- UI 구현
- 온라인 채팅(그룹 채팅 포함) 기능 구현
- 실시간 접속자 확인(온라인/몇 분 전 접속) + 위치 확인(지도) 기능 구현  
- 해당 기능들은 별도 클래스로 분리하여 관리

---

##  Notes
- DTO(전송 데이터 구조)는 클라이언트/서버가 동일하게 공유해야 하므로
  `JStarGram_Comon/dto`에서 함께 관리합니다.
- 불필요한 산출물(bin, .settings 등)은 업로드에서 제외했습니다.

---

##  Screenshots (Optional)
- 로그인 화면
- 피드 화면
- 채팅(그룹 채팅) 화면
- 실시간 접속자 화면
- 지도/위치 화면
