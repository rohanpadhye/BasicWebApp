package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void canAdd() throws Exception {
        assertThat(queryProcessor.process("what is 21 plus 3"), containsString("24"));
    }


    @Test
    public void canMultiply() throws Exception {
        assertThat(queryProcessor.process("what is 21 multiplied by 3"), containsString("63"));
    }


    @Test
    public void canMax() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 13, 21, 99, 1"),
                containsString("99"));
    }

}
