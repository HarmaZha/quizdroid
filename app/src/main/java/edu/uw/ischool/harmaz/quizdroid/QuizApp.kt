package edu.uw.ischool.harmaz.quizdroid

import android.app.Application
import android.util.Log

// singleton because extending android.app.Application
class QuizApp : Application() {
    private val topicRepository: TopicRepository = TopicRepositoryImpl()

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "QuizApp is loaded and being run.")
    }

    fun getTopicRepository(): TopicRepository {
        Log.i(TAG, "TopicRepository instance.")
        return topicRepository
    }
}