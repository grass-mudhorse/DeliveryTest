package com.sirius.controller;

import com.sirius.entity.*;
import com.sirius.feign.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.*;

@CrossOrigin
@RequestMapping("client/home")
@RestController
public class HomePageHandler {

    @Autowired
    private AccountFeign accountFeign;

    @Autowired
    private ReviewFeign reviewFeign;

    @Autowired
    private MenuFeign menuFeign;

    @Autowired
    private OrderFeign orderFeign;
    @Autowired
    private UserFeign userFeign;

    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @GetMapping("findAllRestaurant/{index}/{limit}")
    public Map<String,Object> findAllRestaurant(@PathVariable("index") int index, @PathVariable("limit") int limit){
        Map<String,Object> hashmap = new HashMap<>();
        List<Restaurant> restaurants = userFeign.findAllRestaurant(index,limit);
        int total = userFeign.count();
        hashmap.put("restaurants",restaurants);
        hashmap.put("total",total);
        return hashmap;
    }

    @GetMapping("findReviewByRestaurantId/{restaurantid}/{index}/{limit}")
    public List<Review> findReviewByRestaurantId(@PathVariable("restaurantid") int restaurantid, @PathVariable("index") int index, @PathVariable("limit") int limit){
        return reviewFeign.findReviewByRestaurantId(restaurantid,index,limit);
    }

    @PostMapping("/findRestaurantByStorename")
    public List<Restaurant> findByRname(@RequestBody Restaurant restaurant){
        return userFeign.findByRname(restaurant);
    }

    @GetMapping("/moreinfo/{rname}")
    public Map<String,Object> findRestMenuByRname(@PathVariable String rname){
        Map<String,Object> hashmap = new HashMap<String,Object>();
        List<Menu> menus = menuFeign.findMenuByRestName(rname);
        Restaurant restaurant = accountFeign.findRestaurantByRname(rname);
        hashmap.put("menus",menus);
        insertRestaurantToMap(hashmap,restaurant);
        return hashmap;
    }

    @GetMapping("/findmenubyrname/{rname}")
    public List<Map<String,Object>> findMenuByRname(@PathVariable String rname){
        List<Menu> menus = menuFeign.findMenuByRestName(rname);
        List<Map<String,Object>> maps = new ArrayList<Map<String,Object>>();
        for(Menu menu:menus){
            Map<String,Object> map = new HashMap<String,Object>();
            DecimalFormat df = new DecimalFormat("#.00");
//            float menu_tmp=df.format(menu.price);
//            menu.price=menu_tmp;
            df.format(menu.price);
            insertMenuToMap(map,menu);
            maps.add(map);
        }
        System.out.println(maps);
        return maps;
    }
    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @PostMapping("/makeorder")
    public void makeOrder(@RequestBody Map<String,Object> map){
        Order order = new Order();
        convertMapToOrder(map,order);
        long oid = orderFeign.makeOrder(order);

        List menus = (ArrayList)map.get("menus");
        for(Object obj:menus){
            OrderDetail orderDetail = new OrderDetail();
            convertMapToOrderDetail((Map)obj,orderDetail);
            orderDetail.setOrderid(oid);
            orderFeign.saveOrderDetail(orderDetail);
        }
    }

    public void insertRestaurantToMap(Map hashmap,Restaurant restaurant){
        hashmap.put("restaurantid",restaurant.getRestaurantid());
        hashmap.put("username",restaurant.getUsername());
        hashmap.put("password",restaurant.getPassword());
        hashmap.put("storename",restaurant.getStorename());
        hashmap.put("telephone",restaurant.getTelephone());
        hashmap.put("address",restaurant.getAddress());
        hashmap.put("rating",restaurant.getRating());
        hashmap.put("description",restaurant.getDescription());
        hashmap.put("state",restaurant.getState());
        hashmap.put("persontime",restaurant.getPersontime());
    }

    public void insertMenuToMap(Map hashmap,Menu menu){
        hashmap.put("menuid",menu.getMenuid());
        hashmap.put("storename",menu.getStorename());
        hashmap.put("price",menu.getPrice());
        hashmap.put("stocks",menu.getStocks());
        hashmap.put("description",menu.getDescription());
        hashmap.put("menutype",menu.getMenutype());
        hashmap.put("menuname",menu.getMenuname());
        hashmap.put("photo",menu.getPhoto());
        hashmap.put("materials",menu.getMaterials());
        hashmap.put("total",0);
    }

    public void convertMapToOrder(Map map,Order order){
        order.setRestaurantid(Long.parseLong(map.get("restaurantid").toString()));
        order.setStorename((String)map.get("storename"));
        order.setUserid(Long.parseLong(map.get("userid").toString()));
        order.setTotalprice(Float.parseFloat(map.get("totalprice").toString()));
        order.setState((int)map.get("state"));
        order.setNote((String)map.get("note"));
        order.setAddress((String)map.get("address"));
    }

    public void convertMapToOrderDetail(Map map, OrderDetail orderDetail){
        orderDetail.setMenuid(Long.parseLong(map.get("menuid").toString()));
        orderDetail.setMenuname((String)map.get("menuname"));
        orderDetail.setMenunumber((int)map.get("menunumber"));
    }

}
