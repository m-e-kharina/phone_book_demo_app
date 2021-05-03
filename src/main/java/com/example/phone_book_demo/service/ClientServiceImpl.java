package com.example.phone_book_demo.service;

import com.example.phone_book_demo.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientServiceImpl implements ClientService {

    // Хранилище клиентов
    private static final Map<Integer, Client> CLIENT_REPOSITORY_MAP = new HashMap<>();

    // Переменная для генерации ID клиента
    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Client client) {
        final int clientId = CLIENT_ID_HOLDER.incrementAndGet();
        client.setId(clientId);
        CLIENT_REPOSITORY_MAP.put(clientId, client);
    }

    @Override
    public void createPersonal(int id, Client client) {
        final int clientId = CLIENT_ID_HOLDER.incrementAndGet();
        client.setId(clientId);
        CLIENT_REPOSITORY_MAP.get(id).getPhoneBook().getClientPersonalMap().put(clientId, client);
    }

    @Override
    public List<Client> readAll() {

        return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());
    }

    @Override
    public Client read(int id) {
        return CLIENT_REPOSITORY_MAP.get(id);
    }

    @Override
    public Client readPersonal(int id1, int id2) {
        return CLIENT_REPOSITORY_MAP.get(id1).getPhoneBook().getClientPersonalMap().get(id2);
    }

//    @Override
//    public List<Client> readAllPersonal(int id) {
//
//        return new ArrayList<>(CLIENT_REPOSITORY_MAP.get(id).getPhoneBook().getClientPersonalMap().values());
//    }

    @Override
    public boolean update(Client client, int id) {
        if (CLIENT_REPOSITORY_MAP.containsKey(id)) {
            client.setId(id);
            CLIENT_REPOSITORY_MAP.put(id, client);
            return true;
        }

        return false;
    }

    @Override
    public boolean updatePersonal(int id1, Client client, int id2) {
        if (CLIENT_REPOSITORY_MAP.get(id1).getPhoneBook().getClientPersonalMap().containsKey(id2)) {
            client.setId(id2);
            CLIENT_REPOSITORY_MAP.get(id1).getPhoneBook().getClientPersonalMap().put(id2, client);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        return CLIENT_REPOSITORY_MAP.remove(id) != null;
    }

    @Override
    public boolean deletePersonal(int id1, int id2) {
        return CLIENT_REPOSITORY_MAP.get(id1).getPhoneBook().getClientPersonalMap().remove(id2) != null;
    }

//    @Override
//    public Client getByName(String string) {
//
//        for (Client client : readAll()) {
//            if (client.getName().equals(string)) {
//                return client;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Client getByNumber(String string) {
//
//        for (Client client : readAll()) {
//            if (client.getPhone().equals(string)) {
//                return client;
//            }
//        }
//        return null;
//    }
}
