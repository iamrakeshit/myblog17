package myblog.myblog17.service.impl;

import myblog.myblog17.entity.Post;
import myblog.myblog17.payload.PostDto;
import myblog.myblog17.repository.PostRepository;
import myblog.myblog17.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public PostDto createRegistration(PostDto postDto) {
        Post post = new Post();
        post.setName(postDto.getName());
        post.setEmail(postDto.getEmail());
        post.setMobile(postDto.getMobile());
        Post savepost = repository.save(post);

        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setName(post.getName());
        dto.setEmail(post.getEmail());
        dto.setMobile(post.getMobile());
        return dto;
    }

    @Override
    public PostDto getRegistrationById(long id) {

        return null;
    }
}
