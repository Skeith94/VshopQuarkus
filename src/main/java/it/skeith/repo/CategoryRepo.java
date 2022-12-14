package it.skeith.repo;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import io.smallrye.mutiny.Uni;
import it.skeith.entity.Category;
import org.hibernate.reactive.mutiny.Mutiny;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryRepo implements PanacheRepository<Category> {

    Mutiny.SessionFactory sf;
    public CategoryRepo(Mutiny.SessionFactory sf) {
        this.sf = sf;
    }

    public Uni<Category> save(Category category){
        return persist(category);
    }


    public boolean isPersistentCategory(Category category){
        return isPersistent(category);
    }


    public Uni<Category> getById(Long categoryId) {
        return find("#Category.getByIdVisible",Parameters.with("categoryId",categoryId).map()).firstResult();
    }



}
