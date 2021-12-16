package com.priyanshu.fetchApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.priyanshu.fetchApi.entity.MyNumber;

public interface MyNumberDAO extends JpaRepository<MyNumber,String>{

}
