package learn.kubernetes.bid.purchase.auction_purchase.config;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"learn.kubernetes.bid.purchase.auction_purchase.entity"})
@EnableJpaRepositories(basePackages = {"learn.kubernetes.bid.purchase.auction_purchase.repo"})
@EnableTransactionManagement
public class JPARepsoitoryConfig{
}