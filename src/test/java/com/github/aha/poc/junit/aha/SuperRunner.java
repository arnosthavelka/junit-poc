package com.github.aha.poc.junit.aha;

import java.util.List;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class SuperRunner extends BlockJUnit4ClassRunner {

	public SuperRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}

    protected List<FrameworkMethod> computeTestMethods() {
        return getTestClass().getAnnotatedMethods(SuperTest.class);
    }

    @Override
    protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
    	System.out.println("test '" + method.getName() + "': starting ...");
    	long msStart = System.currentTimeMillis();
    	super.runChild(method, notifier);
    	long ms = System.currentTimeMillis() - msStart;
    	System.out.println("test '" + method.getName() + "': finished in " + ms + "ms ...");
    }
    
}
