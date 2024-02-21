package edu.uw.ischool.harmaz.quizdroid

import android.os.Environment
import android.util.Log
import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.FileReader

interface TopicRepository {
    fun getTopics(): List<Topic>
    fun getTopic(topicIndex: Int): Topic
    fun getQuiz(topicIndex: Int, quizIndex: Int): Quiz

    // These are not used for HW 8, but they do have unit tests as part of the extra credit
    fun saveTopic(newTopic: Topic)
    fun saveQuiz(topicIndex: Int, newQuiz: Quiz)
}

data class Topic(var title: String, var desc: String, var questions: MutableList<Quiz>)

data class Quiz(var text: String, var answers: List<String>, var answer: Int)

class TopicRepositoryImpl(private val context: Context) : TopicRepository {
    private var topics: MutableList<Topic>

    init {

        val jsonFile: String =  context.resources.openRawResource(R.raw.questions).bufferedReader().use { it.readText() }



        // deserialize JSON into Mutable list of topic objects, made sure to match names to make it easier
        val topicsList: MutableList<Topic> = Gson().fromJson(jsonFile, object : TypeToken<MutableList<Topic>>() {}.type)

        // need to convert the correct answer to 0-based
        for (i in 0..<topicsList.size) {
            val questions = topicsList.get(i).questions
            for (j in 0..<questions.size) {
                val question = questions.get(j)
                question.answer = question.answer - 1
            }
        }

        topics = topicsList

        Log.i(TAG, "TopicRepository: read the data the file, topics: $topics")

    }

    override fun getTopics(): List<Topic> {
        return topics
    }

    override fun getTopic(topicIndex: Int): Topic {
        return topics[topicIndex]
    }

    override fun getQuiz(topicIndex: Int, quizIndex: Int): Quiz {
        return topics[topicIndex].questions[quizIndex]
    }

    override fun saveTopic(newTopic: Topic) {
        topics.add(newTopic)
    }

    override fun saveQuiz(topicIndex: Int, newQuiz: Quiz) {
        topics[topicIndex].questions.add(newQuiz)
    }
}