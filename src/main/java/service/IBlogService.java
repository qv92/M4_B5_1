package service;

import model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findByID(long id);
    void save(Blog blog);
    void remove(long id);
}
