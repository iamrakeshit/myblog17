package myblog.myblog17.controller;

import myblog.myblog17.payload.PostDto;
import myblog.myblog17.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//      http://localhost:8080/rest/api
@RestController
@RequestMapping("rest/api")
public class PostController {
    private PostService service;

    public PostController(PostService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<PostDto> createRegistration(@RequestBody PostDto postDto){
        PostDto registration = service.createRegistration(postDto);
        return new ResponseEntity<>(registration, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<PostDto> getRegistrationById(@RequestParam long id){
        service.getRegistrationById(id);
    }
}
