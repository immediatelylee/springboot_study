package dev.be.modulecommon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeEnum {
    SUCESS("0000","Sucess"),
    UNKNOWN_ERROR("9999","UNKNOW_ERROR");

    private String code;
    private String message;
}
