package minh.demo.login.di

import dagger.Component
import minh.demo.login.ui.activity.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [RoomModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

}
