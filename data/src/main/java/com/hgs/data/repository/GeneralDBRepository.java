package com.hgs.data.repository;

import com.activeandroid.query.Select;
import com.hgs.data.entity.GeneralModel;
import com.hgs.domain.repository.IRepository;

import java.util.List;

public class GeneralDBRepository<TEntity extends GeneralModel> implements IRepository<TEntity> {

    private final Class<TEntity> classType;

    public GeneralDBRepository(Class<TEntity> classType) {
        this.classType = classType;
    }

    @Override
    public List<TEntity> getAll() throws Exception {

        List<TEntity> entities =
                new Select().from(classType)
                        .execute();

        return settingLocalId(entities);
    }

    @Override
    public TEntity getById(int id) throws Exception {
        TEntity entity = new Select()
                .from(classType)
                .where("Id = ?", id)
                .executeSingle();

        if (entity != null){entity.setLocalId(entity.getId().intValue());}
        return entity;
    }

    @Override
    public TEntity create(TEntity entity) throws Exception {
        if(entity.getId() != null){
            if (entity.getId() == 0){
                entity.setAaId(null);
            }
        }
        Long idLocal = entity.save();
        entity.setLocalId(idLocal.intValue());

        return entity;
    }

    @Override
    public TEntity delete(int id) throws Exception {
        TEntity entity = getById(id);
        entity.delete();
        return entity;
    }

    @Override
    public TEntity update(int id, TEntity entity) throws Exception {
        Long idLocal = entity.save();
        entity.setLocalId(idLocal.intValue());

        return entity;
    }

    @Override
    public TEntity getByUniqueField(String field, Object value) throws Exception {

        TEntity entity = new Select()
                .from(classType)
                .where(field + " = ?", value)
                .executeSingle();
        if (entity != null){entity.setLocalId(entity.getId().intValue());}

        return entity;
    }

    @Override
    public List<TEntity> getEntitiesByField(String field, Object value) throws Exception {
        List<TEntity> entities = new Select()
                .from(classType)
                .where(field + " = ?", value).execute();
        return settingLocalId(entities);
    }

    @Override
    public List<TEntity> getEntitiesByClause(String clause, Object... args) throws Exception {
        List<TEntity> entities = new Select()
                .from(classType)
                .where(clause, args).execute();

        return settingLocalId(entities);
    }

    @Override
    public TEntity getEntityByClause(String clause, Object... args) throws Exception {
        List<TEntity> entities = new Select()
                .from(classType)
                .where(clause, args).execute();

        if (entities.size() > 0){
            return settingLocalId(entities).get(0);
        }

        return null;
    }

    private List<TEntity> settingLocalId(List<TEntity> entities){
        for (TEntity entity: entities) {
            entity.setLocalId(entity.getId().intValue());
        }
        return entities;
    }
}