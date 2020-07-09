package com.sirius.repository;

import com.sirius.entity.Menu;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface MenuRepository {
    public List<Menu> findAll(int index, int limit);
    public int count();
    public Menu findAllByMId(int MenuID);
    public List<Menu> findByRestaurantName(String rname, int page, int limit);
    public List<Menu> findMenuByRestName(String rname);
    public List<Menu> findMenu(String rname,String mname);
    public void save(Menu menu);
    public void update(Menu menu);
    public void deleteByName(String rname,String mname);
}
