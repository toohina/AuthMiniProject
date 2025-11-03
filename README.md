# MiniAuthProject

It is a practice project that helps you understand the basics of Spring Security using sessions and cookies.



## Acknowledgements

 - https://claude.ai/
 - https://chatgpt.com/


## API Reference

#### Register New User

```http
  GET /register
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `N/A` | `N/A` | **Required**. Create username and password |

#### Login as Existing User

```http
  GET /login
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `N/A`      | `N/A`  | **Required**. Enter valid username and password and submit to get redirected to your home |

#### When you enter invalid password or username
```http
  GET /login?error
```
#### When you register successfully you are redirected to 
```http
  GET /login?registered
```
#### Home page is Authenticated 
```http
  GET /home
```
#### When you logout successfully from home
```http
  GET /login?logout
```


## Authors

- [@toohina](https://www.github.com/toohina)
