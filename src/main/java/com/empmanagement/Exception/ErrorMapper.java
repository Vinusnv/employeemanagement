package com.empmanagement.Exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMapper {

    private int errorcode;

    private String errormessage;

    private String developer;


}
