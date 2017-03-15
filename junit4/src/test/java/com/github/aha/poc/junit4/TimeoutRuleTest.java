package com.github.aha.poc.junit4;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.rules.Timeout;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class TimeoutRuleTest {

//    @Rule
//    public Timeout timeout = Timeout.millis(50);
	
	private static final int TIMEOUT = 100;
	
    @Rule
    public Timeout timeout = new Timeout(TIMEOUT, TimeUnit.MILLISECONDS) {
    	// hide warning since this is just for example (it's achievable)
        @SuppressWarnings("deprecation")
		public Statement apply(Statement base, Description description) {
            return new FailOnTimeout(base, TIMEOUT) {
                @Override
                public void evaluate() throws Throwable {
                    try {
                        super.evaluate();
                        throw new TimeoutException();
                    } catch (Exception e) {}
                }
            };
        }
    };	
	
    @Test(expected=TimeoutException.class)
	public void timeoutingFailFastTest() throws InterruptedException {
		Thread.sleep(200);
		assertThat(1 + 1, is(equalTo(2)));
	}	

}
