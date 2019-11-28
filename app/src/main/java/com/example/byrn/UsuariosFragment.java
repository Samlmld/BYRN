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
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import mx.reel.Configuration;
import mx.reel.pojos.User;
import mx.reel.utils.DialogManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UsuariosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UsuariosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UsuariosFragment extends Fragment implements Callback<List<User>> {
    private List<User> users = null;
    private ListView usersListView = null;
    Button btnBuscarUsuario;
    EditText etBuscar;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public UsuariosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UsuariosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UsuariosFragment newInstance(String param1, String param2) {
        UsuariosFragment fragment = new UsuariosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DialogManager.init(this.getActivity());
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista =  inflater.inflate(R.layout.fragment_usuarios, container, false);

        btnBuscarUsuario = vista.findViewById(R.id.btnBuscarUsuario);
        usersListView = vista.findViewById(R.id.usersListView);
        etBuscar = vista.findViewById(R.id.etBusquedaUsu);

        fetchUsers();

        btnBuscarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchUsersListView(etBuscar.getText().toString());
            }
        });
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

    private void fetchUsers() {
        DialogManager.showLoadingDialog("Obteniendo listado de usuarios...");
        Configuration
                .USER_SERVICE
                .getAllUsers(Configuration.getAuthToken())
                .enqueue(this);
    }

    private void initUsersListView() {
        System.out.println("Initializing users list view");
        List<String> userNames = new ArrayList<>();
        for (User u : users) {
            String name = u.getName() + " " + u.getLastName();
            System.out.println(name);
            userNames.add(name);
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, userNames);

        usersListView.setAdapter(adapter);
        usersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent v = new Intent(getActivity(), DetallesUsuario.class);
                v.putExtra("user", users.get(position));
                startActivity(v);
            }
        });
    }

    private void searchUsersListView(String name) {
        //System.out.println("Initializing users list view");
        List<String> userNames = new ArrayList<>();
        for (User u : users) {
            String nameAux = u.getName() + " " + u.getLastName();
            //System.out.println(name);
            if (nameAux.toLowerCase().contains(name.toLowerCase())){
                userNames.add(nameAux);
            }
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, userNames);

        usersListView.setAdapter(adapter);
        usersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent v = new Intent(getActivity(), DetallesUsuario.class);
                v.putExtra("user", users.get(position));
                startActivity(v);
            }
        });
    }

    @Override
    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
        System.out.println("Succesfully completed the HTTP request.");
        if (!response.isSuccessful()) {
            DialogManager.showMessageDialog("Ocurrió un error inesperado.");
            return;
        }

        DialogManager.hideLoadingDialog();
        users = response.body();
        initUsersListView();
    }

    @Override
    public void onFailure(Call<List<User>> call, Throwable t) {
        DialogManager.showMessageDialog("No se pudieron obtener los usuarios.");
        System.err.println(t.getLocalizedMessage());
    }
}
