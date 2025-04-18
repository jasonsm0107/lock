package com.example.lockcash.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lockcash.R
import com.example.lockcash.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Animation for the lock icon
        val lockIcon: ImageView = binding.iconLock
        val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse_animation)
        lockIcon.startAnimation(pulseAnimation)

        // Animation for sparkle icons
        val sparkleIcon: ImageView = binding.sparkleIcon
        val sparkleSuper: ImageView = binding.sparkleSuperLock
        val sparkleAnimation = AnimationUtils.loadAnimation(context, R.anim.sparkle_animation)
        sparkleIcon.startAnimation(sparkleAnimation)
        sparkleSuper.startAnimation(sparkleAnimation)

        // Set experience progress bar
        setExperienceProgress(78) // 78% progress (2,350 / 3,000)

        return root
    }

    private fun setExperienceProgress(percentage: Int) {
        val expProgress = binding.expProgress
        val params = expProgress.layoutParams as FrameLayout.LayoutParams
        params.width = (binding.expContainer.width * percentage / 100)
        expProgress.layoutParams = params
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}