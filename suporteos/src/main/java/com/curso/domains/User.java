package com.curso.domains;

import com.curso.domains.enums.PersonType;

import java.util.ArrayList;
import java.util.List;

public class User extends Person{

    private List<ServiceOrder> serviceOrders = new ArrayList<>();

    public User(Long id, String firstName, String lastName, String cpf, String email, String password) {
        super(id, firstName, lastName, cpf, email, password);
        addPersonType(PersonType.USER);
    }

    public User() {
    super();
        addPersonType(PersonType.USER);
    }

    public List<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }
}
