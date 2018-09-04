package com.rest.conditionmissionclass;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnMissingClass(value= {"NameService"})
public class DefaultNameService implements INameService {

	public String getName() {
		// TODO Auto-generated method stub
		return "jinghe";
	}

}
