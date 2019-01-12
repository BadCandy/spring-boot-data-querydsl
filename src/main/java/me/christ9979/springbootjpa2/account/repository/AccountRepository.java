package me.christ9979.springbootjpa2.account.repository;

import me.christ9979.springbootjpa2.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * QueryDsl의 Predicator를 이용한 메소드를 사용하기 위해
 * QuerydslPredicateExecutor를 상속 받는다.
 * QueryDsl은 자바 코드로 조건문을 표현할 수 있고, TypeSafe한 장점이 있다.
 * 일반적인 Jpa 메서드를 사용할 경우 조건이 많아질수록 메서드 이름이 엄청 길어지고 가독성이 떨어진다.
 * QueryDsl을 사용하면 이러한 문제를 해결할 수 있다.
 * QueryDsl은 findOne(Predicate), findAll(Predicate) 메소드 형식으로 사용한다.
 */
public interface AccountRepository extends JpaRepository<Account, Long>, QuerydslPredicateExecutor<Account> {

}
