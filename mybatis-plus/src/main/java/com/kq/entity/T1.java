package com.kq.entity;

/**
 * @author: kq
 * @date: 2023-07-04 17:11:26
 * @since: 1.0.0
 * @description:
 */
public class T1 {

    private Long id;
    private String a;
    private String b;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "T1{" +
                "id=" + id +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}
