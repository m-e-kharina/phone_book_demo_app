# phone_book_demo_app

Программа реализует серверную часть приложения (без UI части) по работе с пользователями и их телефонной книжкой.

Основной код проекта содержится в пакете phone_book_demo_app/src/main/java/com/example/phone_book_demo/

Программа для запуска : PhoneBookDemoApplication.java

В пакете model/ содержатся классы, описывающие пользователей (Client) и их телефонные книжки (ClientPhoneBook).

В пакете service/ содержится интерфейс ClientService, в котором описаны CRUD операции над клиентом, а также класс ClientServiceImpl, в котором реализован данный интерфейс.

В пакете controller/ содержится класс, в котором реализуется логика обработки клиентских запросов.

В пакете phone_book_demo_app/src/test/java/com/example/phone_book_demo/ содержатся тесты.
