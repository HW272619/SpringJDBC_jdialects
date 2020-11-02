package com.example.fydemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.util.Date;

@Data
//@Table(name = "HS_PRODUCE_CLASS")
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class ProduceClass {

    private String ID;
//    @Id
    private String  CODE ;
    private Date R_DATE;
    private String  CLASS;
    private String R_TIME;
    private Double DATAVALUE1;
    private Double DATAVALUE2;
    private Double DECIDE ;
    private String TYPE;
    private String  PROPERTY;
    private String  REPORT_NAME;
    private String CREATE_BY ;
    private Date CREATE_TIME;
    private String MODIFY_BY;
    private Date  MODIFY_TIME;
}
