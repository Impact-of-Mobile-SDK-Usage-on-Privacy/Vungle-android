package de.tubs.cs.ias.vappp;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.vungle.ads.BannerAd;
import com.vungle.ads.BannerAdListener;
import com.vungle.ads.BannerAdSize;
import com.vungle.ads.BannerView;
import com.vungle.ads.BaseAd;
import com.vungle.ads.VungleError;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import de.tubs.cs.ias.vappp.databinding.FragmentBasicFuncBinding;

public class BasicFunc extends Fragment implements BannerAdListener {

    private FragmentBasicFuncBinding binding;
    private BannerAd bannerAd;
    private String placementId = "PLACEHOLDER_PLACEMENT_ID";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentBasicFuncBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bannerAd = new BannerAd(requireContext(), placementId, BannerAdSize.BANNER);
        bannerAd.setAdListener(this);
        bannerAd.load(null);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onAdClicked(@NonNull BaseAd baseAd) {

    }

    @Override
    public void onAdEnd(@NonNull BaseAd baseAd) {

    }

    @Override
    public void onAdFailedToLoad(@NonNull BaseAd baseAd, @NonNull VungleError vungleError) {
        binding.textviewBasicFunc.setText("ad failed to load " + vungleError.getErrorMessage());
    }

    @Override
    public void onAdFailedToPlay(@NonNull BaseAd baseAd, @NonNull VungleError vungleError) {
        binding.textviewBasicFunc.setText("ad failed to play " + vungleError.getErrorMessage());
    }

    @Override
    public void onAdImpression(@NonNull BaseAd baseAd) {

    }

    @Override
    public void onAdLeftApplication(@NonNull BaseAd baseAd) {

    }

    @Override
    public void onAdLoaded(@NonNull BaseAd baseAd) {
        BannerView bannerView = bannerAd.getBannerView();
        if(bannerView != null) {
            ViewGroup.LayoutParams params = new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    Gravity.CENTER_HORIZONTAL);
            binding.textviewBasicFunc.setText("Banner View loaded");
            binding.bannerAdContainer.addView(bannerView, params);
        } else {
            binding.textviewBasicFunc.setText("Banner View was null");
        }
    }

    @Override
    public void onAdStart(@NonNull BaseAd baseAd) {

    }
}
