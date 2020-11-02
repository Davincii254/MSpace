package com.moringaschool.myspace.ui;

import android.widget.ListView;

import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.myspace.R;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.Robolectric;

public class ApodsListActivityTest extends TestCase {
    private ApodsListActivity activity;
    private RecyclerView mRecycleView;

    @Before
    public void setup(){
        activity = Robolectric.setupActivity(ApodsListActivity.class);
        mRecycleView = (RecyclerView) activity.findViewById(R.id.recyclerview);
    }

    public void testOnCreate() {
    }

    public void testOnCreateOptionsMenu() {
    }

    public void testOnOptionsItemSelected() {
    }
//    @Test
//    public void ApodsRecyclerViewPopulates() {
//        assertNotNull(mRecycleView.getAdapter());
//        assertEquals(mRecycleView.getAdapter().getCount(), 15);
//    }
}