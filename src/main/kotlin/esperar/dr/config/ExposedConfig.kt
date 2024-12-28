package esperar.dr.config

import esperar.dr.init.ExposedDatabaseInitializer
import org.jetbrains.exposed.spring.SpringTransactionManager
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

@Configuration
class ExposedConfig {
    @Bean
    fun transactionManager(dataSource: DataSource): PlatformTransactionManager {
        return SpringTransactionManager(dataSource)
    }

    @Bean
    @ConditionalOnProperty("spring.exposed.generate-ddl", havingValue = "true")
    fun databaseInitializer(platformTransactionManager: PlatformTransactionManager): ExposedDatabaseInitializer {
        return ExposedDatabaseInitializer(platformTransactionManager, "esperar.dr")
    }

}