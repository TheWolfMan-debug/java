package cn.itcast.travel.domain;

public class FavoriteRank {
    private Integer rid;
    private Integer count;

    public FavoriteRank() {
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "FavoriteRank{" +
                "rid=" + rid +
                ", count=" + count +
                '}';
    }
}
