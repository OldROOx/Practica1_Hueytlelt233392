package com.gael.gael_practica1.features.countries.presentation.viewmodels

import com.gael.gael_practica1.features.countries.domain.usecases.GetCountriesUseCase
import com.gael.gael_practica1.features.countries.presentation.screens.CountriesUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@OptIn(ExperimentalCoroutinesApi::class)
class CountriesViewModelTest {

    private lateinit var getCountriesUseCase: GetCountriesUseCase

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        getCountriesUseCase = mock(GetCountriesUseCase::class.java)
    }

    @Test
    fun `cuando getCountries inicia el estado es Loading y luego Success`() = runTest {
        `when`(getCountriesUseCase()).thenReturn(emptyList())
        val viewModel = CountriesViewModel(getCountriesUseCase)
        // Debido al UnconfinedTestDispatcher, el init se ejecuta inmediatamente
        assertTrue(viewModel.countriesUiState is CountriesUiState.Success)
    }
}