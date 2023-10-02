package minh.demo.login.di

import android.app.Application

class UserManagerApp : Application() {
    val components: ApplicationComponent =
        DaggerApplicationComponent.builder().roomModule(RoomModule(this)).build()
}