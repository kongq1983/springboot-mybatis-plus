package com.kq.mapper;

import com.kq.dto.TableSequence;
import com.kq.entity.T1;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

/**
 * @author: kq
 * @date: 2023-06-27 16:45:08
 * @since: 1.0.0
 * @description:
 */
public interface T1Mapper {


    List<T1> list();


}
