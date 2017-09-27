import java.util.List;

/**
 * Created by faithpercious on 2017/9/25.
 */
public class Player  {
    private String name;
    private  int id;
    private List<String> handcardlist;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public List<String> getHandcardlist() {
        return handcardlist;
    }

    public void setHandcardlist(List<String> handcardlist) {
        this.handcardlist = handcardlist;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override//对判断id是否存在的方法重写，contains方法本质为equals
    public boolean equals(Object obj) {
        if (this==obj)
        { return true;}
        if (obj==null){
            return false;
        }
        if (!(obj instanceof Player))
            return false;
        Player player=(Player)obj;
        if (this.getId()==0){
            if (player.getId()==0)
                return true;
            else return  false;
        }
        else {
            if (this.getId()==player.getId())
                return true;
            else  return false;
        }
    }
}
