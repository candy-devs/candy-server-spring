package candy.server.domain.search.controller;

import candy.server.domain.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
@Slf4j
public class searchController {
    private final SearchService searchService;

    @GetMapping("/{title}")
    public ResponseEntity<List<String>> search(@PathVariable String name, Pageable pageable) {
        List<String> userResponses = searchService.searchByTitle(name);
        return ResponseEntity.ok(userResponses);
    }
}
