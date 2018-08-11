package com.ps.spring.spel.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class LiteralRunner implements CommandLineRunner {
	private static Logger logger = LoggerFactory.getLogger(LiteralRunner.class);
	public void run(String... args) throws Exception {
		logger.info("======Begin run cases=========");
		helloWorld();
		helloWorldMethod();
		stringBytes();
		stringBytesLength();
		stringLength();
		stringMethod();
		logger.info("========End run cases=========");
	}
	
	private void stringMethod() {
		ExpressionParser expressionParser = new SpelExpressionParser();
		Expression expression =  expressionParser.parseExpression("new String('hello world').toUpperCase()");
		String result = expression.getValue(String.class);
		logger.info(result);
	}
	private void stringLength() {
		ExpressionParser expressionParser = new SpelExpressionParser();
		Expression expression = expressionParser.parseExpression("'Hello World'.length()");
		Integer stringLen = (Integer) expression.getValue();
		logger.info(stringLen.toString());
	}
	private void stringBytesLength() {
		ExpressionParser expressionParser = new SpelExpressionParser();
		Expression expression = expressionParser.parseExpression("'Hello World'.bytes.length");
		Integer stringLen = (Integer) expression.getValue();
		logger.info(stringLen.toString());
	}
	private void stringBytes() {
		ExpressionParser expressionParser = new SpelExpressionParser();
		Expression expression = expressionParser.parseExpression("'Hello World'.bytes");
		byte[] bytes = (byte[]) expression.getValue();
		logger.info(String.valueOf(bytes));
	}
	private void helloWorldMethod() {
		ExpressionParser expressionParser = new SpelExpressionParser();
		Expression expression = expressionParser.parseExpression("'Hello World'.concat('!')");
		String expressionValue = (String) expression.getValue();
		logger.info(expressionValue);
	}
	/**
	 * getExpressionString, get expression as a string without caculation
	 */
	private void helloWorld() {
		ExpressionParser expressionParser = new SpelExpressionParser();
		Expression expression  = expressionParser.parseExpression("'Hello World'");
		String expressionValue = expression.getExpressionString();
		logger.info(expressionValue);
	}
	
}
