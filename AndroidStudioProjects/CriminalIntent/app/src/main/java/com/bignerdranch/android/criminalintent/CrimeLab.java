package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimelab;
    private List<Crime> mCrimes;
    public static CrimeLab get(Context context){
        if(sCrimelab == null){
            sCrimelab = new CrimeLab(context);
        }
        return sCrimelab;
    }
    public void addCrime(Crime c){
        mCrimes.add(c);
    }
    private CrimeLab(Context context){
        mCrimes = new ArrayList<>();

    }
    public List<Crime> getmCrimes(){
        return mCrimes;
    }
    public Crime getCrime(UUID id){
        for(Crime crime : mCrimes){
            if(crime.getmId().equals(id)){
                return crime;
            }
        }
        return null;
    }
}
