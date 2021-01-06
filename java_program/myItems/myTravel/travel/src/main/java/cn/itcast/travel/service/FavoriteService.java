package cn.itcast.travel.service;

import cn.itcast.travel.domain.Favorite;

import java.util.List;

public interface FavoriteService {

    /**
     * 判断是否收藏
     *
     * @param rid
     * @param uid
     * @return
     */
    public boolean isFavorite(String rid, int uid);

    /**
     * 添加收藏
     *
     * @param rid
     * @param uid
     */
    void add(String rid, int uid);

    /**
     * 查找收藏的喜欢
     * @param uid
     * @return
     */
    List<Favorite> findFavorites(String uid);

    void delete(String rid, int uid);
}
