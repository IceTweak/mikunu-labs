<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lab 2</title>
    <meta http-equiv="Cache-Control" content="no-cache" />
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<body>
<div class="wrap" id="wrap">
    <h1>Лаб. работа №3</h1>
    <div class="container">
        <p id="formHeader">Заполните форму <br>для добавления запси</p>
        <form>
            <div class="input-div">
                <label for="bookName">Производитель</label>
                <input type="text" id="bookName" class="input" name="manufacturer" autofocus required placeholder="Asus">
            </div>

            <div class="input-div">
                <label for="author">Модель</label>
                <input type="text" id="author" class="input" name="model" required placeholder="VivoBook 14">
            </div>

            <div class="input-div">
                <label for="pages">Цена (руб.)</label>
                <input type="number" step="1" value="40000" id="pages" class="input" name="price" required>
            </div>

            <div class="input-div">
                <label for="date">Дата выпуска</label>
                <input type="date" id="date" class="input" name="releaseDate" required>
            </div>

            <div class="input-div">
                <label for="publisher">Процессор</label>
                <input type="text" id="publisher" class="input" name="processor" required placeholder="Intel Core i7-8700k">
            </div>


            <button id="submit" type="submit">Отправить</button>
        </form>

    </div>
    <div class="btn-container">
        <button id="getData">Загрузить записи</button>
    </div>
</div>
<script src="js/index.js" type="text/javascript"></script>
</body>
</html>
