package com.bignerdranch.android.criminalintent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.UUID;

import com.bignerdranch.android.criminalintent.database.CrimeBaseHelper;
import com.bignerdranch.android.criminalintent.database.CrimeDbSchema;
import com.bignerdranch.android.criminalintent.database.CrimeDbSchema.CrimeTable;

public class CrimeLab {
    private static CrimeLab sCrimelab;
    private Context mContext;
    private SQLiteDatabase mDatabase;
    public static CrimeLab get(Context context){
        if(sCrimelab == null){
            sCrimelab = new CrimeLab(context);
        }
        return sCrimelab;
    }
    public void addCrime(Crime c){
        ContentValues values = getContentValues(c);
        mDatabase.insert(CrimeTable.NAME,null,values);
    }
    private CrimeLab(Context context){
        mContext = context.getApplicationContext();
        mDatabase = new CrimeBaseHelper(mContext).getWritableDatabase();

    }
    public List<Crime> getmCrimes(){
        return new ArrayList<>();
    }
    public Crime getCrime(UUID id){

        return null;
    }
    public void updateCrime(Crime crime){
        String uuidString = crime.getmId().toString();
        ContentValues values = getContentValues(crime);
        mDatabase.update(CrimeTable.NAME,values,
                CrimeTable.Cols.UUID + "= ?",
                new String[]{uuidString});
    }
    private Cursor queryCrimes(String whereClause,String[] whereArgs){
        Cursor cursor = mDatabase.query(
          CrimeTable.NAME,
          null,// null selects all columns
          whereClause,
          whereArgs,
          null,
          null,
          null
        );
        return cursor;
    }
    private static ContentValues getContentValues(Crime crime){
        ContentValues values = new ContentValues();
        values.put(CrimeTable.Cols.UUID,crime.getmId().toString());
        values.put(CrimeTable.Cols.TITLE,crime.getmTitle());
        values.put(CrimeTable.Cols.DATE,crime.getmDate().getTime());
        values.put(CrimeTable.Cols.SOLVED,crime.ismSolved() ? 1 : 0);

        return values;
    }
}
