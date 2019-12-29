import android.app.Application
import com.example.characterviewer.di.component.AppComponent
import com.example.characterviewer.di.module.AppModule
import com.example.characterviewer.di.module.NetworkModule

class App : Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate(){
        super.onCreate()
        getComponent().inject(this)
    }

    private fun getComponent(): AppComponent{
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .build()
        return appComponent
    }

    fun getAppComponent(): AppComponent{
        return appComponent
    }
}