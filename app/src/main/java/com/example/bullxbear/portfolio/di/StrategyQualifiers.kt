package com.example.bullxbear.portfolio.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class QCurrentValueStrategy

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class QTodayPnLStrategy

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class QTotalInvestmentStrategy

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class QTotalPnLStrategy