package pharm.redpharm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class About extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_layout,container, false);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        final ArrayList<RecyclerViewModel> pname = new ArrayList<RecyclerViewModel>();

        pname.add(new RecyclerViewModel("About"));
        pname.add(new RecyclerViewModel("Beta"));
        pname.add(new RecyclerViewModel("Cupcake"));
        pname.add(new RecyclerViewModel("Donut"));
        pname.add(new RecyclerViewModel("Eclairs"));
        pname.add(new RecyclerViewModel("Froyo"));
        pname.add(new RecyclerViewModel("GingerBread"));
        pname.add(new RecyclerViewModel("HoneyComb"));
        pname.add(new RecyclerViewModel("IceCreamSandwich"));
        pname.add(new RecyclerViewModel("JellyBean"));
        pname.add(new RecyclerViewModel("KitKat"));
        pname.add(new RecyclerViewModel("Lollipop"));
        pname.add(new RecyclerViewModel("MarshMallow"));
        pname.add(new RecyclerViewModel("Nougat"));


        final RecyclerViewAdapter itemsAdapter = new RecyclerViewAdapter(About.this.getActivity(), pname, null);
        final RecyclerView clv = (RecyclerView) view.findViewById(R.id.recyclerv_view);
        clv.setLayoutManager(new LinearLayoutManager(About.this.getActivity()));
        clv.setHasFixedSize(true);
        clv.setAdapter(itemsAdapter);

    }
}
