package com.kq.tool.number;

import java.math.BigDecimal;

/**
 * @author kq
 * @date 2022-05-19 18:14
 * @since 2020-0630
 */
public class NumberUtil {

    public static void main(String[] args) {
        BigDecimal calcOrderMoney = new BigDecimal(0);
        calcOrderMoney = calcOrderMoney.add(new BigDecimal(10));

        System.out.println(calcOrderMoney);

    }

}
