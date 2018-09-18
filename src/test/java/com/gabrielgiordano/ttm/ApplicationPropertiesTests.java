package com.gabrielgiordano.ttm;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationPropertiesTests {

  @Autowired
  ApplicationProperties properties;

  @Test
  public void testPropertiesIsNotNull() {
    assertNotNull(properties);
  }

  @Test
  public void testHasCsvExtension() {
    assertThat(properties.getCsv(), CoreMatchers.containsString(".csv"));
  }

}
