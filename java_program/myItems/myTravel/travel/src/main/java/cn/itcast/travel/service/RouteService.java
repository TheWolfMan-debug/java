package cn.itcast.travel.service;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

import java.util.List;

/**
 * 线路Service
 */
public interface RouteService {

    /**
     * 根据类别进行分页查询
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageBean<Route> pageQuery(int cid,int currentPage,int pageSize,String rname);

    /**
     * 根据id查询
     * @param rid
     * @return
     */
    public Route findOne(String rid);

    List<Route> findFavorites(List<Favorite> favorites);

    List<Route> findAllRoutes();

    PageBean<Route> FavoritesPageQuery(int currentPage, int pageSize, List<Favorite> favorites, String rname);

    int findCount(String rid);

    void update(String rid, int favoriteCount);

    PageBean<Route> FavoritesRankPageQuery(int currentPage, int pageSize, String rname, String lowPrice, String highPrice);

}
