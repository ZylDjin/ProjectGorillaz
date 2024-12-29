<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Главная страница</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <div class="quest-block">
        <h2>Приключения Ведьмака</h2>
        <img src="${pageContext.request.contextPath}/img/GameOne/preview.png" alt="Приключения Ведьмака">
        <form action="${pageContext.request.contextPath}/game" method="POST">
            <input type="hidden" name="questId" value="1">
            <input type="hidden" name="stageId" value="0">
            <button type="submit">Начать квест</button>
        </form>
    </div>
</div>
</body>
</html>