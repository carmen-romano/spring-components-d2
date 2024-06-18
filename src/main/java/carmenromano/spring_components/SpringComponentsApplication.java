
package carmenromano.spring_components;
import carmenromano.spring_components.entities.Menu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@Slf4j
public class SpringComponentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringComponentsApplication.class, args);

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringComponentsApplication.class);

		Menu m = (Menu) ctx.getBean("menu");

		m.printMenu();
		ctx.close();
	}

}
