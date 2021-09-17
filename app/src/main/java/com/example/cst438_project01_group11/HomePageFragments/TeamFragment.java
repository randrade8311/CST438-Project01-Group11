package com.example.cst438_project01_group11.HomePageFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cst438_project01_group11.Adapters.DreamTeamRVAdapter;
import com.example.cst438_project01_group11.R;
import com.example.cst438_project01_group11.models.Pokemon;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TeamFragment extends Fragment {

    private TeamFragmentInterface mInterface;
    private RecyclerView mTeamView;
    private RecyclerView.LayoutManager mLayoutManager;
    private DreamTeamRVAdapter mAdapter;

    private ArrayList<Pokemon> mTeam;

    public interface TeamFragmentInterface {
        ArrayList<Pokemon> getTeam();
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dreamteam_layout, container, false);
        mTeam = mInterface.getTeam();
        generateRecyclerView(view, mTeam);
        return view;
    }

    private void generateRecyclerView(View view, ArrayList<Pokemon> team) {
        mTeamView = view.findViewById(R.id.team_recycler_view);
        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mAdapter = new DreamTeamRVAdapter(team, getContext());
        mTeamView.setLayoutManager(mLayoutManager);
        mTeamView.setAdapter(mAdapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mInterface = null;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof TeamFragmentInterface) {
            mInterface = (TeamFragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement TeamFragmentInterface");
        }

    }
}
