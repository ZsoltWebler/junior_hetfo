package databases.books;

import java.util.List;
import java.util.Optional;

public class BookDao implements Dao<Book,String>{


    @Override
    public Optional<Book> get(String id) {
        return Optional.empty();
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void save(List<Book> t) {

    }

    @Override
    public void update(String id, Book book) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void deleteAll(List<String> ids) {

    }
}
