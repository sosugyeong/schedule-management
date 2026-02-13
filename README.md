# 🗓️ 일정 관리 앱 프로젝트
> ⚙️ **사용 기술: Java 17, Spring Boot 4.0.2, Spring Data JPA, MySQL, Git**
<br>

---
## 💻 프로젝트 소개
- 일정 생성, 조회, 수정, 삭제 구현
- 일정에 댓글 생성 구현
- 회원가입 / 로그인(인증) 구현
- 비밀번호 암호화
- Validation 예외처리

---
# ✨ ERD
<img width="943" height="783" alt="스크린샷 2026-02-13 024037" src="https://github.com/user-attachments/assets/f1aba586-54c1-4b9d-828d-ecd5c2fc4acc" />


---
# 🔗 POSTMAN API 명세서
> https://documenter.getpostman.com/view/26831144/2sBXc7MQco
<br>

---
# 🧾 API 명세서
> **공통 URL :** http://localhost:8080<br>
> **Content-Type:** application/json <br>

| 메소드      | Method | URL                              | request  | response | 상태코드       |
|:---------|:-------|:---------------------------------|:---------|:---------|:-----------|
| **일정 등록**    | POST   | /schedules                       | 요청 body  | 등록 정보    | 200: 정상등록  |
| **전체 일정 조회** | GET    | /schedules                       | 요청 param | 다건 응답 정보 | 200: 정상조회  |
| **일정 단건 조회** | GET    | /schedules/{scheduleId}          | 요청 param         | 단건 응답 정보 | 200: 정상조회  |
| **선택 일정 수정** | PUT    | /schedules/{scheduleId}          | 요청 body         | 수정 정보    | 200: 정상조회  |
| **선택 일정 삭제** | DELETE | /schedules/{scheduleId}          | 요청 param         | -        | 200: 정상 삭제 |
| **댓글 등록**    | POST   | /schedules/{scheduleId}/comments | 요청 body         | 등록 정보    | 200: 정상등록  |
| **회원가입**     | POST   | /signup                          | 요청 body         | 등록 정보    | 200: 정상등록  |
| **전체 유저 조회** | GET    | /users                           | 요청 param         | 다건 응답 정보 | 200: 정상조회  |
| **선택 유저 조회** | GET    | /users/myinfo                    | 요청 param         | 단건 응답 정보 | 200: 정상조회  |
| **선택 유저 수정** | PUT    | /users                           | 요청 body         | 수정 정보    | 200: 정상조회  |
| **선택 유저 삭제** | DELETE | /users                           | 요청 param         | -        | 200: 정상 삭제 |
| **로그인**      | POST   | /login                           | 요청 body         | 등록 정보    | 200: 정상등록  |
