package myblog.myblog17.service.impl;

import myblog.myblog17.entity.Post;
import myblog.myblog17.exception.ResourceNotFoundException;
import myblog.myblog17.payload.PostDto;
import myblog.myblog17.repository.PostRepository;
import myblog.myblog17.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public PostDto createRegistration(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post savepost = repository.save(post);
        PostDto dto = mapToDto(savepost);
        return dto;
    }

    @Override
    public PostDto getRegistrationById(long id) {
        Post post = repository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Post not found With id" + id)
        );
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setName(post.getName());
        dto.setEmail(post.getEmail());
        dto.setMobile(post.getMobile());
        return dto;
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = repository.findAll();
        List<PostDto> dtos = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return dtos;
    }

    PostDto mapToDto(Post post){
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setName(post.getName());
        dto.setEmail(post.getEmail());
        dto.setMobile(post.getMobile());
        return dto;
    }
    Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setName(postDto.getName());
        post.setEmail(postDto.getEmail());
        post.setMobile(postDto.getMobile());
        return post;
    }
}
