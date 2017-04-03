package com.github.aha.poc.junit5.tag;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@DisplayName("Fast Suite - run all fast tests")
@SelectClasses({ATest.class, BTest.class})
@IncludeTags(TagConsts.FAST)
public class FastSuite {

}
