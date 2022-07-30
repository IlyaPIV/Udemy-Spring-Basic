package spring_annotations.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import spring_introduction.Cat;
import spring_introduction.Person;
import spring_introduction.Pet;

@Configuration
@PropertySource("classpath:myAppValues.properties")
public class ConfigSecond {

    @Bean
    @Scope("prototype")
    public Pet catBean(){
        return new Cat();
    }

    @Bean
    @Scope("singleton")
    public Person personBean(){
        return new Person(catBean());
    }


}
