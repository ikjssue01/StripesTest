/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ms.rrhh.domain.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author abisai
 * @param <A>
 * @param <B>
 */
public class BeansConverter<A, B> {

    private String[] ignore;

    public void setIgnore(String[] ignore) {
        this.ignore = ignore;
    }

    /**
     * Stream based fast toDTO
     *
     * @param origin
     * @return
     */
    public List<B> toDTO(List<A> origin) {
        List<B> b = new ArrayList<B>();
        for (A a : origin) {
            b.add(this.toDTO(a));
        }
        return b;
        //return (List<B>) origin.stream().map(this::toDTO).collect(toList());
    }

    /**
     * spring fast toDTO
     *
     * @param iA
     * @return
     */
    public B toDTO(A iA) {
        B iB = BeanUtils.instantiate((Class<B>) resolve(1));
        BeanUtils.copyProperties(iA, iB, ignore);
        return iB;
    }

    /**
     * spring fast toDTO
     *
     * @param iB
     * @return
     */
    public A toEntity(B iB) {
        A iA = BeanUtils.instantiate((Class<A>) resolve(0));
        BeanUtils.copyProperties(iB, iA);

        return iA;
    }

    /**
     *
     * @param origin
     * @return
     */
    public List<A> toEntity(List<B> origin) {
        List<A> b = new ArrayList<A>();
        for (B a : origin) {
            b.add(this.toEntity(a));
        }
        return b;
//        return (List<A>) origin.stream().map(this::toEntity).collect(toList());
    }

    /**
     *
     *
     * @return
     */
    private Class<?> resolve(int index) {
        Type[] v = ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments();

        return (Class) v[index];
    }

}
