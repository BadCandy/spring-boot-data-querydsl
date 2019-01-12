package me.christ9979.springbootjpa2.account;

import com.querydsl.core.types.Predicate;
import me.christ9979.springbootjpa2.account.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    /**
     * Predicate를 이용한 queryDsl 테스트를 진행한다.
     */
    @Test
    public void queryDslTest() {

        QAccount account = QAccount.account;

        Predicate predicate = account
                .firstName.containsIgnoreCase("youncheol")
                .and(QAccount.account.lastName.startsWith("jeong"));


        Optional<Account> one = accountRepository.findOne(predicate);
        assertThat(one).isEmpty();
    }
}