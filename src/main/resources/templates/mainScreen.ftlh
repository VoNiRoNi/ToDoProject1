<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>ToDoProject</title>
</head>
<body>
<h1>ToDo</h1>

<p>Аккаунт: user.login</p>
<h4>Все задачи:</h4>
<#list tasks as task>
<div>
    ${task.title}<br>
    ${task.description}<br>
    ${task.status}<br>
</div>
    #elif tasks
</#list>

<h3>Добавить задачу</h3>
<form action="/addTask" method="post">
    Название: <input type="text" name="title"><br>
    Описание: <input type="text" name="description"><br>
    комментарий: <input type="text" name="comment"><br>
    Статус: <input type="text" name="status" value="new"><br>
    <input type="submit" value="Добавить">
</form>
</body>
</html>