package databases.samples.studyjam.com.dbsamples.data.db.simplecursor.dto;

import java.io.Serializable;

public class CoreObject implements Serializable {

    private int id;
    private String name;
    private String url;

    public CoreObject() {
    }

    public CoreObject(String name,String url) {
        this.url = url;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CoreObject{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
