# Library REST API

## Tech Stack

1. Kotlin Language
2. Spring Framework
3. MongoDB

## Deploy Heroku

```
Deploy : 
Using GitHub Action

Log    :
heroku logs --tail -a rest-api-library-kotlin-spring

Note   : 
rest-api-library-kotlin-spring is app name heroku
```

## Base url

```
https://rest-api-library-kotlin-spring.herokuapp.com/
```

## Table Endpoints

### Authentication

| Name     | Endpoint           | Method | Bearer token | Body and response           |
|----------|--------------------|--------|--------------|-----------------------------|
| Login    | `v1/auth/login`    | `GET`  | no           | [example](#login---get)     |
| Register | `v1/auth/register` | `POST` | no           | [example](#register---post) |

### Login - GET

```
GET v1/auth/login
```

Body

```json
{
  "email": "wawan@gmail.com",
  "password": "123456"
}
```

Response Success

```json
{
  "message": "Login Success",
  "status": true,
  "data": {
    "id": "958e8244-a287-4312-bbb7-aea8ab079677",
    "name": "Wawan",
    "email": "wawan@gmail.com",
    "password": "123456"
  }
}
```

Response Failed

```json
{
  "message": "Login Failed - Incorrect Email or Password",
  "status": false,
  "data": null
}
```

### Register - POST

```
GET v1/auth/register
```

Body

```json
{
  "name": "Irwan",
  "email": "rwn@gmail.com",
  "password": "123456"
}
```

Response

```json
{
  "message": "Register Success",
  "status": true,
  "data": {
    "id": "7b6044aa-5ec8-4ded-a9c9-141eaa5040f1",
    "name": "Irwan",
    "email": "rwn@gmail.com",
    "password": "123456"
  }
}
```

### Book

| Name                 | Endpoint                  | Method   | Bearer token | Body and response                  |
|----------------------|---------------------------|----------|--------------|------------------------------------|
| Get Books            | `v1/book`                 | `GET`    | no           | [example](#books---get)            |
| Get Books By Id      | `v1/book/id?{id}`         | `GET`    | no           | [example](#books-by-id---get)      |
| Get Books By User Id | `v1/book/userId?{userId}` | `GET`    | no           | [example](#books-by-user-id---get) |
| Add Book             | `v1/book`                 | `POST`   | no           | [example](#add-book---post)        |
| Update Book          | `v1/book/{id}`            | `PUT`    | no           | [example](#update-book---put)      |
| Delete Book          | `v1/book/{id}`            | `DELETE` | no           | [example](#register---post)        |

### Books - GET

```
GET v1/book
```

Body

```
none
```

Response

```json
{
  "message": "Success Retrieve Data",
  "status": true,
  "data": [
    {
      "id": "c097b04f-925d-4572-92f2-23c21268b1c3",
      "title": "Menjadi Anak Sholeh",
      "author": "Your Parents",
      "userId": "958e8244-a287-4312-bbb7-aea8ab079677"
    },
    {
      "id": "f25ebe1a-4147-4ab3-bf61-0fa7abeb3258",
      "title": "Menjadi Anak Pintar",
      "author": "Your Teacher",
      "userId": "958e8244-a287-4312-bbb7-aea8ab079677"
    }
  ]
}
```

### Books By Id - GET

```
GET v1/book/id?{id}
```

Body

```
none
```

Params

```
Query id
```

Response

```json
{
  "message": "Success Retrieve Data",
  "status": true,
  "data": {
    "id": "c097b04f-925d-4572-92f2-23c21268b1c3",
    "title": "Menjadi Anak Sholeh",
    "author": "Your Parents",
    "userId": "958e8244-a287-4312-bbb7-aea8ab079677"
  }
}
```

### Books By User Id - GET

```
GET v1/book/userId?{userId}
```

Body

```
none
```

Params

```
Query userId
```

Response

```json
{
  "message": "Success Retrieve Data",
  "status": true,
  "data": [
    {
      "id": "303011b7-0dc3-4941-97e6-c4a5c8815dae",
      "title": "Bumi",
      "author": "Tere Liye",
      "userId": "7b6044aa-5ec8-4ded-a9c9-141eaa5040f1"
    }
  ]
}
```

### Add Book - POST

```
POST v1/book
```

Body

```json
{
  "title": "Amburadul",
  "author": "Unknown",
  "userId": "7b6044aa-5ec8-4ded-a9c9-141eaa5040f1"
}
```

Response

```json
{
  "message": "Success Add Data Book",
  "status": true,
  "data": [
    {
      "id": "998289b1-cb35-48dd-895e-4beecd5e03e9",
      "title": "Amburadul",
      "author": "Unknown",
      "userId": "7b6044aa-5ec8-4ded-a9c9-141eaa5040f1"
    }
  ]
}
```

### Update Book - PUT

```
PUT v1/book/{id}
```

Body

```json
{
  "title": "Buku Pintar",
  "author": "Anton",
  "userId": "7b6044aa-5ec8-4ded-a9c9-141eaa5040f1"
}
```

Params

```
Path id
```

Response

```json
{
  "message": "Success Update Data Book",
  "status": true,
  "data": {
    "id": "303011b7-0dc3-4941-97e6-c4a5c8815dae",
    "title": "Buku Pintar",
    "author": "Anton",
    "userId": "7b6044aa-5ec8-4ded-a9c9-141eaa5040f1"
  }
}
```

### Delete Book - DELETE

```
DELETE v1/book/{id}
```

Body

```
none
```

Params

```
Path id
```

Response

```json
{
  "message": "Success Delete Data Book",
  "status": true,
  "data": null
}
```