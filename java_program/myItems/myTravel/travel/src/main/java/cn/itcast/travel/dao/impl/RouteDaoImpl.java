package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.FavoriteRank;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount(int cid, String rname) {
        //String sql = "select count(*) from tab_route where cid = ?";
        //1.定义sql模板
        String sql = "select count(*) from tab_route where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();//条件们
        //2.判断参数是否有值
        if (cid != 0) {
            sb.append(" and cid = ? ");

            params.add(cid);//添加？对应的值
        }

        if (rname != null && rname.length() > 0) {
            sb.append(" and rname like ? ");

            params.add("%" + rname + "%");
        }

        sql = sb.toString();


        return template.queryForObject(sql, Integer.class, params.toArray());
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {
        //String sql = "select * from tab_route where cid = ? and rname like ?  limit ? , ?";
        String sql = " select * from tab_route where 1 = 1 ";
        //1.定义sql模板
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();//条件们
        //2.判断参数是否有值
        if (cid != 0) {
            sb.append(" and cid = ? ");

            params.add(cid);//添加？对应的值
        }

        if (rname != null && rname.length() > 0) {
            sb.append(" and rname like ? ");

            params.add("%" + rname + "%");
        }
        sb.append(" limit ? , ? ");//分页条件

        sql = sb.toString();

        params.add(start);
        params.add(pageSize);


        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), params.toArray());

    }

    @Override
    public Route findOne(int rid) {
        String sql = "select * from tab_route where rid = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);
    }

    @Override
    public List<Route> findAll() {

        String sql = "select * from tab_route";
        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class));

    }

    @Override
    public List<Route> findFavoritesByPage(int start, int pageSize, List<Favorite> favorites, String rname) {
        //SELECT * FROM tab_route WHERE rid IN (1,4,5,3,5,6,8,12,11) LIMIT 2,5;
        String sql = " select * from tab_route where 1 = 1 ";

        if (favorites.size() == 0) {

            return null;
        }

        //1.定义sql模板
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();//条件们
        //2.判断参数是否有值

        String s = " and rid in ( ";

        for (int i = 0; i < favorites.size(); i++) {
            if (i != favorites.size() - 1) {
                s += favorites.get(i).getRid();
                s += ",";
            } else {
                s += favorites.get(i).getRid();
                s += ") ";
            }
        }
        sb.append(s);

        if (rname != null && !("").equals(rname)) {
            sb.append(" and rname like ? ");
            params.add("%" + rname + "%");
        }

        sb.append(" limit ? , ? ");//分页条件
        sql = sb.toString();

        params.add(start);
        params.add(pageSize);

        List<Route> routes = null;
        try {
            routes = template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), params.toArray());
        } catch (Exception e) {
            return null;
        }
        return routes;
    }

    @Override
    public int findTotalCountByName(String rname, List<Favorite> favorites) {
        if (favorites.size() == 0) {
            return 0;
        }
        String sql = "SELECT COUNT(*) FROM tab_route WHERE 1=1 ";

        //1.定义sql模板
        StringBuilder sb = new StringBuilder(sql);

        //2.判断参数是否有值

        String s = " and rid in ( ";

        for (int i = 0; i < favorites.size(); i++) {
            if (i != favorites.size() - 1) {
                s += favorites.get(i).getRid();
                s += ",";
            } else {
                s += favorites.get(i).getRid();
                s += ") ";
            }
        }
        sb.append(s);

        if (rname == null || ("").equals(rname)) {
            System.out.println("rname为空");
            sql = sb.toString();
            return template.queryForObject(sql, Integer.class);
        } else {
            sb.append(" and rname like ? ");
            sql = sb.toString();
            System.out.println("rname为：" + rname);
            return template.queryForObject(sql, Integer.class, ("%" + rname + "%"));
        }
    }

    @Override
    public List<Route> findFavoritesRankByPage(int start, int pageSize, String rname, String lowPrice, String highPrice) {
//        SELECT * FROM tab_route WHERE rname LIKE '%山%' AND rid IN (3,2,4,5,7,4,12,42,345) AND price>100 AND price<2100  LIMIT 1,8 ;

        String sql="SELECT * FROM tab_route WHERE 1=1 ";

        if(rname!=null&&(!"".equals(rname)))
        {
            sql+= (" and rname LIKE "+"'%"+ rname +"%' ");
        }

        if(lowPrice!=null&&!"".equals(lowPrice))
        {
            sql+= (" and price > "+lowPrice);
        }
        if (highPrice != null && !"".equals(highPrice)) {
            sql += (" and price < " + highPrice);
        }

        sql+=(" order by count desc limit " +start +","+pageSize);

        System.out.println("sql："+sql);
        return template.query(sql,new BeanPropertyRowMapper<Route>(Route.class));
    }

    @Override
    public int findFavoritesRankTotalCount(String rname, String lowPrice, String highPrice) {
        //        SELECT COUNT(*) FROM tab_route WHERE rname LIKE '%山%' AND rid IN (3,2,4,5,7,4,12,42,345) AND price>100 AND price<2100  LIMIT 1,8 ;

        String sql="SELECT COUNT(*) FROM tab_route WHERE 1=1 ";

        if(rname!=null&&(!"".equals(rname)))
        {
            sql+= (" and rname LIKE "+"'%"+ rname +"%' ");
        }

        if(lowPrice!=null&&!"".equals(lowPrice))
        {
            sql+= (" and price > "+lowPrice);
        }
        if (highPrice != null && !"".equals(highPrice)) {
            sql += (" and price < " + highPrice);
        }

        System.out.println("sql："+sql);
        return template.queryForObject(sql,Integer.class);
    }

    @Override
    public int findCount(String rid) {
        String sql;
        int count;
        try {
            sql = "SELECT COUNT FROM tab_route WHERE rid=?";
            count = Integer.parseInt(template.queryForObject(sql, String.class, rid));
        } catch (Exception e) {
            count = 0;
        }
        return count;
    }

    @Override
    public void update(String rid, int favoriteCount) {
        String sql = "UPDATE tab_route SET COUNT=? WHERE rid=? ";
        template.update(sql, favoriteCount, rid);
    }

}
