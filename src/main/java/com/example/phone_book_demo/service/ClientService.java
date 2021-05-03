package com.example.phone_book_demo.service;
import com.example.phone_book_demo.model.Client;

import java.util.List;

public interface ClientService {

    /**
     * Создает нового клиента
     * @param client - клиент для создания
     */
    void create(Client client);


    /**
     * Создает нового клиента в телефонной книжке клиента с указанным ID
     * @param client - клиент для создания
     * @param id - ID клиента
     */
    void createPersonal(int id, Client client);

    /**
     * Возвращает список всех имеющихся клиентов
     * @return список клиентов
     */
    List<Client> readAll();

    /**
     * Возвращает клиента по его ID
     * @param id - ID клиента
     * @return - экземпляр клиента с заданным ID
     */
    Client read(int id);

    /**
     * Возвращает клиента из телефонной книжки другого клиента по его ID
     * @param id1 - ID клиента-владельца телефонной книжки
     * @param id2 - ID искомого клиента
     * @return - экземпляр клиента с заданным ID
     */
    Client readPersonal(int id1, int id2);

//    /**
//     * Возвращает телефонную книжку клиента по его ID
//     * @param id - ID клиента
//     * @return - телефонная книжка клиента с заданным ID
//     */
//     List<Client> readAllPersonal(int id);

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     * @param client - клиент в соответсвии с которым нужно обновить данные
     * @param id - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Client client, int id);

    /**
     * Обновляет клиента с заданным ID из телефонной книжки другого клиента,
     * в соответствии с переданным клиентом
     * @param id1 - id клиента, в телефонной книжке которого требуется внести изменения
     * @param client - клиент в соответсвии с которым нужно обновить данные
     * @param id2 - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean updatePersonal(int id1, Client client, int id2);

    /**
     * Удаляет клиента с заданным ID
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int id);

    /**
     * Удаляет клиента с заданным ID из телефонной книжки другого клиента
     * @param id1 - id клиента, из телефонной книжки которого необходимо удалить запись
     * @param id2 - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean deletePersonal(int id1, int id2);

//    /**
//     * Возвращает клиента по его имени
//     * @param string - имя клиента
//     * @return - экземпляр клиента
//     */
//    Client getByName(String string);
//
//    /**
//     * Возвращает клиента по номеру телефона
//     * @param string - номер телефона клиента
//     * @return - экземпляр клиента
//     */
//    Client getByNumber(String string);
}
