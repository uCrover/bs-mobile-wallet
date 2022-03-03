package com.bank.yanki.service.redis.YankiDto;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
public class YankiDto {

    private String id;
    private String identityDocument;
    private String phoneNumber;
    private Double amount;
    private String email;
    private String imeiNumber;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date createDate;

}
