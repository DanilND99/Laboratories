package mx.tec.lab.repository;
import mx.tec.lab.entity.Dragon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DragonRepository extends JpaRepository<Dragon, Long>{
	
}
