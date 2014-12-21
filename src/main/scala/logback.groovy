import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.rolling.RollingFileAppender

import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.ERROR
import static ch.qos.logback.classic.Level.WARN
import static ch.qos.logback.classic.Level.INFO

appender("FILE", RollingFileAppender) {
	file = "logger.log"

	encoder(PatternLayoutEncoder) {
		pattern = "%d [%10.10thread] %-5level %logger{20} - %msg%n"
	}
	rollingPolicy(TimeBasedRollingPolicy) {
		fileNamePattern = "logger.log-%d{yyyy-MM-dd}.zip"
		// 30 days of history
		maxHistory = 30
	}
}

appenders = ["FILE"]

root(INFO, appenders)
logger("org", WARN)
logger("com", WARN)
logger("akka", WARN)


logger("com.tomliddle", DEBUG)

//["PriceFeed", "OrderChecker", "SpreadActor"].each() { logger("com.bullionvault.bvbot.$it", INFO) }
