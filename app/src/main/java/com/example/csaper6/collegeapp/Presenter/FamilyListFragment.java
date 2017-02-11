package com.example.csaper6.collegeapp.Presenter;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.csaper6.collegeapp.Model.Guardian;
import com.example.csaper6.collegeapp.Model.Person;
import com.example.csaper6.collegeapp.Model.Sibling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csaper6 on 2/10/17.
 */
public class FamilyListFragment extends ListFragment {
    private List<Person> family;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        //create our list of heroes
        family = new ArrayList<>();
        populateList();
        //Comparator c = null;
        //Collections.sort(family, c);


        //fill the custom adapter
        FamilyAdapter adapter = new FamilyAdapter(getActivity(), family);

        //set the listView's adapter
        setListAdapter(adapter);

        return rootView;
    }

    private void populateList() {
        family.add(new Guardian("Father","Staplemen", "Can staple really thick stacks of paper", 55));
        family.add(new Sibling("Brother","Staplemen", "Brother", 19));

    }

}
