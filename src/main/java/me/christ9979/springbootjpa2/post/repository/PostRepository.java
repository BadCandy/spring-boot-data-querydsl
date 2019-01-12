package me.christ9979.springbootjpa2.post.repository;

import me.christ9979.springbootjpa2.common.repository.CommonRepository;
import me.christ9979.springbootjpa2.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * CommonRepository를 상속함으로써 @EnableJpaRepositories(repositoryBaseClass = BaseCommonRepository.class)으로
 * 등록된 커스텀한 공통 기능을 정의한 공통 레파지토리 클래스인 BaseCommonRepository 구현체를 사용하게 한다.
 *
 * 공통 레파지토리 클래스를 상속하고, QuerydslPredicateExecutor를 상속받아도
 * QueryDsl 기능도 함께 사용할 수 있다.
 */
public interface PostRepository extends CommonRepository<Post, Long>, QuerydslPredicateExecutor<Post> {

    /*
        식별자가 아닌 title을 이용하여 page를 얻어오는 커스텀 쿼리 호출 메소드
     */
    Page<Post> findByTitleContains(String title, Pageable pageable);

    Long countByTitleContains(String title);
}
