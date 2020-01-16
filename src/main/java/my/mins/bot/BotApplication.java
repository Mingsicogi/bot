package my.mins.bot;

import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@SpringBootApplication
@LineMessageHandler
@PropertySource(value = {
		"classpath:common.properties"
})
public class BotApplication {

	private static final Logger log = LoggerFactory.getLogger(BotApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BotApplication.class);
		Environment env = app.run(args).getEnvironment();
		String phaseCd = env.getRequiredProperty("line.bot.channel-token"); //실행환경  System.out.println(phaseCd);

		log.info(phaseCd);
	}
}
