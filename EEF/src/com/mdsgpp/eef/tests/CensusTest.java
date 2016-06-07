package com.mdsgpp.eef.tests;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by andreanmasiro on 06/06/16.
 */
public class CensusTest {

    @Test
    public void trueIsTrue() {
        assert(true == true);
        assertThat(true, is(true));
    }

        
}
