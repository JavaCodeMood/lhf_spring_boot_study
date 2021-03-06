package com.lhf.springboot.service;

import com.lhf.springboot.pojo.Girl;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: GirlService
 * @Author: liuhefei
 * @Description: TODD
 * @Date: 2019/7/25 17:05
 */
public interface GirlService {

    boolean addKeyMap(String key, Map map);

    boolean addGirl(Girl girl);

    boolean updateGirl(Girl girl);

    boolean deleteGirl(int id);

    Girl findById(int id);

    List<Girl> findByGirlList();
}
