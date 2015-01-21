package td.services.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import td.services.HelloService;


@Component
@Scope("prototype")
public class HelloServiceImpl implements HelloService {
	
	public HelloServiceImpl()
	{
		System.out.println("(+) Hello constructor" );
	}
	
	public void hello(String s)
	{
		System.out.println("Hello " + s );
	}
}
