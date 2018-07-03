package com.example.geeksera.jukebox;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.example.geeksera.jukebox.Objects.DedicationObject;
import com.example.geeksera.jukebox.Objects.NowPlayingObject;
import com.example.geeksera.jukebox.Objects.SongsDetails;
import com.example.geeksera.jukebox.Session.MyApplication;
import com.example.geeksera.jukebox.StaticData.Static;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.Collections;
import java.util.Comparator;


/**
 * A simple {@link Fragment} subclass.
 */
public class NowPlayingAndDadications extends Fragment {


    public NowPlayingAndDadications() {
        // Required empty public constructor
    }

    TextView SongName;
    TextView To, From, Message;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_now_playing_and_dadications, container, false);
        SongName = view.findViewById(R.id.SongName);
        To = view.findViewById(R.id.DTo);
        From = view.findViewById(R.id.DFrom);
        Message = view.findViewById(R.id.DMessage);
        NowPlaying();
        Datications();
        view.findViewById(R.id.Dadications).setVisibility(View.VISIBLE);
        return view;
    }


    public void NowPlaying() {
        RequestQueue mRequestQueue;
        final Cache cache = new DiskBasedCache(getActivity().getCacheDir(), 1024 * 1024); // 1MB cap
        final com.android.volley.Network network = new BasicNetwork(new HurlStack());
        mRequestQueue = new RequestQueue(cache, network);
        mRequestQueue.start();
        MyApplication myApplication = (MyApplication) getActivity().getApplicationContext();

        String url = Static.ServerAddress + "NowPlaying/" + myApplication.getGetRestaurantsResult().getId();

        url = url.replace(" ", "%20");

        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        Gson gson = new Gson();
                        NowPlayingObject nowPlayingObject = gson.fromJson(response, NowPlayingObject.class);

                        SongName.setText(nowPlayingObject.getNowPlayingResult().getTitle().toString());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });

        mRequestQueue.add(stringRequest);
    }


    public void Datications() {
        RequestQueue mRequestQueue;
        final Cache cache = new DiskBasedCache(getActivity().getCacheDir(), 1024 * 1024); // 1MB cap
        final com.android.volley.Network network = new BasicNetwork(new HurlStack());
        mRequestQueue = new RequestQueue(cache, network);
        mRequestQueue.start();
        MyApplication myApplication = (MyApplication) getActivity().getApplicationContext();

        String url = Static.ServerAddress + "CurrentDedications/1";

        url = url.replace(" ", "%20");

        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Gson gson = new Gson();
                        DedicationObject dedicationObject = gson.fromJson(response, DedicationObject.class);
                        To.setText(dedicationObject.getCurrentDedicationsResult().get(0).getDedicatedto());
                        From.setText(dedicationObject.getCurrentDedicationsResult().get(0).getDedicatedBy());
                        Message.setText(dedicationObject.getCurrentDedicationsResult().get(0).getDedicationmessage());


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });

        mRequestQueue.add(stringRequest);
    }


}
