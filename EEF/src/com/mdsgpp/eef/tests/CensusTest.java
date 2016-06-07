package com.mdsgpp.eef.tests;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.mockito.Mock;


/**
 * Created by andreanmasiro on 06/06/16.
 */
public class CensusTest {

    @Mock
    String hue = "haha";

    @Test
    public void trueIsTrue() {
        assert(true == true);
        assertThat(10, is(10));
    }


        
}
