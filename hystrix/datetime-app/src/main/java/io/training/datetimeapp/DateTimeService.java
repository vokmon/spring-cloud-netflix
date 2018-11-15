/**
 *
 */
package io.training.datetimeapp;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author aruangth
 */
@Service
public class DateTimeService {

    @Inject
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "unknown")
    public String getDateTime() {
        return restTemplate.getForEntity(
                "http://date-time-service/date-time", String.class).getBody();
    }

    // fallback method to degrade gracefully
    public String unknown() {
        return "unknown";
    }

}
