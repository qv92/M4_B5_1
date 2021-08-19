package repository;

import model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();
    Blog findByID(long id);
    void save(Blog blog);
    void remove(long id);
}
