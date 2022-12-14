package it.skeith.repo;


import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import io.smallrye.mutiny.Uni;
import it.skeith.entity.User;
import org.hibernate.reactive.mutiny.Mutiny;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class UserRepo  implements PanacheRepository<User>  {

    Mutiny.SessionFactory sf;
    public UserRepo(Mutiny.SessionFactory sf) {
        this.sf = sf;
    }


    public Uni<User> findByUsername(String username){
        return find("username",username).firstResult();
    }

    public Uni<User>getByEmail(String email){
        return find("email",email).firstResult();
    }


    public Uni<Long> getByNameEmail( String email){
        return count("#User.getByNameEmail", Parameters.with("email",email).map());
    }

    public Uni<User>getByid(Long id){

        return find("id",id).firstResult();
    }

    public Uni<User>saveorUpdate(User user){
        return saveorUpdate(user);
    }

    public Uni<User>getByUsername(String username){
        return find("username",username).firstResult();
    }








}
