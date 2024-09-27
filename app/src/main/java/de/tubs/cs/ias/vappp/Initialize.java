package de.tubs.cs.ias.vappp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.vungle.ads.InitializationListener;
import com.vungle.ads.VungleAds;
import com.vungle.ads.VungleError;

import de.tubs.cs.ias.vappp.databinding.FragmentInitializeBinding;

public class Initialize extends Fragment {

    private String APP_ID = "APP_ID_PLACEHOLDER";

    private FragmentInitializeBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentInitializeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        VungleAds.init(requireContext(), APP_ID, new InitializationListener() {
            @Override
            public void onSuccess() {
                binding.textviewInitialize.setText("Vungle SDK successfully initialized");
            }
            @Override
            public void onError(@NonNull VungleError vungleError) {
                binding.textviewInitialize.setText("Vungle SDK failed " + vungleError.getMessage() + "/" + vungleError.getEventId());
            }
        });

        binding.buttonInitialize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Initialize.this)
                        .navigate(R.id.action_Initialize_to_BasicFunc);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
