package by.volkov.testtask.model;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Integer id;

    public AbstractBaseEntity() {
    }

    public AbstractBaseEntity(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return this.id == null;
    }
}
