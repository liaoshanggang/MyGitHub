package com.forward.service;

import com.forward.domain.Girl;
import com.forward.enums.ResultEnum;
import com.forward.exception.GirlException;
import com.forward.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(18);
        girlRepository.save(girlB);

    }

    public void getAge(Integer id) throws Exception {
        Optional<Girl> byId = girlRepository.findById(id);
        Girl girl = byId.get();
        Integer age = girl.getAge();
        if(age<10){
            //返回"你还在上小学吧"
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10&&age<16){
            //返回"你可能上初中"
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        //如果>16岁，加钱
    }

    //查询一个女生
    public Optional<Girl> findOne(Integer id){
        return girlRepository.findById(id);
        //return new Girl();
    }
}
