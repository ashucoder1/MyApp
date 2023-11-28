package com.example.myapplication

sealed class Screen(val route:String){
    object First:Screen(route ="first_screen")
    object Login :Screen(route="login_screen")
    object SignUp :Screen(route="signup_screen")
    object Main: Screen(route="main_screen")

}
