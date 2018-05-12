package adong.org.finedust.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Dust {
    private List<DustList> list;

    public Dust(List<DustList> list) {
        this.list = list;
    }

    public List<DustList> getList() {
        return list;
    }

    public void setList(List<DustList> list) {
        this.list = list;
    }
}
