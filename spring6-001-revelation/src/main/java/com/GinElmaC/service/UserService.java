package com.GinElmaC.service;

/**
 * 业务层
 * 业务层需要调用持久层的方法，所以在业务层的代码中往往要使用多态进行常见持久层对象
 */
public interface UserService {
    /**
     * 删除信息
     * @param id
     */
    void deletUser(Integer id);
}
