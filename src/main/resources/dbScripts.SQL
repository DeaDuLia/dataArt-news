DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS ARTICLE_AND_RUBRIC;
DROP TABLE IF EXISTS ARTICLE;
DROP TABLE IF EXISTS RUBRIC;

create table USER (
    USER_ID LONG SERIAL PRIMARY KEY,
    FIRST_NAME VARCHAR(255) NOT NULL,
    LAST_NAME VARCHAR(255) NOT NULL,
    LOGIN VARCHAR(255) NOT NULL,
    PASS VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255),
    ROLE VARCHAR(20) NOT NULL DEFAULT 'USER',
    STATUS VARCHAR(20) DEFAULT 'ACTIVE'
);

create table ARTICLE (
    ARTICLE_ID LONG SERIAL PRIMARY KEY,
    JOURNALIST_ID LONG,
    HEADER VARCHAR(255),
    BODY TEXT,
    PUBLICATION_DATE DATE
);

create table RUBRIC (
    RUBRIC_NAME VARCHAR(20) PRIMARY KEY
);

CREATE TABLE ARTICLE_AND_RUBRIC (
    ARTICLE_ID LONG NOT NULL,
    RUBRIC_NAME VARCHAR(20) NOT NULL
);

insert into USER (FIRST_NAME, LAST_NAME, LOGIN, PASS, EMAIL)
VALUES ( 'Artem', 'Titov', 'titov_ar', '$2a$12$YOxrNcf8JINS/3HZHcJbYuWav2JoNCDGWmAAOc16o8vy4bMbsx55y', 'artitov@mail.ru');
insert into USER (FIRST_NAME, LAST_NAME, LOGIN, PASS, EMAIL, ROLE)
VALUES ( 'Yaroslav', 'Petrov', 'petrov_ya', '$2a$12$CzlElnl45JANYalYngm1LeFikvRzP4jhjym4QG2ZVjEXEwMM5dN3S', 'yapetrov@mail.ru', 'ADMIN');

insert into ARTICLE (JOURNALIST_ID, HEADER, BODY, PUBLICATION_DATE)
    values (1, 'Сенсация!', 'Это самая первая загруженная статья', SYSDATE);
insert into ARTICLE (JOURNALIST_ID, HEADER, BODY, PUBLICATION_DATE)
values (2, 'Сенсация 2!', 'Это вторая загруженная статья', SYSDATE);
insert into ARTICLE (JOURNALIST_ID, HEADER, BODY, PUBLICATION_DATE)
values (2, 'Сенсация 3!', 'Третья загруженная статья нашего портала!',  SYSDATE);
insert into ARTICLE (JOURNALIST_ID, HEADER, BODY, PUBLICATION_DATE)
values (2, 'Такого вы ещё не видели!', 'Четвёртая загруженная статья нашего портала!',  SYSDATE);
insert into ARTICLE (JOURNALIST_ID, HEADER, BODY, PUBLICATION_DATE)
values (2, 'Сенсация 5!', 'Пятая загруженная статья нашего портала!',  SYSDATE);
insert into ARTICLE (JOURNALIST_ID, HEADER, BODY, PUBLICATION_DATE)
values (2, 'Сенсация!', 'Шестая загруженная статья нашего портала!',  SYSDATE);

insert into ARTICLE (JOURNALIST_ID, HEADER, BODY, PUBLICATION_DATE)
values (1, 'О главном', 'А вы знали, что на нашем портале только самые актуальные новости? ',  SYSDATE);
insert into ARTICLE (JOURNALIST_ID, HEADER, BODY, PUBLICATION_DATE)
values (1, 'О главном 2', 'Здесь была важная информаця, но программист устал',  SYSDATE);
insert into ARTICLE (JOURNALIST_ID, HEADER, BODY, PUBLICATION_DATE)
values (1, 'Дедлайны!', 'Третья загруженная статья нашего портала!',  SYSDATE);
insert into ARTICLE (JOURNALIST_ID, HEADER, BODY, PUBLICATION_DATE)
values (1, 'НЕВЕРОЯТНО!', 'Trainee Программист на Java смог не спать неделю, при этом не чувствую никакого дискомыфвфыро12 ыфв',  SYSDATE);
insert into ARTICLE (JOURNALIST_ID, HEADER, BODY, PUBLICATION_DATE)
values (1, 'Новые рекорды!', 'Trainee Программист на Java смог проспать нельсколько дней! Это определённо новый рекорд!',  SYSDATE);
insert into ARTICLE (JOURNALIST_ID, HEADER, BODY, PUBLICATION_DATE)
values (1, 'Актуальное', 'Данная запись загружалась последней на момент инициализации!',  SYSDATE);


insert into RUBRIC (RUBRIC_NAME) values ('Политика');
insert into RUBRIC (RUBRIC_NAME) values ('Местное');
insert into RUBRIC (RUBRIC_NAME) values ('Спорт');
insert intO RUBRIC (RUBRIC_NAME) VALUES ('Финансы');
insert intO RUBRIC (RUBRIC_NAME) VALUES ('Путешествие');
insert intO RUBRIC (RUBRIC_NAME) VALUES ('Здоровье');

select * from ARTICLE;

insert into ARTICLE_AND_RUBRIC (ARTICLE_ID, RUBRIC_NAME) VALUES (1, 'Политика' );
insert into ARTICLE_AND_RUBRIC (ARTICLE_ID, RUBRIC_NAME) VALUES (2, 'Местное' );
insert into ARTICLE_AND_RUBRIC (ARTICLE_ID, RUBRIC_NAME) VALUES (3, 'Местное' );
insert into ARTICLE_AND_RUBRIC (ARTICLE_ID, RUBRIC_NAME) VALUES (3, 'Спорт' );
insert into ARTICLE_AND_RUBRIC (ARTICLE_ID, RUBRIC_NAME) VALUES (7, 'Спорт' );
insert into ARTICLE_AND_RUBRIC (ARTICLE_ID, RUBRIC_NAME) VALUES (8, 'Путешествие' );
insert into ARTICLE_AND_RUBRIC (ARTICLE_ID, RUBRIC_NAME) VALUES (9, 'Политика' );
insert into ARTICLE_AND_RUBRIC (ARTICLE_ID, RUBRIC_NAME) VALUES (10, 'Здоровье' );
insert into ARTICLE_AND_RUBRIC (ARTICLE_ID, RUBRIC_NAME) VALUES (11, 'Спорт' );
insert into ARTICLE_AND_RUBRIC (ARTICLE_ID, RUBRIC_NAME) VALUES (12, 'Финансы' );
insert into ARTICLE_AND_RUBRIC (ARTICLE_ID, RUBRIC_NAME) VALUES (12, 'Местное' );

COMMIT;


