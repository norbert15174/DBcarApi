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

//    @EventListener(ApplicationReadyEvent.class)
//    public void Init(){
//        String sql = "CREATE TABLE Cars(video_id int, title VARCHAR(45), url VARCHAR(45), PRIMARY KEY(video_id))";
//        getJdbcTemplete().update(sql);
//    }


}
