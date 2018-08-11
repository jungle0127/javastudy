package com.ps.spring.spel.runner;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import com.ps.spring.spel.pojo.Inventor;

@Component
@Order(2)
public class InstanceRunner implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(InstanceRunner.class);
	public void run(String... args) throws Exception {
		objectInstanceProperty();
	}
	@SuppressWarnings("unchecked")
	private void objectInstanceProperty() {
		// Create and set a calendar
		GregorianCalendar c = new GregorianCalendar();
		c.set(1856, 7, 9);
		// The constructor arguments are name, birthday, and nationality.
		Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
		ExpressionParser expressionParser = new SpelExpressionParser();
		Expression expression = expressionParser.parseExpression("name");
		
		EvaluationContext context = new StandardEvaluationContext(tesla);
		String name = expression.getValue(context,String.class);
		logger.info(name);
		expression = expressionParser.parseExpression("name == 'Nikola Tesla'");
		boolean result = expression.getValue(context,Boolean.class);
		logger.info(String.valueOf(result));
		
		Simple simple = new Simple();
		simple.booleanList.add(true);
		context = new StandardEvaluationContext(simple);
		expressionParser.parseExpression("booleanList[0]").setValue(context, false);
		expression = expressionParser.parseExpression("booleanList");
		List<Boolean> resultList = expression.getValue(context,ArrayList.class);
		logger.info(String.valueOf(resultList.get(0)));
	}
}
class Simple{
	public List<Boolean> booleanList = new ArrayList<Boolean>();
}

