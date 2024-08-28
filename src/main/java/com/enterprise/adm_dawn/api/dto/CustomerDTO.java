package com.enterprise.adm_dawn.api.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private Long customerId;
    private String username;
    private String password;
    private String email;
    private String contact;
    private String name;
    private String surname;
    private char gender;
    private String dateOfBirth;
    private String photo;
    private String dateJoined;

    public List<CustomerDTO> dummyData() {
        CustomerDTO customer1 = new CustomerDTO(
            1L,
            "user123",
            "password123",
            "user123@example.com",
            "0123456789",
            "John",
            "Doe",
            'M',
            "1990-01-01",
            "photo1.jpg",
            "2023-01-01"
        );

        CustomerDTO customer2 = new CustomerDTO(
            2L,
            "user456",
            "password456",
            "user456@example.com",
            "0987654321",
            "Jane",
            "Smith",
            'F',
            "1995-05-15",
            "photo2.jpg",
            "2022-06-15"
        );

        CustomerDTO customer3 = new CustomerDTO(
            3L,
            "user789",
            "password789",
            "user789@example.com",
            "1234567890",
            "Alice",
            "Johnson",
            'F',
            "1988-03-22",
            "photo3.jpg",
            "2021-03-22"
        );

        CustomerDTO customer4 = new CustomerDTO(
            4L,
            "user101",
            "password101",
            "user101@example.com",
            "2345678901",
            "Bob",
            "Brown",
            'M',
            "1985-07-11",
            "photo4.jpg",
            "2020-07-11"
        );

        CustomerDTO customer5 = new CustomerDTO(
            5L,
            "user202",
            "password202",
            "user202@example.com",
            "3456789012",
            "Charlie",
            "Davis",
            'M',
            "1992-12-05",
            "photo5.jpg",
            "2019-12-05"
        );

        CustomerDTO customer6 = new CustomerDTO(
            6L,
            "user303",
            "password303",
            "user303@example.com",
            "4567890123",
            "Diana",
            "Evans",
            'F',
            "1998-09-17",
            "photo6.jpg",
            "2018-09-17"
        );

        CustomerDTO customer7 = new CustomerDTO(
            7L,
            "user404",
            "password404",
            "user404@example.com",
            "5678901234",
            "Edward",
            "Garcia",
            'M',
            "1983-04-29",
            "photo7.jpg",
            "2017-04-29"
        );

        CustomerDTO customer8 = new CustomerDTO(
            8L,
            "user505",
            "password505",
            "user505@example.com",
            "6789012345",
            "Fiona",
            "Harris",
            'F',
            "1991-11-13",
            "photo8.jpg",
            "2016-11-13"
        );

        CustomerDTO customer9 = new CustomerDTO(
            9L,
            "user606",
            "password606",
            "user606@example.com",
            "7890123456",
            "George",
            "Ivy",
            'M',
            "1987-02-20",
            "photo9.jpg",
            "2015-02-20"
        );

        CustomerDTO customer10 = new CustomerDTO(
            10L,
            "user707",
            "password707",
            "user707@example.com",
            "8901234567",
            "Hannah",
            "Jones",
            'F',
            "1994-06-30",
            "photo10.jpg",
            "2014-06-30"
        );

        CustomerDTO customer11 = new CustomerDTO(
            11L,
            "user808",
            "password808",
            "user808@example.com",
            "9012345678",
            "Ian",
            "King",
            'M',
            "1989-08-25",
            "photo11.jpg",
            "2013-08-25"
        );

        CustomerDTO customer12 = new CustomerDTO(
            12L,
            "user909",
            "password909",
            "user909@example.com",
            "0123456789",
            "Jill",
            "Lewis",
            'F',
            "1993-10-10",
            "photo12.jpg",
            "2012-10-10"
        );

        List<CustomerDTO> customerList = new ArrayList<>();

        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
        customerList.add(customer5);
        customerList.add(customer6);
        customerList.add(customer7);
        customerList.add(customer8);
        customerList.add(customer9);
        customerList.add(customer10);
        customerList.add(customer11);
        customerList.add(customer12);

        return customerList;
    }
}
