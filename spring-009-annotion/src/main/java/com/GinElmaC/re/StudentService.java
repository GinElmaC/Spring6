package com.GinElmaC.re;

import com.GinElmaC.re.dao.StudentDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentService {
    @Resource(name = "studentDao")
    private StudentDao studentDao;
    public void service(){
        studentDao.insert();
    }
}
