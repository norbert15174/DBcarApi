package pl.dbapicar.DBapiCar;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DBconfig {

    private DataSource dataSource;

    @Autowired
    public DBconfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplete(){

        return new JdbcTemplate(dataSource);

    };
//    Uncomment if you want to generate table Cars
//    @EventListener(ApplicationReadyEvent.class)
//    public void Init(){
//        String sql = "CREATE TABLE Cars(id int AUTO INCREMENT, brand VARCHAR(100), color VARCHAR(45), PRIMARY KEY(id))";
//        getJdbcTemplete().update(sql);
//    }

    //Uncomment if you want to generate table CarNews
//    @EventListener(ApplicationReadyEvent.class)
//    public void Init(){
//        String sql = "CREATE TABLE CarNews(author VARCHAR(100) NOT NULL, title VARCHAR(300) NOT NULL,description VARCHAR(300) NOT NULL, url VARCHAR(300) NOT NULL, urlToImage VARCHAR(300) NOT NULL, id int NOT NULL AUTO INCREMENT, PRIMARY KEY(id))";
//        getJdbcTemplete().update(sql);
//    }


}
