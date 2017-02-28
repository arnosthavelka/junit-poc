package com.github.aha.poc.junit5.tag;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.runner.IncludeTags;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.runner.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@DisplayName("Slow suite - run all slow tests")
@SelectClasses({ATest.class, BTest.class})
@IncludeTags(TagConsts.SLOW)
public class SlowSuite {

}
