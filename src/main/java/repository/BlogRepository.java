package repository;

import model.Blog;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.List;

@Transactional
public class BlogRepository implements IBlogRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog b", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findByID(long id) {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog b where b.id = :id", Blog.class)
                .setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() != null) {
            entityManager.merge(blog);
        } else {
            entityManager.persist(blog);
        }
    }


    @Override
    public void remove(long id) {
        Blog blog = findByID(id);
        if (blog != null) entityManager.remove(blog);
    }
}
