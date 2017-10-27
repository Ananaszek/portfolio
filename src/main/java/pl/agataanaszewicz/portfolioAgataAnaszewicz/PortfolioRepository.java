package pl.agataanaszewicz.portfolioAgataAnaszewicz;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.agataanaszewicz.portfolioAgataAnaszewicz.models.Project;

import java.util.List;

@Repository
public interface PortfolioRepository extends CrudRepository<Project,Integer>{
    List<Project> findAll();
}
