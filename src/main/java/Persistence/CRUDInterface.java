package Persistence;

import Models.Model;

import java.util.List;

/**
 * This class extending our Model class allow us to create easy to use methods for both Reimbursement model
 * and User model to use. The param T is a generic that allows us to pass in any Type of data/object.
 * @param <T>
 */

public  interface CRUDInterface <T extends Model>{
    //CRUD - create, read, update, delete
    public T create(T model);

    public T read(int id);
    //get all
    public List<T> getAll();

    public void update(T model);

    public void delete(int id);
    //Also
    public void delete(T model);

}
