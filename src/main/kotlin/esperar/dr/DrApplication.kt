package esperar.dr

import org.jetbrains.exposed.spring.autoconfigure.ExposedAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    exclude = [
        ExposedAutoConfiguration::class
    ]
)
class DrApplication

fun main(args: Array<String>) {
    runApplication<DrApplication>(*args)
}
