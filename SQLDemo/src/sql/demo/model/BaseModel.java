package sql.demo.model;

import java.util.Objects;

public class BaseModel {
    protected long id;

    public BaseModel(long id) {
        this.id = id;
    }

    public BaseModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BaseModel baseModel = (BaseModel) obj;
        return id == baseModel.id;
    }
}
