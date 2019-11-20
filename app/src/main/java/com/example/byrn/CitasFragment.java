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
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import mx.reel.Configuration;
import mx.reel.pojos.Appointment;
import mx.reel.utils.DialogManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CitasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CitasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CitasFragment extends Fragment implements Callback<List<Appointment>> {
    // TODO: Rename parameter arguments, choose names that match
    private ListView appointmentsListView = null;
    private List<Appointment> appointments = null;
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Button btnBusquedaCita;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CitasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CitasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CitasFragment newInstance(String param1, String param2) {
        CitasFragment fragment = new CitasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_citas, container, false);
        appointmentsListView = vista.findViewById(R.id.lvCitas);

        // Botones
        btnBusquedaCita = vista.findViewById(R.id.btnBusquedaCita);

        DialogManager.showLoadingDialog("Obteniendo citas...");
        Call<List<Appointment>> serviceCall = Configuration.APPOINTMENT_SERVICE.getAllAppointments(
                Configuration.getAuthToken()
        );
        serviceCall.enqueue(this);

        return vista;
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

    private void initAppointmentsListView() {
        List<String> appointmentsList = new ArrayList<>();

        for (Appointment appointment : appointments) {
            appointmentsList.add(
                    appointment.getDate() + " a las " + appointment.getStartTime()
            );
        }

        ListAdapter adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                appointmentsList
        );

        appointmentsListView.setAdapter(adapter);

        appointmentsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Appointment appointmentToPass = appointments.get(position);
                Intent intent = new Intent(getActivity(), DetallesCita.class);
                intent.putExtra("appointment", appointmentToPass);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResponse(Call<List<Appointment>> call, Response<List<Appointment>> response) {
        if (!response.isSuccessful()) {
            DialogManager.showMessageDialog("No se pudieron consultar las citas.");
            return;
        }
        DialogManager.hideLoadingDialog();
        appointments = response.body();
        initAppointmentsListView();
    }

    @Override
    public void onFailure(Call<List<Appointment>> call, Throwable t) {
        DialogManager.showMessageDialog("No se pudieron consultar las citas.");
        System.out.println(t.getLocalizedMessage());
    }

}
