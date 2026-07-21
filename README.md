# Todo List

인프런 부트캠프(Spring 과정) 개인 과제로 구현한 일정 관리 프로젝트입니다.

## API 명세서

### User API

### 1. 사용자 생성

#### Request
POST /users

#### Request Body
```json
{
    "name": "홍길동",
    "email": "hong@test.com",
    "password": "password123"
}
```

#### Response 200 OK
```json
{
    "id": 1,
    "name": "홍길동",
    "email": "hong@test.com",
    "createdAt": "2026-07-21T04:05:12.526616",
    "modifiedAt": "2026-07-21T04:05:12.526616"
}
```

### 2. 전체 사용자 조회

#### Request
GET /users

#### Response 200 OK
```json
[
    {
        "id": 1,
        "name": "홍길동",
        "email": "hong@test.com",
        "createdAt": "2026-07-21T04:05:12.526616",
        "modifiedAt": "2026-07-21T04:05:12.526616"
    }
]
```

### 3. 특정 사용자 조회

#### Request
GET /users/{userId}

#### Response 200 OK
```json
[
    {
        "id": 1,
        "name": "홍길동",
        "email": "hong@test.com",
        "createdAt": "2026-07-21T04:05:12.526616",
        "modifiedAt": "2026-07-21T04:05:12.526616"
    }
]
```

### 4. 사용자 수정

#### Request
PUT /users/{userId}

#### Request Body
```json
{
    "name": "홍길동수정",
    "email": "test2@gmail.com",
    "password": "23456789"
}
```

#### Response 200 OK
```json
{
    "id": 1,
    "name": "홍길동수정",
    "email": "test2@gmail.com",
    "createdAt": "2026-07-21T04:05:12.526616",
    "modifiedAt": "2026-07-21T04:05:12.526616"
}
```

### 5. 사용자 삭제

#### Request
DELETE /users/{userId}

#### Response 200 OK
```json
[
    {
        "id": 2,
        "name": "김철수",
        "email": "kcs@test.com",
        "createdAt": "2026-07-21T04:05:15.526616",
        "modifiedAt": "2026-07-21T04:05:15.526616"
    }
]
```


## ERD
![logo](./src/main/resources/static/image/logo.png)


