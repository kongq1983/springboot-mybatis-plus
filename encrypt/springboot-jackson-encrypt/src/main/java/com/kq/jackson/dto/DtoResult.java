package com.kq.jackson.dto;

import lombok.Data;

/**
 * @author kq
 * @date 2022-04-08 10:35
 * @since 2020-0630
 */
@Data
public class DtoResult {

    private Integer code = 0;
    private Object result;

}
