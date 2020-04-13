package com.briup.dingding.exception;

import com.briup.dingding.util.CodeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomerException extends RuntimeException {

    private CodeStatus codeStatus;
}
