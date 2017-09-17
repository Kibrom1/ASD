package bank.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.StopWatch;

@Aspect
public class Logger {

	@Before("execution(* bank.dao.*.*(..))")
	public void logDBAccess(JoinPoint joinPoint) {
		System.out.println("DBAccess : " + joinPoint.getSignature().getName());
	}

	@Around("execution(* bank.service.*.*(..))")
	public Object invoke(ProceedingJoinPoint call) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		// print the time to the console
		System.out.println("Time to execute " + call.getSignature().getName()
				+ " = " + totaltime + "ms");
		return retVal;
	}
}
