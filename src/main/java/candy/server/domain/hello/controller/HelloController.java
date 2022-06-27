package candy.server.domain.hello.controller;

import candy.server.domain.hello.dto.HelloRequestDto;
import candy.server.domain.hello.dto.HelloResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

    @GetMapping
    public ResponseEntity<HelloResponseDto> get () {
        HelloResponseDto response = HelloResponseDto.builder()
                .value("hello")
                .success(true)
                .build();

        return ResponseEntity.ok()
                .body(response);
    }

    @PostMapping
    public ResponseEntity<HelloResponseDto> create(@Validated @RequestBody HelloRequestDto dto) {
        HelloResponseDto response = HelloResponseDto.builder()
                .value("hello " + dto.getStringValue() + dto.getIntValue())
                .success(true)
                .build();

        return ResponseEntity.ok()
                .body(response);
    }
}
