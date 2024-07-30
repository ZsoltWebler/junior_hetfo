package databases.books;

import java.util.List;
import java.util.Optional;

public interface Dao<T,K> {

    Optional<T> get(K id);

    List<T> getAll();

    void save(T t);

    void save(List<T> t);

    void update(K id, T t);

    void delete(K id);

    void deleteAll(List<K> ids);
}
