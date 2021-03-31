package com.freelec.webservice.web;

import com.freelec.webservice.service.posts.PostsService;
import com.freelec.webservice.web.dto.PostsSaveRequestDto;
import com.freelec.webservice.web.dto.PostsResponseDto;
import com.freelec.webservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto updateRequestDto) {
        return postsService.update(id, updateRequestDto);
    }

    @GetMapping(value = "/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/delete/{id}")
    public Long postsDelete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
