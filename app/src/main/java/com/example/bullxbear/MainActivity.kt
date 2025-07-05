package com.example.bullxbear

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bullxbear.databinding.ActivityMainBinding
import com.example.bullxbear.portfolio.presenter.adapter.HoldingAdapter
import com.example.bullxbear.portfolio.presenter.viewmodel.StocksViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: StocksViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addSafeArea()

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("HOLDINGS"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("POSITIONS"))

        val adapter = HoldingAdapter()
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(this)

        binding.toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
        viewModel.uiStockState.observe(this) { uiStockStateList ->
            adapter.submitList(uiStockStateList)
        }
        viewModel.uiStockCalculationState.observe(this) {

        }
    }

    private fun addSafeArea() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                systemInsets.left,
                systemInsets.top,
                systemInsets.right,
                systemInsets.bottom
            )
            WindowInsetsCompat.CONSUMED
        }
    }
}
