package service;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IBlogRepository;

import java.util.List;

public class BlogService implements IBlogService{
    @Autowired
    IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findByID(long id) {
        return blogRepository.findByID(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(long id) {
        blogRepository.remove(id);
    }
}
