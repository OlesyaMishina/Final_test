#7. В подключенном MySQL репозитории создать базу данных “Друзья
#человека”
DROP DATABASE IF EXISTS friends_of_human;
CREATE DATABASE friends_of_human;
USE friends_of_human;

#8. Создать таблицы с иерархией из диаграммы в БД

DROP TABLE IF EXISTS cat;
CREATE TABLE cat(
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(40),
    command CHAR(40),
    birthday DATE
);

DROP TABLE IF EXISTS dog;
CREATE TABLE dog(
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(40),
    command CHAR(40),
    birthday DATE
);

DROP TABLE IF EXISTS hamster;
CREATE TABLE hamster(
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(40),
    command CHAR(40),
    birthday DATE
);

DROP TABLE IF EXISTS horse;
CREATE TABLE horse(
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(40),
    command CHAR(40),
    birthday DATE
);

DROP TABLE IF EXISTS donkey;
CREATE TABLE donkey(
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(40),
    command CHAR(40),
    birthday DATE
);

DROP TABLE IF EXISTS camel;
CREATE TABLE camel(
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(40),
    command CHAR(40),
    birthday DATE
);

#9. Заполнить низкоуровневые таблицы именами(животных), командами?, которые они выполняют и датами рождения
INSERT cat (animal_name, command, birthday) 
VALUES 
	('Murzik', 'play', '2021-02-02'),
	('Murka', 'play', '2019-12-10'),
    ('Pushok', 'play', '2023-01-04'),
    ('Mashka', 'play', '2022-03-03');
    
INSERT dog (animal_name, command, birthday) 
VALUES 
	('John', 'sit', '2021-02-02'),
	('Dog', 'sit', '2019-12-10'),
    ('Chester', 'sit', '2023-01-04'),
    ('Zhuchka', 'sit', '2022-03-03');
    
INSERT hamster (animal_name, command, birthday) 
VALUES 
	('Pasha', 'sleep', '2021-02-02'),
	('Masha', 'sleep', '2019-12-10'),
    ('Sasha', 'sleep', '2023-01-04'),
    ('Glasha', 'sleep', '2022-03-03');

INSERT horse (animal_name,command, birthday) 
VALUES 
	('Glafira', 'gallop', '2021-02-02'),
	('Snow', 'gallop', '2019-12-10'),
    ('Rain', 'gallop', '2023-01-04'),
    ('Sun', 'gallop', '2022-03-03');
    
INSERT donkey (animal_name,command, birthday) 
VALUES 
	('Vasya', 'sit', '2021-02-02'),
	('Petra', 'sit', '2019-12-10'),
    ('Pretty', 'sit', '2023-01-04'),
    ('Apple', 'sit', '2022-03-03');
    
INSERT camel (animal_name,command, birthday) 
VALUES 
	('Desert', 'sit', '2021-02-02'),
	('Sand', 'sit', '2019-12-10'),
    ('Zhuzhu', 'sit', '2023-01-04'),
    ('Spiter', 'sit', '2022-03-03');
    
#10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
#питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.    

DROP TABLE camel;
CREATE TABLE baggage_animal (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
SELECT  animal_name, 
        Command, 
        Birthday
FROM horse UNION 
SELECT  animal_name, 
        Command, 
        Birthday
FROM donkey;

SELECT * FROM baggage_animal;

#11.Создать новую таблицу “молодые животные” в которую попадут все
#животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
#до месяца подсчитать возраст животных в новой таблице

CREATE TABLE youngAnimals (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
SELECT  animal_name, 
        Command, 
        Birthday,
        Round((year(current_date()) - year(Birthday)) + (month(current_date() - month(Birthday)))/10, 1) AS age
FROM baggage_animal
WHERE   Round((year(current_date()) - year(Birthday)) + (month(current_date() - month(Birthday)))/10, 1) BETWEEN 1 AND 3
UNION ALL 
SELECT  animal_name, 
        Command, 
        Birthday,
        Round((year(current_date()) - year(Birthday)) + (month(current_date() - month(Birthday)))/10, 1) AS age
FROM cat
WHERE   Round((year(current_date()) - year(Birthday)) + (month(current_date() - month(Birthday)))/10, 1) BETWEEN 1 AND 3
UNION ALL
SELECT  animal_name, 
        Command, 
        Birthday,
        Round((year(current_date()) - year(Birthday)) + (month(current_date() - month(Birthday)))/10, 1) AS age
FROM dog
WHERE   Round((year(current_date()) - year(Birthday)) + (month(current_date() - month(Birthday)))/10, 1) BETWEEN 1 AND 3
UNION ALL
SELECT  animal_name, 
        Command, 
        Birthday,
        Round((year(current_date()) - year(Birthday)) + (month(current_date() - month(Birthday)))/10, 1) AS age
FROM hamster
WHERE   Round((year(current_date()) - year(Birthday)) + (month(current_date() - month(Birthday)))/10, 1) BETWEEN 1 AND 3;

SELECT * FROM youngAnimals;

#12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
#прошлую принадлежность к старым таблицам.

DROP TABLE IF EXISTS animals;
CREATE TABLE animals (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
SELECT  animal_name, 
        command,
        birthday,
        'cat' AS animal
FROM cat 
UNION 
SELECT  animal_name, 
        command,
        birthday,
        'dog' AS animal
FROM dog
UNION 
SELECT  animal_name, 
        command,
        birthday,
        'hamster' AS animal
FROM hamster
UNION 
SELECT  animal_name, 
        command,
        birthday,
        'baggage_animal' AS animal
FROM baggage_animal;

SELECT * FROM animals; 

