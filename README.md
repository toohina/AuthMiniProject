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
#### Summary
For Spring Security with session-based authentication, you store users in your database and expose a findByUsername() method in your UserRepository. When a login request comes, Spring Security calls your custom UserDetailsService, which loads the user from the database and wraps it in a UserDetails implementation (e.g., CustomUserDetails). Spring Security then verifies the password (usually BCrypt), and if valid, it creates an Authentication object and stores it in the server-side session. The server sends a JSESSIONID cookie to the browser, and on every subsequent request the browser automatically includes this cookie. Spring Security uses the session data referenced by that cookie to identify the authenticated user. You can retrieve the username anytime using Authentication authentication.getName().

#### Bugs We Handled

###### Bug 1: Thymeleaf th:if syntax error

Issue: th:if=@{username} caused template parsing error

Fix: Wrap value in quotes → th:if="@{username}"

###### Bug 2: Login required twice

Issue: First login redirected back to login page, needing second login

Root cause: /login was not excluded from security filters

Fix: Added .requestMatchers("/login").permitAll() in SecurityConfig


## Authors

- [@toohina](https://www.github.com/toohina)
