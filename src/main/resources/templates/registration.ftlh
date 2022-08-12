<!Doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>
<div>
    <form method="POST" action="/registration">
        <h2>Регистрация</h2>
        <div>
            <input type="text" name="username" placeholder="Username"></input>
        </div>

        <div>
            <input type="text" name="email" placeholder="Email"></input>
        </div>

        <div>
            <input type="password" name="password" placeholder="Password"></input>
        </div>
        <div>
            <input type="password" name="passwordConfirm"
                   placeholder="Confirm your password"></input>
        </div>
        <button type="submit">Зарегистрироваться</button>
    </form>
    <a href="/">Главная</a>
</div>
</body>
</html>