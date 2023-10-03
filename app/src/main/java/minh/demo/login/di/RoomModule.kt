package minh.demo.login.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import javax.inject.Singleton
import dagger.Provides
import minh.demo.login.data.local.UserDao
import minh.demo.login.data.local.UserDatabase
import minh.demo.login.data.repo.UserRepository
import minh.demo.login.data.repo.UserDbRepository
import minh.demo.login.domain.GetAllUseCase
import minh.demo.login.domain.LoginUseCase
import minh.demo.login.domain.RegisterUseCase
import minh.demo.login.ui.UserViewModelFactory

@Module
class RoomModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideApplicationContext() = application

    @Singleton
    @Provides
    fun provideUserDb() : UserDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            UserDatabase::class.java,
            "USER_DATABASE"
        ).build()
    }

    @Singleton
    @Provides
    fun provideUserDao(userDatabase: UserDatabase): UserDao {
        return userDatabase.userDao()
    }

    @Singleton
    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserDbRepository(userDao)
    }

    @Singleton
    @Provides
    fun provideGetAllUsCase(userRepository: UserRepository): GetAllUseCase {
        return GetAllUseCase(userRepository)
    }

    @Singleton
    @Provides
    fun provideLoginUseCase(userRepository: UserRepository): LoginUseCase{
        return LoginUseCase(userRepository)
    }

    @Singleton
    @Provides
    fun provideRegisterUseCase(userRepository: UserRepository): RegisterUseCase{
        return RegisterUseCase(userRepository)
    }

    @Singleton
    @Provides
    fun provideUserViewModelFactory(
        registerUseCase: RegisterUseCase,
        loginUseCase: LoginUseCase,
        getAllUseCase: GetAllUseCase
    ): UserViewModelFactory {
        return UserViewModelFactory(registerUseCase, loginUseCase, getAllUseCase)
    }


}