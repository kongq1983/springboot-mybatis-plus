package com.kq.tool.map;

import com.kq.tool.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kq
 * @date 2022-05-11 14:44
 * @since 2020-0630
 */
public class FilterTest {

    public static void main(String[] args) {
        Product p = new Product();
        p.setTenantId(1L);

        Product p1 = new Product();
        p1.setSchoolId(2L);

        Product p2 = new Product();
        p2.setSchoolId(3L);

        Product p3 = new Product();
        p3.setTenantId(5L);

        List<Product> list = new ArrayList<>();
        list.add(p);
        list.add(p1);
        list.add(p2);
        list.add(p3);

//        List<Long> tenants = list.stream().filter(e->e.getTenantId()!=null).map(e->e.getTenantId()).collect(Collectors.toList());
        List<Long> tenants = list.stream().filter(e->e.getSchoolId()!=null).map(e->e.getTenantId()).collect(Collectors.toList());
        System.out.println(tenants);

    }

}
