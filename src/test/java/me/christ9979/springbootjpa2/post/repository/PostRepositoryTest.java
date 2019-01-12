package me.christ9979.springbootjpa2.post.repository;

import com.querydsl.core.types.Predicate;
import me.christ9979.springbootjpa2.TestConfiguration;
import me.christ9979.springbootjpa2.post.Post;
import me.christ9979.springbootjpa2.post.QPost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(TestConfiguration.class)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void customCommonDslRepositoryTest() {

        Post post = new Post();
        post.setTitle("hibernate");
        postRepository.save(post.registerPost());

        Predicate predicate = QPost.post.title.containsIgnoreCase("hiber");
        Optional<Post> one = postRepository.findOne(predicate);

        assertThat(one).isNotEmpty();
    }
}