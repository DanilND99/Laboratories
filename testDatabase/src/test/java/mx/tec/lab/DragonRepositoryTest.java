package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.*;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import mx.tec.lab.entity.Dragon;
import mx.tec.lab.repository.DragonRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DragonRepositoryTest {
	@Resource
	private DragonRepository dragonRepository;
	@Test
	public void givenDragon_whenSave_thenRetrieveSane() {
		Dragon dragon = new Dragon(1,"Meraxes");
		dragonRepository.save(dragon);
		Dragon retrievedDragon = dragonRepository.findById(1L).orElse(null);
		assertEquals("Meraxes", retrievedDragon.getName());
	}
	@Test
	public void givenDragon_modify() {
		Dragon dragon = new Dragon(1,"Meraxes");
		dragonRepository.save(dragon);
		Dragon retrievedDragon = dragonRepository.findById(1L).orElse(null);
		retrievedDragon.setName("Sexarem");
		dragonRepository.save(retrievedDragon);
		Dragon anotherRetrieve = dragonRepository.findById(1L).orElse(null);
		assertEquals("Sexarem", anotherRetrieve.getName());
	}
	@Test
	public void givenDragon_delete() {
		Dragon dragon = new Dragon(1,"Meraxes");
		dragonRepository.save(dragon);
		Dragon retrievedDragon = dragonRepository.findById(1L).orElse(null);
		dragonRepository.delete(retrievedDragon);
		Dragon anotherRetrieve = dragonRepository.findById(1l).orElse(null);
		assertEquals(null,anotherRetrieve);
	}
}
