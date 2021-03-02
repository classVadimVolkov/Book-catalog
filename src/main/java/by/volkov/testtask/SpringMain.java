package by.volkov.testtask;

import by.volkov.testtask.model.Author;
import by.volkov.testtask.model.SexType;
import by.volkov.testtask.repository.jdbc.JdbcAuthorRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.time.Month;

public class SpringMain {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext(
                "spring/spring-app.xml", "spring/spring-db.xml")) {
            JdbcAuthorRepository authorRepository = appCtx.getBean(JdbcAuthorRepository.class);
            authorRepository.getAll().forEach(System.out::println);

            System.out.println("----GET----");
            System.out.println(authorRepository.get(100_003));

            System.out.println("----CREATE----");
            authorRepository.save(new Author(null, "Vasya", "Pupkin",
                    LocalDate.of(2000, Month.JANUARY, 31), SexType.MALE));
            System.out.println(authorRepository.get(100_006));

            System.out.println("----GET ALL----");
            authorRepository.getAll().forEach(System.out::println);

            System.out.println("----UPDATE----");
            authorRepository.save(new Author(100_006, "Masha", "Pupkina",
                    LocalDate.of(2010, Month.FEBRUARY, 25), SexType.FEMALE));
            System.out.println(authorRepository.get(100_006));

            System.out.println("----GET ALL----");
            authorRepository.getAll().forEach(System.out::println);

            System.out.println("----DELETE----");
            authorRepository.delete(100_006);
            System.out.println(authorRepository.get(100_006));

            System.out.println("----GET ALL----");
            authorRepository.getAll().forEach(System.out::println);
        }
    }
}
