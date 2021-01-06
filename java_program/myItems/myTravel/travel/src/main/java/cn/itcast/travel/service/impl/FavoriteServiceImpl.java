package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.service.FavoriteService;

import java.util.List;

public class FavoriteServiceImpl implements FavoriteService {

    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public boolean isFavorite(String rid, int uid) {

        Favorite favorite = null;
        if(rid!=null&&!"".equals(rid))
        {
            favorite = favoriteDao.findByRidAndUid(Integer.parseInt(rid), uid);
        }
        return favorite != null;//如果对象有值，则为true，反之，则为false
    }

    @Override
    public void add(String rid, int uid) {
        favoriteDao.add(Integer.parseInt(rid),uid);
    }

    @Override
    public List<Favorite> findFavorites(String uid)
    {
        return favoriteDao.findFavoritesByUid(uid);
    }

    @Override
    public void delete(String rid, int uid) {
        favoriteDao.delete(rid,uid);
    }
}
