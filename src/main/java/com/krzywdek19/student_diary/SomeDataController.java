package com.krzywdek19.student_diary;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class SomeDataController {
    private final SomeDataRepository someDataRepository;
    @GetMapping("/siema")
    public String siema(HttpServletRequest httpRequest) {
        SomeData someData = new SomeData();
        someData.setIp(httpRequest.getRemoteAddr());
        someData.setLocalDateTime(LocalDateTime.now());
        someData.setOtherData(httpRequest.getHeader("X-Forwarded-For"));
        someDataRepository.save(someData);
        return "siema";
    }
}
