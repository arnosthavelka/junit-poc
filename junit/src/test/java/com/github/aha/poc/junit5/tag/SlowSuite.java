package com.github.aha.poc.junit5.tag;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@DisplayName("Slow suite - run all slow tests")
@SelectClasses({ATest.class, BTest.class})
@IncludeTags(TagConsts.SLOW)
public class SlowSuite {

}
