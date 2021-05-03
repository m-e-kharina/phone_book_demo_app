package com.example.phone_book_demo.controller;

import com.example.phone_book_demo.model.Client;
import com.example.phone_book_demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/clients")
    public ResponseEntity<?> create(@RequestBody Client client) {
        clientService.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/clients/{id}")
    public ResponseEntity<?> createPersonal(@PathVariable(name = "id") int id,
                                            @RequestBody Client client) {
        clientService.createPersonal(id, client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> readAll() {
        final List<Client> clients = clientService.readAll();

        return clients != null &&  !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<Client> read(@PathVariable(name = "id") int id) {
        final Client client = clientService.read(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/clients/{id1}/{id2}")
    public ResponseEntity<Client> readPersonal(@PathVariable(name = "id1") int id1,
                                               @PathVariable(name = "id2") int id2) {
        final Client client = clientService.readPersonal(id1, id2);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @GetMapping(value = "/clients/{id}")
//    public ResponseEntity<List<Client>> readAllPersonal(@PathVariable(name = "id") int id) {
//        final List<Client> clients = clientService.readAllPersonal(id);
//
//        return clients != null
//                ? new ResponseEntity<>(clients, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id,
                                    @RequestBody Client client) {
        final boolean updated = clientService.update(client, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "/clients/{id1}/{id2}")
    public ResponseEntity<?> updatePersonal(@PathVariable(name = "id1") int id1,
                                            @RequestBody Client client,
                                            @PathVariable(name = "id2") int id2) {
        final boolean updated = clientService.updatePersonal(id1, client, id2);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = clientService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/clients/{id1}/{id2}")
    public ResponseEntity<?> deletePersonal(@PathVariable(name = "id1") int id1,
                                            @PathVariable(name = "id2") int id2) {
        final boolean deleted = clientService.deletePersonal(id1, id2);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

//    @GetMapping(value = "/clients")
//    public ResponseEntity<Client> getByName(@RequestBody String string) {
//        final Client client = clientService.getByName(string);
//
//        return client != null
//                ? new ResponseEntity<>(client, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping(value = "/clients")
//    public ResponseEntity<Client> getByNumber(@RequestBody String string) {
//        final Client client = clientService.getByNumber(string);
//
//        return client != null
//                ? new ResponseEntity<>(client, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
}

