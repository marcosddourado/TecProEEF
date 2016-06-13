package com.mdsgpp.eef.tests.controller;

import android.content.Context;
import android.util.Log;

import com.mdsgpp.eef.controller.StateConroller;
import com.mdsgpp.eef.model.Feed;
import com.mdsgpp.eef.model.State;
import com.mdsgpp.eef.parse.ParseData;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;


public class StateControllerTest {
    @Mock
    Context mock_context = Mockito.mock(Context.class);

    @Mock
    State mock_state = Mockito.mock(State.class);

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testZeroValueGrabState() {
        int value = 0;
        State state = null;

        try {
            state = StateConroller.getInstance(mock_context).grabState(value);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(state.getStateName());
    }
}
