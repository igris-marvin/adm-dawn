package com.enterprise.adm_dawn.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.adm_dawn.api.dto.CustomerDTO;
import com.enterprise.adm_dawn.persistence.entity.Customer;
import com.enterprise.adm_dawn.persistence.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private ConverterService convServ;
    
    @Autowired
    private CustomerRepository custRepo;

    public List<CustomerDTO> getCustomersList() {

        // List<Customer> list = custRepo.findAll();

        List<CustomerDTO> dlist = new ArrayList<>();

        // for (Customer x : list) {
            
        //     CustomerDTO dto = convServ.convertCustomer(x);

        //     dlist.add(dto);
        // }

        //DUMMY DATA

        CustomerDTO dto = new CustomerDTO();

        dlist = dto.dummyData();

        return dlist;
    }


}
