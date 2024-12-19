<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Branch</title>
</head>
<body>
<h1>${message}</h1>
<form action="game" method="post">
    <button type="submit" name="action" value="enter">Войти</button>
    <button type="submit" name="action" value="run">Убежать</button>
</form>
</body>
</html>
