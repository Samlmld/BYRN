package com.example.byrn;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import mx.reel.Configuration;
import mx.reel.pojos.AllEstatesResponse;
import mx.reel.pojos.Estate;
import mx.reel.utils.DialogManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PropiedadesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PropiedadesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PropiedadesFragment extends Fragment implements Callback<AllEstatesResponse> {
    private AllEstatesResponse allEstatesResponse = null;
    private View fragment = null;
    private ListView estatesListView = null;

    Button btnAgregarPropiedad;
    Button btnBusquedaPropiedad;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PropiedadesFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PropiedadesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PropiedadesFragment newInstance(String param1, String param2) {

        PropiedadesFragment fragment = new PropiedadesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        fragment = inflater.inflate(R.layout.fragment_propiedades, container, false);

        estatesListView = fragment.findViewById(R.id.usersListView);
        btnAgregarPropiedad = fragment.findViewById(R.id.btnAgregarPropiedad);
        btnBusquedaPropiedad = fragment.findViewById(R.id.btnBusquedaPropiedad);

        // API Communication
        DialogManager.showLoadingDialog("Cargando propiedades...");
        Call<AllEstatesResponse> estatesCall = Configuration.STATE_SERVICE.getAllEstates();
        estatesCall.enqueue(this);

        btnAgregarPropiedad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                Intent v = new Intent(getActivity(), FormularioPropiedadActivity.class);
                startActivity(v);
            }
        });

        btnBusquedaPropiedad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                Intent v = new Intent(getActivity(), BusquedaPropiedad.class);
                startActivity(v);

            }
        });

        return fragment;
    }

    private void initEstatesList() {
        ArrayList<String> estatesNamesList = new ArrayList<>();

        System.out.println(allEstatesResponse.getCurrentPage());
        for (Estate estate : allEstatesResponse.getEstates()) {
            estatesNamesList.add(estate.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, estatesNamesList);

        estatesListView.setAdapter(adapter);

        estatesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Estate estateToPass = allEstatesResponse.getEstates().get(position);
                Intent intento = new Intent(getActivity(), DetallesDePropiedades.class);
                intento.putExtra("estate", estateToPass);
                startActivity(intento);
            }
        });
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    /** RETRO FIT HANDLERS **/
    @Override
    public void onResponse(Call<AllEstatesResponse> call, Response<AllEstatesResponse> response) {
        if (response.isSuccessful()) {
            DialogManager.hideLoadingDialog();
            allEstatesResponse = response.body();
            initEstatesList();
        } else {
            DialogManager.showMessageDialog("Ocurrió un error al consultar las propiedades, intente después.");
        }
    }

    @Override
    public void onFailure(Call<AllEstatesResponse> call, Throwable t) {
        DialogManager.showMessageDialog("No se pudó obtener las propiedades, intente después.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        DialogManager.clear();
    }
}
