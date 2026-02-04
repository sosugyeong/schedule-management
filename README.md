# 🗓️ 일정 관리 앱 만들기
> ⚙️ Java 17, Spring Boot 4.0.2, Spring Data JPA, MySQL, Git 사용
<br>

---
# 🧾 API 명세서
> **공통 URL : http://localhost:8080**

## 일정 생성 (POST)
- **URL:** /schedules
### Request
```json
{
    "title": "제목",
    "content" : "내용",
    "userName" : "이름",
    "password" : "pass1"
}
```
### Response (200 Created)
```json
{
    "title": "제목",
    "content": "내용",
    "userName": "이름",
    "createdAt": "2026-02-05T03:16:45.2658476",
    "modifiedAt": "2026-02-05T03:16:45.2658476"
}
```

## 전체 일정 조회 (GET)
- **URL:** /schedules/search/이름
### Response
```json
[
    {
        "id": 2,
        "title": "제목2",
        "content": "내용2",
        "userName": "이름",
        "createdAt": "2026-02-05T03:19:02.105436",
        "modifiedAt": "2026-02-05T03:19:02.105436"
    },
    {
        "id": 1,
        "title": "제목",
        "content": "내용",
        "userName": "이름",
        "createdAt": "2026-02-05T03:16:45.265848",
        "modifiedAt": "2026-02-05T03:16:45.265848"
    }
]
```

## 선택 일정 조회 (GET)
- **URL:** /schedules/1
### Response (200 OK)
```json
{
    "id": 1,
    "title": "수정한 제목",
    "content": "내용",
    "userName": "수정한 이름",
    "createdAt": "2026-02-05T03:16:45.265848",
    "modifiedAt": "2026-02-05T03:20:04.554564",
    "getCommentList": [
        {
            "id": 1,
            "comment": "댓글 내용",
            "userName": "이름",
            "createdAt": "2026-02-05T03:22:06.319406",
            "modifiedAt": "2026-02-05T03:22:06.319406"
        },
        {
            "id": 2,
            "comment": "댓글 내용2",
            "userName": "이름",
            "createdAt": "2026-02-05T03:22:20.016526",
            "modifiedAt": "2026-02-05T03:22:20.016526"
        }
    ]
}
```


## 일정 수정 (PUT)
- **URL:** /schedules/1
### Request
```json
{
    "title": "수정한 제목",
    "userName" : "수정한 이름",
    "password" : "pass1"
}
```
### Response (200 OK)
```json
{
    "id": 1,
    "title": "수정한 제목",
    "content": "내용",
    "userName": "수정한 이름",
    "modifiedAt": "2026-02-05T03:16:45.265848"
}
```

## 일정 삭제 (DELETE)
- **URL:** /schedules/2
### Request
```json
{
    "password" : "pass1"
}
```
### Response (204 No Content)
## 댓글 생성 (POST)
- **URL:** /schedules/1/comments
### Request
```json
{
    "comment" : "댓글 내용",
    "userName" : "이름",
    "password" : "pass1"
}
```
### Response
```json
{
    "comment": "댓글 내용",
    "userName": "이름",
    "createdAt": "2026-02-05T03:22:20.0165263",
    "modifiedAt": "2026-02-05T03:22:20.0165263"
}
```

---
# 🔗 POSTMAN API 명세서
> https://documenter.getpostman.com/view/26831144/2sBXc7MQco
<br>

---

# ERD
> 일정 관리하는 프로젝트
<img width="622" height="464" alt="스크린샷 2026-02-04 232658" src="https://github.com/user-attachments/assets/bd02c9ea-4f76-419d-8cc8-85484ce226be" />
