package de.tubs.cs.ias.vappp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.vungle.ads.VunglePrivacySettings;

import de.tubs.cs.ias.vappp.databinding.FragmentConsentBinding;

public class Consent extends Fragment {

    private FragmentConsentBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentConsentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonConsentAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VunglePrivacySettings.setGDPRStatus(true,"1.0.0");
                binding.textviewConsent.setText("Consent is: " + VunglePrivacySettings.getGDPRStatus());
            }
        });

        binding.buttonConsentReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VunglePrivacySettings.setGDPRStatus(false,"1.0.0");
                binding.textviewConsent.setText("Consent is: " + VunglePrivacySettings.getGDPRStatus());
            }
        });

        binding.buttonConsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Consent.this)
                        .navigate(R.id.action_Consent_to_Initialize);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}