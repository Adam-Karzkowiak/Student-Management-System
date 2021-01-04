package app.configuration;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

@Configuration
public class H2Configuration {

    @Profile("dev")
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2server() throws SQLException {
        return Server.createTcpServer("-tcp");
    }
}