package com.fredporciuncula.benchmark

import android.content.Context
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InflationBenchmark {

  @get:Rule val benchmarkRule = BenchmarkRule()

  private val inflater = LayoutInflater.from(ApplicationProvider.getApplicationContext<Context>())

  private fun inflate(@LayoutRes resource: Int) = inflater.inflate(resource, null, false)

  @Test fun mainActivityInflation() = benchmarkRule.measureRepeated {
    inflate(R.layout.activity_main)
  }
}
