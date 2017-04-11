package com.github.aha.poc.junit4.extension.runner.custom;

import java.util.List;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SuperRunner extends BlockJUnit4ClassRunner {
	
	private static final Logger LOG = LoggerFactory.getLogger(SuperRunner.class);

	public SuperRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}

    protected List<FrameworkMethod> computeTestMethods() {
        return getTestClass().getAnnotatedMethods(SuperTest.class);
    }

    @Override
    protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
    	LOG.debug("test '{}': starting ...", method.getName());
    	long msStart = System.currentTimeMillis();
    	super.runChild(method, notifier);
    	LOG.debug("test '{}': finished in {}ms ...", method.getName(), System.currentTimeMillis() - msStart);
    }
    
}
