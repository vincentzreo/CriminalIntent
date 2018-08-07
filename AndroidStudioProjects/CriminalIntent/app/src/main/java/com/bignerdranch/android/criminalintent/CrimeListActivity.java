package com.bignerdranch.android.criminalintent;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

public class CrimeListActivity extends SingleFragmentActivity {
    private RecyclerView mCrimeRecyclerView;


    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
