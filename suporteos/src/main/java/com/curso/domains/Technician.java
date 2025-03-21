package com.curso.domains;

import com.curso.domains.enums.PersonType;

import java.util.ArrayList;
import java.util.List;

public class Technician extends Person{

    private List<ServiceOrder> serviceOrders = new ArrayList<>();

    public Technician(Long id, String firstName, String lastName, String cpf, String email, String password) {
        super(id, firstName, lastName, cpf, email, password);
        addPersonType(PersonType.TECHNICIAN);
    }

    public Technician() {
    super();
        addPersonType(PersonType.TECHNICIAN);
    }

    public List<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }
}
