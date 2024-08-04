package com.e_commerce_app.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Long customerId;

    private String name;

    private String email;

    private String password;

    private String address;

    private Long phoneNumber;

    private List<AuthorityDto> authorityList;
}
