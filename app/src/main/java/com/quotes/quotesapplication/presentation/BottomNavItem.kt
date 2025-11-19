package com.quotes.quotesapplication.presentation

sealed class BottomNavItem(var route: String,var title: String) {

    data object home: BottomNavItem("home","Home")
    data object explore: BottomNavItem("explore","Explore")
    data object saved: BottomNavItem("saved","Saved")
}