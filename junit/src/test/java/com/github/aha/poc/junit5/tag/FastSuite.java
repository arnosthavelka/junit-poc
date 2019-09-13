package com.github.aha.poc.junit5.tag;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;
import static org.junit.platform.launcher.TagFilter.includeTags;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FastSuite {

	public static void main(String[] args) {
		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
				.selectors(selectPackage("com.github.aha.poc.junit5.tag"))
//				.selectors(selectClass(ATest.class), selectClass(BTest.class))
				.filters(includeTags(TagConsts.A, TagConsts.FAST))
				.build();

		Launcher launcher = LauncherFactory.create();

		// analyze test plan
		TestPlan testPlan = launcher.discover(request);
		for (TestIdentifier testIdentifier : testPlan.getRoots()) {
			log.info("Test plan contains {}:", testIdentifier.getUniqueId());
			for (TestIdentifier ti : testPlan.getChildren(testIdentifier)) {
				log.info("{}", ti.getDisplayName());
			}
		}

		// Executing tests
		launcher.execute(request, new SummaryGeneratingListener());
	}
}
