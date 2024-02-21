package edu.uw.ischool.harmaz.quizdroid

import android.app.Application
import android.util.Log

// singleton because extending android.app.Application
class QuizApp : Application() {
    private lateinit var topicRepository: TopicRepository

    override fun onCreate() {
        super.onCreate()

        topicRepository = TopicRepositoryImpl(this)
        Log.i(TAG, "QuizApp is loaded and being run.")
    }

    fun getTopicRepository(): TopicRepository {
        return topicRepository
    }

    companion object {
        const val TAG = "QuizApp"
    }
}
