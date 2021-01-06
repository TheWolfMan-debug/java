package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.FavoriteRank;
import cn.itcast.travel.domain.Route;

import java.util.List;

public interface RouteDao {

    /**
     * 根据cid查询总记录数
     */
    public int findTotalCount(int cid,String rname);

    /**
     * 根据cid，start,pageSize查询当前页的数据集合
     */
    public List<Route> findByPage(int cid , int start , int pageSize,String rname);

    /**
     * 根据id查询
     * @param rid
     * @return
     */
    public Route findOne(int rid);

    List<Route> findAll();

    List<Route> findFavoritesByPage(int start, int pageSize, List<Favorite> favorites, String rname);

    int findTotalCountByName(String rname,List<Favorite> favorites);

    List<Route> findFavoritesRankByPage(int start, int pageSize, String rname, String lowPrice, String highPrice);

    int findFavoritesRankTotalCount(String rname, String lowPrice, String highPrice);

    int findCount(String rid);

    void update(String rid, int favoriteCount);


}
