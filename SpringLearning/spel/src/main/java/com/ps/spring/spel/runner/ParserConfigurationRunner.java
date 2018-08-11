package com.ps.spring.spel.runner;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class ParserConfigurationRunner implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(ParserConfigurationRunner.class);
	public void run(String... args) throws Exception {
		SpelParserConfiguration spelConf = new SpelParserConfiguration(true, true);
		ExpressionParser expressionParser = new SpelExpressionParser(spelConf);
		Expression expression = expressionParser.parseExpression("strList[3]");
		ListDemo demo = new ListDemo();
		expression.getValue(demo);
		logger.info(String.valueOf(demo.strList.size()));
	}

}
class ListDemo{
	public List<String> strList;
}