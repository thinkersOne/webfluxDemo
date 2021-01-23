package org.example.functional.endpoints.router;

import org.example.functional.endpoints.handler.PersonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author lizhihao
 * @data 2021/1/17
 * @time 11:40
 */
@Configuration
public class PersonRouter {

    @Bean
    public RouterFunction<ServerResponse> initRouterFunction(PersonHandler handler){
        RouterFunction<ServerResponse> route = route()
                .GET("/person/{id}", accept(APPLICATION_JSON), handler::getPerson)
                .GET("/person", accept(APPLICATION_JSON), handler::listPeople)
                .POST("/person", handler::createPerson)
                .build();
        return route;
    }

}
