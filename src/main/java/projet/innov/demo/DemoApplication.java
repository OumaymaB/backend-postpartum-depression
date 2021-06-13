package projet.innov.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    private void creatDirectory(String path){
        File directory = new File(path);
        if (! directory.exists()){
            directory.mkdirs();
        }
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of(System.getProperty("user.home")+"/upload/user",
                System.getProperty("user.home")+"/upload/resource").forEach(path -> {
            creatDirectory(path);
        });


    }
}
