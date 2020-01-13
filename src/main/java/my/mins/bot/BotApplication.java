package my.mins.bot;

import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@SpringBootApplication
@LineMessageHandler
public class BotApplication {

	private static final Logger log = LoggerFactory.getLogger(BotApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BotApplication.class);
		Environment env = app.run(args).getEnvironment();
		String phaseCd = env.getRequiredProperty("line.bot.channel-token"); //실행환경  System.out.println(phaseCd);

		log.info(phaseCd);
	}

	@EventMapping
	public Message handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
		log.info("#### event : " + event);

		log.info("#### source : " + event.getSource());
		log.info("#### group id : " + event.getSource().getSenderId()); // group id
		log.info("#### user id : " + event.getSource().getUserId()); // user id


		final String originalMessageText = event.getMessage().getText();
		return new TextMessage("지금은 개발중~!");
	}
}
