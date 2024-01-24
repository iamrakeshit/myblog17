package myblog.myblog17.service;

import myblog.myblog17.payload.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    PostDto createRegistration(PostDto postDto);

    PostDto getRegistrationById(long id);

    List<PostDto> getAllPost(int pageNo, int pageSize);
}
