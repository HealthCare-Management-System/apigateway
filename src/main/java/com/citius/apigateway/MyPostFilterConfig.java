package com.citius.apigateway;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import reactor.core.publisher.Mono;
@Configuration
public class MyPostFilterConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyPostFilterConfig.class);
    @Bean
    public GlobalFilter postGlobalFilter() {

        return ((exchange, chain) -> chain.filter(exchange).then(Mono.fromRunnable(() -> {
            HttpHeaders headers = exchange.getRequest().getHeaders();
            List<String> startTime = headers.get("startTime");
            String s = startTime.stream().findFirst().get();
            Instant startTimeIntant = Instant.parse(s);
            long durationOfRequest = ChronoUnit.MILLIS.between(startTimeIntant, Instant.now());
            LOGGER.info("$$$$ Inside Post-Filter $$$$");
            LOGGER.debug("Total time taken in milliseconds: {}", durationOfRequest);
        })));
    }
}
