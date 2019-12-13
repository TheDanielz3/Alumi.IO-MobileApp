package com.example.alumiio.listeners;

import com.example.alumiio.models.Tpc;

import java.util.ArrayList;

public interface TpcListener {

    void onRefreshTpcList(ArrayList<Tpc> tpcList);

    void onUpdateTpclist(Tpc tpc, int operation);

}
